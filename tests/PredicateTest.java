import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Predicate;

import static junit.framework.Assert.*;

/**
 * Created by claesdc on 2014-03-24.
 */
@RunWith(JUnit4.class)
public class PredicateTest {
        private Predicate<String> predicate = (s) -> s.length() > 3;
        private Predicate<String> predicate2 = (s) -> s.charAt(0) == 'O';
        private Predicate<String> predicate3 = (s) -> s.charAt(0) == 'B';

    @Before
    public void setUp(){
    }

    @Test
    public void predicateTestshouldWork(){
        assertEquals(true, predicate.test("walking"));
        assertEquals(false, predicate.test("ok"));
    }
    @Test
    public void predicateNegateshouldWork(){
        assertEquals(false, predicate.negate().test("walking"));
        assertEquals(true, predicate.negate().test("ok"));
    }
    @Test
    public void predicateAndshouldWork(){
        assertEquals(false,predicate.and(predicate2).test("Oka"));
        assertEquals(true,predicate.and(predicate2).test("Okay"));
        assertEquals(false,predicate.and(predicate2).test("okay"));
    }
    @Test
    public void predicateOrshouldWork(){
        assertEquals(true,predicate2.or(predicate3).test("Oka"));
        assertEquals(true,predicate2.or(predicate3).test("Bka"));
        assertEquals(false,predicate2.or(predicate3).test("oka"));
        assertEquals(false,predicate2.or(predicate3).test("okay"));
    }

}
