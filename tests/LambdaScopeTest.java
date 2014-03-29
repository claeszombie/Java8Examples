import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

/**
 *
 */
@RunWith(JUnit4.class)
public class LambdaScopeTest {

    @Test
    public void shouldAcessLocalVariabel(){
        int num = 1;
        Function<Integer,String> stringConverter = (from) -> String.valueOf(from + num);
        assertEquals("3", stringConverter.apply(2));
    }
}
