package test;

import java.util.*;

public class Main {


        public static void main(String[] args) {
            // 创建一个HashMap
            HashMap<String, Integer> hashMap = new HashMap<>();

            // 添加键值对
            hashMap.put("apple", 10);
            hashMap.put("banana", 20);
            hashMap.put("orange", 15);

            // 获取值
            int appleCount = hashMap.get("apple");
            System.out.println("Apple count: " + appleCount);

            // 检查是否包含某个键
            boolean containsKey = hashMap.containsKey("banana");
            System.out.println("Contains key 'banana': " + containsKey);

            // 遍历HashMap
            for (String key : hashMap.keySet()) {
                int value = hashMap.get(key);
                System.out.println("Key: " + key + ", Value: " + value);
            }

            // 删除键值对
            hashMap.remove("orange");

            // 清空HashMap
            hashMap.clear();
        }



}
