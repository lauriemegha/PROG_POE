public class Login {
    private String username;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    // Constructor to initialize user parameters
    public Login(String username, String password, String phoneNumber, 
     String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Verifies username has an underscore and is 5 characters or fewer
    public boolean checkUserName() {
        return username != null && 
               username.contains("_") && 
               username.length() <= 5;
    }

    // Verifies password meets complexity criteria
    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) {
            return false;
        }
        
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        return hasUpper && hasDigit && hasSpecial;
    }

    // Regular Expression matching South African international country code
    public boolean checkPhoneNumber() {
        return phoneNumber != null && 
               phoneNumber.matches("^\\+27\\d{9,10}$");
    }

    // Assesses formatting checks and maps to exact task assignment text strings
    public String registerUser() {
        String usernameMessage;
        String passwordMessage;
        String phoneMessage;

        if (checkUserName()) {
            usernameMessage = "Username successfully captured.";
        } else {
            usernameMessage = "Username is not correctly formatted; "
                            + "please ensure that your username "
                            + "contains an underscore and is no "
                            + "more than five characters in length.";
        }

        if (checkPasswordComplexity()) {
            passwordMessage = "Password successfully captured.";
        } else {
            passwordMessage = "Password is not correctly formatted; "
                            + "please ensure that the password "
                            + "contains at least eight characters, "
                            + "a capital letter, a number, and "
                            + "a special character.";
        }

        if (checkPhoneNumber()) {
            phoneMessage = "Cell phone number successfully added.";
        } else {
            phoneMessage = "Cell phone number incorrectly formatted "
                         + "or does not contain international code.";
        }

        return usernameMessage + "\n" + passwordMessage + "\n" + phoneMessage;
    }

    // Validates incoming verification credentials
    public boolean loginUser(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && 
               this.password.equals(inputPassword);
    }

    // Maps system response status onto greeting or error notifications
    public String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful) {
            return "Welcome " + firstName + ", " + lastName 
                 + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
