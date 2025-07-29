import java.util.Scanner;

public class tenis {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        int[] array = new int[3];

        if ((a + b) - (c + d) >= 0) {
            array[0] = (a + b) - (c + d);
        }
        else {
            array[0] = (c + d) - (a + b);
        }
        
        if ((a + c) - (b + d) >= 0) {
            array[1] = (a + c) - (b + d);
        }
        else {
            array[1] = (b + d) - (a + c);
        }
        
        if ((a + d) - (c + b) >= 0) {
            array[2] = (a + d) - (c + b);
        }
        else {
            array[2] = (c + b) - (a + d);
        }

        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println(min);
        
        scanner.close();
    }
}
