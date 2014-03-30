import org.junit.Assert;
import org.junit.Before;
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

    private static int outerStaticNum;
    private int outerNum;

    @Before
    public void setUp(){
        outerStaticNum = 0;
    }

    @Test
    public void shouldAcessLocalVariabel(){
        int num = 1;
        Function<Integer,String> stringConverter = (from) -> String.valueOf(from + num);
        assertEquals("3", stringConverter.apply(2));
    }

    @Test
    public void shouldAccesStaticVariable(){
        Assert.assertEquals(0,outerStaticNum);

        Function<Integer,String> stringconverter = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };

        String value = stringconverter.apply(1);

        Assert.assertEquals("1", value);
        Assert.assertEquals(72, outerStaticNum);
    }

    @Test
    public void shouldAccessInstanceField(){
        Assert.assertEquals(0,outerNum);

        Function<Integer,String> stringconverter = (from) -> {
            outerNum = 72;
            return String.valueOf(from);
        };

        String value = stringconverter.apply(1);

        Assert.assertEquals("1", value);
        Assert.assertEquals(72, outerNum);
    }
}
