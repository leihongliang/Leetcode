import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static List<Integer> generateRandomSelection(List<Integer> digits, int count) {
        List<Integer> selection = new ArrayList<>();
        Random random = new Random();

        while (selection.size() < count) {
            int index = random.nextInt(digits.size());
            int digit = digits.get(index);

            if (!selection.contains(digit)) {
                selection.add(digit);
            }
        }

        return selection;
    }

    public static void main(String[] args) {
        List<Integer> allDigits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            allDigits.add(i);
        }

        List<Integer> selectedDigits = generateRandomSelection(allDigits, 5);
        List<String> permutations = generatePermutations(selectedDigits, 3);

        for (String permutation : permutations) {
            System.out.print(permutation + " ");
        }
    }

    public static List<String> generatePermutations(List<Integer> digits, int length) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsHelper(digits, length, "", permutations);
        return permutations;
    }

    private static void generatePermutationsHelper(List<Integer> digits, int length, String current, List<String> result) {
        if (length == 0) {
            result.add(current);
            return;
        }

        for (int digit : digits) {
            if (!current.contains(Integer.toString(digit))) {
                generatePermutationsHelper(digits, length - 1, current + digit, result);
            }
        }
    }
}
