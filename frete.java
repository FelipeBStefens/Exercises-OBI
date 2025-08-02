import java.util.ArrayList;
import java.util.Scanner;

public class frete {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] ways = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                ways[i][j] = scanner.nextInt();
            }
        }

        System.out.println(lessPrice(ways, 1, n, new ArrayList<>()));

        scanner.close();
    }

    private static int lessPrice(int[][] matrix, int initial, int finall, 
        ArrayList<Integer> isVisited) {
        
        if (initial == finall) {
            return 0;
        } 

        isVisited.add(initial);
        ArrayList<Integer> newVisited = new ArrayList<>(isVisited);
        
        ArrayList<Integer> count = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {

            if (initial == matrix[i][0] && !itsVisited(matrix[i][1], newVisited)) {

                int next = lessPrice(matrix, matrix[i][1], finall, newVisited);
                if (next != -1) {
                    count.add(matrix[i][2] + next);
                }
            }
            else if (initial == matrix[i][1] && !itsVisited(matrix[i][0], newVisited)) {

                int next = lessPrice(matrix, matrix[i][0], finall, newVisited);
                if (next != -1) {
                    count.add(matrix[i][2] + next);
                }
            }
        }

        return minCount(count);
    }

    private static int minCount(ArrayList<Integer> count) {

        if (count.isEmpty()) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < count.size(); i++) {
            if (min > count.get(i)) {
                min = count.get(i);
            }
        }

        return min;
    }

    public static boolean itsVisited(int value, ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            if (value == list.get(i)) {
                return true;
            }
        }
        return false;
    }
}
