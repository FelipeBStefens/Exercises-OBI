import java.util.Scanner;

public class blefe {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        for (int i = 0; i < b.length; i++) {
            if (!isInArray(b[i], a) && !valueIsSum(b[i], b)) {
                System.out.println(b[i]);
                return;
            }
        }
        System.out.println("sim");

        scanner.close();
    }

    public static boolean isInArray(int value, int[] a) {

        for (int i = 0; i < a.length; i++){
            if (a[i] == value) {
                return true;
            }
        }

        return false;
    }

    public static boolean valueIsSum(int value, int[] b) {

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {

                if (value == b[i] + b[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
