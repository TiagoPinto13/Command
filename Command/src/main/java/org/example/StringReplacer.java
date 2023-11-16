package org.example;

public class StringReplacer implements StringTransformer {

    private char old,novo;
    public StringReplacer(char a, char x) {
        old=a;
        novo=x;
    }

    @Override
    public void execute(StringDrink drink) {
        String text=drink.getText();
        String replacedText = text.replace(old, novo);
        drink.setText(replacedText);
    }
}
