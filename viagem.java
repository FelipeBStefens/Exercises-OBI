import java.util.ArrayList;
import java.util.Scanner;

public class viagem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int v = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] allWays = new int[m][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                allWays[i][j] = scanner.nextInt();
            }
        }

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println(allPossibles(allWays, x, y, v, 0, new ArrayList<>()));

        scanner.close();
    }

    public static int allPossibles
        (int[][] matrix, int x, int y, int max, int time, ArrayList<Integer> isVisited) {
        
        if (max < 0) {
            return -1;
        }
        if (x == y) {
            return time;
        }

        isVisited.add(x);
        ArrayList<Integer> count = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            
            if (x == matrix[i][0] && !isVisitedX(matrix[i][1], isVisited)) {

                count.add(allPossibles(matrix, matrix[i][1], y, 
                    max - matrix[i][3], time + matrix[i][2], isVisited));
            }
            else if (x == matrix[i][1] && !isVisitedX(matrix[i][0], isVisited)) {

                count.add(allPossibles(matrix, matrix[i][0], y, 
                    max - matrix[i][3], time + matrix[i][2], isVisited));
            }
        }

        isVisited.remove(isVisited.size() - 1);
        return minCount(count);
    }

    public static boolean isVisitedX(int x, ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            if (x == list.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static int minCount(ArrayList<Integer> count) {

        boolean isAllImpossible = true;
        for (int i = 0; i < count.size(); i++) {
            if (count.get(i) != -1) {
                isAllImpossible = false;
            }
            else {
                count.remove(i);
            }
        }

        if (isAllImpossible) {
            return -1;
        }
        
        int min = count.get(0);
        for (int i = 0; i < count.size(); i++) {
            if (count.get(i) < min) {
                min = count.get(i);
            }
        }

        return min;  
    } 
}