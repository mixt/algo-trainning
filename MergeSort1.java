public class MergeSort1 {
    public static void merge(int[] a) {
        int len = a.length;
        int[] b = new int[len];
        for(int i = 0; i < len; i++) {
            b[i] = a[i];
        }
        int lo = 0;
        int hi = len - 1;
        int mid = (lo + hi) / 2;
        int i = lo;
        int j = mid + 1;
        for(int k = 0; k < len; k++) {
            if(i > mid) {
                a[k] = b[j++];
            }
            else if(j > hi) {
                a[k] = b[i++];
            }
            else if(b[i] < b[j]) {
                a[k] = b[i++];
            }
            else {
                a[k] = b[j++];
            }
        }
    }
}

/**
 * 对一个前后两部分已排序数组的合并例程，其中i和j是前后两个子数组的游标。在最后的for循环中，
 * 分四种情况，1.前半个数组用尽，即i已经越过中点；2.后半个数组用尽，即j越过数组末尾；
 * 3.i所指元素小于j所指元素；4.i所指元素大于等于j所指元素。分四种情况进行两个子数组的合并