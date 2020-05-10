package bfs;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-05-09
 */
public class OpenLock752 {
    public int openLock(String[] deadends, String target) {
        if (target == null) {
            return -1;
        }
        List<String> deadendList = Arrays.asList(deadends);
        if (deadendList.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new ArrayBlockingQueue<>(10000);
        Set<String> visited = new HashSet<>(deadendList);
        int totalCount = 0;
        //初始节点
        String initCode = "0000";
        queue.offer(initCode);
        visited.add(initCode);

        while (!queue.isEmpty()) {
            //此处得保存每层节点队列的大小
            int qs = queue.size();
            for (int i = 0; i < qs; i++) {
                //当前节点
                String current = queue.poll();

                //终止条件
                if (target.equals(current)) {
                    return totalCount;
                }

                //bfs遍历
                for (int j = 0; j < 4; j++) {
                    //上下两种拨动
                    String up = up(current, j);
                    if (!visited.contains(up)) {
                        visited.add(up);
                        queue.offer(up);
                    }
                    String down = down(current, j);
                    if (!visited.contains(down)) {
                        visited.add(down);
                        queue.offer(down);
                    }
                }
            }

            totalCount++;

        }

        return -1;
    }


    private String up(String current, int i) {
        char[] chars = current.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return String.valueOf(chars);
    }

    private String down(String current, int i) {
        char[] chars = current.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String[] deads = {"0201", "0101", "0102", "1212", "2002"};
        int res = new OpenLock752().openLock(deads, "0202");
        System.out.println(res);
    }
}
