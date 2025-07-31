import java.util.ArrayList;
import java.util.Scanner;

public class formiga {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int p = scanner.nextInt();

        int[] hight = new int[s];
        for (int i = 0; i < s; i++) {
            hight[i] = scanner.nextInt();
        }

        int[][] tArray = new int[t][2];
        for (int i = 0; i < tArray.length; i++) {
            for (int j = 0; j < tArray[0].length; j++) {
                tArray[i][j] = scanner.nextInt();
            }
        }

        System.out.println(countWays(tArray, hight, p));
        scanner.close();
    }

    public static int countWays(int[][] matrix, int[] hight, int p) {

        ArrayList<Integer> count = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {

            if (matrix[i][0] == p && isBigger(p, matrix[i][1], hight)) {

                count.add(1 + countWays(matrix, hight, matrix[i][1])); 
            }
            else if (matrix[i][1] == p && isBigger(p, matrix[i][0], hight)) {
                count.add(1 + countWays(matrix, hight, matrix[i][0])); 
            }
        }

        if (count.isEmpty()) {
            return 0;
        }
        return max(count);
    }

    public static boolean isBigger(int p, int s, int[] hight) {

        return hight[p - 1] > hight[s - 1];
    }

    public static int max(ArrayList<Integer> list) {

        int max = list.get(0);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
}
