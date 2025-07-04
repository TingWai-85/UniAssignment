
package purchase_order_management_system_.pom;
// Define a Java class as "Admin" that extends the "User" class.
public class Admin extends User {
    // Constructor for the Admin class, user_id as parameter.
    public Admin(String user_id) {
        // Call the constructor of the parent class "User" using "super" and pass the user_id parameter.
        super(user_id);
    }
    // Override the toString() method to provide a custom string representation of the Admin object.
    public String toString() {
        // Return a formatted string which is a welcome message and 
        // the result of the user_operation() method from the parent class "User".
        return "\n-------------------------------------------------------------------------------------------------\n" +
                "Welcome our Admin --> " + super.getUser_data()[1] + "!" +
                "\n" +
                super.user_operation();
    }
}

