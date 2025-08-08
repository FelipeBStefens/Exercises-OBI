import java.util.ArrayList;
import java.util.Scanner;

public class mapas {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] array = new int[n - 1][3];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        ArrayList<int[]> points = new ArrayList<>();
        int count = 0;

        for (int i = 1; i < n + 1; i++) { 
            count += countWays(array, i, new ArrayList<>(), false, i, points);     
        }
        System.out.println(count);

        scanner.close();
    }

    public static int countWays(int[][] matrix, int initialValue, 
        ArrayList<Integer> isVisited, boolean isAlreadySeen, 
        int x, ArrayList<int[]> points) {
        
        ArrayList<Integer> newVisited = new ArrayList<>(isVisited);
        newVisited.add(initialValue);
        
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {

            if (matrix[i][0] == initialValue && !itIsVisited(matrix[i][1], newVisited)) {
                
                if (isAlreadySeen) {
                    if (!isThisPoint(points, x, matrix[i][1])) {
                        int[] point = {x, matrix[i][1]};
                        points.add(point);
                        count += 1 + countWays(matrix, matrix[i][1], newVisited, isAlreadySeen, x, points);
                    }
                    else {
                        count += countWays(matrix, matrix[i][1], newVisited, isAlreadySeen, x, points);
                    }
                }
                else if (matrix[i][2] == 1) {
                    if (!isThisPoint(points, x, matrix[i][1])) {
                        int[] point = {x, matrix[i][1]};
                        points.add(point);
                        count += 1 + countWays(matrix, matrix[i][1], newVisited, !isAlreadySeen, x, points);
                    }
                    else {
                        count += countWays(matrix, matrix[i][1], newVisited, !isAlreadySeen, x, points);
                    }
                }
                else {
                    count += countWays(matrix, matrix[i][1], newVisited, isAlreadySeen, x, points);
                }
            }
            else if (matrix[i][1] == initialValue && !itIsVisited(matrix[i][0], newVisited)) {
                
                if (isAlreadySeen) {
                    if (!isThisPoint(points, x, matrix[i][0])) {
                        int[] point = {x, matrix[i][0]};
                        points.add(point);
                        count += 1 + countWays(matrix, matrix[i][0], newVisited, isAlreadySeen, x, points);
                    }
                    else {
                        count += countWays(matrix, matrix[i][0], newVisited, isAlreadySeen, x, points);
                    }
                }
                else if (matrix[i][2] == 1) {
                    if (!isThisPoint(points, x, matrix[i][0])) {
                        int[] point = {x, matrix[i][0]};
                        points.add(point);
                        count += 1 + countWays(matrix, matrix[i][0], newVisited, !isAlreadySeen, x, points);
                    }
                    else {
                        count += countWays(matrix, matrix[i][0], newVisited, !isAlreadySeen, x, points);
                    }
                }
                else {
                    count += countWays(matrix, matrix[i][0], newVisited, isAlreadySeen, x, points);
                }
            }
        }

        if (count == 0) {
            return 0;
        }
        else {
            return count;
        }
    } 

    public static boolean itIsVisited(int value, ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value) {
                return true;
            }
        }

        return false;
    }

    public static boolean isThisPoint(ArrayList<int[]> list, int x, int y) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] == x && list.get(i)[1] == y) {
                return true;
            }
            else if (list.get(i)[0] == y && list.get(i)[1] == x) {
                return true;
            }
        }

        return false;
    }
}