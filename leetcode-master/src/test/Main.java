package test;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C");
        List<String> resultList = new ArrayList<>();

        list.stream()
                .filter(item -> {
                    System.out.print(item);
                    return true;
                })
                .forEach(item -> {
                    if (item.equals("B")) {
                        resultList.add(item);
                        return;
                    }
                    resultList.add(item.toUpperCase());
                });

        System.out.println("\n" + resultList);
    }


}





