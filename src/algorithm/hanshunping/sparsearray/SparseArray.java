package algorithm.hanshunping.sparsearray;

/**
 * @author ltw
 * on 2019-12-27.
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始二维数组 11*11
        //0:表示 没有棋子 1 表示黑子 2 表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[9][8] = 2;
        for (int[] rows : chessArr1) {
            for (int row : rows) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }
}
