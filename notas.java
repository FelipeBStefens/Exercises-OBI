import java.util.ArrayList;
import java.util.Scanner;

public class notas {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] grades = new int[n];

        for (int i = 0; i < n; i++) {
            grades[i] = scanner.nextInt();
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> duplicatedNumbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isInList(grades[i], numbers)) {
                if (!isInList(grades[i], duplicatedNumbers)) {
                    duplicatedNumbers.add(grades[i]);
                }
            }
            else {
                numbers.add(grades[i]);
            }
        }

        int max = -1;
        for (int i = 0; i < duplicatedNumbers.size(); i++) {
            if (max < duplicatedNumbers.get(i)) {
                max = duplicatedNumbers.get(i);
            }
        }

        System.out.println(max);
        
        scanner.close();
    }

    public static boolean isInList(int value, ArrayList<Integer> list) {

        if (list.isEmpty()) {
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            if (value == list.get(i)) {
                return true;
            }
        }

        return false;
    }
}
