import java.util.*;
public class MallFootfallRangeReport  {
    static long[] footfallReport(int[] visitors, int[][] queries)  {
        long[] prefix = new long[visitors.length + 1];
        for (int i = 0; i < visitors.length; i++) prefix[i + 1] = prefix[i] + visitors[i];
        long[] answer = new long[queries.length];
        for (int i = 0; i < queries.length; i++)  {
            int start = queries[i][0], end = queries[i][1];
            answer[i] = prefix[end + 1] - prefix[start];
        }
return answer;
    }
public static void main(String[] args)  {
        int[] visitors =  {
            12, 7, 3, 9, 15, 4, 8
        };
        int[][] q =  {
             {
                0, 2
            },  {
                2, 5
            },  {
                4, 6
            },  {
                3, 3
            }
        };
        System.out.println(Arrays.toString(footfallReport(visitors, q)));
        // O(n+q) time, O(n) extra space; naive query answering is O(n*q) worst case.
    }
}
