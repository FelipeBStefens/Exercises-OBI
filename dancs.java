import java.util.Scanner;

public class dancs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = (j + 1) + (m * i);
            }
        }

        for (int i = 0; i < p; i++) {
            String movement = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (movement.equals("L")) {
                int[] line1 = matrix[a - 1];
                int[] line2 = matrix[b - 1];
                
                matrix[a - 1] = line2;
                matrix[b - 1] = line1;
            }
            else {
                
                for (int j = 0; j < n; j++) {

                    int column1Value = matrix[j][a - 1];
                    int column2Value = matrix[j][b - 1];

                    matrix[j][a - 1] = column2Value;
                    matrix[j][b - 1] = column1Value;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}