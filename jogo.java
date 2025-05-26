import java.util.Scanner;

public class jogo {
    
    public static void main(String[] args) throws Exception{
        Scanner scannerLine = new Scanner(System.in);
        String line1 = scannerLine.nextLine();

        Scanner scanner = new Scanner(line1);
        int n = scanner.nextInt();
        if (n < 1 || n > 50) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }
        int q = scanner.nextInt();
        if (q < 1 || q > 100) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }

        int[][] allNumbers = new int[n][n];
        for (int i = 0; i < n; i++) {

            String linei = scannerLine.next();
            char[] allElements = linei.toCharArray();
            for (int j = 0; j < n; j++) {

                if (allElements[j] != '0' && allElements[j] != '1') {

                    scanner.close();
                    scannerLine.close();
                    throw new Exception();
                }
                else {

                    int element = Integer.parseInt(Character.toString(allElements[j]));
                    allNumbers[i][j] = element;
                }
            }
        }

        System.out.println();
        boolean[][] altering = new boolean[n][n];

        for (int i = 0; i < q; i++) {

            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    int countAlive = 0;

                    if (k - 1 >= 0) {
                        if (allNumbers[k - 1][j] == 1) {
                            countAlive++;
                        } 

                        if (j - 1 >= 0) {
                            if (allNumbers[k - 1][j - 1] == 1) {
                                countAlive++;
                            } 
                        }

                        if (j + 1 < n) {
                            if (allNumbers[k - 1][j + 1] == 1) {
                                countAlive++;
                            } 
                        }
                    }
                    if (k + 1 < n) {
                        if (allNumbers[k + 1][j] == 1) {
                            countAlive++;
                        } 

                        if (j - 1 >= 0) {
                            if (allNumbers[k + 1][j - 1] == 1) {
                                countAlive++;
                            } 
                        }

                        if (j + 1 < n) {
                            if (allNumbers[k + 1][j + 1] == 1) {
                                countAlive++;
                            } 
                        }
                    }
                    if (j - 1 >= 0) {
                        if (allNumbers[k][j - 1] == 1) {
                            countAlive++;
                        } 
                    }

                    if (j + 1 < n) {
                        if (allNumbers[k][j + 1] == 1) {
                            countAlive++;
                        } 
                    }

                    if (allNumbers[k][j] == 0 && countAlive == 3) {
                        altering[k][j] = true;
                    }
                    else if (allNumbers[k][j] == 1 && countAlive != 3 && countAlive != 2) {
                        altering[k][j] = true;
                    }
                    else {
                        altering[k][j] = false;
                    }
                }
            }
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {

                    if (altering[k][j]) {
                        if (allNumbers[k][j] == 0) {
                            allNumbers[k][j] = 1;
                        }
                        else {
                            allNumbers[k][j] = 0;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(allNumbers[i][j]);
            }
            System.out.println();
        }

        scanner.close();
        scannerLine.close();
    }
}