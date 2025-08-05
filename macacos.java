import java.util.Scanner;

public class macacos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[][] matrix = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println(minCountMonkey(matrix, 0, 0));
        scanner.close();
    }

    public static int minCountMonkey(int[][] matrix, int i, int count) {

        if (i >= matrix.length - 1) {
            return count;
        }
        
        // Gone wrong
        int maxIndex = 0;
        for (int j = i + 1; j < matrix.length - 1; j++) {

            if (!monkeyCanSee(matrix[i], matrix[j], matrix[j + 1]) 
                && maxIndex < j) {
                
                maxIndex = j;
            } 
        }
        
        if (maxIndex != 0) {
            return minCountMonkey(matrix, maxIndex, count + 1);
        }

        if (i < matrix.length - 1 && monkeyCanSee(matrix[i], matrix[matrix.length - 2], matrix[matrix.length - 1])) {
            
            return minCountMonkey(matrix, matrix.length - 1, count + 1);
        } 
        return minCountMonkey(matrix, matrix.length - 1, count + 2);
        
    }

    public static boolean monkeyCanSee(int[] initialPoint, int[] middlePoint, int[] finalPoint) {

        if (initialPoint[1] == finalPoint[1]) {
            return middlePoint[1] <= initialPoint[1];
        }
        else if (initialPoint[1] > finalPoint[1]) {

            double value = ((double)finalPoint[0] - (double)middlePoint[0]) / ((double)finalPoint[0] - (double)initialPoint[0])
                * ((double)initialPoint[1] - (double)finalPoint[1]);

            return middlePoint[1] <= finalPoint[1] + value;
        }
        else {

            double value = ((double)middlePoint[0] - (double)initialPoint[0]) / ((double)finalPoint[0] - (double)initialPoint[0])
                * ((double)finalPoint[1] - (double)initialPoint[1]);

            return middlePoint[1] <= initialPoint[1] + value;
        }
    }
}