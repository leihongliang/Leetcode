package algorithm_08_backtracking;

import java.util.ArrayList;
import java.util.List;

public class m93复原IP地址 {
    /**
     * 无剪枝
     */
    /*
    static List<String>  res = new ArrayList<>();
    public static List<String> restoreIpAddresses(String s) {
        helper(s, 0, 0);
        return res;
    }
    public static void helper(String s, int start,int flag) {

        if (flag == 3 ) {
            if (isIpAddress(s,start,s.length()-1)){
                res.add(s);
            }else {
                return;
            }
        }
        for (int i = start; i < s.length(); i++) {
            if (!isIpAddress(s, start, i)) break;
            if (flag < 3) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
            }
            flag ++;
            helper(s, i + 2, flag);
            s = s.substring(0, i + 1) + s.substring(i + 2);
            flag --;
        }
    }
    public static boolean isIpAddress(String s, int l, int r) {
        if (s.charAt(l) == '0' && l != r) return false;
        int num = 0;
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) return false;
        }
        return true;
    }

     */


    /**
     *我想加个剪枝
     */
    static List<String>  res = new ArrayList<>();
    static StringBuilder stringBuilder = new StringBuilder();
    public static List<String> restoreIpAddresses(String s) {
        helper(s, 0, 0);
        return res;
    }
    public static void helper(String s, int start,int flag) {
        if (start == s.length() && flag ==4) {
            res.add(stringBuilder.toString());
            return;
        }
        if (start == s.length() || flag == 4) {
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) {
                break;
            }
            if (i - start >= 3){
                if (i - start == 3 && Integer.parseInt(s.substring(start, i + 1)) >= 0 && Integer.parseInt(s.substring(start, i + 1)) <= 255 ) {
                    break;
                }
            }
            stringBuilder.append(s.substring(start, i + 1));

            if (flag < 3) {
                stringBuilder.append(".");
            }
            flag++;
            helper(s, i + 1, flag);
            flag--;

            stringBuilder.delete(start + flag, i + flag + 2);
        }
    }
    public static boolean isIpAddress(String s, int i, int start) {
        if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) return false;
        if (i - start >= 3) {
            if ( i - start == 3 && Integer.parseInt(s.substring(start, i + 1)) > 255) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //输入: candidates =[10,1,2,7,6,1,5], target =8,
        //输出:["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
        String s = "25525511135";

        List<String> result = restoreIpAddresses(s);
        System.out.println(result.toString());
    }




}
