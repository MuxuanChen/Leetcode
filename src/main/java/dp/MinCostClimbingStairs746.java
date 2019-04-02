package dp;

/**
 * 最低成本爬楼梯
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2019-04-01
 */
public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        //到前一个台阶的总和
        int f1 = 0;
        //到前两个台阶的总和
        int f2 = 0;
        for (int i = 0; i < cost.length; i++) {
            //到当前台阶的和
            int f0 = cost[i] + Integer.min(f1,f2);
            //原前一个台阶变成了前两个台阶
            f2 = f1;
            //当前台阶变成了前一个台阶
            f1 = f0;
        }
        //最终取前一个和前两个台阶中小的那个
        return Math.min(f1,f2);
    }
}
