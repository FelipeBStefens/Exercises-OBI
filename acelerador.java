import java.util.Scanner;

public class acelerador {
    
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        int d = scanner.nextInt();
        if (d < 6 || d > 800008) {

            scanner.close();
            throw new Exception();
        }

        d -= 3;
        while (d > 8) {
            d -= 8;
        }

        if (d == 3) {
            System.out.println(1);
        }
        else if (d == 4) {
            System.out.println(2);
        }
        else if (d == 5) {
            System.out.println(3);
        }

        scanner.close();
    }
}
