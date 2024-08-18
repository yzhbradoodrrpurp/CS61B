import org.junit.jupiter.api.*;

import java.util.Comparator;
import deque.MaxArrayDeque61B;

import static com.google.common.truth.Truth.assertThat;

public class MaxArrayDeque61BTest {
    private static class StringLengthComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    }
    
    private static class AlphabeticComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    }

    private static class MaxIntArrayDeque61BTest implements Comparator<Integer>{
        public int compare(Integer a,Integer b){
            return a-b;
        }
    }

    @Test
    public void basicTest() {
        MaxArrayDeque61B<String> mad = new MaxArrayDeque61B<>(new StringLengthComparator());
        mad.addFirst("");
        mad.addFirst("2");
        mad.addFirst("fury road");
        assertThat(mad.max()).isEqualTo("fury road");
    }

    @Test
    public void testAlphabetic() {
        MaxArrayDeque61B<String> mad = new MaxArrayDeque61B<>(new StringLengthComparator());
        mad.addFirst("a");
        mad.addFirst("b");
        mad.addFirst("z");

        assertThat(mad.max(new AlphabeticComparator())).isEqualTo("z");
    }

    @Test
    public void testInt(){
        MaxArrayDeque61B<Integer> l=new MaxArrayDeque61B<>(new MaxIntArrayDeque61BTest());

        l.addFirst(1);
        l.addFirst(2);
        l.addLast(19);
        l.addLast(21);

        assertThat(l.max()).isEqualTo(21);
    }
}
