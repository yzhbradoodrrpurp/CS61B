package DisjointSet;

import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;


public class DisjointSetTest {

    @Test
    public void test1(){
        set1 s=new set1();

        s.connect(1,2);
        s.connect(2,3);
        s.connect(1,4);

        s.connect(0,5);
        s.connect(0,6);
        s.connect(0,2);

        assertThat(s.isConnected(1,3)).isTrue();
        assertThat(s.isConnected(3,4)).isTrue();
        assertThat(s.isConnected(5,6)).isTrue();
        assertThat(s.isConnected(1,6)).isTrue();

        assertThat(s.isConnected(1,7)).isFalse();
    }

    @Test
    public void test2(){
        set1 s=new set1();

        s.connect(0,1);
        s.connect(1,2);
        s.connect(2,3);
        s.connect(3,4);
        s.connect(4,5);
        s.connect(5,6);
        s.connect(6,7);

        assertThat(s.isConnected(0,1)).isTrue();
    }
}