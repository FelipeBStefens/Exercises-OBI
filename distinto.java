import java.util.ArrayList;
import java.util.Scanner;

public class distinto {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int count = -1;
        for (int i = 0; i < numbers.length; i++) {

            ArrayList<Integer> list = new ArrayList<>();
            
            for (int j = i; j < numbers.length; j++) {

                boolean notHave = true;
                for (int w = 0; w < list.size(); w++) {

                    if (list.get(w) == numbers[j]) {
                        notHave = false;
                        break;
                    }
                }

                if (notHave) {
                    list.add(numbers[j]);
                }
                else {
                    break;
                }
            }

            if (count < list.size()) {
                count = list.size();
            }
        }

        System.out.println(count);
        
        scanner.close();
    }
}
