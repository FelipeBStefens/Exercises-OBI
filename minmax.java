import java.util.ArrayList;
import java.util.Scanner;

public class minmax {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int s = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = a; i < b + 1; i++) {
            
            if (sumDigits(i) == s) {
                list.add(i);
            }
        }

        int min = list.get(0);
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) < min) {
                min = list.get(i);
            }
            else if(list.get(i) > max) {
                max = list.get(i);
            }
        }

        System.out.println(min);
        System.out.println(max);

        scanner.close();
    }

    public static int sumDigits(int digit) {

        if (digit < 10) {
            return digit;
        }

        return (digit % 10) + sumDigits(digit / 10);
    }
}
