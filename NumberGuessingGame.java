import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            int totalScore = 0;
            int roundsPlayed = 0;
            
            while (true) {
                int number = random.nextInt(100) + 1;
                int attempts = 0;
                int max = 5;
                
                System.out.println("Welcome to the Number Guessing Game!");
                System.out.println("You have " + max + " attempts to guess it.");
                
                while (attempts < max) {
                    System.out.print("Enter your guess: ");
                    int guess = scanner.nextInt();
                    attempts++;
                    
                    if (guess < number) {
                        System.out.println("Guess Higher! Try again.");
                    } else if (guess > number) {
                        System.out.println("Guess Lower! Try again.");
                    } else {
                        System.out.println("Congratulations! You've guessed the number " + number);
                        totalScore++; 
                        break;
                    }
                }
                
                if (attempts == max) {
                    System.out.println("Sorry, you've used all your attempts. The number was " + number + ".");
                }
                
                roundsPlayed++;
                
                
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next().trim().toLowerCase();
                if (!playAgain.equals("yes")) {
                    break;
                }
            }
            
            System.out.println("Thanks for playing! You played " + roundsPlayed + " rounds and scored " + totalScore + " points.");
        }
    }
}
