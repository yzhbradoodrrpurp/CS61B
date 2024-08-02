import java.util.ArrayList;
import java.util.List;

public class JavaExercises {

    /** Returns an array [1, 2, 3, 4, 5, 6] */
    public static int[] makeDice() {
        int[] a={1,2,3,4,5,6};

        return a;
    }

    /** Returns the order depending on the customer.
     *  If the customer is Ergun, return ["beyti", "pizza", "hamburger", "tea"].
     *  If the customer is Erik, return ["sushi", "pasta", "avocado", "coffee"].
     *  In any other case, return an empty String[] of size 3. */
    public static String[] takeOrder(String customer) {

        if(customer.equals("Ergun")){
            String[] order={"beyti","pizza","hamburger","tea"};
            return order;
        }else if(customer.equals("Erik")){
            String[] order={"sushi","pasta","avocado","coffee"};
            return order;
        }

        String[] a=new String[3];

        return a;
    }

    /** Returns the positive difference between the maximum element and minimum element of the given array.
     *  Assumes array is nonempty. */
    public static int findMinMax(int[] array) {
        int minid=0,maxid=0;

        for(int i=0;i<array.length;i++)
            maxid=array[i]>array[maxid]?i:maxid;

        for(int j=0;j<array.length;j++)
            minid=array[j]<array[minid]?j:minid;

        return array[maxid]-array[minid];
    }

    /**
      * Uses recursion to compute the hailstone sequence as a list of integers starting from an input number n.
      * Hailstone sequence is described as:
      *    - Pick a positive integer n as the start
      *        - If n is even, divide n by 2
      *        - If n is odd, multiply n by 3 and add 1
      *    - Continue this process until n is 1
      */
    public static List<Integer> hailstone(int n) {
        return hailstoneHelper(n, new ArrayList<>());
    }

    private static List<Integer> hailstoneHelper(int x, List<Integer> list) {
        if(x!=1){
            list.add(x);

            if(x%2==0)
                hailstoneHelper(x/2,list);
            else if(x%2==1)
                hailstoneHelper(x*3+1,list);
        }else{
            list.add(1);
        }

        return list;
    }

}
