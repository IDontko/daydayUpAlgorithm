package Sort.easy.classic;

import java.util.Arrays;

/**
 * 归并排序
 * 归并排序是建立在归并操作上的一种有效的排序算法
 * 。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用
 * 。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 *
 * 作者：Steven1997
 * 链接：https://www.jianshu.com/p/47170b1ced23
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MergeSort {

    public int[] MergeSort(int[] array){
        if (array.length < 2){
            return array;
        }
        int mid = array.length /2 ;
        int[] left = Arrays.copyOfRange(array,0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    private int[] merge(int[] left, int[] right){
        int[] result = new int[left.length +right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j< right.length){
            if (left[i] <= right[j]){
                result[k++] = left[i++];
            }else {
                result[k++] = right[i++];
            }
            while (i < left.length){
                result[k++] = left[i++];
            }
            while (j < right.length){
                result[k++] = right[j++];
            }

        }
        return result;
    }
}
