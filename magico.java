import java.util.Scanner;

public class magico {
    
    public static void main(String[] args) throws Exception{
        Scanner scannerLine = new Scanner(System.in);

        int n = scannerLine.nextInt();
        if (n < 3 || n > 10) {
            
            scannerLine.close();
            throw new Exception();
        }
        scannerLine.nextLine();
        int[][] magicSquared = new int[n][n];
        for (int i = 0; i < n; i++) {
            String linei = scannerLine.nextLine();
            Scanner scanner = new Scanner(linei);

            for (int j = 0; j < n; j++) {
                
                magicSquared[i][j] = scanner.nextInt();
                if (magicSquared[i][j] < 0 || magicSquared[i][j] > 100) {

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
            scanner.close();
        }

        int[][] indexUnknow = new int[1][2];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (magicSquared[i][j] == 0) {
                    indexUnknow[0][0] = i;
                    indexUnknow[0][1]= j;

                    break;
                }
            }
        }

        int sum = 0;
        if (indexUnknow[0][0] < n - 1) {
            
            for (int i = 0; i < n; i++) {

                sum += magicSquared[indexUnknow[0][0] + 1][i];
            }
        }
        else {

            for (int i = 0; i < n; i++) {

                sum += magicSquared[indexUnknow[0][0] - 1][i];
            }
        }

        int unknowValue = sum;
        for (int i = 0; i < n; i++) {

            unknowValue -= magicSquared[indexUnknow[0][0]][i];
        }

        System.out.println(unknowValue + "\n" + (indexUnknow[0][0] + 1) + "\n" + (indexUnknow[0][1] + 1));
        scannerLine.close();
    }
}
