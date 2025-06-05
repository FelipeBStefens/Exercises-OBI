import java.util.ArrayList;
import java.util.Scanner;

public class bingo {
    
    public static void main(String[] args) throws Exception{
        Scanner scannerLine = new Scanner(System.in);
        String line1 = scannerLine.nextLine();

        Scanner scanner = new Scanner(line1);
        int n = scanner.nextInt();
        if (n < 1 || n > 1000) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }

        int k = scanner.nextInt();
        if (k < 1 || k > 1000) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }

        int u = scanner.nextInt();
        if (u < 1 || u > 10000) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }

        if (scanner.hasNext()) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }

        int[][] allTables = new int[n][k];
        boolean[] isCompleted = new boolean[n];
        for (int i = 0; i < n; i++) {
            isCompleted[i] = false;

            String linei = scannerLine.nextLine();
            scanner = new Scanner(linei);

            for (int j = 0; j < k; j++) {

                allTables[i][j] = scanner.nextInt();
                if (allTables[i][j] < 1 || allTables[i][j] > u) {

                    scanner.close();
                    scannerLine.close();
                    throw new Exception();
                } 
            }
        }

        ArrayList<Integer> sequence = new ArrayList<>();
        String lastLine = scannerLine.nextLine();
        scanner = new Scanner(lastLine);

        for (int i = 0; i < u; i++) {

            if (i == 0) {
                int value = scanner.nextInt();

                if (value < 1 || value > u) {
                    
                    scanner.close();
                    scannerLine.close();
                    throw new Exception();
                }
                else {

                    sequence.add(value);
                }
            }
            else {
                int value = scanner.nextInt();

                if (value < 1 || value > u) {
                    
                    scanner.close();
                    scannerLine.close();
                    throw new Exception();
                }

                boolean hasValue = false;
                for (int j = 0; j < sequence.size(); j++) {

                    if (value == sequence.get(j)) {
                        hasValue = true;
                    }
                }

                if (hasValue) {

                    scanner.close();
                    scannerLine.close();
                    throw new Exception();
                }
                else {

                    sequence.add(value);
                }
            }
        }

        for (int i = 0; i < sequence.size(); i++) {

            boolean completed = false;

            for (int j = 0; j < n; j++) {
                for (int v = 0; v < k; v++) {

                    if (allTables[j][v] == sequence.get(i)) {
                        allTables[j][v] = -1;
                    }
                }

                boolean bingo = true;
                for (int v = 0; v < k; v++) {

                    if (allTables[j][v] != -1) {
                        bingo = false;
                    }
                }
                if (bingo) {
                    completed = true;
                    System.out.print(j + 1 + " ");
                }
            }

            if (completed) {
                break;
            }            
        }

        scanner.close();
        scannerLine.close();
    }
}
