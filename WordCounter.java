import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        try (// Prompt the user to enter a text or provide a file.
        Scanner s = new Scanner(System.in)) {
            System.out.println("Enter a text or provide a file to count the words: ");
            String input = s.nextLine();

            // If the user entered a file, open the file and read the text.
            if (input.contains(".txt")) {
                File file = new File(input);
                try {
                    try (Scanner fileScanner = new Scanner(file)) {
                        input = fileScanner.nextLine();
                    }
                } catch (IOException e) {
                    System.out.println("Error opening file: " + e.getMessage());
                }
            }

            // Split the text into an array of words.
            String[] words = input.split("\\s+");

            // Initialize a counter variable to keep track of the number of words.
            int wordCount = 0;

            // Initialize a map to store the number of times each word appears in the text.
            HashMap<String, Integer> wordFrequencyMap = new HashMap<>();

            // Iterate through the array of words and increment the counter for each word encountered.
            for (String word : words) {
                if (!wordFrequencyMap.containsKey(word)) {
                    wordFrequencyMap.put(word, 1);
                } else {
                    wordFrequencyMap.put(word, wordFrequencyMap.get(word) + 1);
                }
                wordCount++;
            }

            // Display the total count of words to the user.
            System.out.println("The number of words in the text is: " + wordCount);

            // Display the number of unique words in the text.
            int uniqueWordCount = wordFrequencyMap.size();
            System.out.println("The number of unique words in the text is: " + uniqueWordCount);

            // Display the frequency of each word.
            for (String word : wordFrequencyMap.keySet()) {
                System.out.println(word + ": " + wordFrequencyMap.get(word));
            }
        }
    }
}
