import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 *
 */
@RunWith(JUnit4.class)
public class InterfaceTest {

    interface Zombie{
        double walkSpeed(int nroflegs);
        default double fieldofVidion(int nrofeyes, int age){
            return nrofeyes * age;
        }
    }

    @Before
    public void setUp(){

    }

    @Test
    public void interfaceShouldHaveDefaultMethod(){

        Zombie walker = new Zombie(){
            @Override
            public double walkSpeed(int nroflegs) {
                return 2*23;
            }
        };

        assertEquals(Double.valueOf(46),Double.valueOf(walker.walkSpeed(1)));
        assertEquals(Double.valueOf(24), Double.valueOf(walker.fieldofVidion(2, 12)));

        Zombie walker2 = new Zombie(){
            @Override
            public double walkSpeed(int nroflegs) {
                return 2*23;
            }

            @Override
            public double fieldofVidion(int nrofeyes, int age) {
                return age-nrofeyes;
            }
        };

        assertEquals(Double.valueOf(46),Double.valueOf(walker2.walkSpeed(1)));
        assertEquals(Double.valueOf(10), Double.valueOf(walker2.fieldofVidion(2, 12)));



    }
}
