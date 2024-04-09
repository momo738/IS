package mockito;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PasswordValidatorTest {


    private User user;
    private User mockUser;
    @Before
    public void setUp() {
        user = new User("testUser", "19223");
        mockUser = mock(User.class);
        when(mockUser.authenticate("19223")).thenAnswer(invocation -> {
            throw new Exception("Course number");
        });
        when(mockUser.authenticate(anyString())).thenAnswer(invocation -> {
            Object arg = invocation.getArgument(0);
            return !"19223".equals(arg);
        });
    }
    @Test
    public void testExceptionOnMatchingPassword() {
        try {
            mockUser.authenticate("19223");
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            assertEquals("Course number", e.getMessage());
        }
    }
    @Test
    public void testFalseOnNonMatchingPassword() throws Exception {
        boolean result = mockUser.authenticate("password");
        assertFalse(result);
    }
    }