package org.example;
import java.lang.StringBuilder;
public class StringInverter implements StringTransformer{

    @Override
    public void execute(StringDrink drink) {
        String text=drink.getText();
        StringBuilder builder = new StringBuilder(text);
        builder.reverse();
        drink.setText(builder.toString());

    }
}
