
package purchase_order_management_system_.pom;

import java.util.ArrayList; // Import the ArrayList class from the java.util package.

public class Login { // Define a class called Login.

    private String username = ""; // Declare and initialize a private instance variable 'username'.
    private String password = ""; // Declare and initialize a private instance variable 'password'.
    private String role = "";     // Declare and initialize a private instance variable 'role'.
    private String user_id = "";  // Declare and initialize a private instance variable 'user_id'.

    public String toString() { // Define the 'toString' method.

        return "-------------------------------------------------------------------------------------------------\n"
                + "Welcome to SIGMA SDN BHD (SSB)\n\n1.Username: " + this.username + "\n2.Password: " + this.password + "\n\n3.Login\n4.Exit"
                + "\n\nPlease provide your operation using a number, for example: input 1 to enter or modify the username"
                + "\nNote: Only admin can register a user, if you don't have an account, please proceed with the admin";
        // Return a formatted string that represents the login interface and instructions.
    }

    public boolean enter_credential(int command) { // Define the 'enter_credential' method that takes an integer 'command' as a parameter.

        boolean login = true; // Declare and initialize a boolean variable 'login' as true to control the login process.

        switch (command) { // Start a switch statement based on the 'command' parameter.

            case 1: // If 'command' is 1, prompt the user to enter the username and store it in 'username'.
                this.username = System_Common_Function.input_data("Please enter your username here: "); 
                break;

            case 2: // If 'command' is 2, prompt the user to enter the password and store it in 'password'.
                this.password = System_Common_Function.input_data("Please enter your password here: "); 
                break;

            case 3: // If 'command' is 3, create a File_Management object to manage the "userNamePassword.txt" file.
                File_Management obj3 = new File_Management("userNamePassword.txt"); 

                ArrayList<String> myline = obj3.read_file(); // Read the contents of "userNamePassword.txt" into the ArrayList 'myline'.

                for (String profile : myline) { // Iterate through each profile in 'myline'.

                    String[] profile_string = profile.split("~"); // Split the current profile with "~" as a delimiter and store it in 'profile_string'.

                    if ((this.username).equals(profile_string[1]) && (this.password).equals(profile_string[2])) { // Check if the entered username and password match the values in the current profile.

                        login = false; // Set 'login' to false (successful login).
                        this.user_id = profile_string[0]; // Retrieve and store the user ID.
                        this.role = profile_string[3];     // Retrieve and store the user role.
                        break; // Exit the loop.
                    }
                }

                if (login == true) { // If 'login' is true, indicating no matching profile was found.
                    System.out.println("""
                                       -------------------------------------------------------------------------------------------------
                                       Sorry, your username or password is incorrect.
                                       Please try again
                                       -------------------------------------------------------------------------------------------------
                                       """); // Display an error message for incorrect credentials.
                    break; // Exit the switch statement.
                } else { // If 'login' is not true (matching profile found).
                    System.out.println("Login successful"); // Display a login successful message.
                    break; // Exit the switch statement.
                }

            case 4: // If 'command' is 4, set 'login' to false to indicate the user wants to exit the login process.
                login = false; 
        }

        return login; // Return the 'login' variable to indicate whether the login was successful or not.
    }

    // Define getter and setter methods for username, password, role, and user_id.
    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public String getRole() {
        return role;
    }

    public String getUser_id() {
        return user_id;
    }
}
