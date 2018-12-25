 package com.ss.unittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.*;

import com.ss.business.model.User;
import com.ss.business.service.UserService;

/**
 * Unit test for UserService.
 */
public class UserServiceTest 
{
    UserService userService = null;

    @Before
    public void runBeforeTestMethod() {
        userService = new UserService();
    }
    
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAddUser()
    {
        User user = new User();
        user.setName("Harry");
        userService.addUser(user);
        assertEquals(userService.getUsers().size(), 1);
    }

    @Test
    public void shouldFindUser()
    {
        User user = new User();
        user.setName("Harry");
        userService.addUser(user);
        assertNotNull(userService.findByName("Harry"));
    }
}
