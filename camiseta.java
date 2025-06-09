import java.util.Scanner;

public class camiseta {
    
    public static void main(String[] args) throws Exception{
        Scanner scannerLine = new Scanner(System.in);

        int n = scannerLine.nextInt();
        scannerLine.nextLine();
        if (n < 1 || n > 1000) {

            scannerLine.close();
            throw new Exception();
        }

        int totalMedium = 0;
        int totalSmall = 0;

        String line = scannerLine.nextLine();
        Scanner scanner = new Scanner(line);
        for (int i = 0; i < n; i++) {
             int value = scanner.nextInt();

             if (value == 1) {
                totalSmall++;
             }
             else if (value == 2) {
                totalMedium++;
             }
             else {

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

        int p = scannerLine.nextInt();
        if (p < 1 || p > 1000) {

            scannerLine.close();
            throw new Exception();
        }
        int m = scannerLine.nextInt();
        if (m < 1 || m > 1000) {

            scannerLine.close();
            throw new Exception();
        }

        if (m - totalMedium == 0 && p - totalSmall == 0) {
            System.out.println("S");
        }
        else {
            System.out.println("N");
        }
        
        scannerLine.close();
    }
}
