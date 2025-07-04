
package purchase_order_management_system_.pom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

abstract class System_Common_Function {

    public System_Common_Function(){
    }
    // Method to view all items
    public ArrayList view_items() {
        // Initialize a File_Management object to read the item data file
        File_Management obj1 = new File_Management("item.txt");
        // Read the item data from the file and store it in the 'items' ArrayList
        ArrayList<String> items = obj1.read_file();
        // Initialize an ArrayList to store index and code information
        ArrayList<String[]> index_code = new ArrayList<String[]>();
        // Display a header for the list of items
        System.out.println("Items: ");
        int index = 4; // Starting index
        // Display a table header with columns for index, code, stocks, and item's name
        System.out.println(String.format("| %-8s "+"| %-10s "+"| %-10s "+"| %-50s |", "Index","Code","Stocks","Item's Name"));
        // Iterate through each item in the 'items' ArrayList
        for (String item_name: items) {
            String[] item_string = item_name.split("~");
            // Create a temporary array to store index and item's code
            String[] temporary = {Integer.toString(index),item_string[0]};
            // Add the temporary array to the 'index_code' ArrayList
            index_code.add(temporary);
            // Display the item's details in a formatted table row
            System.out.println(String.format("| %-8s "+"| %-10s "+"| %-10s "+"| %-50s |", index,item_string[0],item_string[5],item_string[1]));
            index = index + 1; // Increment the index for the next item
        }
        // Initialize another File_Management object to read PR (Purchase Requisition) data
        File_Management obj2 = new File_Management("PR.txt");
        // Read PR data from the file
        ArrayList<String> itemss = obj2.read_file();
        // Display a message for unadded items from PR
        System.out.println("\nSome items purchased by Purchase Managers have arrived but haven't been added to the system"
                + "\nUnadded Item: ");
        System.out.println(String.format("| %-8s "+"| %-10s "+"| %-10s "+"| %-10s " + "| %-10s |", "Index","Item","Price","Quantity","Supplier"));
        int indexs = 1000; // Starting index for unadded items
        // Iterate through each item in PR
        for (String item_name: itemss) {
            String[] item_string = item_name.split("~");
            // Check if the item is marked as arrived, approved, and unadded
            if (item_string[8].equals("Arrived") && item_string[9].equals("Approved") && item_string[10].equals("")) {
                // Display the details of unadded items in a formatted table row
                System.out.println(String.format("| %-8s "+"| %-10s "+"| %-10s "+"| %-10s " + "| %-10s |", indexs,item_string[2],item_string[3],item_string[4],item_string[6]));
                indexs = indexs + 1;
            }
        }
        // Display menu options for adding new items, deleting existing items, or go back
        System.out.println("\n\n1 Add new" +
                           "\n2 Delete the existing" +
                           "\n3 Back" +
                           "\n\nPlease provide your operation using a number. For example, input 1 to add a new element." +
                           "\nNote: You can also input the index of a particular item to VIEW or EDIT its details." +
                           " For example, input 4 to VIEW or EDIT the details of the first item." +
                           "\nNote: The actions available depend on your role's privileges." +
                           "\nIf you find that you have the right to access something but the system is not allowing it, please report to the admin as soon as possible!");

        return index_code; // Return the index and code information for item selection
    }

    
    
    
    
    
    
    
    
    
    
    public void detail(String position, int command, ArrayList<String[]> indexWITHcode) {
        // Initialize a File_Management object to work with a file named "item.txt"
        File_Management obj1 = new File_Management("item.txt");
        // Read items from the file
        ArrayList<String> items = obj1.read_file();
        // Initialize variables to store the original item detail and its string representation
        String original_detail = null;
        String[] item_detail_string = null;
        // Initialize a variable to keep track of the position in the file
        int position_file = 0;
        // Get the code of the item based on the provided command
        String code = "0";
        for (String[] i : indexWITHcode) {
            if (command == Integer.parseInt(i[0])) {
                code = i[1];
            }
        }
        // Find and store the item's detail by matching the code
        for (String item_name : items) {
            String[] item_string = item_name.split("~");
            if (code.equals(item_string[0])) {
                item_detail_string = item_string; // Store the item's details
                original_detail = item_name; // Store the original detail string
                break;
            }
            position_file = position_file + 1;
        }
        boolean view_detail = true;
        while (view_detail == true) {
            // Display the item's details with options
            System.out.println("\n-------------------------------------------------------------------------------------------------\nItem's Detail: ");
            System.out.println("\n0. Code: " + item_detail_string[0] +
                               "\n1. Name: " + item_detail_string[1] +
                               "\n2. Type: " + item_detail_string[2] +
                               "\n3. Expire Date: " + item_detail_string[3] +
                               "\n4. Price: " + item_detail_string[4] +
                               "\n5. Stock: " + item_detail_string[5] +
                               "\n6. Description: " + item_detail_string[6] +
                               "\n7. Supplier: " + item_detail_string[7] +
                               "\n\n8 Save"  +
                               "\n9 Back");
            
            if (position.equals("SM")) {
                // Display a note informing the user they can't modify the item's code
                System.out.println("Note: you can't modify the code of the item!");
                // Prompt the user to choose an action for modifying the item details
                int command_detail = operation(9);
                // Switch statement to handle user's choices
                switch (command_detail) {
                    case 1:
                        // User choose to modify the item's name
                        String item_name = input_data("Please enter the name of the item: ");
                        // Check if the entered item name already exists
                        for (String element : items) {
                            String[] element_array = element.split("~");
                            if (item_name.equals(element_array[1])) {
                                // Item name already exists, inform the user and exit
                                System.out.println("Sorry, the item is already existed.\nPlease try again!");
                                break;
                            } else {
                                // Update the item's name
                                item_detail_string[1] = item_name;
                                break;
                            }
                        }
                        break;
                    case 2:
                        // User choose to modify the item's type
                        item_detail_string[2] = System_Common_Function.input_data("Please enter the type of the item: ");
                        break;
                    case 3:
                        // User choose to modify the item's expiration date
                        System.out.println("Format: dd-mm-yyyy");
                        item_detail_string[3] = System_Common_Function.input_data("Please enter the expire date of the item: ");
                        break;
                    case 4:
                        // User choose to modify the item's price
                        String price = System_Common_Function.input_data("Please enter the price of the item (without RM): ");
                        if (isNumeric(price)) {
                            // Check if the entered value is a valid number
                            item_detail_string[4] = "RM " + price; // Update the item's price
                        } else {
                            System.out.println("Sorry, here only accept numbers.");
                        }
                        break;
                    case 5:
                        // User choose to modify the item's stock quantity
                        String stocks = System_Common_Function.input_data("Please enter the stock of the item: ");
                        if (isNumeric(stocks)) {
                            // Check if the entered value is a valid number
                            item_detail_string[5] = stocks; // Update the item's stock quantity
                        } else {
                            System.out.println("Sorry, here only accept numbers.");
                        }
                        break;
                    case 6:
                        // User choose to modify the item's description
                        item_detail_string[6] = System_Common_Function.input_data("Please enter the description of the item: ");
                        break;
                    case 7:
                        // User choose to modify the item's supplier
                        System.out.println("Please input a correct format, for example: S00001");
                        String supplier = System_Common_Function.input_data("Please enter the supplier of the item: ");
                        File_Management obj2 = new File_Management("supplier.txt");
                        ArrayList<String> supp = obj2.read_file();
                        for (String element : supp) {
                            String[] element_array = element.split("~");
                            if (supplier.equals(element_array[0])) {
                                // Check if the entered supplier code exists in the system
                                item_detail_string[7] = supplier; // Update the item's supplier
                            }
                        }
                        if (item_detail_string[7].equals("")) {
                            System.out.println("Your supplier id's format is incorrect or is not in our system." +
                                    "\nPlease check the existing supplier id first and input a valid supplier id that this system recognizes");
                        }
                        break;
                    case 8:
                        // User choose to save the modified item's details
                        if (item_detail_string[0].equals("") || item_detail_string[1].equals("") || item_detail_string[2].equals("") || item_detail_string[3].equals("") || item_detail_string[4].equals("") || item_detail_string[5].equals("") || item_detail_string[6].equals("") || item_detail_string[7].equals("")) {
                            // Check if any required field is blank
                            System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                            System.out.println("Sorry, the detail here cannot be blank.\nPlease provide all the detail!");
                            System.out.println("-------------------------------------------------------------------------------------------------");
                            break;
                        } else {
                            String ready_write_into_file = item_detail_string[0] + "~" + item_detail_string[1] + "~" + item_detail_string[2] + "~" + item_detail_string[3] + "~"
                                    + item_detail_string[4] + "~" + item_detail_string[5] + "~" + item_detail_string[6] + "~" + item_detail_string[7];
                            if (ready_write_into_file.equals(original_detail)) {
                                // Check if any changes were made to the item's details
                                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                                System.out.println("Sorry, you have not made any changes to the item.\nPlease try again");
                                System.out.println("-------------------------------------------------------------------------------------------------");
                            } else {
                                items.set(position_file, ready_write_into_file);
                                obj1.rewrite_file(items);
                                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                                System.out.println("Your item's detail has been updated successfully!");
                                System.out.println("-------------------------------------------------------------------------------------------------");
                            }
                            break;
                        }
                    case 9:
                        // User choose to go back to the previous menu
                        view_detail = false;
                        break;
                    default:
                        // Error case: Invalid input
                        System.out.println("Sorry, something error occured!");
                        break;
                }
            }
            else{
                int command_detail = System_Common_Function.operation(9);
                if (command_detail == 9){
                    // User choose to go back to the previous menu
                    view_detail = false;
                    break;
                }
                else if (command_detail <9){
                    // Error, user doesn't have permission to modify item details
                    System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                    System.out.println("Sorry, you can't modify the detail of the item.\nPlease contact the manager if you wish to do so.");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                }
                else{
                    // Error, Invalid input
                    System.out.println("Sorry, something error occurred!");
                    break;
                }
            } 
        }
    }
    
    
    
    
    
    
    
    
    
    
//supplier-------------------------------------------------------------------------------------------------------------------------
    // This method displays a list of suppliers and returns an ArrayList of index-code pairs.
    public ArrayList view_supplier() {
        // Create a File_Management object to read the "supplier.txt" file.
        File_Management obj1 = new File_Management("supplier.txt");
        // Read the contents of the "supplier.txt" file into an ArrayList.
        ArrayList<String> supp = obj1.read_file();
        // Create an ArrayList to store index-code pairs.
        ArrayList<String[]> index_code = new ArrayList<String[]>();
        // Display a header for the list of suppliers.
        System.out.println("Supplier: ");
        int index = 4; // Starting index for the list.
        // Display a table header with columns
        System.out.println(String.format("| %-8s "+"| %-10s "+"| %-50s |", "Index","Code","Name"));
        // Iterate through the list of suppliers and display their details.
        for (String supp_name: supp){
            String[] item_string = supp_name.split("~");
            //to store the string [index,item's code] to locate the item in the file easily later
            String[] temporary = {Integer.toString(index),item_string[0]};
            // Add the temporary array to the index_code ArrayList.
            index_code.add(temporary);
            // Display the supplier's details in a formatted table row.
            System.out.println(String.format("| %-8s "+"| %-10s "+"| %-50s |", index,item_string[0],item_string[1]));
            index = index + 1; // Increment the index for the next supplier.
        }

        // Display options for adding, deleting, or going back.
        System.out.println("\n\n1 Add new" +
                           "\n2 Delete the exist" +
                           "\n3 Back" +
                           "\n\nPlease provide your operation using a number. For example, input 1 to add a new supplier." +
                           "\nNote: You can input the index of a particular supplier to VIEW or EDIT its details." +
                           "For example, input 4 to VIEW or EDIT the details of the first supplier." +
                           "\nNote: The actions available depend on your role's privileges." +
                           "\nIf you encounter any issues with access, please report them to the admin.");
        // Return the ArrayList containing index-code pairs.
        return index_code;
    }

        
        
        
        
        
        
        
        
        
        
    public void supp_detail(String position,int command,ArrayList<String[]> indexWITHcode){
        // Create a File_Management object to read the "supplier.txt" file.
        File_Management obj1 = new File_Management("supplier.txt");
        // Read the contents of the "supplier.txt" file into an ArrayList.
        ArrayList<String> items = obj1.read_file();
        // Initialize variables to store supplier details.
        String original_detail = null;
        String[] supp_detail_string = null;
        // Retrieve the list of items supplied by the supplier.
        ArrayList<String> supp_item = supplier_item();
        String item_supplied = "";
        int position_file = 0;
        // Initialize a default supplier code.
        String code = "0";
        // Find the supplier's code based on the provided command and index-code pairs.
        for (String[] i:indexWITHcode){
            if (command == Integer.parseInt(i[0])){
                code = i[1];
            }
        }
        // Find and store the supplier's details and original detail string.
        for (String supp_name: items){
            String[] supp_string = supp_name.split("~");
            if (code.equals(supp_string[0])){
                supp_detail_string = supp_string;
                original_detail = supp_name;
                break;
            }
            position_file = position_file + 1;
        }
        // Find the items supplied by the supplier.
        for (String supp_items: supp_item){
            String[] supp_item_string = supp_items.split("~");
            if (code.equals(supp_item_string[0])){
                item_supplied = supp_item_string[1];
            }
        }
        
        boolean view_detail = true;
        while (view_detail == true){
                
                System.out.println("\n-------------------------------------------------------------------------------------------------\nSupplier's Detail: ");
                System.out.println("\n0. Code: " + supp_detail_string[0] +
                                "\n1. Name: " + supp_detail_string[1] +
                                "\n2. Person in charge: " + supp_detail_string[2] +
                                "\n3. Contact: " + supp_detail_string[3] +
                                "\n4. Address: " + supp_detail_string[4] +
                                "\n5. Item supplied: " + item_supplied +
                                "\n\n6 Save"  +
                                "\n7 Back");

            // Check the user's role or position to determine the available actions.
            if (position.equals("SM")){
                System.out.println("\nNote: you can't modify the code of the item!");
                int command_detail = operation(7);
                // Get the user's choice for editing supplier details.
                switch (command_detail){
                    case 1:
                        // Allow the user to edit the supplier's name.
                        String item_name = input_data("Please enter the name of the supplier: ");
                        for (String element:items){
                            // Iterate through existing suppliers to check for duplicates.
                            String[] element_array = element.split("~");
                            if (item_name.equals(element_array[1])){
                                // If a supplier with the same name exists, inform the user and break the loop.
                                System.out.println("Sorry, the item is already existed.\nPlease try again!");
                                break;
                            }
                            else{
                                // If the name is unique, update the supplier's name.
                                supp_detail_string[1] = item_name;
                                break;
                            }
                        }
                        break;
                    case 2:
                        // Allow the user to edit the person in charge of the supplier.
                        supp_detail_string[2] = System_Common_Function.input_data("Please enter the person in charge of the supplier: ");
                        break;
                    case 3:
                        // Allow the user to edit the contact information of the person in charge.
                        String contact = System_Common_Function.input_data("Please enter the contact of the person in charge (without -): ");
                        if (isNumeric(contact)){
                            // Check if the input is numeric (phone number) and format it as "RM xxx".
                            supp_detail_string[3] = "RM " + contact;
                        }
                        else{
                            // Display an error message if the input is not numeric.
                            System.out.println("Sorry, here only accept number.");
                        }
                        break;
                    case 4:
                        // Allow the user to edit the address of the supplier.
                        supp_detail_string[4] = System_Common_Function.input_data("Please enter the address of the supplier: ");
                        break; 
                    case 5:
                        // Inform the user that they can modify the items supplied in the item's interface,
                        // and the system will automatically update the information here.
                        System.out.println("\nYou can modify this in the item's interface.\n "
                               + "The system will automatically update the item supplied by this supplier here.");
                    case 6:
                        // Handle the case where the user chooses to save the updated supplier details.
                        if (supp_detail_string[0].equals("") || supp_detail_string[1].equals("") || supp_detail_string[2].equals("") || supp_detail_string[3].equals("") || supp_detail_string[4].equals("")){
                            // Check if any of the required supplier details (code, name, person in charge, contact, address) are blank.
                            System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                            System.out.println("Sorry, the detail here cannot be blank.\nPlease provide all the detail!");
                            System.out.println("-------------------------------------------------------------------------------------------------");
                            break;
                        }
                        else{
                            // If all required details are provided and not blank, proceed to save the updated details.
                            String ready_write_into_file = supp_detail_string[0]+"~"+supp_detail_string[1]+"~"+supp_detail_string[2]+"~"+supp_detail_string[3]+"~"
                                                            + supp_detail_string[4] +"~";
                            if (ready_write_into_file.equals(original_detail)){
                                // Check if the updated details are the same as the original details.
                                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                                System.out.println("Sorry, you have not made any changes to the item.\nPlease try again");
                                System.out.println("-------------------------------------------------------------------------------------------------");
                            }
                            else{
                                // Update the supplier's details in the list of suppliers and write it to the file.
                                items.set(position_file,ready_write_into_file);
                                obj1.rewrite_file(items);
                                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                                System.out.println("You have successfully update the supplier's detail.");
                                System.out.println("-------------------------------------------------------------------------------------------------");
                            }
                            break;
                        }
                    case 7:
                        // Handle the case where the user chooses to go back (exit from editing).
                        view_detail = false;
                        break;
                    default:
                        // Handle any other unexpected input or errors.
                        System.out.println("\nSorry, something error occurred!");
                        break;
                }
            }
            else{
                // Call the operation method to prompt the user to choose an action, expecting input between 1 and 7
                int command_detail = System_Common_Function.operation(7);
                // Check the user's choice using conditional statements
                if (command_detail == 7){
                    // If the user choose option 7, which is to go back, set view_detail to false to exit the loop
                    view_detail = false;
                    break;
                }
                else if (command_detail <7){
                    // If the user choose an option number less than 7, display an error message indicating that they can't modify item details
                    System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                    System.out.println("Sorry, you can't modify the detail of the item.\nPlease contact the manager if you wish to do so.");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                }
                else{
                    // If the user entered an invalid choice (greater than 7), display an error message
                    System.out.println("\nSorry, something error occurred!");
                    break;
                }
            } 
        }
    }
    
    
    
    
    
    
    
    
    
    
 //PR----------------------------------------------------------------------------------------------------------------------------------------------------
    // Define a method to view Purchase Requisitions
    public ArrayList view_pr() {
        // Create an instance of the File_Management class to manage PR.txt file
        File_Management obj1 = new File_Management("PR.txt");
        // Read the content of the PR.txt file into an ArrayList of strings
        ArrayList<String> items = obj1.read_file();
        // Create an ArrayList of string arrays to store index-code pairs for PRs
        ArrayList<String[]> index_code = new ArrayList<String[]>();
        // Display a header for the PR list
        System.out.println("Purchase Requisition: ");
        // Display a table header with column names
        int index = 4;
        System.out.println(String.format("| %-8s "+"| %-10s "+"| %-20s "+"| %-10s " + "| %-10s " + "| %-15s " +" | %-15s |", "Index","Code","Issue Date","Item","Quantity","Arrive Status","Approve Status"));
        // Initialize an index for displaying PRs
        // Iterate through the PRs and display their details
        for (String item_name: items){
            String[] item_string = item_name.split("~");
            // Create a temporary string array to store the index and PR code
            String[] temporary = {Integer.toString(index),item_string[0]};
            // Add the temporary array to the index_code ArrayList
            index_code.add(temporary);
            // Display the PR details in a formatted table row
            System.out.println(String.format("| %-8s "+"| %-10s "+"| %-20s "+"| %-10s " + "| %-10s " + "| %-15s " +" | %-15s |", index,item_string[0],item_string[1],item_string[2],item_string[4],item_string[8],item_string[9]));
            // Increment the index for the next PR
            index = index + 1;
        }
        // Display user operation options
        System.out.println("\n\n1 Add new" +
                           "\n2 Delete the exist" +
                           "\n3 Back" +
                           "\n\nPlease provide your operation using a number. For example, input 1 to add a new element." +
                           "\nNote: You can try to input the index of a particular PR to VIEW or EDIT its detail. \nBut you can only modify the detail of the Unproved PR." +
                           "For example, input 4 to VIEW or EDIT the detail of the first PR (If the first PR is already approved by the Purchase Manager, you can't modify it)." +
                           "\nNote: The actions provided depend on the privilege of your role." +
                           "\nIf you have found that you have the right to access something but the system is not allowed, please report to the admin as soon as possible!");
        // Return the index_code ArrayList containing PR index-code pairs
        return index_code;
    }


    
    
    
    
    
    
    
    
    
    public void pr_detail(String position, String user_id,int command,ArrayList<String[]> indexWITHcode){
        // Create an instance of the File_Management class to manage PR.txt file
        File_Management obj1 = new File_Management("PR.txt");
        // Read the content of the PR.txt file into an ArrayList of strings
        ArrayList<String> items = obj1.read_file();    
        // Initialize variables to store PR details and position in the file
        String original_detail = null;
        String[] item_detail_string = null;
        int position_file = 0;
        // Initialize a code variable to identify the PR to be edited
        String code = "0";
        // Find the PR code associated with the selected index
        for (String[] i:indexWITHcode){
            if (command == Integer.parseInt(i[0])){
                code = i[1];
            }
        }
        // Find and store the PR details for editing
        for (String item_name: items){
            String[] item_string = item_name.split("~");
            if (code.equals(item_string[0])){
                item_detail_string = item_string;
                original_detail = item_name;
                break;
            }
            position_file = position_file + 1;
        }
        // Initialize a boolean variable for controlling the detail view
        boolean view_detail = true;
        // Display the PR details and options in a loop
        while (view_detail == true){
            System.out.println("\n-------------------------------------------------------------------------------------------------\nPurchase Requisition's Detail: ");
            System.out.println("\n0. Code: " + item_detail_string[0] +
                            "\n1. Issue Date: " + item_detail_string[1] +
                            "\n2. Item: " + item_detail_string[2] +
                            "\n0. Single Price: " + item_detail_string[3] +
                            "\n3. Quantity: " + item_detail_string[4] +
                            "\n0. Total: " + item_detail_string[5] +
                            "\n0. Supplier: " + item_detail_string[6] +
                            "\n0. Sales Manager: " + item_detail_string[7] +
                            "\n0. Arrive Status: " + item_detail_string[8] +
                            "\n0. Approve Status: " + item_detail_string[9] +
                            "\n\n4 Save"  +
                            "\n5 Back" );
            // Check if the user is a Sales Manager (SM) or Admin and if the PR is editable
            if (position.equals("SM") && (item_detail_string[7].equals(user_id)) || user_id.equals("Admin")){
                System.out.println("\nNote: You can only modify Date, Item, Quantity and the destination of the unapproved Purchase Requisition."
                        +"\nIf you are not the Sale Manager who raise this Purchase Requisition, you can't modify this Purchase Requisition"
                        + "\nPrice, Total, and Supplier will change base on the item's code and also the quantity"
                        + "\nThe status can only be modified by Purchase Manager");
                // Get the user's command for editing
                int command_detail = System_Common_Function.operation(6);
                

                if (item_detail_string[9].equals("Unapproved")){
                    switch (command_detail){
                        case 1:
                            // Edit the Issue Date of the PR
                            System.out.println("Format: dd-mm-yyyy");
                            item_detail_string[1] = System_Common_Function.input_data("Please enter the  date of the sales: ");
                            break;
                        case 2:
                            // Edit the Item field of the PR
                            String original = item_detail_string[2];
                            System.out.println("Please input a correct format of the item's code, for example: I000001");
                            String item_code = System_Common_Function.input_data("Please enter the code of the item: ");
                            File_Management obj100 = new File_Management("item.txt");
                            ArrayList<String> itm = obj100.read_file();
                            // Check if the entered item code exists in the system
                            for (String element:itm){
                                String[] element_array = element.split("~");
                                if (item_code.equals(element_array[0])){
                                    item_detail_string[2] = item_code;
                                    item_detail_string[3] = element_array[4];
                                    double single = Double.parseDouble(item_detail_string[3].substring(3));
                                    double item_quantity = Double.parseDouble(item_detail_string[4]);
                                    double total = single * item_quantity;
                                    item_detail_string[5] = String.format("RM %.2f",total);
                                    item_detail_string[6] = Daily_Sales.item_supplier(item_detail_string[2]);
                                }  
                            }
                            // If the entered item code is not found or has an incorrect format
                            if (item_detail_string[2].equals(original)){
                                System.out.println("Your item id's format is incorrect or is not in our system." +
                                       "\nPlease check the existing item id first and input a valid item id that this system recognize");
                            }

                           break;
                           
                      
                        case 3:
                            // Edit the Quantity of the PR
                            String item_quantity = System_Common_Function.input_data("Please enter the quantity of the item: ");
                            if (isNumeric(item_quantity) && stock_check(Integer.parseInt(item_quantity),item_detail_string[2])){
                                // Check if the entered quantity is numeric and does not exceed available stock
                                item_detail_string[4] = item_quantity;
                                double single = Double.parseDouble(item_detail_string[3].substring(3));
                                double item_quantity_in_numeric = Double.parseDouble(item_detail_string[4]);
                                double total = single * item_quantity_in_numeric;
                                item_detail_string[5] = String.format("RM %.2f",total);
                            }
                            else{
                                // Display an error message if the quantity input is invalid or exceeds available stock
                                System.out.println("Sorry, you can't procees due to one of these reasons: "
                                + "\na. You accidentally input wrong answer here (here only accept full number)"
                                + "\nb. Your quantity exceed the stock we have"
                                + "\nc. Your Item's section is empty, please provide an item first");
                            }
                            break;
                        case 4:
                            // Save the modified PR details
                            if (item_detail_string[0].equals("") || item_detail_string[1].equals("") || item_detail_string[2].equals("") || item_detail_string[3].equals("") || item_detail_string[4].equals("") || item_detail_string[5].equals("") || item_detail_string[6].equals("") || item_detail_string[7].equals("") || item_detail_string[8].equals("") || item_detail_string[9].equals("")){
                                // Check if any of the PR details is blank
                                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                                System.out.println("Sorry, the detail here cannot be blank.\nPlease provide all the detail!");
                                System.out.println("-------------------------------------------------------------------------------------------------");
                                break;
                            }
                            else{
                                // If all details are provided, create a string to write to the file
                                String ready_write_into_file = item_detail_string[0]+"~"+item_detail_string[1]+"~"+item_detail_string[2]+"~"+item_detail_string[3]+"~"
                                                                + item_detail_string[4] +"~" + item_detail_string[5] +"~"+item_detail_string[6]+"~"+item_detail_string[7] +"~"
                                                                + item_detail_string[8] +"~" + item_detail_string[9] +"~Unadded~";
                                if (ready_write_into_file.equals(original_detail)){
                                    // Check if the modified details are the same as the original
                                    System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                                    System.out.println("Sorry, you have not made any changes to the item.\nPlease try again");
                                    System.out.println("-------------------------------------------------------------------------------------------------");
                                }
                                else{
                                    // Update the PR details in the list and write it back to the file
                                    items.set(position_file,ready_write_into_file);
                                    obj1.rewrite_file(items);
                                    System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                                    System.out.println("You have successfully update this unapproved Purchase Requisition");
                                    System.out.println("-------------------------------------------------------------------------------------------------");
                                }
                                break;
                            }
                        case 5:
                            // Cancel adding PR
                            view_detail = false;
                            break;
                        default:
                            System.out.println("\nSorry, something error occurred!");
                            break;
                    }
                }
                else{
                    if (command_detail<5){
                        // If user tries to edit an approved PR
                        System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                        System.out.println("Sorry, this sale has already approved by Purchase Manager. You cannot edit this." +
                                "\nIf any issue, please contact admin for further detail");
                        System.out.println("-------------------------------------------------------------------------------------------------");
                    }
                    else{
                        // If user is not trying to edit an approved PR
                        view_detail = false;
                        break;
                    }
                }  
            }
            else{
                int command_detail = System_Common_Function.operation(6);
                if (command_detail == 5){
                    // User choose to go back
                    view_detail = false;
                    break;
                }
                else if (command_detail <5){    
                    // User attempts to modify the PR but do not have authorization
                    System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                    System.out.println("Sorry, you cannot modify the detail of the PR."
                            + "It can be the reason that you have not the right to modify this or you are not the one who create this PR"
                            + "\nPlease contact the manager if you wish to do so.");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                }
                else{
                    // Unexpected error
                    System.out.println("\nSorry, something error occurred!");
                    break;
                }
            }
        }
        
    }
    
    
    
    
    
    
    
    
    

//Purchase Order---------------------------------------------------------------------------------------------------------------------------
    public ArrayList view_po(){
        // Create a File_Management object to read PO data from a file
        File_Management obj1 = new File_Management("PO.txt");
        // Read the PO data from the file and store it in the 'items' ArrayList
        ArrayList<String> items = obj1.read_file();
        // Create an ArrayList to store index-code pairs for easy reference
        ArrayList<String[]> index_code = new ArrayList<String[]>();
        // Print a header for the Purchase Order section
        System.out.println("Purchase Order: ");
        int index = 4;
        // Print a table header for the PO data
        System.out.println(String.format("| %-8s "+"| %-10s "+"| %-20s "+"| %-20s " + "| %-15s " + "| %-15s |", "Index","Code","Purchase Manager","Purchase Requisition","Arrive Status","Approve Status"));

        // Loop through the PO items and display them
        for (String item_name: items){
            String[] item_string = item_name.split("~");
            String[] temporary = {Integer.toString(index),item_string[0]}; // Store index-code pairs
            index_code.add(temporary);
            // Print the PO data in a formatted table row
            System.out.println(String.format("| %-8s "+"| %-10s "+"| %-20s "+"| %-20s " + "| %-15s " + "| %-15s |", index,item_string[0],item_string[1],item_string[2],item_string[10],item_string[11]));
            index = index + 1;
        }
        // Create a File_Management object to read Unapproved PR data from a file
        File_Management obj2 = new File_Management("PR.txt");
        // Read the Unapproved PR data from the file
        ArrayList<String> itemss = obj2.read_file();
        // Print a header for the Pending Purchase Requisition section
        System.out.println("\nPending Purchase Requisition: ");
        int indexs = 1000;
        // Loop through the Pending PR items and display them
        for (String item_name: itemss){
            String[] item_string = item_name.split("~");
            if (item_string[9].equals("Pending")){
                // Print the Unapproved PR codes
                System.out.println(indexs + ". " + item_string[0]);
                indexs = indexs + 1;
            }
        }
        // Print menu options
        System.out.println("\n\n1 Add new" +
                           "\n2 Delete the exist" +
                           "\n3 Back" +
                           "\n\nPlease provide your operation using number, for example: input 1 to add a new element" +
                           "\nNote: You can try to input the index of the particular Purchase Order to VIEW or EDIT its detail." +
                           "\nFor example, input 4 to VIEW or EDIT the detail of the first Purchase Order" +
                           "\nNote: The action that have provided to you by this system depend on the privilege of your role" +
                           "\nIf you have found that you have the right to access something but the system is not allowed, please report to admin as soon as possible!");        
        // Return the index-code pairs for reference
        return index_code;
    }

    
    
    
    
    
    
    
    

    public void po_detail(String position, String user_id,int command,ArrayList<String[]> indexWITHcode){
        // Create a File_Management object to read PO data from a file
        File_Management obj1 = new File_Management("PO.txt");
        // Read the PO data from the file and store it in the 'items' ArrayList    
        ArrayList<String> items = obj1.read_file(); 
        // Create a File_Management object to read Unapproved PR data from a file    
        File_Management obj2 = new File_Management("PR.txt");
        // Read the Unapproved PR data from the file    
        ArrayList<String> PR_items = obj2.read_file();
        
        String original_detail = null;
        String[] item_detail_string = null;
        int position_PO_file = 0;
        int position_PR_file = 0;
        
        String code = "0";
        // Find the code associated with the provided command from the index-code pairs    
        for (String[] i:indexWITHcode){
            if (command == Integer.parseInt(i[0])){
                code = i[1];
            }
        }
        // Loop through the PO items to find the one with the matching code        
        for (String item_name: items){
            String[] item_string = item_name.split("~");
            if (code.equals(item_string[0])){
                item_detail_string = item_string;
                original_detail = item_name;
                break;
            }
            position_PO_file = position_PO_file + 1;
        }
        // Loop through the Unapproved PR items to find the one associated with the PO    
        for (String item_name: PR_items){
            String[] item_PR_string = item_name.split("~");
            if (item_detail_string[2].equals(item_PR_string[0])){
                break;
            }
            position_PR_file = position_PR_file + 1;
        }
        
        String arrive = item_detail_string[10];
        boolean view_detail = true;
        while (view_detail == true){
            // Display Purchase Order's details                
            System.out.println("\n-------------------------------------------------------------------------------------------------\nPurchase Order's Detail: ");
            System.out.println("\n0. Code: " + item_detail_string[0] +
                            "\n0. Purchase Manager: " + item_detail_string[1] +
                            "\n0. Purchase Requisition: " + item_detail_string[2] +
                            "\n0. Issue Date: " + item_detail_string[3] +
                            "\n0. Item: " + item_detail_string[4] +
                            "\n0. Single Price: " + item_detail_string[5] +
                            "\n0. Quantity: " + item_detail_string[6] +
                            "\n0. Total: " + item_detail_string[7] +
                            "\n0. Supplier: " + item_detail_string[8] +
                            "\n0. Sales Manager: " + item_detail_string[9] +
                            "\n1. Arrive Status: " + arrive +
                            "\n2. Approve Status: " + item_detail_string[11] +
                            "\n\n3 Save"  +
                            "\n4 Back" );

            if (position.equals("PM") && (item_detail_string[1].equals(user_id) || user_id.equals("Admin"))){
                // If the user is the Purchase Manager or an admin, allow them to modify certain fields
                System.out.println("\nNote: You can only modify the status and the shipping status of the Purchase Order, if anything wrong with the item, you need to contact the Sale manager to modify the Purchase Requisition"
                        +"\nIf you are not the Purchase Manager who raise this Purchase Order, you can't modify this Purchase Order"
                        + "\nNote: you are not allowed modify this Purchase Order once you have stated that this order has been shipped"
                        + "\nBe careful to edit the Shipping status!");
                int command_detail = System_Common_Function.operation(4);

                switch (command_detail){
                    case 2:
                        // Edit the status of the Purchase Order (Approved or Unapproved)        
                        System.out.println("\n1. Approved\n2. Unapproved");
                        System.out.println("Please choose the number to indicate the status of this order\n"
                                           + "For example, choosing 1 to show this order is approved"
                                + "\nIf you change this order to Unapproved, it will be automatically deleted from the Purchase Order after you have save at the end"
                                + "\nYou need to create a new Purchase order again to Approve this order again"
                                + "\nNote: You only can edit this status for unship order!");
                        
                        int choose_status = System_Common_Function.operation(2);
                        if (choose_status == 1){
                            item_detail_string[11] = "Approved";
                        }
                        else{
                            if (arrive.equals("Unarrived")){
                                item_detail_string[11] = "Unapproved";
                            }
                            else{
                                // Display an error message if the order has already been shipped and can't be modified.
                                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                                System.out.println("This order has been arrived at our company, you can't modified anymore\n"
                                        + "Please contact admin for any help!");
                                System.out.println("-------------------------------------------------------------------------------------------------");
                            }
                        }
                        break;
                    case 1:
                        // Edit the shipping status of the Purchase Order (Shipped or Unship)
                        if (item_detail_string[10].equals("Arrived") || item_detail_string[11].equals("Unapproved") || item_detail_string[11].equals("Pending")){
                            // Check if the order can be modified (shipped or approved)        
                            System.out.println("\nIf you haven't approved this order, you need to approve first");
                            System.out.println("Sorry, this order has been shipped by the supplier or arrived at our company, you can't modify it anymore");
                        }
                        else{
                            System.out.println("\n1. Arrived\n2. Unarrived");
                            System.out.println("Please choose the number to indicate the arrive status of this order\n"
                                               + "For example, choosing 1 to show this order is arrive at our company\n"
                                    + "If you have edit this order to arrived and save at the end, you can't change back to unarrived again!"
                                    + "\nPlease be before you save this order");

                            int choose_shipping_status = System_Common_Function.operation(2);
                            if (choose_shipping_status == 1){
                                arrive = "Arrived";
                            }
                            else{
                                arrive = "Unarrived";
                            }                            
                        }
                        break;
                    
                    case 3:
                        item_detail_string[10] = arrive;
                        // Save the modified PO details
                        if (item_detail_string[0].equals("") || item_detail_string[1].equals("") || item_detail_string[2].equals("") || item_detail_string[3].equals("") || item_detail_string[4].equals("") || item_detail_string[5].equals("") || item_detail_string[6].equals("") || item_detail_string[7].equals("") || item_detail_string[8].equals("") || item_detail_string[9].equals("") || item_detail_string[10].equals("") || item_detail_string[11].equals("")){
                            // Check if any of the PO details is blank
                            System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                            System.out.println("Sorry, the detail here cannot be blank.\nPlease provide all the detail!");
                            System.out.println("-------------------------------------------------------------------------------------------------");
                            break;
                        }
                        else{
                            if (item_detail_string[11].equals("Unapproved")){
                                // If the PO is unapproved, remove it from the PO file and update the corresponding PR status        
                                items.remove(position_PO_file);
                                obj1.rewrite_file(items);
                                
                                String ready_write_into_PR_file = item_detail_string[2]+"~"+item_detail_string[3]+"~"+item_detail_string[4]+"~"+item_detail_string[5]+"~"
                                                            + item_detail_string[6] +"~" + item_detail_string[7] +"~"+item_detail_string[8]+"~"+item_detail_string[9] +"~"
                                                            + item_detail_string[10] +"~" + "Unapproved~Unadded~";
                                PR_items.set(position_PR_file,ready_write_into_PR_file);
                                obj2.rewrite_file(PR_items);
                                
                                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                                System.out.println("You have successfully update the Purchase Order!");
                                System.out.println("-------------------------------------------------------------------------------------------------");
                            }
                            else{
                                // If the PO is approved, update the PO details and save it            
                                String ready_write_into_file = item_detail_string[0]+"~"+item_detail_string[1]+"~"+item_detail_string[2]+"~"+item_detail_string[3]+"~"
                                                                + item_detail_string[4] +"~" + item_detail_string[5] +"~"+item_detail_string[6]+"~"+item_detail_string[7] +"~"
                                                                + item_detail_string[8] +"~" + item_detail_string[9] +"~" + item_detail_string[10] + "~" + item_detail_string[11] +"~";
                                
                                String ready_write_into_PR_file = item_detail_string[2]+"~"+item_detail_string[3]+"~"+item_detail_string[4]+"~"+item_detail_string[5]+"~"
                                                            + item_detail_string[6] +"~" + item_detail_string[7] +"~"+item_detail_string[8]+"~"+item_detail_string[9] +"~"
                                                            + item_detail_string[10] +"~" + item_detail_string[11] + "~Unadded~";

                                if (ready_write_into_file.equals(original_detail)){
                                    System.out.println("Sorry, you have not made any changes to the item.\nPlease try again");
                                    
                                    System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                                    System.out.println("Sorry, the detail here cannot be blank.\nPlease provide all the detail!");
                                    System.out.println("-------------------------------------------------------------------------------------------------");
                                }
                                else{
                                    items.set(position_PO_file,ready_write_into_file);
                                    obj1.rewrite_file(items);
                                    
                                    PR_items.set(position_PR_file,ready_write_into_PR_file);
                                    obj2.rewrite_file(PR_items);
                                    
                                    System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                                    System.out.println("You have successfully update the Purchase Order!");
                                    System.out.println("-------------------------------------------------------------------------------------------------");
                                }                              
                            }
                            view_detail = false;
                            break;
                        }
                    case 4:
                        // Exit Purchase Order view_detail
                        view_detail = false;
                        break;
                    default:
                        System.out.println("\nSorry, something error occurred!");
                        break;
                    }  
            }
            else{
                // Get the user's command for modifying the Purchase Order (PO) details
                int command_detail = System_Common_Function.operation(4);
                // Check if the user chooses to exit (Enter 4)
                if (command_detail == 4){
                    view_detail = false; // Exit the PO detail view
                    break;
                }
                // Check if the user enter number is less than 4, indicating an attempt to modify the PO
                else if (command_detail <4){
                    // Display a message indicating the user doesn't have the right to modify the PO    
                    System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                    System.out.println("\nSorry, you can't modify the detail of the PO."
                            + "It can be the reason that you have not the right to modify this or you are not the one who create this PO"
                            + "\nPlease contact the manager if you wish to do so.");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                }
                // Handle any other number that is not 4 or less than 4
                else{
                    // Display an error message
                    System.out.println("\nSorry, something error occurred!");
                    break;
                }
            }
        }
        
    }

    
    
    
    
    
    
    
    
    
//subfunction------------------------------------------------------------------------------------------------------------------------------
    
    public boolean isNumeric(String string) {
        try {
            // Attempt to parse the input string as a double
            double Value = Double.parseDouble(string);
            // If parsing is successful, return true        
            return true;
        } 
        catch (NumberFormatException e) {
            // If parsing fails (due to a NumberFormatException), return false        
            return false;
        }
    }
    
    public ArrayList supplier_item(){
        // Create an instance of File_Management to read items from a file named "item.txt"    
        File_Management obj1 = new File_Management("item.txt");
        // Read the items from the file into an ArrayList of strings    
        ArrayList<String> items = obj1.read_file();
        // Create an ArrayList to store unique supplier names    
        ArrayList<String> supplier = new ArrayList<>();
        // Create an ArrayList to store all supplier-item combinations    
        ArrayList<String> all_supp_item =  new ArrayList<>();
        // Iterate through each item in the 'items' ArrayList    
        for (String supp:items){
            // Split the item string into elements using "~" as the delimiter    
            String[] element = supp.split("~");
            // Check if the 'supplier' ArrayList already contains the supplier name        
            if (!supplier.contains(element[7])){
                // If not, add the supplier name to the 'supplier' ArrayList        
                supplier.add(element[7]);
            }
        }
        
        for (String sup:supplier){
            // Initialize a string to store the supplier and associated items    
            String supplier_and_item = "";
            // Initialize a string to store items that belong to this supplier
            String items_belong_to_this_supplier = "";
            // Append the supplier name to the 'supplier_and_item'   
            supplier_and_item = supplier_and_item + sup + "~";
            // Iterate through each element (item) in the 'items' ArrayList    
            for (String element:items){
                // Split the element into elements using "~" as the delimiter        
                String[] elements = element.split("~");
                // Check if the supplier of the current item matches the current supplier being processed        
                if (elements[7].equals(sup)){
                    // If they match, append the item code to 'items_belong_to_this_supplier'        
                    items_belong_to_this_supplier = items_belong_to_this_supplier + elements[0] +", ";
                }
            }
            // Append the list of items belonging to this supplier to 'supplier_and_item'
            supplier_and_item = supplier_and_item + items_belong_to_this_supplier;
            // Add the 'supplier_and_item' to the 'all_supp_item' ArrayList    
            all_supp_item.add(supplier_and_item);
        }
        // Return the 'all_supp_item' ArrayList, which now contains supplier-item combinations
       return all_supp_item;
    }
    
    
    
    
    
    
    
    
    
    
    public boolean stock_check(int quantity,String item){
        // Create a File_Management object to read the "Item.txt" file    
        File_Management obj1 = new File_Management("Item.txt");
        // Read the contents of the "Item.txt" file into an ArrayList    
        ArrayList<String> items = obj1.read_file(); 
        // Initialize a boolean variable 'i' to false (assuming initially there's not enough stock)    
        boolean i = false;
        // Iterate through each item in the 'items' ArrayList
        for (String item_name: items){
            // Split the item details into an array using "~" as the delimiter    
            String[] item_string = item_name.split("~");
            // Check if the item code of the current item matches the specified 'item'        
            if (item.equals(item_string[0])){
                // Compare the specified 'quantity' with the available stock quantity (item_string[5])            
                if ( quantity < Integer.parseInt(item_string[5])){
                    // If there's enough stock, set 'i' to true and break out of the loop            
                    i=true;
                    break;
                }
            }
        }
        // Return the value of 'i', which indicates whether there's enough stock (true) or not (false)    
        return i;
    }    
    
    
    
    
    
    
    
    
    
    
//Static Function-----------------------------------------------------------------
    public static int operation(int total_operation_having){
        // Create an ArrayList 'number' to store valid operation numbers    
        ArrayList<Integer> number = new ArrayList<Integer>();
        // Populate the 'number' ArrayList with valid operation numbers from 1 to 'total_operation_having'    
        for (int i = 1; i <= total_operation_having; i++){
            number.add(i);
        }
        // Initialize a boolean variable 'doing_operation' to true to start the input loop        
        boolean doing_operation = true;
        // Initialize the 'command' variable to -1 (default value)    
        int command = -1;
        // Enter a loop to repeatedly prompt the user for input until a valid command is provided    
        while (doing_operation == true){
            // Create a Scanner object 'obj1' to read user input from the console        
            Scanner obj1 = new Scanner(System.in);
            try{
                System.out.println("Please enter your command here: ");
                // Read the user's input as an integer            
                command = obj1.nextInt();
                // Check if the entered 'command' is within the valid range of operation numbers            
                if (command >= number.get(0) && command <= number.get(number.size() -1)){
                    // If it's within the range, set 'doing_operation' to false to exit the loop                
                    doing_operation = false;
                }
                else{
                    // If it's outside the range, display an error message and continue the loop                
                    System.out.println("Sorry, your number is not in our range, please try again!");
                    doing_operation = true;
                }
            }
            catch(Exception e){
                // Handle exceptions in case of non-integer input            
                System.out.println("Sorry, I don't understand you, for the operation, only number is allowed.");
            }
        }
        // Return the valid 'command' selected by the user
        return command;
    }
    
    
    
    
    
    public static String input_data(String topic){
        // Display a 'topic' to the user    
        System.out.println(topic);
        // Create a Scanner object 'obj1' to read user input from the console    
        Scanner obj1 = new Scanner(System.in);
        // Read the user's input as a string and store it in the 'entered_data' variable    
        String entered_data = obj1.nextLine();
        // Return the entered data as a string    
        return entered_data;
    }
    
    
    
    
    
    public static String auto_generate_code(int begining,String type,String filename){
        // Create a File_Management object 'obj1' to read data from a file specified by 'filename'    
        File_Management obj1 = new File_Management(filename);
        // Read the data from the file and store it in an ArrayList 'items'    
        ArrayList<String> items = obj1.read_file();
        // Get the last item from the ArrayList     
        String last_item = items.get(items.size()-1);
        // Split the last item into an array using '~' as a delimiter    
        String[] last_item_array = last_item.split("~");
        // Extract the last code from the last item    
        String last_code = last_item_array[0];
        // Remove the specified number of characters from the beginning of the last code    
        last_code = last_code.substring(begining);
        // Convert the last code to an integer    
        int last_code_integer = Integer.parseInt(last_code);
        // Calculate the next code by incrementing the last code    
        int next_code = last_code_integer + 1;
        // Format the next code as a string with leading zeros (e.g., "00123")    
        String new_code_string = type + String.format("%06d",next_code);
        // Return the newly generated code as a string    
        return new_code_string;
    }
    
    
    
}
