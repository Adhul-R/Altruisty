import java.util.Scanner;
class FitnessTest {

    public static void main(String[] args) {
        final int TRAINEES = 3;
        final int ROUNDS = 3;
        int[][] oxygenLevels = new int[TRAINEES][ROUNDS];
        Scanner scanner = new Scanner(System.in);

        // Input for oxygen levels
        for (int round = 0; round < ROUNDS; round++) {
            for (int trainee = 0; trainee < TRAINEES; trainee++) {
               
                int value = scanner.nextInt();

                // Validate input
                if (value < 1 || value > 100) {
                    System.out.println("INVALID INPUT");
                    return; // Exit on invalid input
                }

                oxygenLevels[trainee][round] = value;
            }
        }

        double[] averages = new double[TRAINEES];
        double maxAverage = 0;

        // Calculate average oxygen levels
        for (int trainee = 0; trainee < TRAINEES; trainee++) {
            double total = 0;
            for (int round = 0; round < ROUNDS; round++) {
                total += oxygenLevels[trainee][round];
            }
            averages[trainee] = Math.round(total / ROUNDS); // Round the average
            maxAverage = Math.max(maxAverage, averages[trainee]);
        }

        // Check if the maximum average is below 70
        if (maxAverage < 70) {
            System.out.println("All trainees are unfit.");
            return; // Exit if all are unfit
        }

        // Output results
        
        for (int trainee = 0; trainee < TRAINEES; trainee++) {
            if (averages[trainee] == maxAverage) {
                System.out.println("Trainee Number: " + (trainee + 1));
            }
        }

        scanner.close();
    }
}
