package string;


/**
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2018-11-22
 */
public class JudgeCircle657 {
    public static boolean judgeCircle(String moves) {
        int verticalSum = 0;
        int horizontalSum = 0;

        char[] chars = moves.toCharArray();
        for (char index : chars){
            if (index == 'L'){
                horizontalSum ++;
            }
            else if (index == 'R'){
                horizontalSum --;
            }
            else if (index == 'U'){
                verticalSum ++;
            }
            else {
                verticalSum --;
            }
        }
        if (verticalSum ==0 && horizontalSum==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = judgeCircle("UUUUD");
        System.out.println(res);
    }
}
