import java.util.ArrayList;
import java.util.Scanner;

public class troia {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[m][2];
        for (int i = 0; i < m; i++) {
            matrix[i][0] = scanner.nextInt();
            matrix[i][1] = scanner.nextInt();
        }

        ArrayList<ArrayList<Integer>> countList = new ArrayList<>();

        ArrayList<Integer> firstList = new ArrayList<>();
        firstList.add(matrix[0][0]);
        firstList.add(matrix[0][1]);
        countList.add(firstList);

        for (int i = 1; i < m; i++) {

            int countColumnZero = isInList(matrix[i][0], countList);
            int countColumnOne = isInList(matrix[i][1], countList);

            if (countColumnZero != -1) {
                countList.get(countColumnZero).add(matrix[i][1]);
            }
            else if (countColumnOne != -1) {
                countList.get(countColumnOne).add(matrix[i][0]);
            }
            else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(matrix[i][0]);
                newList.add(matrix[i][1]);
                countList.add(newList);
            }
        }

        System.out.println(countList.size() + elseNumbers(n, matrix, new ArrayList<>()));
        scanner.close();
    }

    public static int isInList(int value, ArrayList<ArrayList<Integer>> countList) {

        for (int i = 0; i < countList.size(); i++) {
            for (int j = 0; j < countList.get(i).size(); j++) {
                if (countList.get(i).get(j) == value) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int elseNumbers(int n, int[][] matrix, ArrayList<Integer> list) {
        
        int count = n;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (matrix[i][j] <= n && !isInArray(matrix[i][j], list)) {
                    count--;
                    list.add(matrix[i][j]);
                }
            }
        }
        return count;
    }

    public static boolean isInArray(int value, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value) {
                return true;
            }
        }
        return false;
    }
}