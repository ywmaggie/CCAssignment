/**
 * Created by zhangyuwei on 9/30/15.
 */

/*
    I modified binary search to fit in this scenario, that I tried to check the middle position to see if
    it is empty or not, and ignore the empty string at the beginning and the end of string arrays.
 */

public class Solution05 {
    public static void main(String[] args){
        String[] words = {"at","","","","ball","","","car","","","dad","",""};
        int position = search(words, "ball");
        System.out.println(position);
    }
    public static int search(String[] words, String target){
        return binarySearch(words, target, 0, words.length-1);
    }

    public static int binarySearch(String[] words, String target, int left, int right){
        while(left <= right){
            int mid = (left + right)/2;
            while( mid <= right && words[mid] == "")
                mid ++;
            if(mid > right)
                right = (left+right)/2;
            else{
                if(words[mid].equals(target))
                    return mid;
                else if(words[mid].compareTo(target) > 0 )
                    right = mid -1;
                else
                    left = mid + 1;
            }
            while(left < words.length && words[left] == "")
                left ++;
            while(right > -1 && words[right] == "")
                right --;
        }

        return -1;
    }

}
