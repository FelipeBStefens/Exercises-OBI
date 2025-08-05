import java.util.Scanner;

public class jardim {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[7][2];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        if (distance(matrix[0], matrix[1]) != distance(matrix[0], matrix[2])) {
            System.out.println("N");
            scanner.close();
            return;
        }
        if (distance(matrix[3], matrix[5]) != distance(matrix[4], matrix[6])) {
            System.out.println("N");
            scanner.close();
            return;
        }
        if (distance(matrix[1], matrix[2]) < distance(matrix[3], matrix[4])) {
            System.out.println("N");
            scanner.close();
            return;
        }
        if (!verify(matrix[0], matrix[1], matrix[2])) {
            System.out.println("N");
            scanner.close();
            return;
        }
        if ((matrix[3][0] + matrix[4][0]) / 2 != (matrix[1][0] + matrix[2][0]) / 2
            || (matrix[3][1] + matrix[4][1]) / 2 != (matrix[1][1] + matrix[2][1]) / 2) {
            
            System.out.println("N");
            scanner.close();
            return;
        }

        
        System.out.println("S");
        scanner.close();
    }

    public static double distance(int[] pointOne, int[] pointTwo) {

        return Math.sqrt(
            Math.pow(((double)pointOne[0] + (double)pointTwo[0]), 2) + 
            Math.pow(((double)pointOne[1] + (double)pointTwo[1]), 2));
    }

    public static boolean verify(int[] pointOne, int[] pointTwo, int[] pointThree) {

        double value1 = Math.pow(distance(pointOne, pointTwo), 2) + 
            Math.pow(distance(pointOne, pointThree), 2) - 
            Math.pow(distance(pointThree, pointTwo), 2);
        
        double value2 = 2 * distance(pointOne, pointTwo) * distance(pointOne, pointThree);
        
        return value1 / value2 > 0;
    }
}
