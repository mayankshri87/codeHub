package closestPairProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.tools.Diagnostic;

import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;

import com.graphbuilder.math.func.SqrtFunction;

public class ClosestPairProblem {

	private List<Point> points;
	
	public ClosestPairProblem(List<Point> points)
	{
		this.points = points;
	}
	
	
	public double solveProblem(){
		
		/*sortedXpoint list is created so get all the points and then sort the list based on the x coordinate, 
		 * this is needed to find the middle point later in this problem to divide the list between left list and right list*/
		List<Point> sortedXPoints = new ArrayList<>();
		List<Point> yPoints = new ArrayList<Point>();
		
		for(Point point : points)
		{
			sortedXPoints.add(point);
			yPoints.add(point);
		}
		
		sortByX(sortedXPoints);
		
		//sorting the sortedXpoint so that we can find the correct middle point.
		return findMinimumDistance(sortedXPoints, yPoints, points.size());
	}
	/*We will be using the recursion to find the closest pairs*/
	public double findMinimumDistance(List<Point> sortedXPoints, List<Point> yPoints, int numberOfPoints) {
		
		/*If the size of the list is 3 or less than 3 then we will have to use to brute force method.*/
		if(numberOfPoints<=3) return bruteForceApproach(sortedXPoints);
		
		/*If the size of the list is greater than the 3 then divide the list in to two parts leftsubpoint and right subpoint,
		 * and then find minDistance between the points in leftSubpoints and rightSubpoints separately.*/
		
		/*Get the middle index to decide the middle point for division of the list*/
		int middleIndex = numberOfPoints/2;
		
		Point middlePoint = sortedXPoints.get(middleIndex);
		
		//leftSubPointY and rightSubPointY are not going to use but needed to pass in findMinimumDistance() method to call is recursively.
		List<Point> leftSubPointSortedX = new ArrayList<Point>(); 
		List<Point> leftSubPointY = new ArrayList<Point>();
		List<Point> rightSubPointSortedX = new ArrayList<Point>();
		List<Point> rightSubPointY = new ArrayList<Point>();
		
		for(int i=0;i<numberOfPoints;i++)
		{
			if(yPoints.get(i).getX() <= middlePoint.getX())
			{
				leftSubPointY.add(yPoints.get(i));
				leftSubPointSortedX.add(sortedXPoints.get(i));
			}else{
				rightSubPointY.add(yPoints.get(i));
				rightSubPointSortedX.add(sortedXPoints.get(i));
			}
		}
		/*Getting the minimum distance in the leftarray by calling findMinimumDistance recursively*/
		double sigmaLeft = findMinimumDistance(leftSubPointSortedX, leftSubPointY, middleIndex);
		/*Getting the minimum distance in the rightarray by calling findMinimumDistance recursively*/
		double sigmaRight = findMinimumDistance(rightSubPointSortedX, rightSubPointY, numberOfPoints-middleIndex);
		
		/*fiinding the minimum distance between both leftSubArray and rightSubArray*/
		double sigma = Math.min(sigmaLeft, sigmaRight);
		
		/*Creating an array which will have all the points withing the middle strip,
		 * To get the middle strip, find distance of all the point from middle point and and that distance should be less than sigma.*/
		
		List<Point> pointsInStrip = new ArrayList<Point>();
		
		for(Point point : yPoints)
		{
			if(Math.abs(point.getX() - middlePoint.getX())<sigma)
			{
				pointsInStrip.add(point);
			}
		}
		/*Finding the minimum distance of between the points in strip*/
		double minDistanceStrip = findMinimumStripDistance(pointsInStrip,sigma);
		
		return Math.min(minDistanceStrip, sigma);
	}

	private double findMinimumStripDistance(List<Point> pointsInStrip, double sigma) {

		double minimumDistance = sigma;
		
		for(int i=0;i<pointsInStrip.size();i++)
		{
			//Math.abs(pointsInStrip.get(j).getY()-pointsInStrip.get(i).getY())<minimumDistance has been used so that we will not try to find distance between the points which are very far on y axis as we have already considered x-axis while creating the array.
			for(int j=i+1;j<pointsInStrip.size() && Math.abs(pointsInStrip.get(j).getY()-pointsInStrip.get(i).getY())<minimumDistance;j++)
			{
				if(distance(pointsInStrip.get(i), pointsInStrip.get(j))<minimumDistance)
				{
					minimumDistance = distance(pointsInStrip.get(i), pointsInStrip.get(j));
				}
			}
		}
		return minimumDistance;
	}


	/*In bruteForceApproach, loop through the points and then find the minimum distance between the points.*/
	public double bruteForceApproach(List<Point> points) {
		
		double minDistance = Double.MAX_VALUE;
		
		for(int i=0;i<points.size();i++)
		{
			for(int j=i+1;j<points.size();j++)
			{
				if(minDistance>distance(points.get(i), points.get(j)))
					minDistance = distance(points.get(i), points.get(j));
			}
		}
		return minDistance;
	}

	/*to find the distance between two coordinates, use Pythagorus theorem*/
	public double distance(Point point1, Point point2) {
		// TODO Auto-generated method stub
		double xDistance = Math.abs(point1.getX() - point2.getX());
		double yDistance = Math.abs(point1.getY() - point2.getY());
		
		return Math.sqrt((xDistance*xDistance) + (yDistance*yDistance));
		
	}


	public void sortByX(List<Point> points)
	{
		Collections.sort(points, new XSorter());
	}
	
	public static void main(String[] args) {
		List<Point> points = Arrays.asList(new Point(1, 1),new Point(1, 2),new Point(2, 1),
				new Point(2, 2), new Point(2, 3), new Point(3, 3));

		ClosestPairProblem obj = new ClosestPairProblem(points);
		
		System.out.println(obj.solveProblem());
	}

}
