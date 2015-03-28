public class InsertSort {
    public static void sort(int[] a) {
        int len = a.length;
        for(int i = 1; i < len; i++) {
            for(int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                int temp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = temp;
            }
        }
    }
}

/**
 * 标准的插入排序，外层循环是逐步增长的从数组头开始的子数组，内循环不断将子数组最后一个元素向前移，
 * 直到不满足大小顺序。
 */