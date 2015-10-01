/**
 * Created by zhangyuwei on 9/30/15.
 */

/*
    We search from the right top corner, if the target number is bigger than the current number, we go down, otherwise,
    we go left.
    Because when the number is bigger than the current number, it cannot be in the left part of this number,
    so we choose to go down and discard the whole line on the left.
 */
public class Solution09 {
    public static void main(String[] args){
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
                };
        System.out.println(searchMatrix(matrix, 14));
    }

    public static boolean searchMatrix(int[][] matrix, int target){
        int row = 0, column = matrix[0].length-1;
        while (row < matrix.length && column >= 0){
            if (matrix[row][column] == target)
                return true;
            else if(matrix[row][column] > target)
                column --;
            else
                row ++;
        }
        return false;
    }
}
