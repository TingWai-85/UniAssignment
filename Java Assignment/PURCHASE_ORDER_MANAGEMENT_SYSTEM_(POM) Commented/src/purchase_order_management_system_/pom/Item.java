
package purchase_order_management_system_.pom;

import java.util.ArrayList;

// Define a class call "Item" that extends the "System_Common_Function" class
public class Item extends System_Common_Function {
    // Declaration of private instance variables to represent item attributes
    private String code = "";
    private String name = "";
    private String type = "";
    private String date = "";
    private String price = "";
    private String stock = "";
    private String description = "";
    private String supplier = "";
    
    // Create an instance of File_Management class to read "item.txt" file
    File_Management obj1 = new File_Management("item.txt");
    // Read the content of the "item.txt" file and store it in an ArrayList named "items"
    ArrayList<String> items = obj1.read_file();
    
    // Method to view all items
    public ArrayList view() {
        // Print a separator line
        System.out.println("\n-------------------------------------------------------------------------------------------------");
        // Call the view_items method from the superclass and store its result
        ArrayList<String[]> index_code = super.view_items();
        // Return the result, which is an ArrayList containing index-code pairs
        return index_code;
    }
    
    
    
    
    
    
    
    
    
    
    // Method to view details of a specific item
    public void detail(String position, int command, ArrayList<String[]> indexWITHcode) {
        // Call the detail method from the superclass, passing along the parameters
        super.detail(position, command, indexWITHcode);
    }


    
    
    
    
    
    
    
    
    // Method to add a new item
    public void add() {
        // Create an instance of the File_Management class to read the "item.txt" file    
        File_Management obj1 = new File_Management("item.txt");
        // Read the contents of the "item.txt" file and store them in the ArrayList "items"    
        ArrayList<String> items = obj1.read_file();
        // Create an instance of the File_Management class to read the "PR.txt" file    
        File_Management obj100 = new File_Management("PR.txt");
        // Read the contents of the "PR.txt" file and store them in an ArrayList called "pr_itemss"    
        ArrayList<String> pr_itemss = obj100.read_file();
        // Create an ArrayList of String arrays called "update" to store information about items that need to be updated    
        ArrayList<String[]> update = new ArrayList<String[]>();
        // Display a message about unadded items that have arrived and need to be processed     
        System.out.println("\nSome item ordered by Sales Manager has been arrived but haven't add to the system"
                + "\nUnadded Item: ");
        // Display a header for the list of unadded items with column headers
        System.out.println(String.format("| %-8s "+"| %-10s "+"| %-10s "+"| %-10s " + "| %-10s |", "Index","Item","Price","Quantity","Supplier"));
        // Initialize an index variable
        int indexs = 3;
        // Initialize a position in PR file variable
        int position_PRfile = 0;
        // Iterate through the list of purchase requests ("pr_itemss")
        for (String item_name: pr_itemss){
            // Split the purchase request data into an array of strings
            String[] item_string = item_name.split("~");
            // Check if the item has arrived, is approved, and hasn't been added yet        
            if (item_string[8].equals("Arrived") && item_string[9].equals("Approved") && item_string[10].equals("Unadded")){
                // Display information about the unadded item in a formatted table row
                System.out.println(String.format("| %-8s "+"| %-10s "+"| %-10s "+"| %-10s " + "| %-10s |", indexs,item_string[2],item_string[3],item_string[4],item_string[6]));
                // Create an array with information about the item for updating
                String position = Integer.toString(position_PRfile);
                String[] temporary = {position,item_string[0],item_string[1],item_string[2],item_string[3],item_string[4],item_string[5],item_string[6],item_string[7],item_string[8],item_string[9],item_string[10],Integer.toString(indexs)};
                // Add this array to the "update" list
                update.add(temporary);
                // Increment the index for display
                indexs = indexs + 1 ;
            }
            // Increment the position in the PR file            
            position_PRfile += 1;
        }
        // Display options for adding existing or new items        
        System.out.println("\n1. Existing item\n"
                + "2. New item\n"
                + "The new arrived item ordered by Purchase Manager may be the existing item recorded in our system but ordered for adding its stock"
                + " and the new item that haven't been recorded in our system\n"
                + "You can choose 1 to update the stock of the item in our system or 2 to add the new arrived item");
        // Get the user's choice by calling the "operation" method
        int choose = System_Common_Function.operation(2);
        
        if (choose == 1) {
            int position_item_file = 0;
            // Iterate through the list of items
            for (String item : items) {
                // Split the item data into an array of strings
                String[] item_in_array = item.split("~");
                // Iterate through the "update" list containing information about unadded items
                for (String[] i : update) {
                    // Check if the item in "update" matches the current item being processed
                    if (i[3].equals(item_in_array[0])) {
                        // Parse the stock information from both the item and the update
                        int stock_recorded = Integer.parseInt(item_in_array[5]);
                        int add_stock = Integer.parseInt(i[5]);
                        int new_stock = stock_recorded + add_stock;
                        // Update the stock quantity in the item array
                        item_in_array[5] = Integer.toString(new_stock);
                        // Create new strings for the updated item and purchase request
                        String new_string_item = item_in_array[0] + "~" + item_in_array[1] + "~" + item_in_array[2] + "~" + item_in_array[3] +
                                "~" + item_in_array[4] + "~" + item_in_array[5] + "~" + item_in_array[6] + "~" + item_in_array[7] + "~";
                        String new_string_pr = i[1] + "~" + i[2] + "~" + i[3] + "~" + i[4] + "~" + i[5] + "~" + i[6] + "~" + i[7] + "~" + i[8]
                                + "~" + i[9] + "~" + i[10] + "~Added~";
                        // Print the new item and purchase request strings for debugging
                        System.out.println(new_string_item);
                        System.out.println(new_string_pr);
                        // Update the item and purchase request lists with the new strings
                        items.set(position_item_file, new_string_item);
                        pr_itemss.set(Integer.parseInt(i[0]), new_string_pr);
                    }
                }
                // Increment the position in the item file
                position_item_file = position_item_file + 1;
            }
            // Rewrite the updated items and purchase requests back to their respective files
            obj1.rewrite_file(items);
            obj100.rewrite_file(pr_itemss);
        }

        else{
            String[] adding_new_item = new String[12];
            int position_in_pr = 0;
            // Prompt the user to choose an arrived item to add into the system    
            System.out.println("\nChoose an arrived item to add into our system\nChoose by indicate the index of the new arrived item");
            int cmt = System_Common_Function.operation(indexs+1);
            // Check if the chosen index is less than 3
            if (cmt<3){
                System.out.println("Sorry, the starting index for an unadded arrived item is 3!");
            }
            else{
                // Iterate through the "update" list containing information about unadded items        
                for (String[]i: update){
                    // Check if the item in "update" matches the chosen index    
                    if (i[12].equals(Integer.toString(cmt))){
                        // Store information about the chosen item
                        this.code = i[3];
                        this.price = i[4];
                        this.stock = i[5];
                        this.supplier = i[7];
                        adding_new_item = i;
                        position_in_pr = Integer.parseInt(i[12]);
                    }
                }
            }
            
            boolean add = true;
            while (add == true){

                System.out.println("\n-------------------------------------------------------------------------------------------------\nAdd new:");
                // Display the current values of the item attributes
                System.out.println("\n0. Code: " + this.code +
                                    "\n1. Name: " + this.name +
                                    "\n2. Type: " + this.type +
                                    "\n3. Expire Date: " + this.date +
                                    "\n4. Price: " + this.price +
                                    "\n5. Stock: " + this.stock +
                                    "\n6. Description: " + this.description +
                                    "\n7. Supplier: " + this.supplier +
                                    "\n\n8. Save" +
                                    "\n9. Cancel ");

                System.out.println("\n\nNote: The code of the item will be auto generated by this system based on the code of the last item stored in this system"
                            + "The price, stock and the supplier will be automatically filled base on the Purchase Requisition the Sales Manager has raised to buy this item"
                            + "If you found that the arrived item's detail is not same as the detail automatically generated, you can change here and report to the Purchase Manager as soon as possible!" +
                         "\nPlease provide the other detail of the item" +
                        "\nFor example, choose 1 to input the name of the item." +
                        "\nNote: The detail of the item cannot same with the existing one (no dulpicated item)" +
                        "\nPlease select your choice to input the data: ");

                // Get the user's input for the choice of operation (from 0 to 9)
                int command = System_Common_Function.operation(9);

                switch (command){
                    case 1:
                        // Prompt the user to enter the name of the item
                        String item_name = System_Common_Function.input_data("Please enter the name of the item: ");
                        for (String element : items) {
                            // Split the current element into an array using the delimiter "~"
                            String[] element_array = element.split("~");
                            if (item_name.equals(element_array[1])) {
                                // If the entered item name matches an existing item's name, display an error message
                                System.out.println("\nSorry, the item is already existed.\nPlease try again!");
                                break; // Exit the loop since a match was found
                            } else {
                                // If the entered item name doesn't match any existing item, assign it to the "name" attribute
                                this.name = item_name;
                                break; // Exit the loop since a non-matching condition was met
                            }
                        }
                        break;
                    case 2:
                        // Prompt the user to input the type of the item
                        this.type = System_Common_Function.input_data("Please enter the type of the item: ");
                        break;
                    case 3:
                        // Prompt the user to input the expiration date of the item
                        System.out.println("Format: dd-mm-yyyy");
                        this.date = System_Common_Function.input_data("Please enter the expire date of the item: ");
                        break;
                    case 4:
                        // Prompt the user to input the price of the item (without RM) and validate it
                        String price = System_Common_Function.input_data("Please enter the price of the item (without RM): ");
                        if (super.isNumeric(price)) {
                            this.price = "RM " + price; // Format the price with "RM" prefix
                        } else {
                            System.out.println("\nSorry, here only accept number.");
                        }
                        break;
                    case 5:
                        // Prompt the user to input the stock of the item and validate it
                        String stocks = System_Common_Function.input_data("Please enter the stock of the item: ");
                        if (super.isNumeric(stocks)) {
                            this.stock = stocks;
                        } else {
                            System.out.println("\nSorry, here only accept number.");
                        }
                        break;
                    case 6:
                        // Prompt the user to input the description of the item
                        this.description = System_Common_Function.input_data("Please enter the description of the item: ");
                        break;
                    case 7:
                        // Prompt the user to input the supplier ID in correct format
                        System.out.println("Please input a correct format, for example: S000001");
                        String supplier = System_Common_Function.input_data("Please enter the supplier of the item: ");
                        // Read the supplier data from the supplier.txt file
                        File_Management obj2 = new File_Management("supplier.txt");
                        ArrayList<String> supp = obj2.read_file();
                        // Search for the input supplier ID in the list of suppliers
                        for (String element : supp) {
                            String[] element_array = element.split("~");
                            if (supplier.equals(element_array[0])) {
                                this.supplier = supplier; // Assign the input supplier ID if found
                            }
                        }
                        // If the supplier ID is not found or is not in the correct format, display an error message
                        if (this.supplier.equals("")) {
                            System.out.println("\nYour supplier id's format is incorrect or is not in our system." +
                                    "\nPlease check the existing supplier id first and input a valid supplier id that this system recognizes");
                        }
                        break;
                    case 8:
                        if (this.code.equals("") || this.name.equals("") || this.type.equals("") || this.date.equals("") || this.price.equals("") || this.stock.equals("") || this.description.equals("") || this.supplier.equals("")) {
                            // Check if any of the item details are blank
                            System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                            System.out.println("Sorry, the detail here cannot be blank.\nPlease provide all the detail!");
                            System.out.println("-------------------------------------------------------------------------------------------------");
                        } else {
                            // If all item details are entered.
                            String ready_write_into_file = this.code + "~" + this.name + "~" + this.type + "~" + this.date + "~" + this.price + "~"
                                + this.stock + "~" + this.description + "~" + this.supplier;
                            // Write the item details to the "item.txt" file
                            obj1.write_file(ready_write_into_file);
                            obj1.write_file("\n");
                            System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                            System.out.println("You have successfully added an item!");
                            System.out.println("-------------------------------------------------------------------------------------------------");

                            // Update the "Added" status for the corresponding item in the PR (Purchase Requisition) file
                            adding_new_item[11] = "Added";
                            String update_pr_file = adding_new_item[1] + "~" + adding_new_item[2] + "~" + adding_new_item[3] + "~" + adding_new_item[4] +
                                "~" + adding_new_item[5] + "~" + adding_new_item[6] + "~" + adding_new_item[7] + "~" + adding_new_item[8] +
                                "~" + adding_new_item[9] + "~" + adding_new_item[10] + "~" + adding_new_item[11] + "~";

                            // Update the PR item status in the "PR.txt" file
                            pr_itemss.set(Integer.parseInt(adding_new_item[0]), update_pr_file);
                            obj100.rewrite_file(pr_itemss);

                            // Reset item details to empty strings for the next item
                            this.code = "";
                            this.name = "";
                            this.type = "";
                            this.date = "";
                            this.price = "";
                            this.stock = "";
                            this.description = "";
                            this.supplier = "";
                            add = false; // Exit the loop
                        }
                        break;
                    case 9:
                        add = false; // Exit the loop and stop adding new items
                        break;
                }
            }
        }
    }    
    
    
    
    
    
    
    
    
    
    public void delete(ArrayList<String[]> indexWITHcode){
        boolean delete = true;
        while (delete == true){
            File_Management obj1 = new File_Management("item.txt");
            ArrayList<String> items = obj1.read_file();
            // Display the list of items and options for deletion
            System.out.println("\n-------------------------------------------------------------------------------------------------\nDelete Item: ");
            System.out.println("\n3. Cancel\nPlease input 3 if you don't wish to delete an item or select the index of the item that you wish to delete: ");
            // Get the user's choice for deletion
            int item_to_be_deleted = System_Common_Function.operation(items.size() + 3);
            if (item_to_be_deleted < 3){
                // Display an error message for an invalid index selection
                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                System.out.println("Sorry, please select a valid index of the item you wish to delete it\n"+
                        "For example: input 4 to delete the first item");
                System.out.println("-------------------------------------------------------------------------------------------------");
            }
            else if (item_to_be_deleted == 3){
                // User choose to cancel the deletion process
                delete = false;
                break; // Exit the loop
            }
            else {
                int position_file = 0;
                // Get the code like "I000001" based on the selected index
                String code = "0";
                for (String[] i : indexWITHcode) {
                    if (item_to_be_deleted == Integer.parseInt(i[0])) {
                        code = i[1];
                    }
                }
                // Loop through the items and remove the selected item based on the code
                for (String item_name : items) {
                    String[] item_string = item_name.split("~");
                    if (code.equals(item_string[0])) {
                        items.remove(position_file); // Remove the item from the list
                        break;
                    }
                    position_file = position_file + 1;
                }
                // Rewrite the updated item list back to the file
                obj1.rewrite_file(items);
                // Display success message and exit the loop
                System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                System.out.println("You have successfully deleted the item!");
                System.out.println("-------------------------------------------------------------------------------------------------");
                delete = false; // Exit the loop
                break;
            }
        }  
    }
    
}
