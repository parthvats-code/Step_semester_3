public class LongestBudgetFriendlyStreak {
    static int[] longestStreak(int[] costs, long budget) {
        int left = 0, bestLength = 0, bestStart = -1;
        long sum = 0;
        for (int right = 0; right < costs.length; right++) {
            sum += costs[right];
            while (left <= right && sum > budget) sum -= costs[left++];
            int length = right - left + 1;
            if (length > bestLength) { bestLength = length; bestStart = left; }
        }
        return new int[]{bestLength, bestStart};
    }
    public static void main(String[] args) {
        int[] costs = {4,2,1,7,3,1,2,1,5};
        int[] ans = longestStreak(costs,8);
        System.out.println("(" + ans[0] + ", " + ans[1] + ")");
        System.out.println(java.util.Arrays.toString(longestStreak(new int[]{9,10},8)));
        // O(n) time, O(1) extra space. Non-negative values make shrinking the window safe.
    }
}