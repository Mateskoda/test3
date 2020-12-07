package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.CellType;
import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.CellException;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * b
 *
 * @author pappgergely
 */
public class LabyrinthImpl implements Labyrinth {
    private int width = -1;
    private int height = -1;
    private HashMap<Integer, ArrayList<CellType>> labyrinthHashMap = new HashMap<>();
    private Coordinate startCoordinate;
    private Coordinate endCoordinate;
    private Coordinate playerCoordinate = startCoordinate;


    public LabyrinthImpl() {

    }

    @Override
//    minden labirintus négyzet?M???

    public void loadLabyrinthFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int width = Integer.parseInt(sc.nextLine());
            int height = Integer.parseInt(sc.nextLine());
//            this.width=width;
//            this.height=height;
            setSize(width, height);
            for (int hh = 0; hh < height; hh++) {
                labyrinthHashMap.putIfAbsent(hh, new ArrayList<>());
                String line = sc.nextLine();
                for (int ww = 0; ww < width; ww++) {
                    Coordinate c = new Coordinate(ww, hh);
                    switch (line.charAt(ww)) {
                        case 'W':
//     Coordinate(int col, int row)

//                            setCellType(c, CellType.WALL);
                            labyrinthHashMap.get(hh).add(CellType.WALL);
                            break;
                        case 'E':
//                            setCellType(c, CellType.END);
                            labyrinthHashMap.get(hh).add(CellType.END);
                            setEndCoordinate(new Coordinate(ww, hh));
                            break;
                        case 'S':
//                            setCellType(c, CellType.START);
                            labyrinthHashMap.get(hh).add(CellType.START);
                            setStartCoordinate(new Coordinate(ww, hh));
                            setPlayerPosition(new Coordinate(ww, hh));
                            break;
                        default:
//                            setCellType(c, CellType.EMPTY);
                            labyrinthHashMap.get(hh).add(CellType.EMPTY);
                    }
                }
            }
        } catch (FileNotFoundException | NumberFormatException ex) {
            System.out.println(ex.toString());
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
        if (c.getRow() > getHeight()) {
            throw new CellException(c.getRow(), c.getCol(), "the labyrinth has not so many rows,please try another coordinate");
        } else if (c.getRow() < 0) {
            throw new CellException(c.getRow(), c.getCol(), "the second number of coordinate(rows) must be positive,please try another coordinate");
        } else if (c.getCol() > getWidth()) {
            throw new CellException(c.getRow(), c.getCol(), "the labyrinth has not so many columns,please try another coordinate");
        } else if (c.getCol() < 0) {
            throw new CellException(c.getRow(), c.getCol(), "the first number of coordinate(columns) must be positive,please try another coordinate");
        }
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
        try {

        if (c.getRow() > getHeight()) {
            throw new CellException(c.getRow(), c.getCol(), "the labyrinth has not so many rows,please try another coordinate");
        } else if (c.getRow() < 0) {
            throw new CellException(c.getRow(), c.getCol(), "the second number of coordinate(rows) must be positive,please try another coordinate");
        } else if (c.getCol() > getWidth()) {
            throw new CellException(c.getRow(), c.getCol(), "the labyrinth has not so many columns,please try another coordinate");
        } else if (c.getCol() < 0) {
            throw new CellException(c.getRow(), c.getCol(), "the first number of coordinate(columns) must be positive,please try another coordinate");
        }
        else {
            try {
                labyrinthHashMap.putIfAbsent(c.getRow(), new ArrayList<>());
                labyrinthHashMap.get(c.getRow()).add(c.getCol(), type);
//        try {
//            labyrinthHashMap.get(c.getRow()).set(c.getCol(), type);
            } catch (NullPointerException n) {
//            System.out.println("NullPointerException");
            }
        }
        } catch (CellException cellException) {
//            System.out.println("NullPointerException");
        }


            try {
            labyrinthHashMap.putIfAbsent(c.getRow(), new ArrayList<>());
            labyrinthHashMap.get(c.getRow()).add(c.getCol(), type);
//        try {
//            labyrinthHashMap.get(c.getRow()).set(c.getCol(), type);
        } catch (NullPointerException n) {
//            System.out.println("NullPointerException");
        }
        if (type.equals(CellType.START)) {
            setStartCoordinate(c);
            setPlayerPosition(c);
        }
        if (type.equals(CellType.END)) {
            setEndCoordinate(c);
        }
//        if (type.equals(CellType.START)) {
//            for (int hh = 0; hh < getHeight(); hh++) {
//                for (int ww = 0; ww < getWidth(); ww++) {
//                    try {
//                        if (labyrinthHashMap.get(hh).get(ww).equals(CellType.START)&& !(new Coordinate(ww,hh).equals(c))) {
//                            labyrinthHashMap.get(hh).set(ww, CellType.WALL);
//                        }
//                        setCellType(new Coordinate(ww, hh), CellType.WALL);
//                        if (playerCoordinate.equals(new Coordinate(ww, hh))) {
//                            playerCoordinate = c;
//                        }
//                    } catch (NullPointerException n) {
//                        System.out.println("NullPointerException");

//    }
//

//                }
            }

//        }
//    }

    @Override
    public Coordinate getPlayerPosition() {
        return playerCoordinate;
    }
//    Valósítsd meg a
//    void setCellType(Coordinate c, CellType type) throws CellException
//    metódust! Ezzel egy adott cella típusát tudjuk felülírni. Ezt a metódust csak a tesztek használják, de akár a fájlból való beolvasásnál is használhatod (nem kötelező). Ha a type paraméter START, akkor állítsd át a játékos koodinátáját is az adott mezőre! Ügyelj arra, hogy ha nem létező koordinátára hivatkozunk, akkor a metódus kivételt dobjon! (2p)

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
//        for (int hh = 0; hh < getHeight(); hh++) {
//            labyrinthHashMap.putIfAbsent(hh, new ArrayList<>());
//            String line = sc.nextLine();
//            for (int ww = 0; ww < width; ww++) {
//                Coordinate c = new Coordinate(ww, hh);
//                switch (line.charAt(ww)) {
//                    case 'W':
//     Coordinate(int col, int row)

//                            setCellType(c, CellType.WALL);
//                        labyrinthHashMap.get(hh).add(CellType.WALL);
//                        break;
//                    case 'E':
//                            setCellType(c, CellType.END);
//                        labyrinthHashMap.get(hh).add(CellType.END);
//                        setEndCoordinate(new Coordinate(ww, hh));
//                        break;
//                    case 'S':
//                            setCellType(c, CellType.START);
//                        labyrinthHashMap.get(hh).add(CellType.START);
//                        setStartCoordinate(new Coordinate(ww, hh));
//                        setPlayerPosition(new Coordinate(ww, hh));
//                        break;
    }

    public Coordinate getEndCoordinate() {
        return endCoordinate;
    }

    public void setEndCoordinate(Coordinate endCoordinate) {
        this.endCoordinate = endCoordinate;
    }

    @Override
    public boolean hasPlayerFinished() {
        try {
            if (getPlayerPosition().equals(getEndCoordinate())) {
                return true;
            }
        } catch (NullPointerException n) {
//            System.out.println("NullPointerException");
        }
        return false;
    }

    @Override
    public List<Direction> possibleMoves() {
        ArrayList dirs = new ArrayList();
        try {
            if (getPlayerPosition().getRow() > 0) {
                if (labyrinthHashMap.get(getPlayerPosition().getRow() - 1).get(getPlayerPosition().getCol()).equals(CellType.EMPTY)) {
                    dirs.add(Direction.NORTH);
                }
            }

            if (getPlayerPosition().getRow() < getHeight()-1) {
                if (labyrinthHashMap.get(getPlayerPosition().getRow() + 1).get(getPlayerPosition().getCol()).equals(CellType.EMPTY)) {
                    dirs.add(Direction.SOUTH);
                }
            }

            if (getPlayerPosition().getCol() > 0) {
                if (labyrinthHashMap.get(getPlayerPosition().getRow()).get(getPlayerPosition().getCol() - 1).equals(CellType.EMPTY)) {
                    dirs.add(Direction.WEST);
                }
            }

            if (getPlayerPosition().getCol() < getWidth()-1) {
                if (labyrinthHashMap.get(getPlayerPosition().getRow()).get(getPlayerPosition().getCol() + 1).equals(CellType.EMPTY)) {
                    dirs.add(Direction.EAST);
                }
            }
        } catch (NullPointerException n) {
            System.out.println("Null...");
//            n.printStackTrace();
        }


        return dirs;
    }

    @Override
    public void movePlayer(Direction direction) throws InvalidMoveException {
//        if (!(possibleMoves().contains(direction))){
//            throw new InvalidMoveException();
//
//        }
        try {
            if (!(possibleMoves().contains(direction))) {
                throw new InvalidMoveException();
            }
        } catch (InvalidMoveException i) {
            System.out.println("Invalid");

//            i.printStackTrace();
        }
        try {


            if (getPlayerPosition().equals(getEndCoordinate())) {
                System.out.println("You should not turn back to labyrinth :)");
            } else {
                if (!(getPlayerPosition().equals(getStartCoordinate()))) {
                    labyrinthHashMap.get(getPlayerPosition().getRow()).set(getPlayerPosition().getCol(), CellType.EMPTY);
                }
            }
            if (direction.equals(Direction.NORTH)) {
                setPlayerPosition(new Coordinate(getPlayerPosition().getCol(), getPlayerPosition().getRow() - 1));
            } else if (direction.equals(Direction.SOUTH)) {
                setPlayerPosition(new Coordinate(getPlayerPosition().getCol(), getPlayerPosition().getRow() + 1));
            } else if (direction.equals(Direction.WEST)) {
                setPlayerPosition(new Coordinate(getPlayerPosition().getCol() - 1, getPlayerPosition().getRow()));
            } else if (direction.equals(Direction.EAST)) {
                setPlayerPosition(new Coordinate(getPlayerPosition().getCol() + 1, getPlayerPosition().getRow()));
            }
            try {
                setCellType(getPlayerPosition(), CellType.PLAYER);
            } catch (CellException e) {
                e.printStackTrace();
            }
            labyrinthHashMap.get(getPlayerPosition().getRow()).set(getPlayerPosition().getCol(), CellType.PLAYER);
        } catch (NullPointerException n) {
            System.out.println("Null");
//            n.printStackTrace();
        }
    }
}