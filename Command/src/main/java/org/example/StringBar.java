package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar {

    private boolean happyHour;
    public StringBar(){
        this.happyHour = false;
    }
    @Override
    public boolean isHappyHour() {
        return happyHour;
    }

    @Override
    public void startHappyHour() {
        if (!isHappyHour()) {
            this.happyHour = true;
            notifyObservers();
        }
    }

    @Override
    public void endHappyHour() {
        if(isHappyHour()) {
            this.happyHour = false;
            notifyObservers();
        }
    }

    public void order(StringDrink drink,StringRecipe recipe){
        recipe.mix(drink);
    }

}