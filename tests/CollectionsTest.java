import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by claesdc on 2014-03-20.
 */

@RunWith(JUnit4.class)
public class CollectionsTest {

        private List names = Arrays.asList("peter","anna","mike","xenia");
        private String[] originalorder = {"peter","anna","mike","xenia"};
        private String[] ztoaorder = {"xenia","peter","mike","anna"};
        private String[] atozorder = {"anna","mike","peter","xenia"};


    @Before
    public void setUp(){
        names = Arrays.asList("peter","anna","mike","xenia");
    }

    @Test
    public void shouldSortaList(){
        assertArrayEquals(originalorder, names.toArray());

        Collections.sort(names, (String a,String b) -> b.compareTo(a));
        assertArrayEquals(ztoaorder, names.toArray());

        Collections.sort(names, (String a, String b) -> a.compareTo(b));
        assertArrayEquals(atozorder, names.toArray());
    }

    @Test
    public void shouldLoopList(){

        List<Integer> nrlist = Arrays.asList(1, 2, 3, 4, 5);

        nrlist.forEach(nr -> nr++);
        System.out.println(nrlist);
    }
}
