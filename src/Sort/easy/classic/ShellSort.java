package Sort.easy.classic;

/**
 * 希尔排序
 */
public class ShellSort {

    public static int[] shellSort(int[] arr){
        int n = arr.length;
        int gap = n /2;
        while(gap > 0){

            for (int i = gap; i < n; i++) {
                int current = arr[i];
                int preIndex = i - gap;
                while(preIndex >= 0 && arr[preIndex] > current){
                    arr[preIndex + gap]= arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex+gap] = current;
            }
            gap = gap /2;
        }
        return arr;
    }
}
