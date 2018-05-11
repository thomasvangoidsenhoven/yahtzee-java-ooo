package ui;

import model.*;
import model.categories.*;

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
/*
        DiceCup d = new DiceCup(5);
        d.roll();
        System.out.println(d);
        d.getDices().get(3).setLock();
        System.out.println(d);
        d.roll();
        System.out.println(d);
*/

//CATEGORY TEST

        //MAKE NEW PLAYER AND PLAYERGOURP
        Player p = new Player("Arnold");
        PlayerGroup playerGroup = new PlayerGroup();
        //ADD THE PLAYER
        playerGroup.addPlayer(p);

//TO MAKE STATIC DICE AND DICECOLLECTION
/*
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
        DiceCup diceCup = new DiceCup(dices);
*/

        DiceCup diceCup = new DiceCup(5);
        diceCup.roll();

        //CHECK IF DICES ARE ADDED CORRECTLY
        System.out.println(diceCup);

        //MAKE NEW CATEGORIES
        Category TOAK = new ThreeOfAKind(diceCup);
        Category FOAK = new FourOfAKind(diceCup);
        Category SS = new SmallStraight(diceCup);
        Category LS = new LargeStraight(diceCup);
        Category FH = new FullHouse(diceCup);
        Category C = new Chance(diceCup);
        Category Y = new Yatzee(diceCup);
        Category NC1 = new NumberCombos(diceCup, 1);
        Category NC2 = new NumberCombos(diceCup, 2);
        Category NC3 = new NumberCombos(diceCup, 3);
        Category NC4 = new NumberCombos(diceCup, 4);
        Category NC5 = new NumberCombos(diceCup, 5);
        Category NC6 = new NumberCombos(diceCup, 6);

        //CHECK PLAYERS CATEGORIES, ADD CATEGOTIES AND CHECK PLAYERS CATEGORY AGAIN
        System.out.println(p.getCatogories());
        playerGroup.addCategoryToPlayer(TOAK, "Arnold");
        playerGroup.addCategoryToPlayer(FOAK, "Arnold");
        playerGroup.addCategoryToPlayer(SS, "Arnold");
        playerGroup.addCategoryToPlayer(LS, "Arnold");
        playerGroup.addCategoryToPlayer(FH, "Arnold");
        playerGroup.addCategoryToPlayer(C, "Arnold");
        playerGroup.addCategoryToPlayer(Y, "Arnold");
        playerGroup.addCategoryToPlayer(NC1, "Arnold");
        playerGroup.addCategoryToPlayer(NC2, "Arnold");
        playerGroup.addCategoryToPlayer(NC3, "Arnold");
        playerGroup.addCategoryToPlayer(NC4, "Arnold");
        playerGroup.addCategoryToPlayer(NC5, "Arnold");
        playerGroup.addCategoryToPlayer(NC6, "Arnold");

        System.out.println(p.getCatogories());

        //CHECK IF CATEGORY CALCULATES CORRECTLY
        System.out.println(TOAK.toString() + " SCORE IF POSSIBLE: " + TOAK.getScore());
        System.out.println(FOAK.toString() + " SCORE IF POSSIBLE: " + FOAK.getScore());
        System.out.println(SS.toString() + " SCORE IF POSSIBLE: " + SS.getScore());
        System.out.println(LS.toString() + " SCORE IF POSSIBLE: " + LS.getScore());
        System.out.println(FH.toString() + " SCORE IF POSSIBLE: " + FH.getScore());
        System.out.println(C.toString() + " SCORE IF POSSIBLE: " + C.getScore());
        System.out.println(Y.toString() + " SCORE IF POSSIBLE: " + Y.getScore());
        System.out.println(NC1.toString() + " SCORE IF POSSIBLE: " + NC1.getScore());
        System.out.println(NC2.toString() + " SCORE IF POSSIBLE: " + NC2.getScore());
        System.out.println(NC3.toString() + " SCORE IF POSSIBLE: " + NC3.getScore());
        System.out.println(NC4.toString() + " SCORE IF POSSIBLE: " + NC4.getScore());
        System.out.println(NC5.toString() + " SCORE IF POSSIBLE: " + NC5.getScore());
        System.out.println(NC6.toString() + " SCORE IF POSSIBLE: " + NC6.getScore());

    }
}
