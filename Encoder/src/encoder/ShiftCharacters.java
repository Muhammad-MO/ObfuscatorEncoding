package encoder;

public class ShiftCharacters {
	
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

    public static void main(String[] args) {
        // Given reference string
        String referenceString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";

        // Shift each character down by 2 spaces
        String shiftedString = shiftCharacters(referenceString, -1);

        // Print the original and shifted strings
        System.out.println("Original String   : " + referenceString);
        System.out.println("Shifted String    : " + shiftedString);
    }
   
}
