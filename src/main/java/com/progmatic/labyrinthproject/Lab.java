package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.CellType;
import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.CellException;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;

import java.util.List;

public class Lab implements Labyrinth {
    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void loadLabyrinthFile(String fileName) {

    }

    @Override
    public CellType getCellType(Coordinate c) throws CellException {
        return null;
    }

    @Override
    public void setSize(int width, int height) {

    }

    @Override
    public void setCellType(Coordinate c, CellType type) throws CellException {

    }

    @Override
    public Coordinate getPlayerPosition() {
        return null;
    }

    @Override
    public boolean hasPlayerFinished() {
        return false;
    }

    @Override
    public List<Direction> possibleMoves() {
        return null;
    }

    @Override
    public void movePlayer(Direction direction) throws InvalidMoveException {

    }
}
