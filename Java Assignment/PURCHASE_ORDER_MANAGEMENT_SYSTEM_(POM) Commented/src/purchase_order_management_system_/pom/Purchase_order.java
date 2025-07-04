
package purchase_order_management_system_.pom;

import java.util.ArrayList;

public class Purchase_order extends System_Common_Function {
    private String code = "";  // Initialize a private instance variable 'code' as an empty string.
    private String purchase_manager = "";  // Initialize 'purchase_manager' as an empty string.

    // Constructor for the Purchase_order class that takes a user_id as a parameter.
    public Purchase_order(String user_id) {
        this.purchase_manager = user_id;  // Set 'purchase_manager' with the provided 'user_id'.
    }
    
    
    
    
    
    
    
    
    
    
    // Method to view purchase orders.
    public ArrayList view() {
        System.out.println("\n-------------------------------------------------------------------------------------------------");
        // Call the 'view_po' method from the parent class 'System_Common_Function' to get purchase order information.
        ArrayList<String[]> index_code = super.view_po();
        return index_code;  // Return the retrieved purchase order information.
    }
    
    
    
    
    
    
    
    
    
    
    // Method to view purchase order details for a specific item.
    public void detail(String position, String user_id, int command, ArrayList<String[]> indexWITHcode) {
        // Call the 'po_detail' method from the parent class 'System_Common_Function' to view details of specific item.
        super.po_detail(position, user_id, command, indexWITHcode);
    }
    
    
    
    
    
    
    
    
    
    
    public void add(){
        boolean add = true;
        while (add == true){
            // Create a File_Management object to manage the "PO.txt" file.
            File_Management obj1 = new File_Management("PO.txt");
            // Create another File_Management object to manage the "PR.txt" file.
            File_Management obj2 = new File_Management("PR.txt");
            // Read the contents of the "PR.txt" file and store them in the 'items' ArrayList.
            ArrayList<String> items = obj2.read_file();
            // Initialize an empty ArrayList of String arrays to store indexes and codes.
            ArrayList<String[]> index_code = new ArrayList<String[]>();
            // Initialize a String array to store purchase requisition data.
            String[] purchase_requisition = null;
            // Print information for selecting a Purchase Requisition.
            System.out.println("\n-------------------------------------------------------------------------------------------------\nSelect a Purchase Requisition:");
            System.out.println("\nPending Purchase Requisition: ");
            // Initialize an index variable starting at 2. It will be used to number the options.
            int index = 2;
            
            
            // Loop through each item in the 'items' ArrayList, which contains purchase requisition data.
            for (String item_name : items) {
                // Split the current 'item_name' using the "~" delimiter and store the result in 'item_string'.
                String[] item_string = item_name.split("~");
                // Check if the purchase requisition is "Unapproved" (based on the condition 'item_string[9].equals("Unapproved")').
                if (item_string[9].equals("Pending")){
                    // If the purchase requisition is unapproved, create a new 'item_unapprove_string' array by splitting 'item_name' again.
                    String[] item_unapprove_string = item_name.split("~");
                    // Create a 'temporary' array to store [index, PR's code] to locate the item in the file easily later.
                    String[] temporary = { Integer.toString(index), item_unapprove_string[0] };
                    // Add the 'temporary' array to the 'index_code' ArrayList.
                    index_code.add(temporary);
                    // Print the index (numbered option) and the PR's code to display available unapproved purchase requisitions.
                    System.out.println(index + ". " + item_string[0]);
                    // Increment the 'index' variable to number the next option.
                    index = index + 1;
                }
            }
            System.out.println("\n1. Cancel\nPlease select a Pending Purchase Requisition to be approved or unapproved");
            int command = System_Common_Function.operation(index_code.size()+1);
            
            // Check if the user choose to cancel the operation.
            if (command == 1) {
                // If 'Cancel', set the 'add' to false and break out of the loop to exit the operation.
                add = false;
                break;
            } 
            else {
                String approve_status = "";
                // Prompt the user to choose between 'Approved' or 'Unapproved' for the PR.
                System.out.println("1. Approved\n2. Unapproved\nPlease select your choice");
                int approve = System_Common_Function.operation(2);
                if (approve == 1){
                    approve_status = "Approved";
                }
                else{
                    approve_status = "Unapproved";
                }
                // Generate a unique code for the Purchase Order (PO) using the 'auto_generate_code' method from 'System_Common_Function.'
                this.code = System_Common_Function.auto_generate_code(2, "PO", "PO.txt");
                // Initialize 'pr_code' to an empty string.
                String pr_code = "";
                // Loop through the 'index_code' ArrayList to find the Purchase Requisition (PR) code based on the user's selection.
                for (String[] i : index_code) {
                    if (command == Integer.parseInt(i[0])) {
                        pr_code = i[1];
                    }
                }
                // Initialize 'position_pr_file' to 0 to keep track of the position of the PR in the 'items' ArrayList.
                int position_pr_file = 0;
                // Loop through the 'items' ArrayList, splitting each item into an array of strings.
                for (String item_name : items) {
                    String[] item_string = item_name.split("~");
                    // Check if the current item's code matches the selected PR code.
                    if (item_string[0].equals(pr_code)) {
                        // If matches, store the PR details in the 'purchase_requisition' array.
                        purchase_requisition = item_string;
                        break; // Exit the loop 
                    }
                    // Increment 'position_pr_file' to keep track of the position in the 'items' ArrayList.
                    position_pr_file = position_pr_file + 1;
                }
                // Update the status of the selected Purchase Requisition (PR) to "Approved."
                purchase_requisition[9] = approve_status;
                // Display information and options for creating a new Purchase Order (PO).
                System.out.println("\n-------------------------------------------------------------------------------------------------\nAdd new:");
                System.out.println("\n0. Code: " + this.code +
                                    "\n0. Pruchase Manager: " + this.purchase_manager +
                                    "\n0. Purchase Requisition: " + purchase_requisition[0] +
                                    "\n0. Issue Date: " + purchase_requisition[1] +
                                    "\n0. Item: " + purchase_requisition[2] +
                                    "\n0. Single Price: " + purchase_requisition[3] +
                                    "\n0. Quantity: " + purchase_requisition[4] +
                                    "\n0. Total: " + purchase_requisition[5] +
                                    "\n0. Supplier: " + purchase_requisition[6] +
                                     "\n0. Sales Manager: " + purchase_requisition[7] +
                                    "\n0. Arrive Status:" + purchase_requisition[8] +
                                    "\n0. Approve Status: " + purchase_requisition[9] +
                                    "\n\n1. Save" +
                                    "\n2. Cancel ");
                int save_or_cancel = System_Common_Function.operation(2);
                if (save_or_cancel == 1) {
                    // User choose to save the new Purchase Order (PO).
                    // Prepare data for writing into the PO and PR files.
                    String ready_write_into_file = this.code+"~"+this.purchase_manager+"~"+purchase_requisition[0] +"~"+purchase_requisition[1]+"~"+ purchase_requisition[2]+"~"
                                                    + purchase_requisition[3] + "~"+purchase_requisition[4]+"~"+purchase_requisition[5] +"~" + purchase_requisition[6] +"~"
                                                    + purchase_requisition[7] +"~" + purchase_requisition[8] +"~" + purchase_requisition[9] +"~";
                    // Write the data into the PO file.
                    obj1.write_file(ready_write_into_file);
                    obj1.write_file("\n");
                    // Prepare data for updating the PR file with the approved PR.
                    String ready_write_into_PR_file = purchase_requisition[0]+"~"+purchase_requisition[1]+"~"+purchase_requisition[2]+"~"+purchase_requisition[3]+"~"
                                                      + purchase_requisition[4] +"~" + purchase_requisition[5] +"~"+purchase_requisition[6]+"~"+purchase_requisition[7] +"~"
                                                      + purchase_requisition[8] +"~" + purchase_requisition[9] +"~Unadded";
                    // Update the PR file with the approved PR.
                    items.set(position_pr_file, ready_write_into_PR_file);
                    obj2.rewrite_file(items);
                    // Display a successful message.
                    System.out.println("-------------------------------------------------------------------------------------------------\n\n-------------------------------------------------------------------------------------------------");
                    System.out.println("You have successfully added a new Purchase Order \n"
                            + "If the item ia already reached our company, remember to update the arrive status of this Purchase Order in the edit section!");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                    add = false;
                    break;
                } else {
                    // User choose to cancel the operation.
                    add = false;
                    break;
                }

            }
  
        }
        
    }
    
    
    
}
