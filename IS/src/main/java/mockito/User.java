package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class User {
    private String username;
    private String password;
    private boolean locked;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.locked = false;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password) && !locked;
    }

    public boolean isLocked() {
        return locked;
    }

    public void resetPassword(String newPassword) {
        this.password = newPassword;
        unlockUser();
    }

    public void lockUser() {
        this.locked = true;
    }

    public void unlockUser() {
        this.locked = false;
    }
}

class UserTest {

    @Test
    void successfulAuthentication() {
        User user = Mockito.mock(User.class);
        when(user.authenticate("19212")).thenReturn(true);

        assertTrue(user.authenticate("19212"));
    }

    @Test
    void unsuccessfulAuthentication() {
        User user = Mockito.mock(User.class);
        when(user.authenticate("19212_false")).thenReturn(false);

        assertFalse(user.authenticate("19212_false"));
    }

    @Test
    void lockUser() {
        User user = new User("19212", "19212");
        user.lockUser();

        assertTrue(user.isLocked());
    }

    @Test
    void unlockUser() {
        User user = new User("19212", "19212");
        user.unlockUser();

        assertFalse(user.isLocked());
    }

    @Test
    void resetPasswordAndUnlock() {
        User user = new User("19212", "19212");
        user.lockUser();
        user.resetPassword("new_19212");

        assertFalse(user.isLocked());
        assertTrue(user.authenticate("new_19212"));
    }
}


