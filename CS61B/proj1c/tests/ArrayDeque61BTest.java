import deque.ArrayDeque61B;
import deque.Deque61B;

import org.junit.jupiter.api.Test;
import java.util.Iterator;
import static com.google.common.truth.Truth.assertThat;

public class ArrayDeque61BTest {
    /*
    ArrayDeque61B的大部分功能已经在之前的project中测试过了，
    所以现在需要测试的就是新写的方法。
    */

    @Test
    public void testIsEquals(){
        Deque61B<String> l1= new ArrayDeque61B<>();
        Deque61B<String> l2= new ArrayDeque61B<>();

        l1.addFirst("a");
        l1.addLast("c");
        l1.addFirst("b");

        l2.addFirst("a");
        l2.addLast("c");
        l2.addFirst("b");

        boolean result=l1.equals(l2);

        assertThat(result).isTrue();
    }

    @Test
    public void testIsNotEquals(){
        Deque61B<String> l1= new ArrayDeque61B<>();
        Deque61B<String> l2= new ArrayDeque61B<>();

        l1.addFirst("a");
        l1.addLast("c");
        l1.addFirst("b");

        l2.addFirst("a");
        l2.addLast("b");
        l2.addFirst("c");

        boolean result=l1.equals(l2);

        assertThat(result).isFalse();
    }

    @Test
    public void testToString(){
        Deque61B<String> l= new ArrayDeque61B<>();

        l.addFirst("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");

        System.out.println(l);

        assertThat(l.toString()).isEqualTo("[z, a, b, c]");
    }

    @Test
    public void testToStringOne(){
        Deque61B<String> l= new ArrayDeque61B<>();

        l.addFirst("a");
        System.out.println(l);

        assertThat(l.toString()).isEqualTo("[a]");
    }

    @Test
    public void testToStringNull(){
        Deque61B<String> l= new ArrayDeque61B<>();

        l.addFirst(null);
        l.addLast(null);
        l.addFirst(null);
        l.addLast(null);

        assertThat(l.toString()).isNull();
    }

    @Test
    public void testIterator(){
        Deque61B<String> l= new ArrayDeque61B<>();
        int cnt=0;

        l.addFirst("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");
        l.addFirst("y");
        l.addFirst("x");
        l.addLast("d");

        Iterator<String> seer=l.iterator();

        while(seer.hasNext()) {
            String item=seer.next();
            System.out.println(item);

            assertThat(item).isEqualTo(l.get(cnt));
            cnt++;
        }
    }

    @Test
    public void testAdvancedFor(){
        Deque61B<String> l= new ArrayDeque61B<>();
        int cnt=0;

        l.addFirst("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");
        l.addFirst("y");
        l.addFirst("x");
        l.addLast("d");


        for(String item:l) {
            System.out.println(item);

            assertThat(item).isEqualTo(l.get(cnt));
            cnt++;
        }
    }
}
