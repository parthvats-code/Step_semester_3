import java.util.*;
public class NetBalancePeriodCounter {
    static long countPeriods(int[] transactions, long k) {
        Map<Long, Long> frequency = new HashMap<>();
        frequency.put(0L, 1L);
        long prefix = 0, count = 0;
        for (int x : transactions) {
            prefix += x;
            count += frequency.getOrDefault(prefix-k, 0L);
            frequency.put(prefix, frequency.getOrDefault(prefix, 0L)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPeriods(new int[] {
            3, 4, -7, 1, 3, 3, 1, -4
        }, 7));
        // 4
        System.out.println(countPeriods(new int[] {
            1, 2, 3
        }, 10));
        // 0
        // O(n) expected time and O(n) extra space; prefix-frequency handles negative values.
    }
}
