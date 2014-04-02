import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.Clock;
import java.time.Instant;
import java.util.function.Consumer;

/**
 *
 */
@RunWith(JUnit4.class)
public class ConsumerTest {

    @Test
    public void consumerShouldAcceptArgument(){
        Consumer<Instant> apocalypsetime = (ap) -> System.out.println("It's time "+ ap );
        apocalypsetime.accept(Clock.systemDefaultZone().instant());

        Assert.assertNotNull(apocalypsetime);
    }
}
