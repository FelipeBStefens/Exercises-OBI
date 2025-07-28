import java.util.Scanner;

public class piramide {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] p = new int[n][n];

        for (int camada = 0; camada < n / 2; camada++) {
            int valor = camada + 1;

            for (int i = camada; i < n - camada; i++) {
                p[camada][i] = valor;               
                p[n - camada - 1][i] = valor;       
                p[i][camada] = valor;               
                p[i][n - camada - 1] = valor;       
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(p[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
