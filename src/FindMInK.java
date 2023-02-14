/**
 * 寻找数组中第k小的元素
 */
public class FindMInK {
    public static int partition(int[] a, int low, int high) {//一次快排
        int middle = a[low];
        while (low < high) {
            while (low < high && a[high] >= middle)
                high--;
            if (low < high)
                a[low++] = a[high];
            while (low < high && a[low] <= middle)
                low++;
            if (low < high)
                a[high--] = a[low];
        }
        a[low] = middle;
        return low;
    }

    public static int solution(int[] a, int k, int low, int high) {
        int middleIndex = partition(a, low, high);//找出分段点
        middleIndex = middleIndex - low;
        if (k == middleIndex + 1) {
            return a[middleIndex + low];
        } else if (k < middleIndex + 1) {
            return solution(a, k, low, middleIndex - 1 + low);
        } else {
            return solution(a, k - middleIndex - 1, middleIndex + 1 + low, high);
        }
    }

}
