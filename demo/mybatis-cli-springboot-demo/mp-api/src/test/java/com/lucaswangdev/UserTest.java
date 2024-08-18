package com.lucaswangdev;

import com.lucaswangdev.entity.User;
import com.lucaswangdev.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper userMapper;

//    @Test
//    public void testDeleteByPrimaryKey() {
//        int result = userMapper.deleteByPrimaryKey(20L);
//        Assert.assertTrue(result >= 0);
//    }

    @Test
    public void testSelectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(2L);
        Assert.assertNotNull(user);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUserName("TestUser");
        user.setSex("1");
        user.setAddress("Test Address");
        int result = userMapper.insert(user);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testInsertSelective() {
        User user = new User();
        user.setUserName("SelectiveUser");
        int result = userMapper.insertSelective(user);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testInsertBatch() {
        // Create a list of User entities to insert
        List<User> userList = new ArrayList<>();

        // Prepare test data
        User user1 = new User();
        user1.setUserName("Lucas1");
        user1.setSex("M");
        user1.setAddress("Address1");

        User user2 = new User();
        user2.setUserName("Lucas2");
        user2.setSex("M");
        user2.setAddress("Address2");

        userList.add(user1);
        userList.add(user2);

        // Call insertBatch method and capture the result
        int rowsInserted = userMapper.insertBatch(userList);

        // Verify the result
        Assert.assertEquals(userList.size(), rowsInserted);
        System.out.println("Rows inserted: " + rowsInserted);
    }

    @Test
    public void testUpdateByPrimaryKey() {
        User user = new User();
        user.setId(2L);
        user.setGmtCreate(new Timestamp(System.currentTimeMillis()));
        user.setGmtModified(new Timestamp(System.currentTimeMillis()));
        user.setUserName("xxxName");
        user.setSex("1");
        user.setAddress("Updated Address");
        int result = userMapper.updateByPrimaryKey(user);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        User user = new User();
        user.setId(2L);
        user.setUserName("UpdatedUser");
        int result = userMapper.updateByPrimaryKeySelective(user);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testSelectCount() {
        User user = new User();
        user.setUserName("李四");
        int count = userMapper.selectCount(user);
        Assert.assertTrue(count >= 0);
    }

    @Test
    public void testSelectPage() {
        User user = new User();
        // 设置需要查询的条件，例如 user.setUserName("Lucas");

        // 创建分页对象，注意 page 是从 0 开始的
        // Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("gmt_create"), Sort.Order.desc("id")));
        List<User> users = userMapper.selectPage(user, pageable);
        Assert.assertNotNull(users);
        Assert.assertTrue(users.size() >= 0);
    }

    @Test
    public void testDelete() {
        int result = userMapper.delete(1L);
        Assert.assertTrue(result >= 0);
    }

    @Test
    public void testQueryByAddress() {
        User user = new User();
        user.setAddress("Test Address");
        List<User> users = userMapper.queryByAddress(user);
        Assert.assertNotNull(users);
        Assert.assertTrue(users.size() >= 0);
    }

    @Test
    public void testQuery() {
        User user = userMapper.query(2L);
        Assert.assertNotNull(user);
    }

}
