package ui;

import model.*;
import model.categories.*;

import java.util.ArrayList;
import java.util.List;

public class testui {
    public static void main(String[] args ){
//DICE TEST
/*
        Dice d = new Dice();
        d.setLock();
        d.setLock();
        try{
            d.roll();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println(d.getEyes());
*/

//DICECOLLECTION TEST
/*        DiceCollection d = new DiceCollection(5);
        d.roll();
        System.out.println(d);
        d.getDices().get(3).setLock();
        System.out.println(d);
        d.roll();
        System.out.println(d);*/

//CATEGORY TEST
        //MAKE NEW PLAYER AND PLAYERGOURP
        Player p = new Player("Arnold");
        PlayerGroup playerGroup = new PlayerGroup();
        //ADD THE PLAYER
        playerGroup.addPlayer(p);

        //MAKE  DICES TO USE WITH TESTPURPOSE CONSTRUCTOR
        Dice d1 = new Dice(5);
        Dice d2 = new Dice(5);
        Dice d3 = new Dice(5);
        Dice d4 = new Dice(5);
        Dice d5 = new Dice(5);

        //ADD DICES TO AN ARRAYLIST TO PAS THEM WITH TESPURPOSE CONSTRUCTOR OF DICE COLLECTION
        ArrayList<Dice> dices = new ArrayList<>();
        dices.add(d1);
        dices.add(d2);
        dices.add(d3);
        dices.add(d4);
        dices.add(d5);

        DiceCollection diceCollection = new DiceCollection(dices);

        //CHECK IF DICES ARE ADDED CORRECTLY
        System.out.println(diceCollection);

        //MAKE NEW CATEGORIES
        Category TOAK = new ThreeOfAKind(diceCollection, playerGroup, "Arnold");
        Category FOAK = new FourOfAKind(diceCollection, playerGroup, "Arnold");
        Category SS = new SmallStraight(diceCollection, playerGroup, "Arnold");
        Category LS = new LargeStraight(diceCollection, playerGroup, "Arnold");
        Category FH = new FullHouse(diceCollection, playerGroup, "Arnold");
        Category C = new Chance(diceCollection, playerGroup, "Arnold");
        Category Y = new Yatzee(diceCollection, playerGroup, "Arnold");
        Category NC = new NumberCombos(diceCollection, playerGroup, "Arnold", 5);

        //CHECK PLAYERS CATEGORIES, ADD CATEGOTIES AND CHECK PLAYERS CATEGORY AGAIN
        System.out.println(p.getCatogories());
        TOAK.add();
        FOAK.add();
        SS.add();
        LS.add();
        FH.add();
        C.add();
        Y.add();
        NC.add();
        System.out.println(p.getCatogories());

        //CHECK IF CATEGORY CALCULATES CORRECTLY
        System.out.println(TOAK.toString() + " SCORE IF POSSIBLE: " + TOAK.getScore());
        System.out.println(FOAK.toString() + " SCORE IF POSSIBLE: " + FOAK.getScore());
        System.out.println(SS.toString() + " SCORE IF POSSIBLE: " + SS.getScore());
        System.out.println(LS.toString() + " SCORE IF POSSIBLE: " + LS.getScore());
        System.out.println(FH.toString() + " SCORE IF POSSIBLE: " + FH.getScore());
        System.out.println(C.toString() + " SCORE IF POSSIBLE: " + C.getScore());
        System.out.println(Y.toString() + " SCORE IF POSSIBLE: " + Y.getScore());
        System.out.println(NC.toString() + " SCORE IF POSSIBLE: " + NC.getScore());
    }
}
