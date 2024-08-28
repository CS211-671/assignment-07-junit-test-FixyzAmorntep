package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        UserList user = new UserList();
        user.addUser("A1234","Hello");
        user.addUser("B1234","Hi");
        user.addUser("C1234","Welcome");

        User foundUser = user.findUserByUsername("B1234");

        assertNotNull(foundUser, "Not Found");
        assertEquals("B1234", foundUser.getUsername());
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("A1234","Hello");
        userList.addUser("B1234","Hi");
        userList.addUser("C1234","Welcome");

        // TODO: change password of one user

        boolean result = userList.changePassword("A1234", "Hello", "Testo2");

        // TODO: assert that user can change password
        assertTrue(result, "Password change should be successful");
        User user = userList.findUserByUsername("A1234");
        assertNotNull(user, "User should be found in the list");
        assertTrue(user.validatePassword("Testo2"), "Password should be updated to newPassword");
        assertFalse(user.validatePassword("Hello"), "Old password should no longer be valid");
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("A1234","Hello");
        userList.addUser("B1234","Hi");
        userList.addUser("C1234","Welcome");

        // TODO: call login() with correct username and password

        User user = userList.login("A1234", "Hello");

        // TODO: assert that User object is found
        assertNotNull(user, "User should be returned with correct username and password");
        assertEquals("A1234", user.getUsername(), "Username should match");
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList

        UserList userList = new UserList();
        userList.addUser("A1234","Hello");
        userList.addUser("B1234","Hi");
        userList.addUser("C1234","Welcome");

        // TODO: call login() with incorrect username or incorrect password

        User user = userList.login("A1234", "wrongPassword");

        // TODO: assert that the method return null
        assertNull(user, "User should not be returned with incorrect password");
    }

}