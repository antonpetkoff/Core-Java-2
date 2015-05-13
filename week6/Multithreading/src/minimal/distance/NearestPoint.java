package minimal.distance;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NearestPoint {

    /**
     * 
     * @param inPoints      inclusive
     * @param indexFrom     exclusive
     * @param indexTo
     * @param outMap
     */
    public static void doCalculations(List<Point> inPoints, int indexFrom, int indexTo, Map<Point, Point> outMap) {
        double minDistance = 0.0, tempDistance = 0.0;
        int minIndex = 0;

        for (int i = indexFrom; i < indexTo; ++i) {
            minDistance = Double.MAX_VALUE;

            for (int j = indexFrom; j < indexTo; ++j) {
                if (i != j) {
                    tempDistance = inPoints.get(i).distanceTo(inPoints.get(j));
                    
                    if (tempDistance < minDistance) {
                        minDistance = tempDistance;
                        minIndex = j;
                    }
                }
            }
            
            outMap.put(inPoints.get(i), inPoints.get(minIndex));
        }
    }

    public static Map<Point, Point> getNearestPoints(final List<Point> generatedPoints, int threadsCount) throws IllegalArgumentException {
        final Map<Point, Point> outMap = new ConcurrentHashMap<Point, Point>();

        Thread[] threads = new Thread[threadsCount];
        final int slice = generatedPoints.size() / threadsCount;

        for (int i = 0; i < threadsCount; ++i) {
            threads[i] = new Thread(new Calculation(generatedPoints, 0 + i * slice, (i + 1) * slice, outMap));
            threads[i].start();
        }
        
        for (int i = 0; i < threadsCount; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return outMap;
    }

    // THREADS_COUNT must divide POINTS_COUNT
    public static final int THREADS_COUNT = 100;
    
    public static final int DIMENSIONS_COUNT = 3;
    public static final int POINTS_COUNT = 100_000;
    public static final int RANGE_MIN = 0;
    public static final int RANGE_MAX = 10_000;
    
    public static void main(String[] args) throws IllegalArgumentException {
        List<Point> generatedPoints = Point.generatePoints(DIMENSIONS_COUNT, POINTS_COUNT, RANGE_MIN, RANGE_MAX);

        long start = System.currentTimeMillis();

        Map<Point, Point> map = NearestPoint.getNearestPoints(generatedPoints, THREADS_COUNT);

        System.out.println("Duration: " + (System.currentTimeMillis() - start) / 1000.0 + " seconds");
    }
}
