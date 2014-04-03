import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Comparator;

/**
 *
 */
@RunWith(JUnit4.class)
public class ComparatorTest {


    class Zombie{

        private final Integer height;

        Zombie(Integer height){
            this.height = height;
        }
        Integer getHeight(){
            return height;
        }

    }

    @Test
    public void comparatorShouldCompare(){
        Comparator<Zombie> comparator = (z1,z2) -> z1.getHeight().compareTo(z2.getHeight());
        Zombie zomb1 = new Zombie(201);
        Zombie zomb2 = new Zombie(189);
        Zombie zomb3 = new Zombie(189);

        Assert.assertTrue("Zomb1 is taller! ",comparator.compare(zomb1, zomb2) > 0);
        Assert.assertTrue("Zomb1 is taller reversed! ",comparator.reversed().compare(zomb1, zomb2) < 0);
        Assert.assertTrue("Zomb2 and Zomb3 are same height! ",comparator.compare(zomb3, zomb2) == 0);

    }
}
