import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BarTests {
    @Test
    public void thappyHour() {
        Bar bar = new StringBar();
        assertFalse(bar.isHappyHour());
        bar.startHappyHour();
        assertTrue(bar.isHappyHour());
        bar.endHappyHour();
        assertFalse(bar.isHappyHour());

    }

    @Test
    public void orderStringRecipe() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        stringBar.order(drink, recipe);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void impatientStrategy() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        ImpatientStrategy strategy = new ImpatientStrategy();
        HumanClient client = new HumanClient(strategy);
// Recipe is ordered immediately
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void smartStrategyStartOpened() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = recipe.getRecipe();
        SmartStrategy strategy = new SmartStrategy();
        HumanClient client = new HumanClient(strategy);
        stringBar.startHappyHour();
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void smartStrategyStartClosed() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = recipe.getRecipe();
        SmartStrategy strategy = new SmartStrategy();
        HumanClient client = new HumanClient(strategy);
        stringBar.addObserver(client); // this is important!
        client.wants(drink, recipe, stringBar);
        assertEquals("AbCd-aBcD", drink.getText());
// Recipe is only ordered here
        stringBar.startHappyHour();
        assertEquals("dCbX-DcBa", drink.getText());
    }
}