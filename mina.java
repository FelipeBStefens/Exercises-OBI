import java.util.ArrayList;
import java.util.Scanner;

public class mina {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println(countRocks(matrix, 0, 0, 0));
        scanner.close();
    }

    public static int countRocks(int[][] matrix, int i, int j, int count) {

        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return count;
        }

        int oldValue = matrix[i][j];
        matrix[i][j] = -1;

        ArrayList<Integer> min = new ArrayList<>();

        if (i > 0 && matrix[i - 1][j] != -1) {
            if (matrix[i - 1][j] == 1) {
                int value = countRocks(matrix, i - 1, j, count + 1);
                if (value != Integer.MAX_VALUE) {
                    min.add(value);
                }
            }
            else {
               int value = countRocks(matrix, i - 1, j, count);
                if (value != Integer.MAX_VALUE) {
                    min.add(value);
                }
            }
        }
        if (i < matrix.length - 1 && matrix[i + 1][j] != -1) {
            if (matrix[i + 1][j] == 1) {
                int value = countRocks(matrix, i + 1, j, count + 1);
                if (value != Integer.MAX_VALUE) {
                    min.add(value);
                }
            }
            else {
                int value = countRocks(matrix, i + 1, j, count);
                if (value != Integer.MAX_VALUE) {
                    min.add(value);
                } 
            }
        }
        if (j > 0 && matrix[i][j - 1] != -1) {
            if (matrix[i][j - 1] == 1) {
                int value = countRocks(matrix, i, j - 1, count + 1);
                if (value != Integer.MAX_VALUE) {
                    min.add(value);
                }
            }
            else {
               int value = countRocks(matrix, i, j - 1, count);
                if (value != Integer.MAX_VALUE) {
                    min.add(value);
                } 
            }
        }
        if (j < matrix[0].length - 1 && matrix[i][j + 1] != -1) {
            if (matrix[i][j + 1] == 1) {
                int value = countRocks(matrix, i, j + 1, count + 1);
                if (value != Integer.MAX_VALUE) {
                    min.add(value);
                }
            }
            else {
                int value = countRocks(matrix, i, j + 1, count);
                if (value != Integer.MAX_VALUE) {
                    min.add(value);
                }
            }
        }

        matrix[i][j] = oldValue;
        return minCount(min);
    }

    public static int minCount(ArrayList<Integer> list) {

        if (list.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (min > list.get(i)) {
                min = list.get(i);
            }
        }

        return min;
    }
}