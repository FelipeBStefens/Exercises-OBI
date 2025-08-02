import java.util.Scanner;

public class xerxes {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();

        int[][] matrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[][] winMatrix = {
            {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0},
            {0, 2}, {1, 3}, {2, 4}, {3, 0}, {4, 1}};

        int countDario = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < winMatrix.length; j++) {

                if (matrix[i][0] == winMatrix[j][0] && 
                    matrix[i][1] == winMatrix[j][1]) {
                    
                    countDario++;
                }
            }
        }

        if (countDario < n - countDario) {
            System.out.println("xerxes");
        }
        else {
            System.out.println("dario");
        }
        
        scanner.close();
    }
}
