/*
 * Homework 1 - Class 1
 * Main.java
 * 
 * Created by Juan Felipe Restrepo on 22/01/2025
 */

import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileNotFoundException;

class Main {
    public static void main(String[] args) {
        // Create a new File object to represent the file where the username will be saved
        Path filePath = Path.of("username.txt");
        // Create a new Scanner object to read the input from the console
        Scanner scanner = new Scanner(System.in);
        // Print the inputText to the console
        System.out.print("Please enter your username: ");
        // Read the username from the console
        String username = scanner.nextLine();

        // Save the username in the txt file 
        try {
            // Write the username to the file
            Files.writeString(filePath, username);
            // Print the success message
            System.out.println("Username saved successfully!");
        } catch (FileNotFoundException e) {
            // Print the error message if the file is not found
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (Exception e) {
            // Print the error message if an exception occurs
            System.out.println("An error occurred.");
            e.printStackTrace();
        }      
    }
} 