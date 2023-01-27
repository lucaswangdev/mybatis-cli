#!/usr/bin/env node

const yargs = require("yargs");
const figlet = require("figlet");
const fs = require("fs");
const util = require("util");
const child_process = require("child_process");
const exec = util.promisify(child_process.exec);
const fsExtra = require('fs-extra');
const path = require("path");
const srcPath = path.join(process.cwd(), "src");
if (!fs.existsSync(srcPath)){fs.mkdirSync(srcPath);}

let pathObj = {};
// 展示log
let showLog = false;

console.log(figlet.textSync("mybatis-cli", {
  horizontalLayout: "full"
}));

/**
 * 拷贝文件夹下的文件
 * @param filePath 文件路径
 */
function copyDirFile(filePath) {
	//根据文件路径读取文件，返回文件列表
	let files = fs.readdirSync(filePath).filter(item => item !== '.DS_Store');
	//遍历读取到的文件列表
	for (const fileName of files) {
		//获取当前文件的绝对路径
		const filedir = path.join(filePath, fileName);
		//根据文件路径获取文件信息，返回一个fs.Stats对象
		const stats = fs.statSync(filedir);
		const isFile = stats.isFile(); //是文件
		const isDir = stats.isDirectory(); //是文件夹
		if (isFile) {
			const _dirName = path.dirname(filedir);
			const _fileName = path.basename(filedir);
			const fileNameArray = _fileName.split(".");
			const filePrefix = fileNameArray[0];
			const fileSuffix = `.${fileNameArray[1]}`;
			// 排除掉 .DS_Store 这个文件
			if (fileSuffix !== ".DS_Store") {
				const destPath = `${_dirName}/${filePrefix}Copy${fileSuffix}`;
				fs.copyFile(filedir, destPath, (err) => {});
				pathObj[filedir] = destPath;
			}
		}
		if (isDir) {
			copyDirFile(filedir); //递归，如果是文件夹，就继续遍历该文件夹下面的文件
		}
	}
}

/**
 * 更新文件夹下的文件
 * @param filePath 文件路径
 */
function updateDirFile(filePath) {
    showLog && console.log('updateDirFile')
    //根据文件路径读取文件，返回文件列表
    const files = fs.readdirSync(filePath).filter(item => item !== '.DS_Store');
    //遍历读取到的文件列表
    for (const fileName of files) {
			//获取当前文件的绝对路径
			const filedir = path.join(filePath, fileName);
			//根据文件路径获取文件信息，返回一个fs.Stats对象
			const stats = fs.statSync(filedir);
			const isFile = stats.isFile(); //是文件
			const isDir = stats.isDirectory(); //是文件夹
			if (isFile) {
					_fileName = path.basename(filedir);
					const fileNameArray = _fileName.split(".");
					fileSuffix = `.${fileNameArray[1]}`;
					let splitStr;
					if (fileSuffix === ".java") {
							splitStr = "/** The above part of the comment is auto generated, the following part is written by the user, please do not delete this comment. */";
					} else if (fileSuffix === ".xml") {
							splitStr = "<!-- The above part of the comment is auto generated, the following part is written by the user, please do not delete this comment. -->";
					} else {
							splitStr = "The above part of the comment is auto generated, the following part is written by the user, please do not delete this comment.";
					}
					if (pathObj[filedir] && fs.existsSync(pathObj[filedir])) {
							let data1 = fs.readFileSync(filedir, "utf-8");
							let str1 = data1.toString();
							const _data1 = str1.split(splitStr);
							updateFileStr = _data1[0];

							let data2 = fs.readFileSync(pathObj[filedir], "utf-8");
							let str2 = data2.toString();
							const _data2 = str2.split(splitStr);
							copyFileStr = _data2[1];
							resultStr = updateFileStr + splitStr + copyFileStr;
							// 写入文件
							fs.writeFileSync(filedir, resultStr, function (err) {
									if (err) return console.log(err);
							});
					}
			}
			if (isDir) {
					updateDirFile(filedir); //递归，如果是文件夹，就继续遍历该文件夹下面的文件
			}
    }
}

/**
* 删除文件
* @param delPath 文件路径
*/
function deleteFile(delPath) {
  try {
		// 判断文件或文件夹是否存在
		if (fs.existsSync(delPath)) {
			fs.unlinkSync(delPath);
		} else {
			console.log("inexistence path：", delPath);
		}
  } catch (error) {
    console.log("del error", error);
  }
}

/**
 * 删除文件夹下的文件
 */
function deleteDirFile() {
	for (const filePath in pathObj) {
		//根据文件路径获取文件信息，返回一个fs.Stats对象
		const stats = fs.statSync(filePath);
		const isFile = stats.isFile(); //是文件
		if (isFile && pathObj[filePath] && fs.existsSync(pathObj[filePath])) {
				deleteFile(pathObj[filePath]);
		}
	}
}


/**
 * init 初始化
 */
async function init() {
	try {
		const globalNodeModulesPathObj = await exec('npm root -g') || {};
		const globalNodeModulesPath = globalNodeModulesPathObj.stdout.replace('\n', '');
		const globalJasmineTemplatePath = path.join(globalNodeModulesPath, 'mybatis-cli/src/template');
		// Async with promises:
		fsExtra.copy(globalJasmineTemplatePath, `${process.cwd()}`)
			.then(() => console.log('mybatis-cli init success'))
			.catch((err) => console.error(err));
	} catch (error) {
		console.log("mybatis-cli init error: " + error);
	}
}

/**
 * generate 生成mybatis entity、mapper、xml
 */
async function generate() {
	try {
		const globalNodeModulesPathObj = await exec('npm root -g') || {};
		const globalNodeModulesPath = globalNodeModulesPathObj.stdout.replace('\n', '');
		const globalJasmineBinPath = path.join(globalNodeModulesPath, 'mybatis-cli/src/jasmine-bin/bin/jasmine');
		// 创建文件副本
		copyDirFile(srcPath);
		// 生成mybatis相关文件
		await exec(`${globalJasmineBinPath} ${process.cwd()}/jasmine.properties`);
		// 更新文件
		updateDirFile(srcPath);
		// 删除文件副本
		deleteDirFile();
		console.log('mybatis-cli generate success');
	} catch (error) {
		console.log("mybatis-cli generate error: " + error);
	}
}

// 输出支持的命令
yargs
  .scriptName('mybatis-cli')
  .usage('$0 <cmd> [args]')
  .command(
    'i',
    '初始化生成mybatis-cli配置文件',
    (yargs) => {},
    function (argv) {
      init();
    }
  )
  .command(
    'g',
    '生成mybatis',
    (yargs) => {},
    function (argv) {
      generate();
    }
  )
  .help().argv;