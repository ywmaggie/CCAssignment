import java.util.Scanner;

public class Solution07 {
    public static void main(String[] args) {
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(m);
        return;
    }

    // Rotate clock wise from the out layer, until we get to the middle of the matrix
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i != len/2; i ++){
            for(int j = i; j != len -i-1 ; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-j-1][i];
                matrix[len-j-1][i] = matrix[len-i-1][len-j-1];
                matrix[len-i-1][len-j-1] = matrix[j][len-i-1];
                matrix[j][len-i-1] = temp;
            }
        }
        for(int i = 0; i < len; i ++) {
            for (int j = 0; j < len; j++)
                System.out.print(matrix[i][j]);
            System.out.println("");
        }
        return;
    }
}