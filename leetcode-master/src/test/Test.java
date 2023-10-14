package test;

import java.util.ArrayList;
import java.util.List;

class Test {

    public static void generateSequences(String outStack, String currentSequence, String stack, List<String> sequences) {
        if (outStack.isEmpty() && stack.isEmpty()) {
            sequences.add(currentSequence);
            return;
        }

        if (!stack.isEmpty()) {
            char top = stack.charAt(stack.length() - 1);
            generateSequences(outStack, currentSequence + top, stack.substring(0, stack.length() - 1), sequences);
        }

        if (!outStack.isEmpty()) {
            char next = outStack.charAt(0);
            generateSequences(outStack.substring(1), currentSequence, stack + next, sequences);
        }
    }

    public static List<String> getAllValidSequences(String outStack) {
        List<String> sequences = new ArrayList<>();
        generateSequences(outStack, "", "", sequences);
        return sequences;
    }

    public static void main(String[] args) {
        String outStack = "FEABCD";
        List<String> validSequences = getAllValidSequences(outStack);
        for (String sequence : validSequences) {
            System.out.println(sequence);
        }
    }


}
