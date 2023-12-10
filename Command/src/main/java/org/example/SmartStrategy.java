package org.example;

import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy{

    private List<StringDrink> drinkList;
    private List<StringRecipe> recipeList;

    public SmartStrategy(){
        drinkList = new ArrayList<>();
        recipeList = new ArrayList<>();
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour()){
            bar.order(drink,recipe);
        }

        else{
            drinkList.add(drink);
            recipeList.add(recipe);
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        bar.startHappyHour();
        for (int i = 0; i < drinkList.size(); i++){
            bar.order(drinkList.get(i), recipeList.get(i));
        }

    }

    @Override
    public void happyHourEnded(StringBar bar) {
        bar.endHappyHour();
    }
}