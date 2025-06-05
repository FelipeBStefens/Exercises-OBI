import java.util.Scanner;

public class fissura {

    public static void main(String[] args) throws Exception{
        Scanner scannerLine = new Scanner(System.in);

        String line1 = scannerLine.nextLine();
        Scanner scanner = new Scanner(line1);

        
        int n = scanner.nextInt();
        if (n < 1 || n > 500) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }

        int f = scanner.nextInt();
        if (f < 0 || f > 9) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }

        int[][] matrixMap = new int[n][n];
        boolean[][] haveLava = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String linei = scannerLine.nextLine();
            char[] allNumbersChar = linei.toCharArray();

            for (int j = 0; j < allNumbersChar.length; j++) {
                
                matrixMap[i][j] = Integer.parseInt(Character.toString(allNumbersChar[j]));
                if (matrixMap[i][j] < 0 || matrixMap[i][j] > 9) {

                    scanner.close();
                    scannerLine.close();
                    throw new Exception();
                }
                haveLava[i][j] = false;
            }
        }
        matrixMap[0][0] = -1;
 
        boolean changed;
        do {
            changed = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (matrixMap[i][j] == -1) {
                        // cima
                        if (i - 1 >= 0 && matrixMap[i - 1][j] != -1 && f >= matrixMap[i - 1][j]) {
                            matrixMap[i - 1][j] = -1;
                            changed = true;
                        }

                        // baixo
                        if (i + 1 < n && matrixMap[i + 1][j] != -1 && f >= matrixMap[i + 1][j]) {
                            matrixMap[i + 1][j] = -1;
                            changed = true;
                        }

                        // esquerda
                        if (j - 1 >= 0 && matrixMap[i][j - 1] != -1 && f >= matrixMap[i][j - 1]) {
                            matrixMap[i][j - 1] = -1;
                            changed = true;
                        }

                        // direita
                        if (j + 1 < n && matrixMap[i][j + 1] != -1 && f >= matrixMap[i][j + 1]) {
                            matrixMap[i][j + 1] = -1;
                            changed = true;
                        }
                    }
                }
            }
        } while (changed);

        System.out.println("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (matrixMap[i][j] != -1) {
                    System.out.print(matrixMap[i][j]);
                }
                else {
                    System.out.print('*');
                }
            }
            System.out.println();
        }

        scanner.close();
        scannerLine.close();
    }
}
