import java.util.Scanner;

public class cubo {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int totalCubes = n * n * n;

        int threFaces = 8;
        int twoFaces = 12 * (n - 2);
        int oneFace = 6 * ((n * n - 4 * n + 4));

        System.out.println(totalCubes - threFaces - twoFaces - oneFace);
        System.out.println(oneFace);
        System.out.println(twoFaces);
        System.out.println(threFaces);

        scanner.close();
    }
}
