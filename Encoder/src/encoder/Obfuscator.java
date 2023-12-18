package encoder;

import java.util.Scanner;

public class Obfuscator {
	
	public static String shiftCharacters(String input, int shift) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        // Get the length of the reference string
        int length = input.length();

        // StringBuilder to store the shifted characters
        StringBuilder shiftedText = new StringBuilder();

        // Iterate through each character in the input string
        for (int i = 0; i < length; i++) {
            char currentChar = input.charAt(i);

            // Check if the character is in the reference string
            int charIndex = input.indexOf(currentChar);
            if (charIndex != -1) {
                // Calculate the new index after shifting
                int newIndex = (charIndex + shift) % length;

                // Handle negative indices
                if (newIndex < 0) {
                    newIndex += length;
                }

                // Append the shifted character to the result
                shiftedText.append(input.charAt(newIndex));
            } else {
                // If the character is not in the reference string, keep it unchanged
                shiftedText.append(currentChar);
            }
        }

        return shiftedText.toString();
	
	}
	
	public static String encode(String plainText) { // changed method name to encode . Commented by interviewer
        if (plainText == null || plainText.isEmpty()) {
            return "";
        }

        // Choose 'B' as the offset character
        char offset = 'B';

        // Generate the shifted reference table
        String original = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
        String shifted = shiftCharacters(original, 2);
        System.out.println("Original Table : " + original);
        System.out.println("Shifted Table : " + shifted);
        // Find the index of the offset character in the shifted reference table
        int offsetIndex = shifted.indexOf(offset);

        StringBuilder encodedText = new StringBuilder();
        encodedText.append(offset); // The first character of the encoded message is the offset character

        for (char c : plainText.toCharArray()) {
            // Check if the character is in the shifted reference table
            if (shifted.indexOf(c) != -1) {
                // Calculate the new index based on the offset
                int index = (shifted.indexOf(c) + offsetIndex) % shifted.length();
                // Append the character from the shifted reference table at the new index
                encodedText.append(shifted.charAt(index));
            } else {
                // If the character is not in the shifted reference table, keep it unchanged
                encodedText.append(c);
            }
        }

        return encodedText.toString();
    }
	

	
	 // Changed method decode to meet requirement 
	
	 public static String decode(String encodedText) {
	        if (encodedText == null || encodedText.length() < 2) {
	            return "";
	        }

	        // Choose 'B' as the offset character
	        char offset = 'B';

	        // Generate the shifted reference table
	        String original = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
	        String shifted = shiftCharacters(original, 2);

	        // Find the index of the offset character in the shifted reference table
	        int offsetIndex = shifted.indexOf(offset);

	        StringBuilder decodedText = new StringBuilder();

	        for (int i = 1; i < encodedText.length(); i++) {
	            char c = encodedText.charAt(i);
	            if (shifted.indexOf(c) != -1) {
	                int index = (shifted.indexOf(c) - offsetIndex + shifted.length()) % shifted.length();
	                decodedText.append(shifted.charAt(index));
	            } else {
	                decodedText.append(c);
	            }
	        }

	        return decodedText.toString();
	    }

	public static void main(String[] args) {
		
	        // Test the encodeWithShiftedTable method
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
		
		
	    String originalText = userInput;
//	    String original = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
//	    String shifted = shiftCharacters(original, 2);
	    String encodedText = encode(originalText);
	    String decodedText = decode(encodedText);
//	    System.out.println("Original Text : " + originalText);
	    System.out.println("Encoded Text  : " + encodedText);
	    System.out.println("Decoded Text  : " + decodedText);
	    
	    }


}
