package real.a;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
对于一个字符串，如果把字符串的第一个字符放到最后，得到的新串就是原来字符串的旋转串。
一个字符串的旋转串的旋转串也是这个字符串的旋转串。即这种关系具有传递性。
例如abc的旋转串有：bca cab abc
如果存在一个字符串，既是 x 的旋转串也是 y 的旋转串，那么我们称 x,y 匹配。
请回答一系列字符串中是否有两个字符串匹配。
输入描述:
第一行输入一个正整数 T，表示输入数据的组数
每组数据第一行为一个正整数n
接下来n行，每行一个只含小写字母的字符串s
1 <= T <= 50, 1<= n <= 5000
每个字符串的长度都相同且不会超过50

输出描述:
如果存在两个字符串匹配，则输出YES，否则输出NO

示例1输入输出示例仅供调试，后台判题数据一般不包含示例
输入
2
3
abb
abc
bab
3
aba
abc
abb
输出
YES
NO
*
* */

public class tx23旋转串 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int t=in.nextInt();
        int[][] p=new int[n][2];
        int[] v=new int[n];
        for (int i = 0; i < n; i++) {
            p[i][0]=in.nextInt();
            p[i][1]=i;
        }
        for (int i = 0; i < n; i++) {
            v[i]=in.nextInt();
            p[i][0]+=v[i]*t;
        }
        Arrays.sort(p,(a, b)->(a[0]-b[0]));
        int[] index=new int[n];
        index[n-1]=n-1;
        for (int i = n-2; i >=0 ; i--) {
            index[i]=i;
            if (p[i][0]==p[i+1][0]) index[i]=index[i+1];
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            if (p[i][1]<index[i]) res++;
        }
        System.out.println(res);
    }
}








