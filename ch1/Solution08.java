import java.util.HashSet;

public class Solution08 {
    public static void main(String[] args) {
        int[][] m= {{1,2,3},{4,0,0},{7,8,9}};
        zeroMatrix(m,3,3);
        return;
    }

    // We use two hashsets to keep track of row numbers and column numbers
    // which contains zero
    // later, we set all rows and columns that are recorded in the Hashset to zero
    public static void zeroMatrix(int[][] matrix, int m, int n){
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> column = new HashSet<>();
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    column.add(j);
                }
            }
        }
        for(int i = 0; i < m; i ++) {
            if (row.contains(i)) {
                for (int j = 0; j < n; j++)
                    matrix[i][j] = 0;
            }
        }

        for(int j = 0; j < n; j ++){
            if(column.contains(j)){
                for(int i = 0; i < m; i ++)
                    matrix[i][j] = 0;
            }
        }

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++)
                System.out.print(matrix[i][j]);
            System.out.println("");
        }
        return;
    }
}
