public class ExamScoreBandCounter  {
    static int lowerBound(int[] a, int target)  {
        int lo=0, hi=a.length;
        while(lo<hi)  {
            int mid=lo+(hi-lo)/2;
            if(a[mid]<target) lo=mid+1;
            else hi=mid;
        }
return lo;
    }
static int upperBound(int[] a, int target)  {
        int lo=0, hi=a.length;
        while(lo<hi)  {
            int mid=lo+(hi-lo)/2;
            if(a[mid]<=target) lo=mid+1;
            else hi=mid;
        }
return lo;
    }
static int countInBand(int[] scores, int low, int high)  {
        if(low>high) return 0;
        return upperBound(scores, high)-lowerBound(scores, low);
    }
public static void main(String[] args)  {
        int[] scores= {
            35, 42, 42, 50, 58, 58, 58, 63, 71, 88
        };
        System.out.println(countInBand(scores, 42, 58));
        // 6
System.out.println(countInBand(scores, 90, 100));
        // 0
// O(log n) time, O(1) space; bounds correctly include duplicates.
    }
}
