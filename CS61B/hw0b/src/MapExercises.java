import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
map表示一种对应关系，是一种键值对的数据结构(key-value pair),允许用户通过键来查找对应的值。
map分为两种，一种是TreeMap，另一种是HashMap，在使用前import java.util.TreeMap或者java.util.HashMap。
每一个键都是唯一的，若重复对一个键进行赋值则会覆盖原有的值。
*/

/*
创建一个map例子：Map<Integer,String> a=new HashMap<>();
如上所示，a就是一个map，键的类型为int，值的类型为String。

对a插入键值对：a.put(5,"Zhihang Yi");
那么5就是键，对应的值就是Zhihang Yi。

对a中的值进行查找：a.get(5);
就会得到String类型的值zhihang Yi。

对a的键值对进行删除操作：a.remove(5);
如此就会删除掉5和Zhihang Yi的对应关系。

对map的键进行遍历：for(int i:a.keySet());
对map的键值对进行遍历：for(Map.Entry<Integer,String> i:map.entrySet());
*/


public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character,Integer> a=new TreeMap<>();
        int i;

        for(i=1;i<=26;i++) {
            a.put((char)('a'-1+i),i);
        }

        return a;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        if(nums==null)
            return null;

        Map<Integer,Integer> a=new TreeMap<>();

        for(int i:nums)
            a.put(i,i*i);

        return a;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        if(words==null)
            return null;

        Map<String,Integer> a=new TreeMap<>();

        for(String j:words){
            int cnt=0;

            for(String k:words){
                if(j.equals(k))
                    cnt++;
            }

            a.put(j,cnt);
        }

        return a;
    }
}
