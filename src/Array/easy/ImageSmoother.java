package Array.easy;

/**
 * @author gaoyang
 * create on 2022/2/16
 * https://leetcode-cn.com/problems/image-smoother/
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int rowLength = img.length;
        int colLength =  img[0].length;
        int[][] result = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength ; j++) {
                int count = 0 ;
                for (int nr = i - 1; nr <= i+1 ; nr++) {
                    for (int nc = j - 1; nc <= j + 1 ; nc++) {
                        if (0<=nr && nr< rowLength && nc>=0 && nc< colLength){
                            result[i][j] += img[nr][nc];
                            count++;
                        }
                    }
                }
                result[i][j] /=count;

            }

        }
        return result;
    }
}
