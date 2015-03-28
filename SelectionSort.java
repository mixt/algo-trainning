public class SelectionSort {
    public static void sort(int[] a) {
        int len = a.length;
        for(int i = 0; i < len; i++) {
            int min = i;
            for(int j = i; j < len; j++) {
                if(a[j] < a[i]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
}

/**
 * 常规的选择排序，有2层循环，外层代表起始点不断后移的数组子列，内层循环代表在每个子列中
 * 遍历比较，将最小元素的下标记录下来，然后在外层循环中将这个最小元素和子列的头对调。
 */