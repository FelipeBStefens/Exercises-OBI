import java.util.Arrays;
import java.util.Scanner;

public class pokemon {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        int[] array = new int[3];
        array[0] = x;
        array[1] = y;
        array[2] = z;
        Arrays.sort(array);

        int count = 0;
        for (int i = 0; i < 3; i++) {

            if (array[i] <= n) {
                n -= array[i];
                count++;
            }
            else {
                break;
            }
        }

        System.out.println(count);
        scanner.close();
    }
}
