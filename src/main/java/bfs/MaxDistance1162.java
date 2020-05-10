package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1162. 地图分析
 * <p>
 * 根据陆地源向外搜索海洋，搜索过一次的海洋不能重复搜索
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-29
 */
public class MaxDistance1162 {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        //放入队列
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //陆地
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }

        int count = -1;
        while (!queue.isEmpty()) {
            //没向外搜索一层，计数+1
            count++;
            //每次处理同一层中的所有节点，向四周搜索一次
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                //向左遍历
                if (x - 1 >= 0 && grid[x - 1][y] == 0) {
                    grid[x - 1][y] = 2;
                    queue.offer(new int[]{x - 1, y});
                }
                //向右遍历
                if (x + 1 < n && grid[x + 1][y] == 0) {
                    grid[x + 1][y] = 2;
                    queue.offer(new int[]{x + 1, y});
                }
                //向上遍历
                if (y - 1 >= 0 && grid[x][y - 1] == 0) {
                    grid[x][y - 1] = 2;
                    queue.offer(new int[]{x, y - 1});
                }
                //向下遍历
                if (y + 1 < n && grid[x][y + 1] == 0) {
                    grid[x][y + 1] = 2;
                    queue.offer(new int[]{x, y + 1});
                }
            }
        }
        return count;
    }

}
