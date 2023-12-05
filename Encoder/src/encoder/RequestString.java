


package encoder;

import java.util.Scanner;

public class RequestString {

// Ask user for a String

public static void main(String[] args) {
    // Create a Scanner object to read user input
    Scanner scanner = new Scanner(System.in);

    // Request user input for a string
    System.out.print("Enter a string: ");
    
    // Read the user input and store it in a variable
    String userInput = scanner.nextLine();

    // Close the scanner to prevent resource leaks
    scanner.close();

    // Display the stored string
    System.out.println("You entered: " + userInput);
}






}