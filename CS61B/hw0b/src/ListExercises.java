import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int sum=0;

        for(int i:L)
            sum+=i;
        /*
        for(int i:L)是一个增强型for循环，用于遍历L链表中的每一个元素。
        i就表示L链表中的每一个元素，类型为int。
        */

        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> a=new ArrayList<>();

        for(int i:L){
            if(i%2==0)
                a.add(i);
                //a.add()表示在链表a的末尾加上某个元素。
        }

        return a;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> a=new ArrayList<>();

        for(int i:L1) {
            if (L2.contains(i))
                //L2.contains()是一个boolean类型变量，表示L2链表中是否含有某个元素。
                a.add(i);
        }

        return a;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int cnt=0;

        for(String i:words){
            //由于链表words中的元素为String，那么i也应该定义为String类型。
            //i就表示链表words中的每一个String类型的字符串。
           for(int j=0;j<i.length();j++){
               if(i.charAt(j)==c)
                   cnt++;
           }
        }

        return cnt;
    }
}
