import java.util.Scanner;

public class chocolate {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] pointOne = new int[2];
        for (int i = 0; i < 2; i++) {
            pointOne[i] = scanner.nextInt();
        }

        int[] pointTwo = new int[2];
        for (int i = 0; i < 2; i++) {
            pointTwo[i] = scanner.nextInt();
        }

        int[][] matrixLine = new int[n / 2][n];
        if ((isInMatrix(matrixLine, pointOne) && !isInMatrix(matrixLine, pointTwo)) ||
            (isInMatrix(matrixLine, pointTwo) && !isInMatrix(matrixLine, pointOne))) {

            System.out.println("S");
            scanner.close();
            return;
        }

        int[][] matrixColumn = new int[n][n / 2];
        if ((isInMatrix(matrixColumn, pointOne) && !isInMatrix(matrixColumn, pointTwo)) ||
            (isInMatrix(matrixColumn, pointTwo) && !isInMatrix(matrixColumn, pointOne))) {

            System.out.println("S");
            scanner.close();
            return;
        }

        System.out.println("N");
        scanner.close();
    }

    public static boolean isInMatrix(int[][] matrix, int[] point) {

        if (matrix.length > point[0] && matrix[0].length > point[1]) {
            return true;
        }
        return false;
    }
}
