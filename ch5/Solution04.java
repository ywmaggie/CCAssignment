/**
 * Created by zhangyuwei on 10/4/15.
 */

/*
    Next Smallest: Set the rightmost 0 (with 1 on its right) to 1, and move all 1s on the right of that zero to the rightmost.
    Next Largest: Set the rightmost 1 (with 0 on its right) to 0, and move all 1s on the left to just behind the zero.
 */
public class Solution04 {
    public static void main(String[] args){
        System.out.println(nextSmallest(13948));
        System.out.println(nextLargest(10115));
    }

    public static int nextSmallest(int number){
        System.out.println(Integer.toBinaryString(number));
        int low1 = 0,low0 = 0,result = number;
        for(int i = 0; i < 31; i ++){
            if(((number >>i)&1) == 1){
                low1 = i;
                break;
            }
        }
        for(int i = low1; i < 31; i ++){
            if(((number >>i)&1) == 0){
                low0 = i;
                break;
            }
        }

        System.out.println(Integer.toString(low0) +"  "+ low1);
        result = result ^ (1<<low0)^(1<<(low0-1));
        System.out.println(Integer.toBinaryString(result));
        for(int i = low1; i < low0-1; i ++){
            result ^= 1<<i;
            System.out.println(Integer.toBinaryString(result));
            result |= 1<<(i-low1);
            System.out.println(Integer.toBinaryString(result));
        }
        return result;
    }

    public static int nextLargest(int number) {
        System.out.println(Integer.toBinaryString(number));
        int low1 = 0,low0 = 0,result = number;
        for(int i = 0; i < 31; i ++){
            if(((number >>i)&1) == 0){
                low0 = i;
                break;
            }
        }
        for(int i = low0; i < 31; i ++){
            if(((number >>i)&1) == 1){
                low1 = i;
                break;
            }
        }
        System.out.println(Integer.toString(low0) +"  "+ low1);
        result = result ^ (1<<low1)^(1<<(low1-1));
        System.out.println(Integer.toBinaryString(result));
        for(int i = 0; i < low0; i ++){
            result ^= 1<<i;
            System.out.println(Integer.toBinaryString(result));
            result |= 1<<(low1-2);
            System.out.println(Integer.toBinaryString(result));
        }
        return result;
    }
}
