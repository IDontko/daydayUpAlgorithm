package Sort.easy.classic;

/**
 * 选择排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 */
public class SelectionSort {
    public static int[] selectionSort(int[] array){
        if (array.length == 0){
            return null;
        }
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int targetIndex = i;
            for (int j = i; j < n ; j++) {
                if (array[j] < array[targetIndex]){
                    targetIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[targetIndex];
            array[targetIndex] = temp;
        }
        return array;
    }
}
