public class WarehouseBinGridScan  {
    static class Summary  {
        long total;
        int row, col, max;
        Summary(long t, int r, int c, int m) {
            total=t;
            row=r;
            col=c;
            max=m;
        }
public String toString() {
            return "total="+total+", maxCoordinate=("+row+", "+col+"), max="+max;
        }
    }
static Summary warehouseSummary(int[][] grid)  {
        long total=0;
        int max=-1, mr=0, mc=0;
        for(int r=0;r<grid.length;r++) for(int c=0;c<grid[r].length;c++)  {
            int v=grid[r][c];
            total+=v;
            if(v>max) {
                max=v;
                mr=r;
                mc=c;
            }
        }
return new Summary(total, mr, mc, max);
    }
public static void main(String[] args)  {
        System.out.println(warehouseSummary(new int[][] {
             {
                4, 9, 2
            },  {
                7, 1, 6
            },  {
                3, 12, 5
            }
        }));
        // O(m*n) time, O(1) extra space. Strict > preserves the first maximum on ties.
    }
}
