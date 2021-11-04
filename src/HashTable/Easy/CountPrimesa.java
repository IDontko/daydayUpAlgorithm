package HashTable.Easy;

/**
 * https://leetcode.com/problems/count-primes/
 * 目的：求出比n小的所有的素数
 * 思路：简单方法就是循环迭代寻找相应的数。
 */
public class CountPrimesa {

    public static int countPrimes(int n) {
        int count = 0;
        boolean prime = true;
        for(int num=2;num<n;num++) {
            for(int i=2;i<=Math.sqrt(num);i++) {
                if(num%i == 0 && num!=i) {
                    prime = false;
                    break;
                }
            }
            if(prime) {
                count++;
            } else {
                // Continue for next iteration, undo the existing value
                prime = true;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int n = 10 ;
        CountPrimesa.countPrimes(n);
    }
}
