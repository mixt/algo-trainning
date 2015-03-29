public class MergeSortBU {
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
        for(int step = 1; step < a.length; step += step) {
            for(int i = 0; i < a.length - step; i += 2 * step) {
                merge(a, i, i + step - 1, Math.min(i + 2 * step - 1, a.length - 1));
            }
        }
    }
}

/**
 * 自底到顶的归并排序例程，其中step是要合并的单位长度，特别注意的是里层的for循环的条件，
 * 因为要考虑到数组总长可能是奇数的情况，即最末尾只有一个而不是一对合并单元的情况（注意
 * merge函数已经可以处理这种情况），还有merge调用时的参数。