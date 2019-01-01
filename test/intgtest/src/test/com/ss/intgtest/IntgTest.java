package com.ss.intgtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import com.ss.business.model.User;
import com.ss.business.service.DroolsService;
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
    @Autowired
    private DroolsService droolsService;
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

    @Test
    public void greetUser()
    {
        User user = new User();
        user.setName("Harry");
        assertEquals(droolsService.greetUser(user).getMessage(), "Sorry, I dont know you");
        user.setName("abc");
        assertNotEquals(droolsService.greetUser(user).getMessage(), "Sorry, I dont know you");
        assertEquals(droolsService.greetUser(user).getMessage(), "Hello abc");

        user.setName("123");
        assertEquals(droolsService.greetUser(user).getMessage(), "Hello 123");
    }
}
