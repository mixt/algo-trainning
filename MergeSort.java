public class MergeSort {
    private static int[] b;

    public static void merge(int[] a， int lo, int mid, int hi) {
        for(int i = lo; i <= hi; i++) {
            b[i] = a[i];
        }
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++) {
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

    public static void sort(int[] a) {
        b = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if(lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }
}

/**
 * merge()是对一个前后两部分已排序数组的合并例程，其中i和j是前后两个子数组的游标。在最后的for循环中，
 * 分四种情况，1.前半个数组用尽，即i已经越过中点；2.后半个数组用尽，即j越过数组末尾；
 * 3.i所指元素小于j所指元素；4.i所指元素大于等于j所指元素。分四种情况进行两个子数组的合并。
 * 第一个sort()是驱动例程，第二个sort()是分段排序的例程，整个程序分为分段排序、合并，并由驱动例程驱动。
 */