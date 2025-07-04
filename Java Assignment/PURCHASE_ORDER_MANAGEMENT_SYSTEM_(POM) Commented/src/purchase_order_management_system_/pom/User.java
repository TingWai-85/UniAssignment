
package purchase_order_management_system_.pom;

import java.util.ArrayList;
// Define a Java class name as "User" 
public class User {
    
    // Private instance variables to store user information
    private String user_id;
    private String[] user_data;  // Stores user data read from "profileDetail.txt"
    private String[] user_pass;  // Stores user passwords read from "userNamePassword.txt"

    // Constructor for the User class, taking user ID as a parameter
    public User(String id) {
        // Initialize the user_id field with the provided ID
        this.user_id = id;
        
        // Read user data from "profileDetail.txt" and store in user_data array
        File_Management obj1 = new File_Management("profileDetail.txt");
        ArrayList<String> myline = obj1.read_file();
        for (String user : myline) {
            String[] user_detail = user.split("~");
            if (id.equals(user_detail[0])) {
                this.user_data = user_detail;
                break;
            }
        }
        
        // Read user passwords from "userNamePassword.txt" and store in user_pass array
        File_Management obj2 = new File_Management("userNamePassword.txt");
        ArrayList<String> myuserpass = obj2.read_file();
        for (String user : myuserpass) {
            String[] user_password = user.split("~");
            if (id.equals(user_password[0])) {
                this.user_pass = user_password;
                break;
            }
        }
    }
    
    // Override the toString() method to provide a formatted user information string
    public String toString() {
        // Return a formatted string with user details including ID, name, gender, etc
        return "Staff ID: " + this.user_id +
                "\nName: " + this.user_data[1] +
                "\nGender: " + this.user_data[2] +
                "\nEmail: " + this.user_data[3] +
                "\nPhone: " + this.user_data[4] +
                "\nRole: " + this.user_data[5] +
                "\nUsername: " + this.user_pass[1] +
                "\nPassword: " + this.user_pass[2] +
                "\n\n1. Change Password" +
                "\n2. Back";
    }
    
    // A method to generate a user menu based on the user's role
    public String user_operation() {
        // Initialize a variable to hold the user menu
        String daily_item_sale_operand;
        
        // Determine the user's role and show the menu options 
        if ("Purchase_Manager".equals(this.user_data[5])) {
            daily_item_sale_operand = "\n\n6. Sign Out\n" +
                                      "7. Exit" +
                                      "\n\nPlease provide your operation using a number, for example, input 0 to view your personal details\n" +
                                      "Note: The available actions depend on your role's privileges.\n" +
                                      "If you have the right to access something but the system doesn't allow it, please report it to an admin as soon as possible!";
        } else if ("Admin".equals(this.user_data[5])) {
            daily_item_sale_operand = "6. Daily Item-wise Sales\n" +
                                        "7. Registration\n\n" +
                                        "8. Sign Out\n"+
                                        "9. Exit" +
                                        "\n\nPlease provide your operation using a number, for example, input 0 to view your personal details\n" +
                                      "Note: The available actions depend on your role's privileges.\n" +
                                      "If you have the right to access something but the system doesn't allow it, please report it to an admin as soon as possible!";
        } else {
            daily_item_sale_operand = "6. Daily Item-wise Sales\n\n" +
                                      "7. Sign Out\n" +
                                      "8. Exit" +
                                      "\n\nPlease provide your operation using a number, for example, input 0 to view your personal details\n" +
                                      "Note: The available actions depend on your role's privileges.\n" +
                                      "If you have the right to access something but the system doesn't allow it, please report it to an admin as soon as possible!";
        }
        
        // Return the complete user menu
        return "\n1. Personal Detail\n\n" + 
                "2. Item\n" +
                "3. Supplier\n" +
                "4. Purchase Requisition\n" +
                "5. Purchase Order\n" +  
                daily_item_sale_operand;
    }
    
    // A method to handle user registration
    public void registeration() {
        // Initialize variables to store user details and credentials
        boolean register = true;
        boolean select_role = true;
        String[] detail = {"", "", "", "", "", ""};  // To store data in "profileDetail.txt"
        String[] credential = {"", "", "", ""};      // To store data in "userNamePassword.txt"
        
        // Main registration loop
        while (register == true) {
            // Role selection loop
            while (select_role == true) {
                // Display the role selection menu
                System.out.println("\n-------------------------------------------------------------------------------------------------\nRegistration: ");
                System.out.println("1. Sales Manager"
                        + "\n2. Purchase Manager"
                        + "\n3. Admin"
                        + "\n4. Back"
                        + "\n\nPlease select the role of the staff you wish to register!"
                        + "\nFor example, input 1 to register a Sales Manager.");
            
                // Read the user's choice for role selection
                int command = System_Common_Function.operation(4);
                String code_prefix = "";

                // Set the user's role and code prefix based on user's choice
                switch (command) {
                    case 1:
                        detail[5] = "Sales_Manager";
                        credential[3] = "Sales_Manager";
                        code_prefix = "SM";
                        select_role = false;
                        break;
                    case 2:
                        detail[5] = "Purchase_Manager";
                        credential[3] = "Purchase_Manager";
                        code_prefix = "PM";
                        select_role = false;
                        break;
                    case 3:
                        detail[5] = "Admin";
                        credential[3] = "Admin";
                        code_prefix = "AM";
                        select_role = false;
                        break;
                    case 4:
                        select_role = false;
                        register = false;
                        break;
                }
                // Generate and set the staff ID based on the role and code prefix
                detail[0] = System_Common_Function.auto_generate_code(2, code_prefix, "profileDetail.txt");
                credential[0] = detail[0];
            }
            
            // Display and collect user information
            System.out.println("\nStaff Detail:\n\n0. Staff ID: " + detail[0] +
                                "\n1. Name: " + detail[1] +
                                "\n2. Gender: " + detail[2] +
                                "\n3. Email: " + detail[3] +
                                "\n4. Phone: " + detail[4] +
                                "\n0. Role: " + detail[5] +
                                "\n5. Username: " + credential[1] +
                                "\n6. Password: " + credential[2] +
                                "\n\n7. Register" +
                                "\n8. Back");
            
            // Staff Detail input menu
            System.out.println("\n\nNote: The code of the staff will be auto-generated by this system based on the code of the last staff's code stored in this system" +
                 "\nPlease provide the detail of the staff" +
                "\nFor example, choose 1 to input the name of the staff." +
                "\nPlease select your choice to input the data: ");
            int command = System_Common_Function.operation(8);

            // Process user input and set user details accordingly
            switch (command) {
                case 1:
                    detail[1] = System_Common_Function.input_data("Please enter the name of the staff: ");
                    break;
                case 2:
                    System.out.println("1. Male\n2. Female\n\nPlease select the gender of the staff: ");
                    int gender = System_Common_Function.operation(2);
                    if (gender == 1) {
                        detail[2] = "Male";
                    } else if (gender == 2) {
                        detail[2] = "Female";
                    } else {
                        System.out.println("\nSorry, I don't understand you, please try again!");
                    }
                    break;
                case 3:
                    detail[3] = System_Common_Function.input_data("Please enter the email of the staff: ");
                    break;
                case 4:
                    String phone = System_Common_Function.input_data("Please enter the phone (without any symbol including -) of the staff: ");
                    if (isNumeric(phone)) {
                        detail[4] = phone;
                    } else {
                        System.out.println("\nSorry, here only accept number (without any symbol including -)");
                    }
                    break;
                case 5:
                    String username = System_Common_Function.input_data("Please enter the username of the staff:");

                    // Check if the username already exists in the system
                    File_Management obj2 = new File_Management("userNamePassword.txt");
                    ArrayList<String> myuserpass = obj2.read_file();
                    for (String user : myuserpass) {
                        String[] user_password = user.split("~");
                        if (username.equals(user_password[1])) {
                            username = ""; // If the username exists in our file, reset the variable username as empty
                        }
                    }

                    if (username.equals("")) {
                        // If the variable username is not empty, it means the username already exists in the system.
                        System.out.println("\nSorry, the username has already existed in our system, please try another username!");
                    } else {
                        credential[1] = username;
                    }
                    break;
                case 6:
                    credential[2] = System_Common_Function.input_data("Please enter the password of the staff: ");
                    break;
                case 7:
                    if (detail[0].equals("") || detail[1].equals("") || detail[2].equals("") || detail[3].equals("") || detail[4].equals("") || detail[5].equals("") || credential[0].equals("") || credential[1].equals("") || credential[2].equals("") || credential[3].equals("")) {
                        // Check if any detail is blank and prompt the user to provide all the details
                        System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                        System.out.println("Sorry, the details here cannot be blank. Please provide all the details!");
                        System.out.println("-------------------------------------------------------------------------------------------------");
                    } else {
                        // If all details are provided, write them into the respective text files
                        String detail_ready_write_into_file = detail[0] + "~" + detail[1] + "~" + detail[2] + "~" + detail[3] + "~" +
                                detail[4] + "~" + detail[5] + "~";
                        String credential_ready_write_into_file = credential[0] + "~" + credential[1] + "~" + credential[2] + "~" +
                                credential[3] + "~";

                        File_Management obj100 = new File_Management("profileDetail.txt");
                        File_Management obj200 = new File_Management("userNamePassword.txt");

                        obj100.write_file(detail_ready_write_into_file);
                        obj100.write_file("\n");

                        obj200.write_file(credential_ready_write_into_file);
                        obj200.write_file("\n");

                        System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                        System.out.println("You have successfully registered a new staff!");
                        System.out.println("-------------------------------------------------------------------------------------------------");

                        // Reset all detail and credential variables for the next registration
                        detail[0] = "";
                        detail[1] = "";
                        detail[2] = "";
                        detail[3] = "";
                        detail[4] = "";
                        detail[5] = "";
                        credential[0] = "";
                        credential[1] = "";
                        credential[2] = "";
                        credential[3] = "";

                        // Exit the registration loop.
                        register = false;
                        break;
                    }
                    break;
                case 8:
                    // Exit the registration loop.
                    register = false;
                    break;
            } 
        }
    }    

// Method to handle changing the user's password
    public void changePassword() {
        boolean change = true;
        while (change == true) {
            // Prompt the user to enter a new password
            String new_password = System_Common_Function.input_data("Please enter your new password: ");

            // Array to store the user's profile in "userNamePassword.txt"
            String[] profile_of_the_user_in_userNamePassword = new String[4];

            // Read the contents of "userNamePassword.txt" and search for the user's profile
            File_Management obj2 = new File_Management("userNamePassword.txt");
            ArrayList<String> myuserpass = obj2.read_file();
            int position = 0;

            for (String user : myuserpass) {
                String[] user_password = user.split("~");
                if (this.user_id.equals(user_password[0])) {
                    profile_of_the_user_in_userNamePassword = user_password;
                    break;
                }
                position = position + 1; // Get the position index of this particular profile in the userNamePassword text file
            }

            // Create a new credential string with the updated password.
            String credential_ready_write_into_file = profile_of_the_user_in_userNamePassword[0] + "~" +
                                                      profile_of_the_user_in_userNamePassword[1] + "~" + 
                                                      new_password + "~" +
                                                      profile_of_the_user_in_userNamePassword[3] + "~";

            if (new_password.equals(profile_of_the_user_in_userNamePassword[2])) {
                // If the new password is the same as the original password, display a message and do not change the password.
                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                System.out.println("Sorry, you've entered the same password as your original password. Failed to change the password.");
                System.out.println("-------------------------------------------------------------------------------------------------");
                change = false;
                break;
            } 
            else {
                // Update the password in the ArrayList and rewrite the "userNamePassword.txt" file.
                myuserpass.set(position,credential_ready_write_into_file);
                obj2.rewrite_file(myuserpass);
                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                System.out.println("Your password has been changed successfully!");
                System.out.println("-------------------------------------------------------------------------------------------------");
                change = false;
                break;
            }
        }
        
    }
    
    // Getter method to retrieve the user's ID.
    public String getUser_id() {
        return user_id;
    }

    // Getter method to retrieve the user's data.
    public String[] getUser_data() {
        return user_data;
    }

    // Method to check if a given string is numeric.
    public boolean isNumeric(String string) {
        try {
            double Value = Double.parseDouble(string);
            return true;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }
} 









