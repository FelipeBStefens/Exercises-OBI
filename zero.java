import java.util.ArrayList;
import java.util.Scanner;

public class zero {
    
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        if (n < 1 || n > 100000) {

            scanner.close();
            throw new Exception();
        }

        ArrayList<Integer> allValues = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            int x = scanner.nextInt();
            if (x < 0 || x > 100) {

                scanner.close();
                throw new Exception();
            }

            if (x != 0) {
                allValues.add(x);
            }
            else {
                if (i != 0) {
                    allValues.remove(allValues.size() - 1);
                }
                else {

                    scanner.close();
                    throw new Exception();
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < allValues.size(); i++) {
            sum += allValues.get(i);
        }
        System.out.println(sum);
        
        scanner.close();
    }
}
