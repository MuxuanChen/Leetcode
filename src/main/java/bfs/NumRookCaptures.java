package bfs;

/**
 * 999.车的可用捕获量
 * <p>
 * 此题主要难点在于理解题意，其实题意很简单，车只能往四个方向各走一遍，在每个方向上，如果遇到象或者边界直接停止；
 * 如果遇到卒，捕获且停止向前走，如果遇到空格则继续向前走。也就是最多只可能捕获到4个卒。
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-26
 */
public class NumRookCaptures {
    public int numRookCaptures(char[][] board) {
        int pawnCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 找到车所在的位置
                if (board[i][j] == 'R') {
                    //dfs四个方向，统计卒的数量
                    pawnCount += search(board, i + 1, j, 1, 0);
                    pawnCount += search(board, i - 1, j, -1, 0);
                    pawnCount += search(board, i, j + 1, 0, 1);
                    pawnCount += search(board, i, j - 1, 0, -1);
                }
            }
        }
        return pawnCount;
    }

    int search(char[][] board, int i, int j, int s, int t) {
        if (i < 0 || i > 7 || j < 0 || j > 7) {
            return 0;
        }
        char cur = board[i][j];
        //遇到白象返回，不继续走下去
        if (cur == 'B') {
            return 0;
        } else if (cur == 'p') {
            //遇到卒，捕获，不继续走下去
            return 1;
        } else {
            //沿当前方向继续走下去
            return search(board, i + s, j + t, s, t);
        }
    }

    public static void main(String[] args) {
        char[][] a = {
                {
                        '.', '.', '.', '.', '.', '.', '.', '.'
                }, {
                '.', '.', '.', 'p', '.', '.', '.', '.'
        }, {
                '.', '.', '.', 'R', '.', '.', '.', 'p'
        }, {
                '.', '.', '.', '.', '.', '.', '.', '.'
        }, {
                '.', '.', '.', '.', '.', '.', '.', '.'
        }, {
                '.', '.', '.', 'p', '.', '.', '.', '.'
        }, {
                '.', '.', '.', '.', '.', '.', '.', '.'
        }, {
                '.', '.', '.', '.', '.', '.', '.', '.'
        }
        };

        int res = new NumRookCaptures().numRookCaptures(a);
        System.out.println(res);
    }
}
