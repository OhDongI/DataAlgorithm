//week3
import java.util.Arrays;

public class Maze {
    int[][] maze;
    int[][] memo;
    
    public Maze(int[][] in) {
        maze = in;
        memo = new int[in.length][in.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
    }
    
    public int findMaxIter(int i, int j) {
        // 이전 코드와 동일합니다.
        return 0;
    }
    
    public int findMaxRec(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        int up = findMaxRec(i - 1, j);
        int left = findMaxRec(i, j - 1);
        memo[i][j] = maze[i][j] + Math.max(up, left);
        
        return memo[i][j];
    }
    
    public static void main(String[] args) {
        int[][] maze = {
                {1, 2, 1, 5, 8, 4},
                {4, 1, 9, 4, 2, 3},
                {8, 5, 4, 3, 8, 2},
                {1, 5, 3, 5, 7, 3},
                {4, 7, 7, 9, 2, 8},
                {2, 4, 6, 3, 1, 4}
        };
        Maze me = new Maze(maze);
        
        System.out.println("MaxSum = " + me.findMaxIter(maze.length - 1, maze.length - 1));
        //시작점에서 도착점까지 이동할 수 없는 경우
        System.out.println("MaxSum = " + me.findMaxRec(maze.length - 1, maze.length - 1));
    }
}

