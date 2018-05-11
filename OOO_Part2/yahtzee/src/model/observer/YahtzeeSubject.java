package model.observer;

import java.util.ArrayList;
import java.util.List;

public interface YahtzeeSubject {
     List<ScreenObserver> observers = new ArrayList<>();
     void registerObserver(ScreenObserver observer);
     void removeObserver(ScreenObserver observer);
     void notifyObservers();


}
