import java.util.Scanner;

public class papel {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] sequenceRect = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            sequenceRect[i] = scanner.nextInt();

            if (sequenceRect[i] > max) {
                max = sequenceRect[i];
            }
        }

        int maxCount = 0;
        for (int i = 1; i < max - 1; i++) {

            int[] especificSequence = fillSequence(sequenceRect);
            int[][] matrix = new int[max + 1][n];

            for (int w = 0; w < max + 1; w++) {
                for (int j = 0; j < n; j++) {

                    if (w == i || especificSequence[j] == 0) {
                        matrix[w][j] = 0;
                    }
                    else if (especificSequence[j] > 0) {
                        matrix[w][j] = 1;
                        especificSequence[j]--;
                    }
                }
            }

            int actualCount = 0;
            for (int w = 0; w < max + 1; w++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[w][j] != 0) {
                        actualCount += countPapers(matrix, w, j);
                    }
                }
            }

            if (actualCount > maxCount) {
                maxCount = actualCount;
            }
        }

        System.out.println(maxCount);
        scanner.close();
    }

    private static int[] fillSequence(int[] sequenceRect) {
        
        int[] newSequence = new int[sequenceRect.length];
        for (int i = 0; i < newSequence.length; i++) {
            newSequence[i] = sequenceRect[i];
        }

        return newSequence;
    }

    public static int countPapers(int[][] matrix, int i, int j) {

        if (matrix[i][j] == 0) {
            return 0;
        }

        matrix[i][j] = 0;
        if (i > 0) {
            countPapers(matrix, i - 1, j);
        }
        if (i < matrix.length - 1) {
            countPapers(matrix, i + 1, j);
        }
        if (j > 0) {
            countPapers(matrix, i, j - 1);
        }
        if (j < matrix[0].length - 1) {
            countPapers(matrix, i, j + 1);
        }

        return 1;
    }
}
