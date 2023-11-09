package org.example;

public class StringCaseChanger implements StringTransformer{

    @Override
    public void execute(StringDrink drink) {
        String s = drink.getText();
        StringBuilder nova= new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (Character.isLowerCase(s.charAt(i))){
                nova.append(Character.toUpperCase(s.charAt(i)));
            }
            else{
                nova.append(Character.toLowerCase(s.charAt(i)));
            }
        }
    drink.setText(nova.toString());
    }

}
