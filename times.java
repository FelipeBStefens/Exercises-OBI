import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class times {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> groupOne = new ArrayList<>();
        ArrayList<Integer> groupTwo = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int[] hatePeople = new int[scanner.nextInt()];
            for (int j = 0; j < hatePeople.length; j++) {

                hatePeople[j] = scanner.nextInt();
            }

            if (i == 0) {
                groupOne.add(1);
                for (int j = 0; j < hatePeople.length; j++) {
                    groupTwo.add(hatePeople[j]);
                }
            }
            else {

                boolean isInGroupOne = false;
                for (int j = 0; j < hatePeople.length; j++) {
                    if (isInArray(hatePeople[j], groupOne)) {
                        isInGroupOne = true;
                        break;
                    }
                }

                if (isInGroupOne) {
                    groupTwo.add(i + 1);
                    for (int j = 0; j < hatePeople.length; j++) {
                        if (!isInArray(hatePeople[j], groupOne)) {
                            groupOne.add(hatePeople[j]);
                        }
                    }
                }
                else {
                    groupOne.add(i + 1);
                    for (int j = 0; j < hatePeople.length; j++) {
                        if (!isInArray(hatePeople[j], groupTwo)) {
                            groupTwo.add(hatePeople[j]);
                        }
                    }
                }
            }
        }

        int[] sortGroupOne = new int[groupOne.size()];
        for (int i = 0; i < groupOne.size(); i++) {
            sortGroupOne[i] = groupOne.get(i);
        }
        Arrays.sort(sortGroupOne);

        int[] sortGroupTwo = new int[groupTwo.size()];
        for (int i = 0; i < groupTwo.size(); i++) {
            sortGroupTwo[i] = groupTwo.get(i);
        }
        Arrays.sort(sortGroupTwo);

        ArrayList<Integer> newGroupOne = removeDuplicateIndex(sortGroupOne);
        ArrayList<Integer> newGroupTwo = removeDuplicateIndex(sortGroupTwo);

        for (int i = 0; i < newGroupOne.size(); i++) {
            System.out.print(newGroupOne.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < newGroupTwo.size(); i++) {
            System.out.print(newGroupTwo.get(i) + " ");
        }

        scanner.close();
    }

    public static boolean isInArray(int value, ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> removeDuplicateIndex(int[] list) {
        ArrayList<Integer> newList = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {

            boolean isInList = false;
            for (int j = 0; j < newList.size(); j++) {
                if (newList.get(j).equals(list[i])) {
                    isInList = true;
                    break;
                }
            }

            if (!isInList) {
                newList.add(list[i]);
            }
        }
        return newList;
    }
}