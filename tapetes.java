import java.util.Scanner;

public class tapetes {
    
    public static int[][] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int l = scanner.nextInt();
        int n = scanner.nextInt();

        memo = new int[l + 1][n + 1];
        for (int i = 0; i < l + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                memo[i][j] = -1;
            }
        }

        System.out.println(maxCarpet(l, n));

        scanner.close();
    }

    public static int maxCarpet(int l, int n) {
        
        if (memo[l][n] != -1) {
            return memo[l][n];
        }
        if (n == 1) {
            return l * l;
        }

        int max = -1; 
        for (int i = 1; i <= l - n + 1; i++) {

            int value = (i * i) + maxCarpet(l - i, n - 1);
            if (value > max) {
                max = value;
            }
        }

        memo[l][n] = max;
        return memo[l][n];
    }
}