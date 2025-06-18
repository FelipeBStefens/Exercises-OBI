import java.util.Scanner;

public class chuva {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            
            if (i - 1 >= 0) {
                for (int j = 0; j < m; j++) {

                    if (matrix[i][j] == '.' && matrix[i - 1][j] == 'o') {
                        matrix[i][j] = 'o';
                    }
                }
            }
            if (i + 1 < n) {
                for (int j = m - 1; j >= 0; j--) {
                    if (j + 1 < m) {
                        if (matrix[i][j] == '.' && matrix[i][j + 1] == 'o' && matrix[i + 1][j + 1] == '#') {
                            matrix[i][j] = 'o';
                        }
                    }
                }

                for (int j = 0; j < m; j++) {
                    if (j - 1 > 0) {
                        if (matrix[i][j] == '.' && matrix[i][j - 1] == 'o' && matrix[i + 1][j - 1] == '#') {
                            matrix[i][j] = 'o';
                        }
                    }
                }
            }
            
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}
