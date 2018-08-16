package closestPairProblem;

import java.util.Comparator;

/*This class is needed as we are tryng to sort the points based on the distance between the x coordinates of points*/

public class XSorter implements Comparator<Point>{

	@Override
	public int compare(Point point, Point otherPoint) {
		return Double.compare(point.getX(), otherPoint.getX());
	}
}