import java.util.Arrays;
import java.util.Scanner;

public class concurso {
    
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
        int k = scanner.nextInt();
        if (k < 1 || k > 500 || k > n) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }
        else if (scanner.hasNext()) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }

        int[] grades = new int[n];
        String line2 = scannerLine.nextLine();
        scanner = new Scanner(line2);

        for (int i = 0; i < grades.length; i++) {

            grades[i] = scanner.nextInt();
            if (grades[i] < 1 || grades[i] > 100) {

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
        Arrays.sort(grades);
        
        System.out.println(grades[n - k]);
        scannerLine.close();
    }
}
