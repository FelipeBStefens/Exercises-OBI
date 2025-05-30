import java.util.Scanner;

public class maior {
    
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        if (n < 1 || n > 10000) {

            scanner.close();
            throw new Exception();
        }

        int m = scanner.nextInt();
        if (m < 1 || m > 10000 || m <= n) {

            scanner.close();
            throw new Exception();
        }
        
        int s = scanner.nextInt();
        if (s < 1 || s > 36) {

            scanner.close();
            throw new Exception();
        }

        int number = -1;
        for (int i = n; i <= m; i++) {

            if (sumDigits(i) == s) {
                number = i;
            }
        }

        System.out.println(number);
        scanner.close();
    }

    public static int sumDigits(int number) {
        char[] allDigitsChar = Integer.toString(number).toCharArray();
        int sum = 0;

        for (int i = 0; i < allDigitsChar.length; i++) {
            sum += Integer.parseInt(Character.toString(allDigitsChar[i]));
        }

        return sum;
    }
}
