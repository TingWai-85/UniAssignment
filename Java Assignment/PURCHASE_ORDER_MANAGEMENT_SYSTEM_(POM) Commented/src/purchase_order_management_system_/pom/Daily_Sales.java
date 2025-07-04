
package purchase_order_management_system_.pom;

import java.util.ArrayList;

public class Daily_Sales {
    
    // Class member variables
    private String code = "";
    private String date = "";
    private String item = "";
    private String single_price = "";
    private String quantity = "";
    private String total_sales = "";
    private String supplier = "";
    private String status = "Unmatch";
    
    
    
    // Method to view all daily sales
    public ArrayList view_daily() {
        // Initialize a File_Management object to read daily sales data from a file
        File_Management obj1 = new File_Management("Daily_Item_Sales.txt");
        // Read daily sales data from the file
        ArrayList<String> items = obj1.read_file();    
        
        // Initialize a list to store index-code pairs for easy reference later
        ArrayList<String[]> index_code = new ArrayList<String[]>();        
        
        // Print header for the daily sales
        System.out.println("\n-------------------------------------------------------------------------------------------------");
        System.out.println("Daily Sales: ");
        int index = 5;
        
        // Print table header
        System.out.println(String.format("| %-8s | %-10s | %-15s | %-10s | %-15s | %-8s |", "Index", "Code", "Date", "Item", "Total_Sales", "Status"));
        
        // Loop through each item and print its details
        for (String item_name : items) {
            String[] item_string = item_name.split("~");
            // Store index and item's code for easy reference later
            String[] temporary = { Integer.toString(index), item_string[0] };
            index_code.add(temporary);
            // Print formatted row with item details
            System.out.println(String.format("| %-8s | %-10s | %-15s | %-10s | %-15s | %-8s |", index, item_string[0], item_string[1], item_string[2], item_string[5], item_string[7]));
            index = index + 1 ;
        }
        
        // Print additional instructions and options for operations
        System.out.println("\n\n1 Add new" +
                           "\n2 Delete the exist" +
                           "\n3 Match All to item file" +
                           "\n4 Back" +
                           "\n\nPlease provide your operation using a number, for example: input 1 to add a new element" +
                           "\nNote: You can try to input the index of the particular daily sales to VIEW or EDIT its detail." +
                           "\nFor example, input 4 to VIEW or EDIT the detail of the first daily sale" +
                           "\nNote, if you have an unmatch item, the sale will not update the stock of the item, so please match any unmatch sale!" +
                           "\nNote: The actions provided by this system depend on the privilege of your role" +
                           "\nIf you find that you have the right to access something but the system is not allowing it, please report to admin as soon as possible!");
         
        return index_code;
    }

    
    
    
    
    
    
    
    
    
    public void sales_detail(int command, ArrayList<String[]> indexWITHcode) {
        // Create an instance of the File_Management class to manage the "Daily_Item_Sales.txt" file
        File_Management obj1 = new File_Management("Daily_Item_Sales.txt");
        // Read the contents of the "Daily_Item_Sales.txt" file into an ArrayList of strings
        ArrayList<String> items = obj1.read_file();

        // Initialize variables to store the original sales details and the current item's details
        String original_detail = null;
        String[] item_detail_string = null;
        int position_file = 0;

        // Initialize a code variable with a default value "0"
        String code = "0";

        // Iterate through the indexWITHcode ArrayList to find the code corresponding to the provided command
        for (String[] i : indexWITHcode) {
            if (command == Integer.parseInt(i[0])) {
                code = i[1];
            }
        }

        // Iterate through the items in the "Daily_Item_Sales.txt" file to find the item with the matching code
        for (String item_name : items) {
            String[] item_string = item_name.split("~");
            if (code.equals(item_string[0])) {
                // Store the item's details and original detail
                item_detail_string = item_string;
                original_detail = item_name;
                break;
            }
            position_file = position_file + 1;
        }

        boolean view_detail = true;
        while (view_detail == true) {
            System.out.println("\n-------------------------------------------------------------------------------------------------\nDaily Sales's Detail: ");
            System.out.println("\n0. Code: " + item_detail_string[0] +
                    "\n1. Date: " + item_detail_string[1] +
                    "\n2. Item: " + item_detail_string[2] +
                    "\n0. Single Price: " + item_detail_string[3] +
                    "\n3. Quantity: " + item_detail_string[4] +
                    "\n0. Total_Sales: " + item_detail_string[5] +
                    "\n0. Supplier: " + item_detail_string[6] +
                    "\n. Status: " + item_detail_string[7] +
                    "\n\n4. Save" +
                    "\n5. Back");

            System.out.println("\nNote: You can only modify Date, Item, and the Quantity of the unmatch item."
                    + "\nPrice, Total Sales, and Supplier will change based on the item's code and also the quantity");

            // Read user's command for editing the sales details
            int command_detail = System_Common_Function.operation(5);

            if (item_detail_string[7].equals("Unmatch")) {
                switch (command_detail) {
                    case 1:
                        System.out.println("Format: dd-mm-yyyy");
                        // Allow the user to input a new date for the sales
                        item_detail_string[1] = System_Common_Function.input_data("Please enter the date of the sales: ");
                        break;
                    case 2:
                        // Store the original item code before any changes
                        String original = item_detail_string[2];
                        // Display message to guide user on the expected format of the item's code
                        System.out.println("Please input a correct format of the item's code, for example: I000001");
                        // Prompt user to input the new item code
                        String item_code = System_Common_Function.input_data("Please enter the code of the item: ");
                        // Create an instance to manage the "item.txt" file
                        File_Management obj100 = new File_Management("item.txt");
                        // Read item data from "item.txt" into an ArrayList
                        ArrayList<String> itm = obj100.read_file();
                        // Iterate through each item in the "item.txt" file to find a match with the input item code
                        for (String element : itm) {
                            // Split the item data into an array of elements
                            String[] element_array = element.split("~");
                            // Check if the input item code matches the code in the file
                            if (item_code.equals(element_array[0])) {
                                // Update the item code and related details for the daily sale
                                item_detail_string[2] = item_code; // Update item code
                                item_detail_string[3] = element_array[4]; // Update single price
                                // Calculate the total sales based on updated single price and existing quantity
                                double single = Double.parseDouble(item_detail_string[3].substring(3)); // Parse single price
                                double item_quantity = Double.parseDouble(item_detail_string[4]); // Parse item quantity
                                double total = single * item_quantity; // Calculate total sales
                                item_detail_string[5] = String.format("RM %.2f", total); // Update total sales
                                // Retrieve and update the supplier ID based on the new item code
                                item_detail_string[6] = Daily_Sales.item_supplier(item_detail_string[2]);
                            }
                        }
                        // Check if the updated item code is the same as the original
                        if (item_detail_string[2].equals(original)) {
                            System.out.println("\nYour item id's format is incorrect or is not in our system." +
                                    "\nPlease check the existing item id first and input a valid item id that this system recognizes");
                        }
                        break;
                    case 3:
                        // Prompt the user to input the quantity of the item
                        String item_quantity = System_Common_Function.input_data("Please enter the quantity of the item: ");
                        // Check if the input quantity is numeric
                        if (isNumeric(item_quantity)) {
                            // Update the quantity for the item and related details
                            item_detail_string[4] = item_quantity; // Update item quantity
                            // Parse the single price and item quantity into numeric values
                            double single = Double.parseDouble(item_detail_string[3].substring(3)); // Parse single price
                            double item_quantity_in_numeric = Double.parseDouble(item_detail_string[4]); // Parse item quantity
                            // Calculate the total sales based on the updated quantity and existing single price
                            double total = single * item_quantity_in_numeric; // Calculate total sales
                            // Update the formatted total sales string
                            item_detail_string[5] = String.format("RM %.2f", total);
                        } else {
                            // Display an error message if the input is not a numeric value
                            System.out.println("\nSorry, only numbers are accepted for quantity.");
                        }
                        break;
                    case 4:
                        // Check if any modifications were made to the item's details
                        if (item_detail_string[0].equals("") || item_detail_string[1].equals("") || item_detail_string[2].equals("") || item_detail_string[3].equals("") || item_detail_string[4].equals("") || item_detail_string[5].equals("") || item_detail_string[6].equals("")) {
                            // Display an error message if any detail is blank
                            System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                            System.out.println("Sorry, the details cannot be blank.\nPlease provide all the details!");
                            System.out.println("-------------------------------------------------------------------------------------------------");
                            break;
                        } else {
                            // Prepare the modified item details to write back into the file
                            String ready_write_into_file = item_detail_string[0] + "~" + item_detail_string[1] + "~" + item_detail_string[2] + "~" + item_detail_string[3] + "~"
                                    + item_detail_string[4] + "~" + item_detail_string[5] + "~" + item_detail_string[6] + "~" + item_detail_string[7];

                            // Check if any changes were made to the item's details
                            if (ready_write_into_file.equals(original_detail)) {
                                // Display a message if no changes were made
                                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                                System.out.println("Sorry, you have not made any changes to the item.\nPlease try again");
                                System.out.println("-------------------------------------------------------------------------------------------------");
                            } else {
                                // Update the item's details in the ArrayList and rewrite the file
                                items.set(position_file, ready_write_into_file);
                                obj1.rewrite_file(items);
                                // Display a success message after updating the item's details
                                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                                System.out.println("You have successfully updated a Daily Sales!");
                                System.out.println("-------------------------------------------------------------------------------------------------");
                            }
                            break;
                        }
                    case 5:
                        // Exit the loop and go back to the previous menu
                        view_detail = false;
                        break;
                    default:
                        System.out.println("\nSorry, an error occurred!");
                        break;
                }
            } else {
                if (command_detail < 5) {
                    // Display a message for matched sales (already updated to stock)
                    System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                    System.out.println("Sorry, this matched sale has already been updated to the stock of the item. You cannot edit this." +
                            "\nIf there are any issues, please contact an admin for further details");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                } else {
                    // Exit the loop and go back to the previous menu
                    view_detail = false;
                    break;
                }
            }
        }
    }

    
    
    
    
    
    
    
    
    
    public void add_new_sale() {
        boolean add = true;
        while (add == true) {
            // Create an instance of the File_Management class to manage the "Daily_Item_Sales.txt" file
            File_Management obj1 = new File_Management("Daily_Item_Sales.txt");
            // Read the contents of the "Daily_Item_Sales.txt" file into an ArrayList of strings
            ArrayList<String> items = obj1.read_file();

            // Auto generate a code for the new sale based on the last sale's code in the system
            this.code = System_Common_Function.auto_generate_code(1, "D", "Daily_Item_Sales.txt");

            System.out.println("\n-------------------------------------------------------------------------------------------------\nAdd new:");
            System.out.println("\n0. Code: " + this.code +
                    "\n1. Date: " + this.date +
                    "\n2. Item: " + this.item +
                    "\n0. Single Price: " + this.single_price +
                    "\n3. Quantity: " + this.quantity +
                    "\n0. Total_Sales: " + this.total_sales +
                    "\n0. Supplier: " + this.supplier +
                    "\n0. Status: " + this.status + " (You should check all the detail before matching the sale. (Match at the sale's main interface)" +
                    "\n\n4. Save" +
                    "\n5. Cancel");

            System.out.println("\n\nNote: The code of the sale will be auto-generated by this system based on the code of the last sale stored in this system" +
                    "\nPlease provide the detail of the Daily Sale" +
                    "\nFor example, choose 1 to input the date of the sale." +
                    "\nNote: The detail of the sale cannot be the same as the existing one (no duplicated sale)" +
                    "\nPlease select your choice to input the data: ");

            // Read user's command for adding new sale details
            int command = System_Common_Function.operation(5);
            switch (command) {
                case 1:
                    System.out.println("Format: dd-mm-yyyy");
                    // Allow the user to input a new date for the sale
                    this.date = System_Common_Function.input_data("Please enter the date of the sales: ");
                    break;
                case 2:
                    System.out.println("Please input a correct format of the item's code, for example: I000001");
                    // Allow the user to input a new item code and update item-related details
                    String item_code = System_Common_Function.input_data("Please enter the code of the item: ");
                    File_Management obj3 = new File_Management("item.txt");
                    ArrayList<String> itm = obj3.read_file();
                    for (String element : itm) {
                        String[] element_array = element.split("~");
                        if (item_code.equals(element_array[0])) {
                            this.item = item_code;
                            this.single_price = element_array[4];
                            this.supplier = Daily_Sales.item_supplier(this.item);
                        }
                    }
                    if (this.item.equals("")) {
                        System.out.println("\nYour item id's format is incorrect or is not in our system." +
                                "\nPlease check the existing item id first and input a valid item id that this system recognizes");
                    }
                    break;
                case 3:
                    String item_quantity = System_Common_Function.input_data("Please enter the quantity of the item: ");
                    if (isNumeric(item_quantity)) {
                        // Allow the user to input a new quantity for the item and calculate the total sales
                        this.quantity = item_quantity;
                        double single = Double.parseDouble(this.single_price.substring(3));
                        double item_quantity_in_numeric = Double.parseDouble(this.quantity);
                        double total = single * item_quantity_in_numeric;
                        this.total_sales = String.format("RM %.2f", total);
                    } else {
                        System.out.println("\nSorry, only numbers are accepted for quantity.");
                    }
                    break;
                case 4: // Save
                    if (this.code.equals("") || this.date.equals("") || this.item.equals("") || this.single_price.equals("") || this.quantity.equals("") || this.total_sales.equals("") || this.supplier.equals("") || this.status.equals("")) {
                        System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                        System.out.println("Sorry, the details here cannot be blank.\nPlease provide all the details!");
                        System.out.println("-------------------------------------------------------------------------------------------------");
                    } else {
                        // Create a string with the sale details and write it to the "Daily_Item_Sales.txt" file
                        String ready_write_into_file = this.code + "~" + this.date + "~" + this.item + "~" + this.single_price + "~" + this.quantity + "~"
                                + this.total_sales + "~" + this.supplier + "~" + this.status;
                        obj1.write_file(ready_write_into_file);
                        obj1.write_file("\n");

                        System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                        System.out.println("You have successfully added a Daily Sales!");
                        System.out.println("-------------------------------------------------------------------------------------------------");

                        // Reset sale details for the next entry
                        this.code = "";
                        this.date = "";
                        this.item = "";
                        this.single_price = "";
                        this.quantity = "";
                        this.total_sales = "";
                        this.supplier = "";
                    }
                    break;
                case 5: // Cancel
                    add = false;
                    break;
            }
        }
    }

    
    
    
    
    
    
    
    
    public void delete_sale(ArrayList<String[]> indexWITHcode) {
        boolean delete = true;
        while (delete == true) {
            // Create an instance of the File_Management class to manage the "Daily_Item_Sales.txt" file
            File_Management obj1 = new File_Management("Daily_Item_Sales.txt");
            // Read the contents of the "Daily_Item_Sales.txt" file into an ArrayList of strings
            ArrayList<String> items = obj1.read_file();
            // Create a copy of the original list of items for comparison later
            ArrayList<String> original = obj1.read_file();

            System.out.println("\n-------------------------------------------------------------------------------------------------\nDelete Daily Sales: ");
            System.out.println("\n4. Cancel\nPlease input 4 if you don't wish to delete the sale or select the index of the sale that you wish to delete: ");

            // Read user's choice for deleting a sale or canceling the operation
            int item_to_be_deleted = System_Common_Function.operation(items.size() + 4);

            if (item_to_be_deleted < 4) {
                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                System.out.println("Sorry, please select a valid index of the item you wish to delete\n" +
                        "For example: input 5 to delete the first item");
                System.out.println("-------------------------------------------------------------------------------------------------");
            } else if (item_to_be_deleted == 4) {
                delete = false;
                break;
            } else {
                int position_file = 0;
                // Get the sale code like "D000001" based on the user-selected index
                String code = "0";
                for (String[] i : indexWITHcode) {
                    if (item_to_be_deleted == Integer.parseInt(i[0])) {
                        code = i[1];
                    }
                }

                for (String item_name : items) {
                    String[] item_string = item_name.split("~");
                    if (code.equals(item_string[0]) && (item_string[7]).equals("Unmatch")) {
                        // Remove the sale from the ArrayList if it matches the code and is unmatch status
                        items.remove(position_file);
                        break;
                    }
                    position_file = position_file + 1;
                }

                if (items.equals(original)) {
                    System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                    System.out.println("Sorry, you can't delete the matched sale");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                } else {
                    // Rewrite the file with the updated list of items after deletion
                    obj1.rewrite_file(items);
                    System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                    System.out.println("You have successfully deleted the Daily Sale!");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                    delete = false;
                    break;
                }
            }
        }
    }

    
    
    
    
    
    
    
    
    
    
//subfunction----------------------------------------------------------------------------------------
    public void match() {
        // Initialize File_Management objects to read data from files
        File_Management obj1 = new File_Management("Daily_Item_Sales.txt");
        ArrayList<String> sale_in_file = obj1.read_file();
        File_Management obj100 = new File_Management("item.txt");
        ArrayList<String> item_in_file = obj100.read_file();

        // Initialize lists to store item quantities and unmatched items
        ArrayList<String[]> all = new ArrayList<String[]>();
        ArrayList<String> unmatched = new ArrayList<String>();

        String new_string = "";

        int daily_counter = 0;

        // Loop through each sale and store unmatch sales' item, quantity, and code
        for (String sale : sale_in_file) {
            String[] sale_element = sale.split("~");
            if (sale_element[7].equals("Unmatch")) {
                String[] item_quantity = new String[3];
                item_quantity[0] = sale_element[0];
                item_quantity[1] = sale_element[2];
                item_quantity[2] = sale_element[4];
                all.add(item_quantity);
            }
        }

        // Loop through unmatch sales and try to match them with available stock
        for (String[] item_and_quantity : all) {
            String item = item_and_quantity[1];
            int quantity = Integer.parseInt(item_and_quantity[2]);
            int item_counter = 0;

            for (String itm : item_in_file) {
                String[] item_element = itm.split("~");
                int stock = Integer.parseInt(item_element[5]);
                if (item_element[0].equals(item)) {
                    if (stock < quantity) {
                        // Item stock is not enough for this sale
                        break;
                    } else {
                        stock = stock - quantity;
                        quantity = 0;
                        // Update item stock and quantity
                        new_string = item_element[0] + "~" + item_element[1] + "~" + item_element[2] + "~" + item_element[3] + "~" + item_element[4] + "~" + Integer.toString(stock) + "~" + item_element[6] + "~" + item_element[7];
                        item_in_file.set(item_counter, new_string);
                        break;
                    }
                }
                item_counter = item_counter + 1;
            }

            // If quantity is still not matched to available stock, add item code to unmatched list
            if (quantity != 0) {
                unmatched.add(item_and_quantity[0]);
            }
        }

        // Update sales to "Matched" status if they were successfully matched with stock
        for (String sales : sale_in_file) {
            String[] element = sales.split("~");
            if ((element[7].equals("Unmatch")) && !(unmatched.contains(element[0]))) {
                new_string = element[0] + "~" + element[1] + "~" + element[2] + "~" + element[3] + "~" + element[4] + "~" + element[5] + "~" + element[6] + "~Matched";
                sale_in_file.set(daily_counter, new_string);
            }
            daily_counter = daily_counter + 1;
        }

        // Prepare message for unmatched sales
        String unmatch_sale = "";
        for (String unmatch : unmatched) {
            unmatch_sale = unmatch_sale + unmatch;
        }

        // Update files and display message for unmatched sales
        obj1.rewrite_file(sale_in_file);
        obj100.rewrite_file(item_in_file);

        if (!(unmatch_sale.equals(""))) {
            System.out.println("\nThese items: " + unmatch_sale + " are not enough (stock < quantity)");
        }
    }

    
    
    
    
    
    
    
    
    
    
// A static method to retrieve the supplier ID of an item based on its item ID
public static String item_supplier(String item_id) {
    // Create an instance of File_Management to manage the "item.txt" file
    File_Management obj100 = new File_Management("item.txt");
    
    // Read the contents of the "item.txt" file into an ArrayList of strings
    ArrayList<String> item_in_file = obj100.read_file();
    
    // Initialize a variable to store the supplier ID
    String supp_id = "";
    
    // Iterate through each line of item data in "item.txt"
    for (String item_supp : item_in_file) {
        // Split the item data into an array of elements using "~" as the delimiter
        String[] ele = item_supp.split("~");
        
        // Check if the item ID matches the provided item ID
        if (item_id.equals(ele[0])) {
            // If a match is found, retrieve the supplier ID
            supp_id = ele[7];
        }
    }
    // Return the supplier ID
    return supp_id;
}

    
    
    
    





// A private helper method to check if a string can be parsed as a numeric (double) value
    private boolean isNumeric(String string) {
        try {
            // Attempt to parse the string as a double
            double value = Double.parseDouble(string);

            // If parsing succeeds, the string is numeric
            return true;
        } catch (NumberFormatException e) {
            // If parsing fails (NumberFormatException is thrown), the string is not numeric
            return false;
        }
    }


}
