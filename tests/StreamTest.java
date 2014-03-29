import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 */
@RunWith(JUnit4.class)
public class StreamTest {

    private List<Integer> nrlist = Arrays.asList(1, 2, 3, 4, 5);

    //Filter
    @Test
    public void shouldFilterList(){
        assertEquals(5, nrlist.size());
        assertEquals(2, nrlist.stream().filter(nr -> nr > 3).count());

    }

    @Test
    public void shouldMapLargestNrToListofStrings(){
        List<String> nrstream = nrlist.stream().filter(nr -> nr > 3).map(nr -> String.valueOf(nr)).collect(Collectors.toCollection(ArrayList::new));
        assertTrue(nrstream != null);
        assertEquals(5, nrlist.size());
        assertEquals(1, nrlist.get(0).intValue());
    }
    //Sorted
    //TODO

    //Map
    @Test
    public void shouldMapLargestNrToString(){
//        Stream<String> nrstream = nrlist.stream().filter(nr -> nr > 4).map(nr -> String.valueOf(nr));
        Stream<String> nrstream = nrlist.stream().filter(nr -> nr > 4).map(String::valueOf);
        assertEquals(String.valueOf(5), nrstream.findFirst().get());

    }
    @Test
    public void shouldcalculateTotalofList(){

        int sum =0;
        for(Integer nr : nrlist){
            sum = sum + nr;
        }
        assertEquals(15, sum);

        int newsum = nrlist.stream().mapToInt(p -> p).sum();
        assertEquals(15, newsum);
    }

    //Match
    //TODO

    //Count
    //TODO

    //Reduce
    //TODO

}
