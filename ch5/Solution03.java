/**
 * Created by zhangyuwei on 10/4/15.
 */

/*
    If we have got a 0 in the sequence, we look at how 1s are before that 0 and how many 1s are after that zero.
    We record these numbers and pass on the end of the sequence, and we will get the longest 1s after modification.
 */

public class Solution03 {
    public static void main(String[] args){
        System.out.println(flipBitToWin(1775));
    }
    public static int flipBitToWin(int number){
        int[] bits = new int[32];
        for(int i = 0; i != 32; i ++){
            bits[i] = (number>>i) & 1;
        }
        for(int i:bits)
            System.out.print(i);
        int[] length = new int[32];
        for(int i = 0; i != 32; i ++)
            length[i] = 0;

        int begin = 0, end = 0;
        while(true){
            while(end<32 && bits[begin] == bits[end])
                end++;
            if(end==32)
                break;
            if(bits[begin] == 1){
                length[begin] = end-begin;
                length[end-1] = end-begin;
            }
            begin = end;
        }
        if(bits[begin] == 1){
            length[begin] = end-begin;
            length[end-1] = end-begin;
        }
        for(int i:length)
            System.out.println(i);
        int maxlen = length[0];
        if(bits[0] == 0){
            maxlen = Math.max(maxlen, 1+length[1]);
        }
        if(bits[31] == 0)
            maxlen = Math.max(maxlen, 1+length[30]);

        for(int i = 1; i != 31; i ++){
            if(bits[i] == 0){
                if(bits[i-1] == 1 && bits[i+1] ==1)
                    maxlen = Math.max(maxlen, length[i-1]+length[i+1]+1);
                else
                    maxlen = Math.max(maxlen, Math.max(length[i-1], length[i+1])+1);
            }
        }
        return maxlen;
    }
}
