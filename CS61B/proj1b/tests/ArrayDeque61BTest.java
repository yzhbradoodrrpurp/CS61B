import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

     @Test
     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
     void noNonTrivialFields() {
         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                 .toList();

         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
     }

     @Test
    public void testAddFirstNormal1(){
         Deque61B<Integer> l=new ArrayDeque61B<>();

         l.addFirst(1);
         l.addFirst(2);
         l.addFirst(3);

         assertThat(l.get(0)).isEqualTo(3);
         assertThat(l.get(1)).isEqualTo(2);
         assertThat(l.get(2)).isEqualTo(1);

         assertThat(l.toList()).containsExactly(3,2,1).inOrder();
     }

    @Test
    public void testAddFirstNormal2(){
        Deque61B<Integer> l=new ArrayDeque61B<>();

        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        l.addFirst(4);
        l.addFirst(5);
        l.addFirst(6);
        l.addFirst(7);


        assertThat(l.get(0)).isEqualTo(7);
        assertThat(l.get(1)).isEqualTo(6);
        assertThat(l.get(2)).isEqualTo(5);
        assertThat(l.get(3)).isEqualTo(4);
        assertThat(l.get(4)).isEqualTo(3);
        assertThat(l.get(5)).isEqualTo(2);
        assertThat(l.get(6)).isEqualTo(1);

        assertThat(l.toList()).containsExactly(7,6,5,4,3,2,1).inOrder();
    }

     @Test
    public void testAddFirstOneItem(){
         Deque61B<String> l=new ArrayDeque61B<>();

         l.addFirst("a");

        assertThat(l.get(0)).isEqualTo("a");
     }

     @Test
    public void testAddFirstNull(){
         Deque61B<String> l=new ArrayDeque61B<>();

         l.addFirst(null);
         l.addFirst(null);
         l.addFirst(null);

         assertWithMessage("The first item isn't null.")
                .that(l.get(0)).isNull();
     }

    @Test
    public void testAddLastNormal1(){
        Deque61B<Integer> l=new ArrayDeque61B<>();

        l.addLast(5);
        l.addLast(3);
        l.addLast(9);


        assertThat(l.get(l.size()-1)).isEqualTo(9);
        assertThat(l.get(l.size()-2)).isEqualTo(3);
        assertThat(l.get(l.size()-3)).isEqualTo(5);

        assertThat(l.toList()).containsExactly(5,3,9).inOrder();
    }

    @Test
    public void testAddLastNormal2(){
        Deque61B<Integer> l=new ArrayDeque61B<>();

        l.addLast(5);
        l.addLast(2);
        l.addLast(7);
        l.addLast(4);
        l.addLast(0);
        l.addLast(22);
        l.addLast(77);


        assertThat(l.get(l.size()-1)).isEqualTo(77);
        assertThat(l.get(l.size()-2)).isEqualTo(22);
        assertThat(l.get(l.size()-3)).isEqualTo(0);
        assertThat(l.get(l.size()-4)).isEqualTo(4);
        assertThat(l.get(l.size()-5)).isEqualTo(7);
        assertThat(l.get(l.size()-6)).isEqualTo(2);
        assertThat(l.get(l.size()-7)).isEqualTo(5);

        assertThat(l.toList()).containsExactly(5,2,7,4,0,22,77).inOrder();
    }

    @Test
    public void testAddLastOneItem(){
        Deque61B<String> l=new ArrayDeque61B<>();

        l.addLast("a");

        assertThat(l.get(l.size()-1)).isEqualTo("a");
    }

    @Test
    public void testAddLastNull(){
        Deque61B<String> l=new ArrayDeque61B<>();

        l.addLast(null);
        l.addLast(null);
        l.addLast(null);

        assertWithMessage("The last item isn't null.")
                .that(l.get(l.size()-1)).isNull();
    }

    @Test
    public void testAddFirstAndAddLast(){
        Deque61B<Integer> l=new ArrayDeque61B<>();

        l.addLast(5);
        l.addLast(2);
        l.addFirst(2);
        l.addFirst(3);
        l.addLast(4);
        l.addLast(0);
        l.addFirst(6);
        l.addLast(7);

        assertThat(l.get(0)).isEqualTo(6);
        assertThat(l.get(1)).isEqualTo(3);
        assertThat(l.get(2)).isEqualTo(2);
        assertThat(l.get(3)).isEqualTo(5);
        assertThat(l.get(4)).isEqualTo(2);
        assertThat(l.get(5)).isEqualTo(4);
        assertThat(l.get(6)).isEqualTo(0);
        assertThat(l.get(7)).isEqualTo(7);

        assertThat(l.toList()).containsExactly(6,3,2,5,2,4,0,7).inOrder();
    }

    @Test
    public void testAddFirstResize(){
         Deque61B<String> l=new ArrayDeque61B<>();

         l.addFirst("a");
         l.addFirst("b");
         l.addFirst("c");
         l.addFirst("d");
         l.addFirst("e");
         l.addFirst("f");
         l.addFirst("g");
         l.addFirst("h");
         l.addFirst("i");
         l.addFirst("j");
         l.addFirst("k");
         l.addFirst("l");
         l.addFirst("m");
         l.addFirst("n");
         l.addFirst("o");
         l.addFirst("p");
         l.addFirst("q");
         l.addFirst("r");
         l.addFirst("s");
         l.addFirst("t");
         l.addFirst("u");
         l.addFirst("v");
         l.addFirst("w");
         l.addFirst("x");
         l.addFirst("y");
         l.addFirst("z");
         l.addLast("wet");
         l.addLast("dreams");

         assertThat(l.toList()).containsExactly("z","y","x","w","v","u","t","s","r","q","p","o","n","m","l","k","j","i","h","g","f","e","d","c","b","a","wet","dreams").inOrder();
     }

     @Test
    public void testAddLastResize(){
        Deque61B<String> l=new ArrayDeque61B<>();

        l.addLast("a");
        l.addLast("b");
        l.addLast("c");
        l.addLast("d");
        l.addLast("e");
        l.addLast("f");
        l.addLast("g");
        l.addLast("h");
        l.addLast("i");
        l.addLast("j");
        l.addLast("k");
        l.addLast("l");
        l.addLast("m");
        l.addLast("n");
        l.addLast("o");
        l.addLast("p");
        l.addLast("q");
        l.addLast("r");
        l.addLast("s");
        l.addLast("t");
        l.addLast("u");
        l.addLast("v");
        l.addLast("w");
        l.addLast("x");
        l.addLast("y");
        l.addLast("z");

        assertThat(l.toList()).containsExactly("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z").inOrder();
    }

    @Test
    public void testAddComprehensiveResize(){
         Deque61B<String> l=new ArrayDeque61B<>();

        l.addFirst("a");
        l.addLast("b");
        l.addFirst("c");
        l.addLast("d");
        l.addFirst("e");
        l.addLast("f");
        l.addFirst("g");
        l.addLast("h");
        l.addFirst("i");
        l.addLast("j");
        l.addFirst("k");
        l.addLast("l");
        l.addFirst("m");
        l.addLast("n");
        l.addFirst("o");
        l.addLast("p");
        l.addFirst("q");
        l.addLast("r");
        l.addFirst("s");
        l.addLast("t");

        assertThat(l.toList()).containsExactly("s","q","o","m","k","i","g","e","c","a","b","d","f","h","j","l","n","p","r","t").inOrder();
    }

    @Test
    public void testGet(){
         Deque61B<String> l=new ArrayDeque61B<>();

         l.addFirst("a");
         l.addLast("b");
         l.addFirst("c");
         l.addLast("d");
         l.addFirst("e");
         l.addLast("f");
         l.addFirst("g");
         l.addLast("h");
        l.addFirst("i");
        l.addLast("j");
        l.addFirst("k");
        l.addLast("l");
        l.addFirst("m");
        l.addLast("n");
        l.addFirst("o");
        l.addLast("p");
        l.addLast("what");
        l.addLast("yep");

        assertThat(l.get(0)).isEqualTo("o");
        assertThat(l.get(1)).isEqualTo("m");
        assertThat(l.get(2)).isEqualTo("k");
        assertThat(l.get(3)).isEqualTo("i");
        assertThat(l.get(4)).isEqualTo("g");
        assertThat(l.get(5)).isEqualTo("e");
        assertThat(l.get(6)).isEqualTo("c");
        assertThat(l.get(7)).isEqualTo("a");
        assertThat(l.get(8)).isEqualTo("b");
        assertThat(l.get(9)).isEqualTo("d");
        assertThat(l.get(10)).isEqualTo("f");
        assertThat(l.get(11)).isEqualTo("h");
        assertThat(l.get(12)).isEqualTo("j");
        assertThat(l.get(13)).isEqualTo("l");
        assertThat(l.get(14)).isEqualTo("n");
        assertThat(l.get(15)).isEqualTo("p");
        assertThat(l.get(16)).isEqualTo("what");
        assertThat(l.get(17)).isEqualTo("yep");
    }

    @Test
    public void testGetNegative(){
         Deque61B<String> l=new ArrayDeque61B<>();

        l.addFirst("a");
        l.addLast("b");
        l.addFirst("c");
        l.addLast("d");

        assertThat(l.get(-2)).isEqualTo(null);
    }

    @Test
    public void testGetBeyondScope(){
        Deque61B<String> l=new ArrayDeque61B<>();

        l.addFirst("a");
        l.addLast("b");
        l.addFirst("c");
        l.addLast("d");

        assertThat(l.get(10)).isEqualTo(null);
    }

    @Test
    public void testEmpty(){
         Deque61B<Integer> l=new ArrayDeque61B<>();

         l.addFirst(null);
         l.addLast(null);
         l.addFirst(null);
         l.addLast(null);

         assertThat(l.isEmpty()).isTrue();
    }

    @Test
    public void testNoneEmptyNormal(){
         Deque61B<Integer> l=new ArrayDeque61B<>();

         l.addFirst(1);
         l.addFirst(2);
         l.addFirst(3);
         l.addFirst(4);
         l.addFirst(5);
         l.addFirst(6);
         l.addFirst(7);
         l.addFirst(8);

         assertThat(l.isEmpty()).isFalse();
    }

    @Test
    public void testToList(){
        Deque61B<String> l=new ArrayDeque61B<>();

        l.addLast("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");
        l.addFirst("y");
        l.addFirst("x");
        l.addLast("d");

        assertThat(l.toList()).containsExactly("x","y","z","a","b","c","d").inOrder();
    }

    @Test
    public void testToListNull(){
         Deque61B<String> l=new ArrayDeque61B<>();

         l.addFirst(null);
         l.addLast(null);
        l.addFirst(null);
        l.addLast(null);

        assertThat(l.toList()).isNull();
    }

    @Test
    public void testRemoveFirst(){
         Deque61B<String> l=new ArrayDeque61B<>();

         l.addLast("a");
         l.addLast("b");
         l.addLast("c");
         l.addFirst("z");
         l.addFirst("y");
         l.addFirst("x");

         String removedItem=l.removeFirst();

         assertThat(removedItem).isEqualTo("x");
         assertThat(l.toList()).containsExactly("y","z","a","b","c").inOrder();
    }

    @Test
    public void testAddFirstAfterRemoveToEmpty(){
        Deque61B<String> l=new ArrayDeque61B<>();

        l.addLast("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");
        l.addFirst("y");
        l.addFirst("x");

        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();

        String removedItem=l.removeFirst();

        l.addFirst("hhh");

        assertThat(removedItem).isEqualTo("c");
        assertThat(l.toList()).containsExactly("hhh").inOrder();
    }

    @Test
    public void testAddFirstAfterRemoveToOne(){
        Deque61B<String> l=new ArrayDeque61B<>();

         l.addLast("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");
        l.addFirst("y");
        l.addFirst("x");

        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();

        l.addFirst("hhh");

        assertThat(l.toList()).containsExactly("hhh","c").inOrder();
    }

    @Test
    public void testRemoveFirstResizeDown(){
         Deque61B<String> l=new ArrayDeque61B<>();

        l.addLast("a");
        l.addLast("b");
        l.addLast("c");
        l.addLast("d");
        l.addLast("e");
        l.addLast("f");
        l.addLast("g");
        l.addLast("h");
        l.addLast("i");
        l.addLast("j");
        l.addLast("k");
        l.addLast("l");
        l.addLast("m");
        l.addLast("n");
        l.addLast("o");
        l.addLast("p");
        l.addLast("q");
        l.addLast("r");
        l.addLast("s");
        l.addLast("t");
        l.addLast("u");
        l.addLast("v");
        l.addLast("w");
        l.addLast("x");
        l.addLast("y");
        l.addLast("z");

        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();

       assertThat(l.toList()).containsExactly("y","z").inOrder();
    }

    @Test
    public void testRemoveLast(){
        Deque61B<String> l=new ArrayDeque61B<>();

        l.addLast("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");
        l.addFirst("y");
        l.addFirst("x");

        String removedItem=l.removeLast();

        assertThat(removedItem).isEqualTo("c");
        assertThat(l.toList()).containsExactly("x","y","z","a","b").inOrder();
    }

    @Test
    public void testAddLastAfterRemoveToEmpty(){
        Deque61B<String> l=new ArrayDeque61B<>();

        l.addLast("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");
        l.addFirst("y");
        l.addFirst("x");

        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();

        String removedItem=l.removeLast();

        l.addLast("hhh");

        assertThat(removedItem).isEqualTo("x");
        assertThat(l.toList()).containsExactly("hhh").inOrder();
    }

    @Test
    public void testAddLastAfterRemoveToOne(){
        Deque61B<String> l=new ArrayDeque61B<>();

        l.addLast("a");
        l.addLast("b");
        l.addLast("c");
        l.addFirst("z");
        l.addFirst("y");
        l.addFirst("x");

        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();

        l.addLast("hhh");

        assertThat(l.toList()).containsExactly("x","hhh").inOrder();
    }

    @Test
    public void testRemoveLastResizeDown(){
        Deque61B<String> l=new ArrayDeque61B<>();

        l.addLast("a");
        l.addLast("b");
        l.addLast("c");
        l.addLast("d");
        l.addLast("e");
        l.addLast("f");
        l.addLast("g");
        l.addLast("h");
        l.addLast("i");
        l.addLast("j");
        l.addLast("k");
        l.addLast("l");
        l.addLast("m");
        l.addLast("n");
        l.addLast("o");
        l.addLast("p");
        l.addLast("q");
        l.addLast("r");
        l.addLast("s");
        l.addLast("t");
        l.addLast("u");
        l.addLast("v");
        l.addLast("w");
        l.addLast("x");
        l.addLast("y");
        l.addLast("z");

        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();

        assertThat(l.toList()).containsExactly("a","b").inOrder();
    }

    @Test
    public void testRemoveComprehensive(){
        Deque61B<String> l=new ArrayDeque61B<>();

         l.addLast("a");
        l.addLast("b");
        l.addLast("c");
        l.addLast("d");
        l.addLast("e");
        l.addLast("f");
        l.addLast("g");
        l.addLast("h");
        l.addLast("i");
        l.addLast("j");
        l.addLast("k");
        l.addLast("l");
        l.addLast("m");
        l.addLast("n");
        l.addLast("o");
        l.addLast("p");
        l.addLast("q");
        l.addLast("r");
        l.addLast("s");
        l.addLast("t");
        l.addLast("u");
        l.addLast("v");
        l.addLast("w");
        l.addLast("x");
        l.addLast("y");
        l.addLast("z");

        l.removeFirst();
        l.removeLast();
        l.removeFirst();
        l.removeLast();
        l.removeFirst();
        l.removeLast();
        l.removeFirst();
        l.removeLast();
        l.removeFirst();
        l.removeLast();
        l.removeFirst();
        l.removeLast();
        l.removeFirst();
        l.removeLast();
        l.removeFirst();
        l.removeLast();
        l.removeFirst();
        l.removeLast();
        l.removeFirst();
        l.removeLast();
        l.removeFirst();
        l.removeLast();
        l.removeFirst();
        l.removeLast();

        assertThat(l.toList()).containsExactly("m","n").inOrder();
    }
}
