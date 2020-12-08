package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.CellType;
import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.CellException;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author pappgergely
 */

public class LabyrinthImpl implements Labyrinth {
    private int width = -1;
    private int height = -1;
    private HashMap<Integer, ArrayList<CellType>> labyrinthHashMap = new HashMap<>();
    private Coordinate startCoordinate;
    private Coordinate endCoordinate;
    private Coordinate playerCoordinate = startCoordinate;


    @Override
    public void loadLabyrinthFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int width = Integer.parseInt(sc.nextLine());
            int height = Integer.parseInt(sc.nextLine());
            setSize(width, height);
            for (int hh = 0; hh < height; hh++) {
                String line = sc.nextLine();
                for (int ww = 0; ww < width; ww++) {
                    Coordinate c = new Coordinate(ww, hh);

                    switch (line.charAt(ww)) {
                        case 'W':
                            setCellType(c, CellType.WALL);

                            break;
                        case 'E':
                            setCellType(c, CellType.END);

                            break;
                        case 'S':
                            setCellType(c, CellType.START);

                            break;
                        default:
                            setCellType(c, CellType.EMPTY);
//                                labyrinthHashMap.get(hh).add(CellType.EMPTY);

                    }
                }
            }
        } catch (FileNotFoundException | NumberFormatException | CellException ex) {
            System.out.println(ex.toString());
        }
    }


//    public LabyrinthImpl() {
//
//    }

    @Override
    public void movePlayer(Direction direction) throws InvalidMoveException {
//        try {
            if (!(possibleMoves().contains(direction))) {
                throw new InvalidMoveException();
//            }
//        } catch (InvalidMoveException i) {
//            System.out.println("Invalid");

//            i.printStackTrace();
        }
        try {
            if (getPlayerPosition().equals(getEndCoordinate())) {
                System.out.println("You should not turn back to labyrinth :)");
            } else {
//                if (!(getPlayerPosition().equals(getStartCoordinate()))) {
//                    labyrinthHashMap.get(getPlayerPosition().getRow()).set(getPlayerPosition().getCol(), CellType.EMPTY);
//                }
                if (direction.equals(Direction.NORTH)) {
                    setPlayerPosition(new Coordinate(getPlayerPosition().getCol(), getPlayerPosition().getRow() - 1));
                } else if (direction.equals(Direction.SOUTH)) {
                    setPlayerPosition(new Coordinate(getPlayerPosition().getCol(), getPlayerPosition().getRow() + 1));
                } else if (direction.equals(Direction.WEST)) {
                    setPlayerPosition(new Coordinate(getPlayerPosition().getCol() - 1, getPlayerPosition().getRow()));
                } else if (direction.equals(Direction.EAST)) {
                    setPlayerPosition(new Coordinate(getPlayerPosition().getCol() + 1, getPlayerPosition().getRow()));
                }
            }
//                try {
//                    setCellType(getPlayerPosition(), CellType.PLAYER);
//                } catch (CellException e) {
//                    e.printStackTrace();
//                }
//                labyrinthHashMap.get(getPlayerPosition().getRow()).set(getPlayerPosition().getCol(), CellType.PLAYER);
        } catch (NullPointerException n) {
//                System.out.println("Null");
//            n.printStackTrace();
        }
    }


    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public CellType getCellType(Coordinate c) throws CellException {
//        try {
            if (c.getRow() >= getHeight()) {
                throw new CellException(c.getRow(), c.getCol(), "the labyrinth has not so many rows,please try another coordinate");
            } else if (c.getRow() < 0) {
                throw new CellException(c.getRow(), c.getCol(), "the second number of coordinate(rows) must be positive,please try another coordinate");
            } else if (c.getCol() >= getWidth()) {
                throw new CellException(c.getRow(), c.getCol(), "the labyrinth has not so many columns,please try another coordinate");
            } else if (c.getCol() < 0) {
                throw new CellException(c.getRow(), c.getCol(), "the first number of coordinate(columns) must be positive,please try another coordinate");
            }
//        }
//        catch (CellException ce) {
//            System.out.println("Cell");
//            return null;
//        }
        try {
            return labyrinthHashMap.get(c.getRow()).get(c.getCol());
        } catch (NullPointerException n) {
//            System.out.println("NullPointerException");
            return null;
        }
    }


    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void setCellType(Coordinate c, CellType type) throws CellException {
        labyrinthHashMap.putIfAbsent(c.getRow(), new ArrayList<>());
        if (labyrinthHashMap.get(c.getRow()).isEmpty()) {
            labyrinthHashMap.get(c.getRow()).add(c.getCol(), type);
        } else if (c.getCol() >= labyrinthHashMap.get(c.getRow()).size()) {
            labyrinthHashMap.get(c.getRow()).add(c.getCol(), type);
        } else {
            labyrinthHashMap.get(c.getRow()).set(c.getCol(), type);
        }
        if (type.equals(CellType.START)) {
            setStartCoordinate(c);
            setPlayerPosition(c);
        }
        if (type.equals(CellType.END)) {
            setEndCoordinate(c);
        }
    }

    @Override
    public boolean hasPlayerFinished() {
        try {
            if (getCellType(getPlayerPosition()).equals(CellType.END)) {
                return true;
            }
        } catch (NullPointerException | CellException n) {
//            System.out.println("NullPointerException");
        }
        return false;
    }

    @Override
    public Coordinate getPlayerPosition() {
        return playerCoordinate;
    }

    //
    public void setPlayerPosition(Coordinate c) {
        playerCoordinate = c;

    }

    public HashMap<Integer, ArrayList<CellType>> getLabyrinthHashMap() {
        return labyrinthHashMap;
    }

    public Coordinate getStartCoordinate() {
        return startCoordinate;
    }

    public void setStartCoordinate(Coordinate startCoordinate) {

        this.startCoordinate = startCoordinate;

    }

    public Coordinate getEndCoordinate() {
        return endCoordinate;
    }

    public void setEndCoordinate(Coordinate endCoordinate) {
        this.endCoordinate = endCoordinate;
    }

    @Override
    public List<Direction> possibleMoves() {
        ArrayList dirs = new ArrayList();
        try {
            if (getPlayerPosition().getRow() > 0) {
                if (labyrinthHashMap.get(getPlayerPosition().getRow() - 1).get(getPlayerPosition().getCol()).equals(CellType.EMPTY)
                        || labyrinthHashMap.get(getPlayerPosition().getRow() - 1).get(getPlayerPosition().getCol()).equals(CellType.END)
                ) {
                    dirs.add(Direction.NORTH);
                }
            }

            if (getPlayerPosition().getRow() < getHeight() - 1) {
                if (labyrinthHashMap.get(getPlayerPosition().getRow() + 1).get(getPlayerPosition().getCol()).equals(CellType.EMPTY)
                        || labyrinthHashMap.get(getPlayerPosition().getRow() + 1).get(getPlayerPosition().getCol()).equals(CellType.END)

                ) {
                    dirs.add(Direction.SOUTH);
                }
            }

            if (getPlayerPosition().getCol() > 0) {
                if (labyrinthHashMap.get(getPlayerPosition().getRow()).get(getPlayerPosition().getCol() - 1).equals(CellType.EMPTY)
                        || labyrinthHashMap.get(getPlayerPosition().getRow()).get(getPlayerPosition().getCol() - 1).equals(CellType.END)

                ) {
                    dirs.add(Direction.WEST);
                }
            }

            if (getPlayerPosition().getCol() < getWidth() - 1) {
                if (labyrinthHashMap.get(getPlayerPosition().getRow()).get(getPlayerPosition().getCol() + 1).equals(CellType.EMPTY)
                        || labyrinthHashMap.get(getPlayerPosition().getRow()).get(getPlayerPosition().getCol() + 1).equals(CellType.END)

                ) {
                    dirs.add(Direction.EAST);
                }
            }
        } catch (NullPointerException n) {
            System.out.println("Null...");
            n.printStackTrace();
        }


        return dirs;
    }


}
