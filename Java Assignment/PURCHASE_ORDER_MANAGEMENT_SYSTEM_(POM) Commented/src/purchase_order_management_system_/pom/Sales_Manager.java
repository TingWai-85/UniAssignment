
package purchase_order_management_system_.pom;

// Define a class called 'Sales_Manager' that extends the 'User' class
public class Sales_Manager extends User {
    
    // Constructor for the 'Sales_Manager' class that takes a user_id as a parameter
    public Sales_Manager(String user_id){
        // Call the constructor of the parent class (User) with the user_id parameter
        super(user_id);
    }
    // Override the toString() method to provide a custom string representation
    public String toString(){
        // Return a formatted welcome message for the Sales Manager and the user operation menu
        return "\n-------------------------------------------------------------------------------------------------\n" +
                "Welcome our Sales Manager --> " + super.getUser_data()[1] + "!" +
                "\n" +
                super.user_operation();
    }
}

