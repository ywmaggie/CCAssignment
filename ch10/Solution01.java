/**
 * Created by zhangyuwei on 9/27/15.
 */

 /*
    We look from the end of array A, and compare A and B from the end.
    We move the bigger one to the end of array A, until we get to the end of any array.
    If we still left some elements in A, that's OK, we already have the 
    sorted result.
    If some elements are left in B, we copy them to A from the current 'end' point.
 */
public class Solution01 {
    public static void main(String[] args){
        int[] a = {1,3,4,6,8,10,0,0,0,0};
        int[] b = {2,5,7,9};
        sortedMerge(a,b,5);
        for(int i:a){
            System.out.println(i);
        }
        return;
    }

    public static void sortedMerge(int[] a, int[] b, int endA){
        int posA = endA, posB = b.length-1, end = a.length-1;
        while(posA >= 0 && posB >= 0){
            if(a[posA] > b[posB]){
                a[end] = a[posA];
                posA --;
            }
            else{
                a[end] = b[posB];
                posB --;
            }
            end --;
        }
        if (posB >= 0){
            a[end] = b[posB];
            end --;
            posB --;
        }
        return;
    }
}
