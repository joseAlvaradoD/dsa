public class Main {
    /*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the
    number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or
    vertically. You may assume all four edges of the grid are all surrounded by water.
    Example 1:
    Input: grid = [
    ["1","1","1","1","0"],
    ["1","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
    ]
    Output: 1
    Example 2:
    Input: grid = [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
    ]
    Output: 3
    Constraints:
     m == grid.length
     n == grid[i].length
     1 <= m, n <= 300
     grid[i][j] is '0' or '1'.
    * */
    public static void main(String[] args) {
        String [][] grid = {
                {"1","1","1","1","0"},
                {"1","1","0","1","0"},
                {"1","1","0","0","0"},
                {"0","0","0","0","0"}
                };

        System.out.println(islandsNumber(grid));

        grid = new String [][]{
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
            };

        System.out.println(islandsNumber(grid));

        System.out.println("Hello world!");
    }

    public static int islandsNumber(String[][] grid){

        int ans = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j].equals("1")){
                    ans++;
                    DFS(grid, i, j);
                }
            }
        }

        return ans;

    }

    public static void DFS(String[][] grid, int i, int j){

        if(
             i < 0 ||
             j < 0 ||
             i > grid.length - 1 ||
             j > grid[i].length - 1 ||
             grid[i][j].equals("0")
        ){
            return;
        }
        if(grid[i][j].equals("1")){
            grid[i][j] = "0";
            DFS(grid, i-1, j);
            DFS(grid, i+1, j);
            DFS(grid, i, j+1);
            DFS(grid, i, j-1);
            DFS(grid, i+1, j+1);
            DFS(grid, i-1, j-1);
            DFS(grid, i+1, j-1);
            DFS(grid, i-1, j+1);
        }

    }
}