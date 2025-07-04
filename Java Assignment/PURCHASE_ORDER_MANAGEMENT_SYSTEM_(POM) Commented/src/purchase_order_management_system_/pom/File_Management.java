
package purchase_order_management_system_.pom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.nio.file.Paths;

public class File_Management {
    private String filename;

    // Constructor for the 'File_Management' class that takes a 'filename' as a parameter
    public File_Management(String x) {
        // Get the current working directory and normalize the path
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        // Replace backslashes with double backslashes for Windows paths
        currentPath = currentPath.replace("\\", "\\\\");

        // Create the full path to the file using the provided filename
        filename = (currentPath + "\\\\src\\\\purchase_order_management_system_\\\\pom\\\\" + x);
    }

    // Getter method to retrieve the filename
    public String getfile() {
        return filename;
    }

    // Method to display details about the file
    public void file_detail() {
        File myfile = new File(filename);
        if (myfile.exists()) {
            // Display file details
            System.out.println("File name: " + myfile.getName());
            System.out.println("File path: " + myfile.getAbsolutePath());
            System.out.println("Writable: " + myfile.canWrite());
            System.out.println("Readable: " + myfile.canRead());
        } else {
            System.out.println("The file does not exist.");
        }
    }

    // Method to read the contents of the file and return them as an ArrayList of strings
    public ArrayList<String> read_file() {
        ArrayList<String> data = new ArrayList<String>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                // Read each line from the file and add it to the ArrayList
                data.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }

    // Method to write a string to the end of the file
    public void write_file(String i) {
        try {
            FileWriter myObj = new FileWriter(filename, true);
            // Write the provided string to the end of the file
            myObj.write(i);
            myObj.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            // Handle IO exception
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Method to rewrite the entire file with the contents of the provided ArrayList of strings
    public void rewrite_file(ArrayList<String> i) {
        try {
            PrintWriter writer = new PrintWriter(filename);
            writer.print(""); // Clear the file
            writer.close();

            // Write each item in the ArrayList to the file, followed by a newline
            for (String item : i) {
                // Write each item to the file
                write_file(item);
                // Write a newline character to separate items
                write_file("\n");
            }
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
