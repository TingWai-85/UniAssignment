
package purchase_order_management_system_.pom;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//login--------------------------------------------------------
        // Create an instance of the Login class
        Login obj1 = new Login();
        boolean system = true;
        while (system == true){
            // Boolean variable to control the login loop
            boolean login = true;
            String user_role = "";
            String user_id = "";
            while (login){
                // Display login information (possibly a menu) using the toString() method of obj1        
                System.out.println(obj1);
                // Get user input for login operation (presumably a menu choice)            
                int command = System_Common_Function.operation(4);
                // Attempt to enter credentials and check if login was successful                
                login = obj1.enter_credential(command);
                // User enter 4 to exit, break out of the login loop
                if (command == 4){
                    login = false;
                    system = false;
                    break; // Exit both loops
                }
                // Get the user's role and user ID after successful login                
                user_role = obj1.getRole();
                user_id = obj1.getUser_id();
            }
            if (system == false){
                System.out.println("\nThanks You!");
                break;
            }
//login-----------------------------------------------------------

//user-------------------------------------------------------------------------------
            boolean user = true;
            while (user){
                if ("Sales_Manager".equals(user_role)){
                    Sales_Manager obj2 = new Sales_Manager(user_id);
                    System.out.println(obj2);
                    int command = System_Common_Function.operation(8);
                    if (command == 7){
                        user = false;
                        continue;
                    }
                    else if (command == 8){
                        user = false;
                        system = false;
                        break;
                    }
                    
                    switch (command){
                        case 1:
                            boolean profile = true;
                            while (profile == true){
                                User myuser = new User(user_id);
                                System.out.println("\n-------------------------------------------------------------------------------------------------\nPersonal Detail: \n");

                                System.out.println(myuser);
                                int command_profile = System_Common_Function.operation(2);
                                if (command_profile == 1){
                                    myuser.changePassword();
                                }
                                else if (command_profile == 2){
                                    profile = false;
                                    break;
                                }
                            }
                            break;
                        
                        case 2:
                            boolean system_item = true;
                            while(system_item == true){
                                Item obj3 = new Item();
                                ArrayList<String[]> item = obj3.view();
                                int command_item = System_Common_Function.operation(item.size()+3);
                                if (command_item == 1){ //add
                                    obj3.add();
                                }
                                else if (command_item == 2){ //delete
                                    obj3.delete(item);
                                }
                                else if (command_item == 3){
                                    system_item = false;
                                    break;
                                }
                                else if (command_item > 3 && command_item <= item.size()+3){
                                    obj3.detail("SM",command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occur\nPlease try again!");
                                }
                            }
                            break;
                        case 3:
                            boolean system_supp = true;
                            while(system_supp == true){
                                Supplier obj3 = new Supplier();
                                ArrayList<String[]> item = obj3.view();
                                int command_item = System_Common_Function.operation(item.size()+3);
                                if (command_item == 1){ //add
                                    obj3.add();
                                }
                                else if (command_item == 2){ //delete
                                    obj3.delete(item);
                                }
                                else if (command_item == 3){
                                    system_supp = false;
                                    break;
                                }
                                else if (command_item > 3 && command_item <= item.size()+3){
                                    obj3.detail("SM",command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occur\nPlease try again!");
                                }
                            }
                            break;
                        case 4:
                            boolean system_pr = true;
                            while(system_pr == true){
                                Purchase_Requisition obj3 = new Purchase_Requisition(user_id);
                                ArrayList<String[]> item = obj3.view();
                                int command_item = System_Common_Function.operation(item.size()+3);
                                if (command_item == 1){ //add
                                    obj3.add();
                                }
                                else if (command_item == 2){ //delete
                                    obj3.delete(item);
                                }
                                else if (command_item == 3){
                                    system_pr = false;
                                    break;
                                }
                                else if (command_item > 3 && command_item <= item.size()+3){
                                    obj3.detail("SM",user_id,command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occur\nPlease try again!");
                                }
                            }
                            break;
                        case 5:
                            boolean system_po = true;
                            while(system_po == true){
                                Purchase_order obj3 = new Purchase_order(user_id);
                                ArrayList<String[]> item = obj3.view();
                                int command_item = System_Common_Function.operation(item.size()+3);
                                if (command_item == 1){ //add
                                    System.out.println("Sorry, you can't add Purchase Requisition.\nPlease contact the manager if you wish to do so.");
                                }
                                else if (command_item == 2){ //delete
                                    System.out.println("Sorry, you can't delete Purchase Requisition.\nPlease contact the manager if you wish to do so.");
                                }
                                else if (command_item == 3){
                                    system_pr = false;
                                    break;
                                }
                                else if (command_item > 3 && command_item <= item.size()+3){
                                    obj3.detail("SM",user_id,command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occur\nPlease try again!");
                                }
                            }
                            break;
                        
                        case 6:
                            boolean system_daily = true;
                            while(system_daily == true){
                                Daily_Sales obj3 = new Daily_Sales();
                                ArrayList<String[]> item = obj3.view_daily();
                                int command_item = System_Common_Function.operation(item.size()+4);
                                if (command_item == 1){ //add
                                    obj3.add_new_sale();
                                }
                                else if (command_item == 2){ //delete
                                    obj3.delete_sale(item);
                                }
                                else if (command_item == 3){
                                    obj3.match();
                                }
                                else if (command_item == 4){
                                    system_supp = false;
                                    break;
                                }
                                else if (command_item > 4 && command_item <= item.size()+4){
                                    obj3.sales_detail(command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occur\nPlease try again!");
                                }
                            }
                            break;                            
                            
                    }
                }
                else if ("Purchase_Manager".equals(user_role)){
                    Purchase_Manager obj2 = new Purchase_Manager(user_id);
                    System.out.println(obj2);
                    int command = System_Common_Function.operation(7);
                    if (command == 6){
                        user = false;
                        continue;
                    }
                    else if (command == 7){
                        user = false;
                        system = false;
                        break;
                    }
                    
                    switch (command){
                        case 1:
                            boolean profile = true;
                            while (profile == true){
                                User myuser = new User(user_id);
                                System.out.println(myuser);
                                int command_profile = System_Common_Function.operation(2);
                                if (command_profile == 1){
                                    myuser.changePassword();
                                }
                                else if (command_profile == 2){
                                    profile = false;
                                    break;
                                }
                            }
                            break;
                        case 2:
                            boolean system_item = true;
                            while(system_item == true){
                                Item obj3 = new Item();
                                ArrayList<String[]> item = obj3.view();
                                int command_item = System_Common_Function.operation(item.size()+3);
                                if (command_item == 1){ //add
                                    System.out.println("Sorry, you can't add item.\nPlease contact the manager if you wish to do so.");
                                }
                                else if (command_item == 2){ //delete
                                    System.out.println("Sorry, you can't delete item.\nPlease contact the manager if you wish to do so.");
                                }
                                else if (command_item == 3){
                                    system_item = false;
                                    break;
                                }
                                else if (command_item > 3 && command_item <= item.size()+3){
                                    obj3.detail("PM",command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occur\nPlease try again!");
                                }
                            }
                            break;
                        case 3:
                            boolean system_supp = true;
                            while(system_supp == true){
                                Supplier obj3 = new Supplier();
                                ArrayList<String[]> item = obj3.view();
                                int command_item = System_Common_Function.operation(item.size()+3);
                                if (command_item == 1){ //add
                                    System.out.println("Sorry, you can't add supplier.\nPlease contact the manager if you wish to do so.");
                                }
                                else if (command_item == 2){ //delete
                                    System.out.println("Sorry, you can't delete supplier.\nPlease contact the manager if you wish to do so.");
                                }
                                else if (command_item == 3){
                                    system_supp = false;
                                    break;
                                }
                                else if (command_item > 3 && command_item <= item.size()+3){
                                    obj3.detail("PM",command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occur\nPlease try again!");
                                }
                            }
                            break;
                        case 4:
                            boolean system_pr = true;
                            while(system_pr == true){
                                Purchase_Requisition obj3 = new Purchase_Requisition(user_id);
                                ArrayList<String[]> item = obj3.view();
                                int command_item = System_Common_Function.operation(item.size()+3);
                                if (command_item == 1){ //add
                                    System.out.println("Sorry, you can't add Purchase Requisition.\nPlease contact the manager if you wish to do so.");
                                }
                                else if (command_item == 2){ //delete
                                    System.out.println("Sorry, you can't delete Purchase Requisition.\nPlease contact the manager if you wish to do so.");
                                }
                                else if (command_item == 3){
                                    system_pr = false;
                                    break;
                                }
                                else if (command_item > 3 && command_item <= item.size()+3){
                                    obj3.detail("PM",user_id,command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occur\nPlease try again!");
                                }
                            }
                            break;
                        case 5:
                            boolean system_po = true;
                            while(system_po == true){
                                Purchase_order obj3 = new Purchase_order(user_id);
                                ArrayList<String[]> item = obj3.view();
                                int command_item = System_Common_Function.operation(item.size()+3);
                                if (command_item == 1){ //add
                                    obj3.add();
                                }
                                else if (command_item == 2){ //delete
                                    System.out.println("You can delete the Purchase Order by editing the Purchase Order from Approved to Unapproved"
                                            + ".\nOnce you have transformed the Purchase Order's status from Approved to Unapproved, the system"
                                            + " will automatically delete the Purchase Order");
                                }
                                else if (command_item == 3){
                                    system_po = false;
                                    break;
                                }
                                else if (command_item > 3 && command_item <= item.size()+3){
                                    obj3.detail("PM",user_id,command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occur\nPlease try again!");
                                }
                            }
                            break;
                            
                    }
                }
                
                else if ("Admin".equals(user_role)){
                    Admin obj2 = new Admin(user_id);
                    System.out.println(obj2);
                    int command = System_Common_Function.operation(9);
                    if (command == 8){
                        user = false;
                        continue;
                    }
                    else if (command == 9){
                        user = false;
                        system = false;
                        break;
                    }
                    switch (command){
                        case 1:
                            boolean profile = true;
                            while (profile == true){
                                User myuser = new User(user_id);
                                System.out.println(myuser);
                                int command_profile = System_Common_Function.operation(2);
                                if (command_profile == 1){
                                    myuser.changePassword();
                                }
                                else if (command_profile == 2){
                                    profile = false;
                                    break;
                                }
                            }
                            break;
                        case 2:
                            boolean system_item = true;
                            while(system_item == true){
                                Item obj3 = new Item();
                                ArrayList<String[]> item = obj3.view();
                                int command_item = System_Common_Function.operation(item.size()+3);
                                if (command_item == 1){ //add
                                    obj3.add();
                                }
                                else if (command_item == 2){ //delete
                                    obj3.delete(item);
                                }
                                else if (command_item == 3){
                                    system_item = false;
                                    break;
                                }
                                else if (command_item > 3 && command_item <= item.size()+3){
                                    obj3.detail("SM",command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occur\nPlease try again!");
                                }
                            }
                            break;
                        case 3:
                            boolean system_supp = true;
                            while(system_supp == true){
                                Supplier obj3 = new Supplier();
                                ArrayList<String[]> item = obj3.view();
                                int command_item = System_Common_Function.operation(item.size()+3);
                                if (command_item == 1){ //add
                                    obj3.add();
                                }
                                else if (command_item == 2){ //delete
                                    obj3.delete(item);
                                }
                                else if (command_item == 3){
                                    system_supp = false;
                                    break;
                                }
                                else if (command_item > 3 && command_item <= item.size()+3){
                                    obj3.detail("SM",command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occur\nPlease try again!");
                                }
                            }
                            break;
                        case 4:
                            boolean system_pr = true;
                            while(system_pr == true){
                                Purchase_Requisition obj3 = new Purchase_Requisition(user_id);
                                ArrayList<String[]> item = obj3.view();
                                int command_item = System_Common_Function.operation(item.size()+3);
                                if (command_item == 1){ //add
                                    obj3.add();
                                }
                                else if (command_item == 2){ //delete
                                    obj3.delete(item);
                                }
                                else if (command_item == 3){
                                    system_pr = false;
                                    break;
                                }
                                else if (command_item > 3 && command_item <= item.size()+3){
                                    obj3.detail("SM","Admin",command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occur\nPlease try again!");
                                }
                            }
                            break;
                        case 5:
                            boolean system_po = true;
                            while(system_po == true){
                                Purchase_order obj3 = new Purchase_order(user_id);
                                ArrayList<String[]> item = obj3.view();
                                int command_item = System_Common_Function.operation(item.size()+3);
                                if (command_item == 1){ //add
                                    obj3.add();
                                }
                                else if (command_item == 2){ //delete
                                    System.out.println("You can delete the Purchase Order by editing the Purchase Order from Approved to Unapproved"
                                            + ".\nOnce you have transformed the Purchase Order's status from Approved to Unapproved, the system"
                                            + " will automatically delete the Purchase Order");
                                }
                                else if (command_item == 3){
                                    system_po = false;
                                    break;
                                }
                                else if (command_item > 3 && command_item <= item.size()+3){
                                    obj3.detail("PM","Admin",command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occurred\nPlease try again!");
                                }
                            }
                            break;
                        case 6:
                            boolean system_daily = true;
                            while(system_daily == true){
                                Daily_Sales obj3 = new Daily_Sales();
                                ArrayList<String[]> item = obj3.view_daily();
                                int command_item = System_Common_Function.operation(item.size()+4);
                                if (command_item == 1){ //add
                                    obj3.add_new_sale();
                                }
                                else if (command_item == 2){ //delete
                                    obj3.delete_sale(item);
                                }
                                else if (command_item == 3){
                                    obj3.match();
                                }
                                else if (command_item == 4){
                                    system_supp = false;
                                    break;
                                }
                                else if (command_item > 4 && command_item <= item.size()+4){
                                    obj3.sales_detail(command_item,item);
                                }
                                else{
                                System.out.println("Sorry, some problem occur\nPlease try again!");
                                }
                            }
                            break;  
                        case 7:
                            obj2.registeration();
                    }
                }
                else{
                    System.out.println("Something occur\nPlease report to the admin as soon as possible");
                    break;
                }
                
            }
        
//user-------------------------------------------------------------------------------
        }
        
        
    }
    
}
