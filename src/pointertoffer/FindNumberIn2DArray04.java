package pointertoffer;

/**
 * @author lizhanzhan
 * @date 2020/8/2
 * @explanation 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */
public class FindNumberIn2DArray04 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0, j = cols - 1;
        while (i <= rows - 1 && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (matrix[i][j] < target) {
                ++i;
            } else {
                --j;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(FindNumberIn2DArray04.findNumberIn2DArray(matrix, 20));
    }
}
