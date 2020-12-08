package com.progmatic.labyrinthproject;


import com.progmatic.labyrinthproject.enums.CellType;
import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.CellException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import com.progmatic.labyrinthproject.interfaces.Player;

import java.util.List;
import java.util.Random;

public class RandomPlayer implements Player {
    @Override
    public Direction nextMove(Labyrinth l) throws CellException {
        Random random = new Random();
        Direction dir= null;
        Integer num = null;
        int i = l.getPlayerPosition().getRow();
        int j = l.getPlayerPosition().getCol();
        int k = l.getPlayerPosition().getCol();
        CellType m = l.getCellType(l.getPlayerPosition());
        boolean n = l.possibleMoves().isEmpty();
l.possibleMoves();
        boolean n2 = l.possibleMoves().isEmpty();

        if (!(l.possibleMoves().isEmpty())){
            num = random.nextInt(l.possibleMoves().size());

            if (num.equals(0)){
                dir= l.possibleMoves().get(0);

            }
            else if (num.equals(1)){
                dir= l.possibleMoves().get(1);

            }
            else if (num.equals(2)){
                dir= l.possibleMoves().get(2);

            }
            else if (num.equals(3)){
                dir= l.possibleMoves().get(3);

            }}

//        switch (r){
//            case 0:
//                     dir=Direction.NORTH;

//            case 1:
//                     dir=Direction.SOUTH;
//            case 2:
//                dir= Direction.WEST;
//            case 3:
//                dir= Direction.EAST;
//
//        }
        return dir;
    }

//    Készíts el egy random játékost, aki véletlenszerűen mozog a pályán (úgy, hogy azért falba ne ütközzön).
//    Ehhez készíts egy új osztályt, és implementáld a Player interface-t!
//    Figyeld meg, hogy a Player implementáció nem tárolja, hogy hol tartózkodik a pályán, ez a Labyrinth felelőssége! A Player csupán a következő lépését adja meg.
//    Ellenőrizd megoldásod a LabyrinthTest
//    private Player getRandomPlayerImpl()
//    metódusának megírásával és a teszt futtatásával!
//            (Csak olyan kicsi labirintussal teszteljük ezt a játékost, ahol egy random walk is általában legfeljebb néhány másodpercen belül kivezet a labirintusból.)

}
