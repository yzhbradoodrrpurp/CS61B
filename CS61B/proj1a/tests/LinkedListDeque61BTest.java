import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/** Performs some basic linked list tests. */
public class LinkedListDeque61BTest {

     @Test
     /* In this test, we have three different assert statements that verify that addFirst works correctly. */
     public void addFirstTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addFirst("back"); // after this call we expect: ["back"]
         assertThat(lld1.toList()).containsExactly("back").inOrder();

         lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
         assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

         lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

         /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
            to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
            but not ["front", "middle", "back"].
          */
     }

     @Test
     /* In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
      *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
     public void addLastTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addLast("front"); // after this call we expect: ["front"]
         lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
         lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
     }

     @Test
     /* This test performs interspersed addFirst and addLast calls. */
     public void addFirstAndAddLastTest() {
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         /* I've decided to add in comments the state after each call for the convenience of the
            person reading this test. Some programmers might consider this excessively verbose. */
         lld1.addLast(0);   // [0]
         lld1.addLast(1);   // [0, 1]
         lld1.addFirst(-1); // [-1, 0, 1]
         lld1.addLast(2);   // [-1, 0, 1, 2]
         lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

         assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
     }

//Below, you'll write your own tests for LinkedListDeque61B.

    @Test
    public void addFirstRepeated(){
        Deque61B<Integer> l=new LinkedListDeque61B<>();

        l.addFirst(5);
        l.addFirst(5);
        l.addFirst(5);
        l.addFirst(5);
        l.addFirst(5);

        assertThat(l.toList()).containsExactly(5,5,5,5,5).inOrder();
    }

    @Test
    public void addFirstOneItem(){
        Deque61B<Integer> l=new LinkedListDeque61B<>();

        l.addFirst(1);

        assertThat(l.toList()).containsExactly(1).inOrder();
    }

    @Test
    public void addFirstRepeatedAndNot(){
        Deque61B<Integer> l=new LinkedListDeque61B<>();

        l.addFirst(1);
        l.addFirst(1);
        l.addFirst(1);
        l.addFirst(1);
        l.addFirst(2);

        assertThat(l.toList()).containsExactly(2,1,1,1,1).inOrder();
    }

    @Test
    public void addLastRepeated(){
        Deque61B<Integer> l=new LinkedListDeque61B<>();

        l.addFirst(5);
        l.addFirst(5);
        l.addFirst(5);
        l.addFirst(5);
        l.addFirst(5);

        assertThat(l.toList()).containsExactly(5,5,5,5,5).inOrder();
    }

    @Test
    public void addLastOneItem(){
        Deque61B<Integer> l=new LinkedListDeque61B<>();
        l.addFirst(1);

        assertThat(l.toList()).containsExactly(1).inOrder();
    }

    @Test
    public void addLastRepeatedAndNot(){
        Deque61B<Integer> l=new LinkedListDeque61B<>();

        l.addLast(1);
        l.addLast(1);
        l.addLast(1);
        l.addLast(1);
        l.addLast(2);

        assertThat(l.toList()).containsExactly(1,1,1,1,2).inOrder();
    }

    @Test
    public void addFirstAndAddLastNull(){
         Deque61B<Integer> l=new LinkedListDeque61B<>();

         l.addFirst(1);
         l.addLast(2);
         l.addLast(null);
         l.addLast(3);
         l.addFirst(null);
         l.addFirst(0);
         l.addLast(null);

         assertThat(l.toList()).containsExactly(0,1,2,3).inOrder();
    }

    @Test
    public void multipleNull(){
         Deque61B<String> l=new LinkedListDeque61B<>();

         l.addFirst(null);
         l.addLast(null);
         l.addFirst(null);
         l.addLast(null);

         assertThat(l.toList()).isEqualTo(null);
    }

    @Test
    public void isEmptyTest1(){
         Deque61B<String> l=new LinkedListDeque61B<>();

         l.addFirst("a");
         l.addFirst("b");
         l.addFirst("c");
         l.addFirst(null);
         l.addLast("h");
         l.addLast("r");

         assertThat(l.isEmpty()).isFalse();
    }

    @Test
    public void isEmptyTest2(){
         Deque61B<String> l=new LinkedListDeque61B<>();

         l.addFirst(null);
         l.addLast(null);
         l.addFirst(null);
         l.addLast(null);
         l.addFirst(null);
         l.addLast(null);

         assertThat(l.isEmpty()).isTrue();
    }

    @Test
    public void sizeTestNormal(){
         Deque61B<String> l=new LinkedListDeque61B<>();

         l.addFirst("a");
         l.addFirst("z");
         l.addFirst("y");
         l.addLast("b");
         l.addLast("c");
         l.addLast("d");

         assertThat(l.size()).isEqualTo(6);
    }

    @Test
    public void sizeTestOneItem(){
        Deque61B<String> l=new LinkedListDeque61B<>();

        l.addFirst("a");

        assertThat(l.size()).isEqualTo(1);
    }

    @Test
    public void sizeTestNull(){
         Deque61B<String> l=new LinkedListDeque61B<>();

         l.addFirst(null);

         assertThat(l.size()).isEqualTo(0);
    }

    @Test
    public void sizeTestMultipleNull(){
         Deque61B<String> l=new LinkedListDeque61B<>();

         l.addFirst(null);
         l.addLast(null);
         l.addFirst(null);
         l.addLast(null);

        assertThat(l.size()).isEqualTo(0);
    }

    @Test
    public void getTestNormal(){
         Deque61B<String> l=new LinkedListDeque61B<>();

         l.addFirst("a");
         l.addLast("b");
         l.addLast("c");
         l.addFirst("z");
         l.addLast("d");
         l.addFirst("y");

         assertThat(l.get(3)).isEqualTo("b");
    }

    @Test
    public void getTestBeyondScope(){
         Deque61B<String> l=new LinkedListDeque61B<>();

         l.addFirst("a");

         assertThat(l.get(1)).isNull();
    }

    @Test
    public void getTestNegativeIndex(){
         Deque61B<String> l=new LinkedListDeque61B<>();

         l.addFirst("a");
         l.addLast("b");
         l.addLast("c");
         l.addFirst("z");

         assertThat(l.get(-1)).isNull();
    }

    @Test
    public void getTestRecursiveNormal(){
        Deque61B<String> l=new LinkedListDeque61B<>();

        l.addFirst("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");
        l.addLast("d");
        l.addFirst("y");

        assertThat(l.getRecursive(3)).isEqualTo("b");
    }

    @Test
    public void getTestRecursiveBeyondScope(){
        Deque61B<String> l=new LinkedListDeque61B<>();

        l.addFirst("a");

        assertThat(l.getRecursive(1)).isNull();
    }

    @Test
    public void getTestRecursiveNegativeIndex(){
        Deque61B<String> l=new LinkedListDeque61B<>();

        l.addFirst("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");

        assertThat(l.getRecursive(-1)).isNull();
    }

    @Test
    public void testRemoveFirstNormal(){
         Deque61B<String> l=new LinkedListDeque61B<>();

         l.addFirst("a");
         l.addLast("b");
         l.addLast("c");
         l.addFirst("z");
         l.addLast("d");
         l.addFirst("y");

         String removedItem=l.removeFirst();

         assertThat(removedItem).isEqualTo("y");
         assertThat(l.size()).isEqualTo(5);
         assertThat(l.get(0)).isEqualTo("z");
    }

    @Test
    public void testRemoveLastNormal(){
        Deque61B<String> l=new LinkedListDeque61B<>();

        l.addFirst("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");
        l.addLast("d");
        l.addFirst("y");

        String removedItem=l.removeLast();

        assertWithMessage("The removedItem is not \"d\".")
                .that(removedItem).isEqualTo("d");

        assertWithMessage("The size is not 5.")
                .that(l.size()).isEqualTo(5);

        assertWithMessage("The last Item isn't \"c\".")
                .that(l.get(l.size()-1)).isEqualTo("c");
    }

    @Test
    public void testRemoveSingleNull(){
         Deque61B<String> l=new LinkedListDeque61B<>();

         l.addFirst(null);

         String removedItem=l.removeFirst();

         assertThat(removedItem).isNull();
    }

    @Test
    public void testRemoveMultipleNull(){
         Deque61B<String> l=new LinkedListDeque61B<>();

         l.addFirst(null);
         l.addLast(null);
         l.addFirst(null);
         l.addLast(null);
         l.addFirst(null);
         l.addLast(null);

         String removedItem1 =l. removeFirst();
         String removedItem2 =l. removeLast();

         assertWithMessage("removedItem1 is not null.")
                 .that(removedItem1).isNull();

         assertWithMessage("removedItem2 is not null.")
                 .that(removedItem2).isNull();

         assertWithMessage("The size is not zero.")
                 .that(l.size()).isEqualTo(0);
    }

    @Test
    public void testRemoveOneItem(){
         Deque61B<String> l=new LinkedListDeque61B<>();

         l.addFirst("a");

         String removedItem=l.removeLast();

         assertWithMessage("The removedItem isn't \"a\".")
                 .that(removedItem).isEqualTo("a");

         assertWithMessage("The size isn't 0.")
                 .that(l.size()).isEqualTo(0);
    }

    @Test
    public void addFirstAfterRemoveAll() {
         Deque61B<String> l=new LinkedListDeque61B<>();

        l.addLast("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");
        l.addFirst("y");

        int loopTimes=l.size();

        for(int i=0;i<loopTimes;i++)
            l.removeFirst();

        assertWithMessage("The size isn't 0.")
                .that(l.size()).isEqualTo(0);

        l.addFirst("a");

        assertWithMessage("The added item isn't \"a\".")
                .that(l.get(0)).isEqualTo("a");
    }

    @Test
    public void addLastAfterRemoveAll() {
        Deque61B<String> l=new LinkedListDeque61B<>();

        l.addLast("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");
        l.addFirst("y");

        int loopTimes=l.size();

       for(int i=0;i<loopTimes;i++)
           l.removeLast();

        assertWithMessage("The size isn't 0.")
                .that(l.size()).isEqualTo(0);

        l.addLast("a");

        assertWithMessage("The added item isn't \"a\".")
                .that(l.get(0)).isEqualTo("a");

    }
}