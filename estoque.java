import java.util.Scanner;

public class estoque {
    
    public static void main(String[] args) throws Exception{
        Scanner scannerLine = new Scanner(System.in);

        String line1 = scannerLine.nextLine();
        Scanner scanner = new Scanner(line1);
        int m = scanner.nextInt();
        if (m < 1 || m > 500) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }
        int n = scanner.nextInt();
        if (n < 1 || n > 500) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }
        if (scanner.hasNext()) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }

        int[][] allQuantities = new int[m][n];
        for (int i = 0; i < m; i++) {
            String linei = scannerLine.nextLine();
            scanner = new Scanner(linei);
            for (int j = 0; j < n; j++) {

                allQuantities[i][j] = scanner.nextInt();
                if (allQuantities[i][j] < 0 || allQuantities[i][j] > 10) {
                    
                    scanner.close();
                    scannerLine.close();
                    throw new Exception();
                }
            }
            if (scanner.hasNext()) {

                scanner.close();
                scannerLine.close();
                throw new Exception();
            }
        }

        scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        if (p < 1 || p > 1000) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }
        int quantitySells = 0;

        for (int k = 0; k < p; k++) {
            String linek = scannerLine.nextLine();
            scanner = new Scanner(linek);

            int i = scanner.nextInt();
            if (i < 1 || i > m) {

                scanner.close();
                scannerLine.close();
                throw new Exception();
            }
            int j = scanner.nextInt();
            if (j < 1 || j > n) {

                scanner.close();
                scannerLine.close();
                throw new Exception();
            }

            if (allQuantities[i - 1][j - 1] > 0) {
                allQuantities[i - 1][j - 1]--;
                quantitySells++;
            }
        }

        System.out.println(quantitySells);

        scanner.close();
        scannerLine.close();
    }
}
