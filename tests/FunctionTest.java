import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Function;
import static junit.framework.Assert.assertEquals;

/**
 *
 */
@RunWith(JUnit4.class)
public class FunctionTest {

    @Test
    public void functionshouldChainWithCompose(){
        Function<Integer, String> toString = String::valueOf;
        Function<String, Integer> toInteger = Integer::valueOf;

        assertEquals("123",toString.compose(toInteger).apply("123"));
    }

    @Test
    public void functionshouldChainWithAndThen(){
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(value -> (value.toString() + " is a string again"));

        assertEquals("123 is a string again", backToString.apply("123"));
    }
}
