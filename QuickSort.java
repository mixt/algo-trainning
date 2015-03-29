public class QuickSort {
    public static void sort(int[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if(lo > hi) {
            return;
        }
        int pivot = partition(a, lo, hi);
        sort(a, lo, pivot - 1);
        sort(a, pivot + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int v = a[lo];
        int i = lo;
        int j = hi + 1;
        while(true) {
            while(a[++i] < v) {
                if(i == hi) {
                    break;
                }
            }
            while(a[--j] > v) {
                if(j == lo) {
                    break;
                }
            }
            if(i >= j) {
                break;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        a[lo] = a[j];
        a[j] = v;
        return j;
    }
}

/**
 * 典型的快速排序例程，注意递归调用时pivot是不被包含在内的，然后是partition时
 * 两个游标的起始点要根据后面while中的游标改变方式而定，是++i还是i++。注意最后交换的是
 * a[lo]和a[j]
 */