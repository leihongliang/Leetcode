package real.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
现在有一辆货车需要从A地出发到达B地，中间会经过一系列城市，如果需要入城补给，则需要缴纳一定的过路费，现给出中间城市的过路费数组toll，toll[i]表示第i个城市（不包含起点和终点城市）的过路费，求最少支付的过路费总额。
注意：1.货车可以跳过某些城市不进城，但是不能连续跳过两个城市。
           2.出发和到达城市都不需要计算过路费
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
[1,2,3]
输出
2
说明
出发后跳过第0个城市，在第1个城市进行补给，然后跳过第2个城市，一共花费2

示例2
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
[10,1,1,1,10,1,1,10]
输出
4
说明
在第1,3,5,6号城市补给，共计花费为4
示例3
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
[1,19,2,4,22,8,16,5]
输出
20
说明
在第0,2,3,5,7号城市进行补给
* */
public class w58最少的过路费 {
    public static void main(String[] args) {
        int[] word1Index = {1, 2, 3, 7};
        int[] word2Index = {2, 5, 7};

        int[] result = findCommonPosts(word1Index, word2Index);
        for (int postID : result) {
            System.out.println(postID);
        }
    }

    public static int[] findCommonPosts(int[] word1Index, int[] word2Index) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < word1Index.length && j < word2Index.length) {
            if (word1Index[i] == word2Index[j]) {
                result.add(word1Index[i]);
                i++;
                j++;
            } else if (word1Index[i] < word2Index[j]) {
                j++;
            } else {
                i++;
            }
        }

        // Convert the list to an array and reverse the order
        int[] resultArray = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            resultArray[k] = result.get(k);
        }

        // Sort in descending order
        Arrays.sort(resultArray);
        reverseArray(resultArray);

        return resultArray;
    }

    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
