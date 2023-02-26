package algorithm_04_string;

public class e151_颠倒字符串中的单词 {
    public static String reverseWords0(String s) {
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int k = 0;// 起点
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                continue;
            }
            int start = i;
            while (i < arr.length && arr[i] != ' ') {
                i++;
            }
            for (int j = start; j < i; j++) {
                if (j == start) {
                    reverse(arr, start,i - 1);
                }
                arr[k++] = arr[j];//复制
                if (j == i - 1) {//字符结尾加空格
                    if (k < arr.length) {
                        arr[k++] = ' ';
                    }
                }
            }
        }
        if (k == 0) {
            return " ";
        } else {
            return new String(arr, 0, (k == arr.length) && (arr[k - 1] != ' ') ? k : k - 1);
        }
    }

    public static void reverse (char[] arr, int l , int r) {
        while (l < r) {
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
            l++;
            r--;
        }

    }

    public static String reverseWords2(String s) {
        char[] arr = s.toCharArray();
        char[] res = new char[arr.length+1];
        int k = 0;
        int i = arr.length-1;//从后往前
        while(i >= 0){
            while(i >= 0 && arr[i] == ' '){i--;}
            int end = i;
            while(i >= 0 && arr[i] != ' '){i--;}
            for (int j = i+1; j <= end; j++) {
                res[k++] = arr[j];
                if(j == end){
                    res[k++] = ' ';//空格
                }
            }
        }
        if(k == 0){
            return "";
        }else{
            return new String(res,0,k-1);
        }
    }

    /**
     * 2023年5月11日16:41:47
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s.substring(i + 1, j + 1) + ' ');
            i--;
            j = i;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String res = reverseWords(" abc  ab ");
        System.out.println(res.toString());
    }
}
