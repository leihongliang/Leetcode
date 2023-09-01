package algorithm_01_array;


import java.util.Arrays;

public class e000_排序 {

    public static void quickSort0(int[] arr, int l, int r) {
        if (l >= r) return;
        int i = partition(arr, l, r);
        quickSort0(arr, l, i - 1);//< 区域
        quickSort0(arr, i + 1, r);//> 区域
    }

    public static int partition(int[] arr, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            // 找到首个小于中心轴的数
            while (i < j && arr[j] >= arr[l]) j--;
            // 找到首个大于中心轴的数
            while (i < j && arr[i] <= arr[l]) i++;
            // 你俩先换
            swap(arr, i, j);
        }
        // 直接找到中心轴的最终位置
        swap(arr, i, l);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        while (i < j) {
            // 找到首个小于中心轴的数
            while (i < j && arr[j] >= arr[l]) j--;
            // 找到首个大于中心轴的数
            while (i < j && arr[i] <= arr[l]) i++;
            // 你俩先换
            swap(arr, i, j);
        }
        // 直接找到中心轴的最终位置
        swap(arr, i, l);
        quickSort(arr, l, i - 1);//< 区域
        quickSort(arr, i + 1, r);//> 区域
    }

    public static int[] mergeSort(int[] arr, int left, int right) {
        // 如果 left == right，表示数组只有一个元素，则不用递归排序
        if (left < right) {
            // 把大的数组分隔成两个数组
            int mid = (left + right) / 2;
            // 对左半部分进行排序
            arr = mergeSort(arr, left, mid);
            // 对右半部分进行排序
            arr = mergeSort(arr, mid + 1, right);
            //进行合并
            merge(arr, left, mid, right);
        }
        return arr;
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        //先用一个临时数组把他们合并汇总起来
        int[] a = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                a[k++] = arr[i++];
            } else {
                a[k++] = arr[j++];
            }
        }
        while(i <= mid) a[k++] = arr[i++];
        while(j <= right) a[k++] = arr[j++];
        // 把临时数组复制到原数组
        for (i = 0; i < k; i++) {
            arr[left++] = a[i];
        }
    }

        // 非递归式的归并排序
    public static int[] mergeSort2(int[] arr) {
        int n = arr.length;
        // 子数组的大小分别为1，2，4，8...
        // 刚开始合并的数组大小是1，接着是2，接着4....
        for (int i = 1; i < n; i += i) {
            //进行数组进行划分
            int left = 0;
            int mid = left + i - 1;
            int right = mid + i;
            //进行合并，对数组大小为 i 的数组进行两两合并
            while (right < n) {
                // 合并函数和递归式的合并函数一样
                merge(arr, left, mid, right);
                left = right + 1;
                mid = left + i - 1;
                right = mid + i;
            }
            // 还有一些被遗漏的数组没合并，千万别忘了
            // 因为不可能每个字数组的大小都刚好为 i
            if (left < n && mid < n) {
                merge(arr, left, mid, n - 1);
            }
        }
        return arr;
    }



    public static void main(String[] args) {
        int[] arr = {7,3,1,2,5,8,6,4,9};
        mergeSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
