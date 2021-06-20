package de.thdeg.helfrich.choplifter.graphics.basics;

import java.util.*;

/**
 * Represents movement patterns objects can follow, e.g. the random ball
 */
public class MovementPatterns {

    Random random;
    HashMap<String, ArrayList<Position>> movementPatterns;
    XAxisComparator xAxisComparator;
    ArrayList<Position> zero;
    ArrayList<Position> square;
    ArrayList<Position> zigZag;
    ArrayList<Position> xFirst;
    ArrayList<Position> yFirst;
    ArrayList<Position> centered;

    /**
     * Creates movement patterns
     */
    public MovementPatterns() {
        Comparator<Position> yAxisComparator = new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return (int) Math.signum(o1.x-o2.x);
            }
        };
        this.random = new Random();
        this.xAxisComparator = new XAxisComparator();
        this.movementPatterns = new HashMap<>(5);
        square = new ArrayList<>(List.of(
                new Position(30, 30),
                new Position(930, 30),
                new Position(930, 510),
                new Position(30, 510)));
         zigZag = new ArrayList<>(List.of(
                new Position(200, 340),
                new Position(300, 200),
                new Position(400, 340),
                new Position(500, 200),
                new Position(600, 340),
                new Position(700, 200),
                new Position(800, 340)));
        this.movementPatterns.put("square", square);
        this.movementPatterns.put("zigzag", zigZag);
        zero = new ArrayList<>(square);
        zero.addAll(zigZag);
        this.movementPatterns.put("zero", zero);
        Collections.sort(zero);
        this.xFirst = new ArrayList<>(zero);
        Collections.sort(xFirst, xAxisComparator);
        this.movementPatterns.put("xFirst", xFirst);
        this.yFirst = new ArrayList<>(zero);
        Collections.sort(yFirst, yAxisComparator);
        this.movementPatterns.put("yFirst", yFirst);
        this.centered = new ArrayList<>(zero);
        Collections.sort(centered, (a, b) -> {
            return (int) Math.signum(a.distance(new Position(960/2d, 540/2d))- b.distance(new Position(960/2d, 540/2d)));
        });
        this.movementPatterns.put("centered", centered);
    }


    /**
     *Gets a pattern
     * @param pattern the requested pattern as String
     * @return the requested pattern
     */
    public ArrayList<Position> getPattern(String pattern) {
        return movementPatterns.get(pattern);
    }

    /**
     *Gets a random pattern from the pattern list
     * @return a random pattern
     */
    public ArrayList<Position> getRandomPattern() {
        if (random.nextBoolean()) {
            return movementPatterns.get("xFirst");
        } else {
            return movementPatterns.get("centered");
        }
        /*for (int i=1; i<100; i++ ){
            if (random.nextInt(5)) {
                movementPatterns.get("zigzag");
                movementPatterns.get("square");
                movementPatterns.get("zero");
                movementPatterns.get("xFirst");
                movementPatterns.get("yFirst");
                movementPatterns.get("centered");
            }
        }*/


        /*if (random.nextBoolean()) {
            return movementPatterns.get("zigzag");
        } else {
            return movementPatterns.get("square");
        }*/
    }

    /*public void sorting(){
        ListIterator<Position> litz = zero.listIterator();
        while(litz.hasNext()) {
            Position element = litz.next();

        }
    }*/


    /*@Override
    public MovementPatterns clone() {
        MovementPatterns clone = null;
        try {
            clone = (MovementPatterns) super.clone();
        } catch (CloneNotSupportedException ignored) {

        }
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MovementPatterns movementPatterns = (MovementPatterns) o;
        return random == movementPatterns.random && movementPatterns == movementPatterns.movementPatterns;
    }

    @Override
    public int hashCode(){
        return Objects.hash(random, movementPatterns);
    }*/
}
