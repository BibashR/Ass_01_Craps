import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Starting a new game.");
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.printf("You rolled: %d + %d = %d\n", die1, die2, sum);

            // checking initial roll
            if (sum == 2 || sum == 3 || sum ==12) {
                System.out.println("Craps, You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural, you win.");
            } else {
                // sum = point
                int point = sum;
                System.out.println("Your point is: " + point);
                System.out.println("Rolling until the point or a 7.");

                while (true) {
                    die1 = random.nextInt(6) + 1;
                    die2 = random.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.printf("You rolled: %d + %d = %d\n", die1, die2, sum);

                    if (sum == point) {
                        System.out.println("You made your point. YOU WIN!");
                        break;
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7, you lose.");
                        break;
                    } else {
                        System.out.println("Rolling for point...");
                    }
                }
            }

            // play again
            System.out.print("Do you want to play again? (Y/N): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("y");
        }
        System.out.println("Thanks for playing.");
        scanner.close();
    }
}