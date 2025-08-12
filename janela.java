import java.util.Scanner;

public class janela {

    public static int totalArea = 60000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        totalArea -= 20000;
        if (b >= a && b <= a + 200) {
            totalArea -= (b - a) * 100;

            if (c >= a && b >= c) {
                totalArea -= (c - b) * 100;
            }
            else if (c + 200 >= a && c <= b) {
                totalArea -= (a - c) * 100;
            }
            else {
                totalArea -= 20000;
            }
        }
        else if (b + 200 >= a && b <= a) {
            totalArea -= (a - b) * 100;

            if (c >= b && a >= c) {
                totalArea -= (c - a) * 100;
            }
            else if (c + 200 >= b && c <= a) {
                totalArea -= (b - c) * 100;
            }
            else {
                totalArea -= 20000;
            }
        }
        else {
            totalArea -= 20000;

            if ((c > a && c < a + 200) && (c + 200 > b && c < b)) {
                totalArea -= (b - a - 200) * 100;
            }
            else if ((c > b && c < b + 200) && (c + 200 > a && c < a)) {
                totalArea -= (a - b - 200) * 100;
            }
            else if (c >= a && c >= a + 200) {
                totalArea -= (c - a) * 100;
            }
            else if (c + 200 >= a && c <= a) {
                totalArea -= (a - c) * 100;
            }
            else if (c >= b && c >= b + 200) {
                totalArea -= (c - b) * 100;
            }
            else if (c + 200 >= b && c <= b) {
                totalArea -= (b - c) * 100;
            }
            else {
                totalArea -= 20000;
            }
        }

        System.out.println(totalArea);

        scanner.close();
    }  
}
