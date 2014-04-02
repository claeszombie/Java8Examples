import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;
import java.util.function.Supplier;

/**
 *
 */
@RunWith(JUnit4.class)
public class SupplierTest {

    @Test
    public void supplierShouldGetResult(){
        Supplier<Date> stringSupplier = Date::new;
        Date datesupplied = stringSupplier.get();

        Assert.assertNotNull(datesupplied);
    }
}
