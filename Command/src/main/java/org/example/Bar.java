package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Bar {
    private List<BarObserver> observers ;
    public Bar() {
        observers = new ArrayList<>();
    }
    abstract public boolean isHappyHour();

    abstract public void startHappyHour();

    abstract public void endHappyHour();

    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (BarObserver observer : observers) {
            if (isHappyHour()) {
                observer.happyHourStarted(this);
            } else {
                observer.happyHourEnded(this);
            }
        }
    }
    private StringRecipe getRecipe() {
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');
        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);
        transformers.add(sr);
        StringRecipe recipe = new StringRecipe(transformers);
        return recipe;
    }
}
