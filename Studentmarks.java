import java.util.Scanner;

public class Studentmarks{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Simple hardcoded credentials
        String correctUsername = "admin";
        String correctPassword = "pas123";

        // Authentication loop
        boolean authenticated = false;
        for (int attempts = 0; attempts < 3; attempts++) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                authenticated = true;
                break;
            } else {
                System.out.println("Invalid credentials. Try again.");
            }
        }

        if (!authenticated) {
            System.out.println("Too many failed attempts. Exiting program.");
            sc.close();
            return;
        }

        // User authenticated - continue with marks analysis
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        String[] names = new String[n];
        int[][] marks = new int[n][];
        double[] averages = new double[n];

        for (int i = 0; i < n; i++) {
            sc.nextLine(); // consume newline
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            names[i] = sc.nextLine();
            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();
            marks[i] = new int[subjects];
            int sum = 0;
            for (int j = 0; j < subjects; j++) {
                System.out.print("Enter mark for subject " + (j + 1) + ": ");
                marks[i][j] = sc.nextInt();
                sum += marks[i][j];
            }
            averages[i] = (double) sum / subjects;
        }

        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Name: " + names[i]);
            System.out.print("Marks: ");
            for (int m : marks[i]) {
                System.out.print(m + " ");
            }
            System.out.printf("\nAverage: %.2f\n", averages[i]);
            System.out.println();
        }
        sc.close();
    }
}
