import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Function;

/**
 *
 */
@RunWith(JUnit4.class)
public class MethodConstructorReferenceTest {

    class Zombie {
        String firstName;
        String lastName;

        Zombie() {}

        Zombie(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
    interface ZombieFactory<P extends Zombie> {
        P create(String firstName, String lastName);
    }

    @Test
    public void shouldUseMethodReference(){
        Function<String,Integer> reference =  Integer::valueOf;
        Integer converted = reference.apply("123");
        Assert.assertNotNull(converted);
        Assert.assertSame(123, converted);

    }
    @Test
    public void shouldUseConstructorReference(){
        //reference to the Zombie constructor via Zombie::new
        ZombieFactory<Zombie> zombiefactory = Zombie::new;
        //automatically chooses the right constructor by matching the signature of
        Zombie zombie = zombiefactory.create("Daryl", "Dixon");
        Assert.assertNotNull(zombie);
    }
}
