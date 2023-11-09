import org.example.StringInverter;
import org.example.StringTransformer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringInverterTest extends StringInverter {
    @Test
    public void stringInverter() {
        StringDrinkTest drink = new StringDrinkTest("ABCD");
        StringInverterTest si = new StringInverterTest();
        si.execute(drink);
        assertEquals("DCBA", drink.getText());
    }
}
