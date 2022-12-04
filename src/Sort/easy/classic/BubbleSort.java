package Sort.easy.classic;

import java.awt.event.ItemEvent;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] array){
        if (array.length == 0){
            return null;
        }
        int n = array.length;
        for (int i = 0; i < n ; i++) {
            for (int j = i; j < n ; j++) {
                if (array[i] > array[j]){
                     int temp = array[i];
                    array[i]  = array[j] ;
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
