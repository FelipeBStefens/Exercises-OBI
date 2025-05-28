import java.util.Scanner;

public class subsequencia {

    public static void main(String[] args) throws Exception{
        Scanner scannerLine = new Scanner(System.in);
        
        String line1 = scannerLine.nextLine();
        Scanner scanner = new Scanner(line1);

        int a = scanner.nextInt();
        if (a < 1 || a > Math.pow(10, 5)) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }
        int b = scanner.nextInt();
        if (b < 1 || b > Math.pow(10, 5)) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }
        if (scanner.hasNext()) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }

        String line2 = scannerLine.nextLine();
        scanner = new Scanner(line2);
        int[] sequence = new int[a];

        for (int i = 0; i < a; i++) {

            int x = scanner.nextInt();
            if (x < Math.pow(-10, 9) || x > Math.pow(10, 9)) {

                scanner.close();
                scannerLine.close();
                throw new Exception();
            }
            sequence[i] = x;
        }
        if (scanner.hasNext()) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }

        String line3 = scannerLine.nextLine();
        scanner = new Scanner(line3);
        int[] subsequence = new int[b];

        for (int i = 0; i < b; i++) {

            int x = scanner.nextInt();
            if (x < Math.pow(-10, 9) || x > Math.pow(10, 9)) {

                scanner.close();
                scannerLine.close();
                throw new Exception();
            }
            subsequence[i] = x;
        }
        if (scanner.hasNext()) {

            scanner.close();
            scannerLine.close();
            throw new Exception();
        }

        if (verifySubsequence(sequence, subsequence)) {
            System.out.println("S");
        }
        else {
            System.out.println("N");
        }

        scanner.close();
        scannerLine.close();
    }

    public static boolean verifySubsequence(int[] array, int[] subArray) {

        for (int j = 0; j < array.length; j++) {

            if (subArray[0] == array[j]) {

                if (subArray.length - 1 == 0) {
                    return true;
                }
                else {
                    int[] newSubArray = new int[subArray.length - 1]; 
                    int[] newArray = new int[array.length - 1 - j]; 

                    for (int k = 0; k < newSubArray.length; k++) { 
                        newSubArray[k] = subArray[k + 1];
                    }
                    for (int k = 0; k < newArray.length; k++) { 
                        newArray[k] = array[k + 1 + j];
                    }

                    return verifySubsequence(newArray, newSubArray);
                }
            }
        }
        return false;
    }
}
