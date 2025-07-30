import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class lista {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        System.out.println(countList(list));
        scanner.close();
    }

    public static int countList(ArrayList<Integer> list) {

        if (isPalindrome(list, 0) || list.size() == 1) {
            return 0;
        }

        ArrayList<Integer> count = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {

            ArrayList<Integer> newList = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                
                if (j == i) {
                    newList.add(list.get(i) + list.get(i + 1));
                }
                else if (j != i && j != i + 1) {
                    newList.add(list.get(j));
                }
            }
            count.add(1 + countList(newList));
        }

        return min(count);
    }

    public static boolean isPalindrome(ArrayList<Integer> list, int i) {

        if (i == list.size() - 1 - i || i + 1 == list.size() - 1 - i) {
            return true;
        }

        if (!Objects.equals(list.get(i), list.get(list.size() - 1 - i))) {
            return false;
        }
        else {
            return isPalindrome(list, i + 1);
        }
    }

    public static int min(ArrayList<Integer> list) {

        int min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (min > list.get(i)) {
                min = list.get(i);
            }
        }

        return min;
    }
}
