public class MaximumSumSubarrayFixedK {
    static long maxSumSubarray(int[] sales, int k) {
        if(k<1 || k>sales.length) throw new IllegalArgumentException("k must be 1..n");
        long window=0;
        for(int i=0;i<k;i++) window+=sales[i];
        long best=window;
        for(int i=k;i<sales.length;i++) {
            window += sales[i]-sales[i-k];
            best=Math.max(best, window);
        }
        return best;
    }
    public static void main(String[] args) {
        System.out.println(maxSumSubarray(new int[] {
            2, 1, 5, 1, 3, 2
        }, 3));
        // 9
        // O(n) time, O(1) extra space; naive recomputation is O(n*k).
    }
}
