package real.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
*
搜索场景下，搜索引擎针对帖子建立倒排索引，即单词对应出现该单词的所有文档列表，倒排索引的具体结构如下：
单词1->文档1的ID；文档2的ID；文档3的ID…   即单词1出现在文档1、2、3…中
单词2->文档2的ID；文档5的ID；文档7的ID…   即单词2出现在文档2、5、7…中
具体可以简化为每个单词对应一个倒排链，即int数组，数组中存储值为从小到大排序好的无重复的帖子ID。
现在用户希望查询同时出现单词1与单词2的帖子，即输入为两个单词的倒排链数组，输出同时包含这两个单词的帖子ID，帖子ID按照从大到小排序。
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入

[1,2,3,7],[2,5,7]
输出

[7,2]
* */
public class w58倒排链求交 {
    public static void main(String[] args) {
        // 测试用例
        int[] arr1 = {1, 2, 3, 7};
        int[] arr2 = {2, 5, 7};
        System.out.println(Arrays.toString(query(arr1, arr2)));
    }

    // 查询同时出现两个单词的帖子ID
    public static int[] query(int[] docList1, int[] docList2) {
        // 创建一个列表用于存储结果
        ArrayList<Integer> list = new ArrayList<>();
        // 定义两个指针分别指向两个数组的开头
        int i = 0;
        int j = 0;
        // 当两个指针都没有越界时，进行循环
        while (i < docList1.length && j < docList2.length) {
            // 如果两个数组的当前元素相等，说明找到了一个共同的文档ID
            if (docList1[i] == docList2[j]) {
                // 将该文档ID加入到列表中
                list.add(docList1[i]);
                // 同时移动两个指针
                i++;
                j++;
            } else if (docList1[i] < docList2[j]) {
                // 如果第一个数组的当前元素小于第二个数组的当前元素，说明第一个数组需要向后移动
                i++;
            } else {
                // 如果第一个数组的当前元素大于第二个数组的当前元素，说明第二个数组需要向后移动
                j++;
            }
        }
        // 将列表反转，得到从大到小排序的结果
        Collections.reverse(list);
        // 将列表转换为int数组并返回
        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        return result;
    }
}
