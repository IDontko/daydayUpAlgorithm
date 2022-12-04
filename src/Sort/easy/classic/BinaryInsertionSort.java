package Sort.easy.classic;

/**
 * 在直接插入排序中，待插入的元素总是在有序区线性查找合适的插入位置，
 * 没有利用有序的优势，考虑使用二分查找搜索插入位置进行优化
 * ，即二分插入排序。
 */
public class BinaryInsertionSort {
    public static int[] BinaryInsertionSort(int[] array){
        if (array.length == 0){
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            int left = 0;
            int right = i -1;
            int current = array[i];
            while (left <= right){
                int mid = left + ((right -left) >> 1);
                if (array[mid] < current){
                    left = mid+ 1;
                }else {
                    right = mid -1;
                }
            }
            for (int j = i - 1; j >= left ; j--) {
                array[j + 1] = array[j];
            }
            array[left] = current;
        }
        return array;
    }
}
