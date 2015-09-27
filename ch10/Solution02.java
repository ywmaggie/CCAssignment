import java.util.*;

/**
 * Created by zhangyuwei on 9/27/15.
 */

/*
    We create a hash map, which key is the sorted form of a string, and value is the lsit of original strings that can
    be sorted to the key.
    Thus, we can put each string in the hashmap, and print our the map.

    reference: http://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
 */
public class Solution02 {
    public static void main(String[] args){
        String[] group= {"123","321","456","654","231"};
        groupAnagrams(group);
        for(String s:group)
            System.out.println(s);
        return;
    }

    public static void groupAnagrams(String[] stringArray){
        HashMap<String, ArrayList> bucket= new HashMap<>();
        for(String s: stringArray){
            String k = key(s);
            if(bucket.containsKey(k)){
                bucket.get(k).add(s);
            }
            else{
                ArrayList<String> a = new ArrayList<>();
                a.add(s);
                bucket.put(key(s),a);
            }
        }
        Iterator it = bucket.entrySet().iterator();
        int i = 0;
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            ArrayList<String> arr = (ArrayList<String>)pair.getValue();
            for(String str:arr){
                stringArray[i++] = str;
            }
            it.remove();

        }


         /* from book solutions
            int index = 0;
            for(String s:bucket.keySet()){
                ArrayList<String> b = bucket.get(s);
                for(String str:b){
                    stringArray[index++] = str;
                }
            }
         */
    }

    public static String key(String s){
        char[] charS = s.toCharArray();
        Arrays.sort(charS);
        return charS.toString();
    }
}
