package model;

import exceptions.DomainException;

import java.util.Random;

public class Dice {
    private boolean lock = false;
    private int eyes;

    public Dice(){

    }

    public Dice(int eyes){
        if(eyes < 1 || eyes > 6)throw new DomainException("eyes cannot be greater than 6 and smaller than 1");
        this.eyes = eyes;
    }

    //default getter
    public boolean isLocked() {
        return lock;
    }

    //if called check for boolean and set the opposite
    public void setLock() {
        if (isLocked()) {
            this.lock = false;
        } else{
            this.lock = true;
        }
    }

    public void roll(){
        if(!isLocked()) {
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
        return "Dice: " + getEyes() + " - State: " + (isLocked() == true ? "Locked" : "Unlocked") + "\n";
    }
}
