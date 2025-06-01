import java.util.Scanner;

public class chuva {
    
    public static void main(String[] args) throws Exception{
        Scanner scannerLine = new Scanner(System.in);

        int n = scannerLine.nextInt();
        if (n < 1 || n > 100000) {

            scannerLine.close();
            throw new Exception();
        }

        int s = scannerLine.nextInt();
        if (s < 0 || s > 1000000) {

            scannerLine.close();
            throw new Exception();
        }

        scannerLine.nextLine();
        int[] sequence = new int[n];

        String line = scannerLine.nextLine();
        Scanner scanner = new Scanner(line); 
        for (int i = 0; i < n; i++) {

            sequence[i] = scanner.nextInt();
            if (sequence[i] < 0 || sequence[i] > 10) {

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

        int count = 0;
        for (int i = 1; i <= sequence.length; i++) {
            for (int j = 0; j <= sequence.length - i; j++) {
                int[] array = new int[i]; 
                for (int k = 0; k < i; k++) {
                    array[k] = sequence[j + k];
                }

                int sum = 0;
                for (int k = 0; k < array.length; k++) {
                    sum += array[k];
                }
                if (sum == s) {
                    count++;
                }
            }
        }

        System.out.println(count);
        scannerLine.close();
    }
}
