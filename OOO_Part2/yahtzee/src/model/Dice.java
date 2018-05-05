package model;

import java.util.Random;

public class Dice {
    private boolean lock = false;
    private int eyes;

    public Dice(){

    }

    //TESTPURPOSE CONSTRUCTOR
    public Dice(int eyes){
        this.eyes = eyes;
    }

    //default getter
    public boolean isLock() {
        return lock;
    }

    //if called check for boolean and set the opposite
    public void setLock() {
        if (isLock()) {
            this.lock = false;
        } else{
            this.lock = true;
        }
    }

    public void roll(){
        if(!isLock()) {
            Random r = new Random();
            this.eyes = r.nextInt(6) + 1;
        } else {
            throw new IllegalArgumentException("The dice is locked");
        }
    }

    public int getEyes(){
        return eyes;
    }

    public void reset(){
        this.lock = false;
    }

    @Override
    public String toString() {
        return "Dice: " + getEyes() + " - State: " + (isLock() == true ? "Locked" : "Unlocked") + "\n";
    }
}