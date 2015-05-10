package minimal.distance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  Point composed of integer coordinates, the count of which
 *  is given at construction.
 */
public final class Point {

    private final ImmutableArray<Integer> coords;

    public Point(Integer... coords) throws IllegalArgumentException {
        if (coords == null || coords.length == 0) {
            throw new IllegalArgumentException("Point must have at least one dimension!");
        }

        this.coords = new ImmutableArray<Integer>(coords);
    }

    public int getDimensionsCount() {
        return coords.length();
    }

    public double get(int index) {
        return coords.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(coords.get(0));

        for (int i = 1; i < coords.length(); ++i) {
            sb.append(',').append(coords.get(i));
        }

        return sb.append(')').toString();
    }

    public double distanceTo(Point other) throws IllegalArgumentException {
        if (coords.length() != other.getDimensionsCount()) {
            throw new IllegalArgumentException("Point dimensions must match!");
        }

        double distance = 0.0;

        for (int i = 0; i < coords.length(); ++i) {
            distance += (coords.get(i) - other.get(i)) * (coords.get(i) - other.get(i));
        }

        return distance;
    }

    public static List<Point> generatePoints(int dimensions, int pointCount, int min, int max)
            throws IllegalArgumentException {
        List<Point> list = new ArrayList<Point>();

        Random rand = new Random();
        Integer[] coords = new Integer[dimensions];

        for (int i = 0; i < pointCount; ++i) {
            for (int j = 0; j < dimensions; ++j) {
                coords[j] =  min + rand.nextInt((max - min) + 1);
            }

            list.add(new Point(coords));
        }

        return list;
    }

    public static void main(String[] args) throws IllegalArgumentException {
        List<Point> points = Point.generatePoints(3, 10, 0, 10_000);
        System.out.println(points);
    }

}
