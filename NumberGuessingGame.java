import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private int randomNumber;

    public NumberGuessingGame(int min, int max) {
        Random random = new Random();
        this.randomNumber = random.nextInt(max - min + 1) + min;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int maxAttempts = 10; // or any other number
        boolean isCorrect = false;

        System.out.println("Guess the number between 1 and 100:");

        while (attempts < maxAttempts && !isCorrect) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;
            isCorrect = checkGuess(guess);
        }

        if (isCorrect) {
            System.out.println("Congratulations! You guessed the right number.");
        } else {
            System.out.println("Game over! The number was: " + randomNumber);
        }
        scanner.close();
    }

    private boolean checkGuess(int guess) {
        if (guess == randomNumber) {
            return true;
        } else if (guess < randomNumber) {
            System.out.println("Too low!");
        } else {
            System.out.println("Too high!");
        }
        return false;
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame(1, 100);
        game.startGame();
    }
}
