import java.util.*;
public class LibraryCatalogLookupAlternative  {
    static String findBook(List<String[]> catalog, String targetIsbn)  {
        int lo=0, hi=catalog.size();
        while(lo<hi)  {
            int mid=lo+(hi-lo)/2;
            if(catalog.get(mid)[0].compareTo(targetIsbn)<0) lo=mid+1;
            else hi=mid;
        }
return lo<catalog.size() && catalog.get(lo)[0].equals(targetIsbn) ? catalog.get(lo)[1] : "Not Found";
    }
public static void main(String[] args)  {
        List<String[]> catalog=Arrays.asList(new String[] {
            "0001112223", "Intro to Algebra"
        }, new String[] {
            "0002223334", "Beginning Python"
        });
        System.out.println(findBook(catalog, "0002223334"));
        System.out.println(findBook(catalog, "0009998887"));
        // Lower-bound variant: O(log n) time and O(1) auxiliary space.
    }
}
