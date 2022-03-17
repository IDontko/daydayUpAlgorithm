package Array.easy;

/**
 * @author gaoyang
 * create on 2022/2/21
 */
public class FindAndInvertImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] ans = new int[image.length][image[0].length];
        for (int i = 0; i < image.length ; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[image.length - i - 1][image.length - j - 1] == 1){
                    ans[i][j] = 0;
                }else {
                    ans[i][j] = 1;
                }

            }
        }
        return ans;
    }
}
