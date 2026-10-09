import java.util.*;
public class SpiralStockAuditRoute  {
    static List<Integer> auditRoute(int[][] grid)  {
        List<Integer> out = new ArrayList<>();
        if(grid==null || grid.length==0 || grid[0].length==0) return out;
        int top=0, bottom=grid.length-1, left=0, right=grid[0].length-1;
        while(top<=bottom && left<=right)  {
            for(int c=left;c<=right;c++) out.add(grid[top][c]);
            top++;
            for(int r=top;r<=bottom;r++) out.add(grid[r][right]);
            right--;
            if(top<=bottom)  {
                for(int c=right;c>=left;c--) out.add(grid[bottom][c]);
                bottom--;
            }
if(left<=right)  {
                for(int r=bottom;r>=top;r--) out.add(grid[r][left]);
                left++;
            }
        }
return out;
    }
public static void main(String[] args)  {
        int[][] grid= {
             {
                1, 2, 3, 4
            },  {
                5, 6, 7, 8
            },  {
                9, 10, 11, 12
            }
        };
        System.out.println(auditRoute(grid));
        // O(rows*columns) time; O(1) auxiliary space excluding output.
    }
}
