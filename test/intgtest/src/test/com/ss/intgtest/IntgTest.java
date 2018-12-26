package com.ss.intgtest;

import static org.junit.Assert.assertNotNull;

import com.ss.business.model.User;
import com.ss.business.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes=TestConfig.class)
 public class IntgTest 
{

    @Autowired
    private UserService userService;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldFindUser()
    {
        User user = new User();
        user.setName("Harry");
        userService.addUser(user);
        assertNotNull(userService.findByName("Harry"));
    }
}
