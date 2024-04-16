package mockito;

public class PasswordValidator {
    private final String courseNumber;

    public PasswordValidator(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public boolean validatePassword(String inputPassword) throws Exception {
        if (inputPassword.equals(courseNumber)) {
            throw new Exception("Password equals the course number!");
        } else {
            return false;
        }
    }
}

