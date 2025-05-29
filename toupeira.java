import java.util.Scanner;

public class toupeira {
    
    public static void main(String[] args) throws Exception{
        Scanner scannerLine = new Scanner(System.in);
        String line1 = scannerLine.nextLine();
        Scanner scanner = new Scanner(line1);
        int s = scanner.nextInt();
        if (s < 2 || s > 1000) {
            
            scanner.close();
            scannerLine.close();
            throw new Exception();
        }
        int t = scanner.nextInt();
        if (t < 1 || t > s * (s - 1) / 2) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }

        int[][] allValueCave = new int[t][2];

        for (int i = 0; i < t; i++) {

            String linei = scannerLine.nextLine();
            scanner = new Scanner(linei);
            int x = scanner.nextInt();
            if (x < 1 || x > s) {

                scanner.close();
                scannerLine.close();
                throw new Exception();
            }
            int y = scanner.nextInt();
            if (y < 1 || y > s || y == x) {

                scanner.close();
                scannerLine.close();
                throw new Exception();
            }
            if (scanner.hasNext()) {

                scanner.close();
                scannerLine.close();
                throw new Exception();
            }
            allValueCave[i][0] = x;
            allValueCave[i][1] = y;
        }

        int p = scannerLine.nextInt();
        if (p < 1 || p > 1000) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }
        int count = 0;
        scannerLine.nextLine();
        for (int i = 0; i < p; i++) {
            String linei = scannerLine.nextLine();
            scanner = new Scanner(linei);

            int n = scanner.nextInt();
            if (n < 1 || n > 1000) {

                scanner.close();
                scannerLine.close();
                throw new Exception();
            }   
            int[] allValues = new int[n];
            for (int j = 0; j < n; j++) {

                int c = scanner.nextInt();
                if (c < 1 || c > s) {

                    scanner.close();
                    scannerLine.close();
                    throw new Exception();
                }
                allValues[j] = c;
            }
            boolean isPossible = false;
            for (int j = 0; j < allValues.length - 1; j++) {

               boolean trying = false;

               for (int k = 0; k < t; k++) {
                    if (allValues[j] == allValueCave[k][0]) {
                        if (allValues[j + 1] == allValueCave[k][1]) {
                            trying = true;
                        }
                    }
                    else if (allValues[j] == allValueCave[k][1]) {
                        if (allValues[j + 1] == allValueCave[k][0]) {
                            trying = true;
                        }
                    }
                }

                if (!trying) {
                     break;
                }
                else if (j == allValues.length - 2) {
                     isPossible  = true;
                }
            }

            if (isPossible) {
                count++;
            }
        }
        System.out.println(count);

        scanner.close();
        scannerLine.close();
    }
}
