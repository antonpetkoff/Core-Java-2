package minimal.distance;

import java.util.List;
import java.util.Map;

public final class Calculation implements Runnable {

    private final List<Point> inPoints;
    private final int indexFrom;
    private final int indexTo;
    private final Map<Point, Point> outMap;

    public Calculation(List<Point> inPoints, int indexFrom, int indexTo, Map<Point, Point> outMap) {
        this.inPoints = inPoints;
        this.indexFrom = indexFrom;
        this.indexTo = indexTo;
        this.outMap = outMap;
    }

    @Override
    public void run() {
        NearestPoint.doCalculations(inPoints, indexFrom, indexTo, outMap);
    }
    
}
