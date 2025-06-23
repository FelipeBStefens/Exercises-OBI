import java.util.Scanner;

public class poder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] powerMatrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                powerMatrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(maxValueInPosition(i, j, powerMatrix) + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    public static int maxValueInPosition(int line, int column, int[][] matrix) {
        int sum = matrix[line][column];
        
        if (line - 1 >= 0 && matrix[line][column] >= matrix[line - 1][column]) {

            sum += matrix[line - 1][column];
            maxValueInPosition(line - 1, column, matrix);
        }
        if (line + 1 < matrix.length && matrix[line][column] > matrix[line + 1][column]) {

            sum += matrix[line + 1][column];
            maxValueInPosition(line + 1, column, matrix);
        }
        if (column - 1 >= 0 && matrix[line][column] > matrix[line][column - 1]) {

            sum += matrix[line][column - 1];
            maxValueInPosition(line, column - 1, matrix);
        }
        if (column + 1 < matrix[0].length && matrix[line][column] > matrix[line][column + 1]) {

            sum += matrix[line][column + 1];
            maxValueInPosition(line, column + 1, matrix);
        }

        return sum;
    } 
}