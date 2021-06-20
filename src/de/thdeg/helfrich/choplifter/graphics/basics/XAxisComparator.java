package de.thdeg.helfrich.choplifter.graphics.basics;

import java.util.Comparator;

/**
 * This class enables comparisons of two positions
 */
public class XAxisComparator implements Comparator<Position> {

    /**
     * Creates an XAxisComperator
     */
    public XAxisComparator(){

    }

    @Override
    public int compare(Position o1, Position o2) {
        return (int) Math.signum(o1.x-o2.x);
    }
}
