import java.util.Scanner;
import java.util.Random;

public class numberg50
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int min = 1; // Minimum number in the range
        int max = 100; // Maximum number in the range
        int maxAttempts = 5; // Maximum number of attempts allowed
        int rounds = 0; // Number of rounds played
        int totalAttempts = 0; // Total attempts made by the user
        int totalScore = 0; // Total score of the user
        
        boolean playAgain = true;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (playAgain) {
            System.out.println("Round " + (rounds + 1));
            int targetNumber = random.nextInt(max - min + 1) + min; // Generate a random number within the range
            int attempts = 0; // Number of attempts for current round
            boolean found = false; // Flag to indicate if the number is guessed
            
            while (!found && attempts < maxAttempts) {
                System.out.print("Guess the number between " + min + " and " + max + ": ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    found = true;
                    System.out.println("Congratulations! You've guessed the number " + targetNumber + " in " + attempts + " attempts!");
                    totalScore += (maxAttempts - attempts + 1);
                    totalAttempts += attempts;
                }
            }
            
            if (!found) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + targetNumber);
                totalAttempts += maxAttempts;
            }
            
            rounds++;
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        }
        
        System.out.println("Game Over! You played " + rounds + " round(s).");
        System.out.println("Your total score is: " + totalScore);
        System.out.println("Your average number of attempts per round is: " + (double) totalAttempts / rounds);
        
        scanner.close();
    }
}