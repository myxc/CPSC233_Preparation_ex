
/**
 * Point.java: A point class that returns distance between point objects, stores coordinates, etc.
 * @version CPSC 233
 * @author Xuecheng Yu
 * Open source
*/
public class Point {
	//attribute definitions
	private int xcoord;
	private int ycoord;
	/*
	 * Default constructor
	*/
	Point() 
	{
		xcoord = 0;
		ycoord = 0;
	}
	/*
	 * @param x sets the value of xcoord to x
	 * @param[y][sets the value of ycoord to y]
	*/
	Point(int x, int y) 
	{
		xcoord = x;
		ycoord = y;
	}
	/*
	 * @param[Point Object][Takes point object to access its x and y coords]
	 * @return[euclidean distance between x and y coords of object method is applied to and arg]
	*/
	public double distance(Point object)
	{
		double dist;
		double x_dist = xcoord - object.getX();
		double y_dist = ycoord - object.getY();
		double val = (y_dist * y_dist) + (x_dist * x_dist);
		dist = Math.sqrt(val);
		return dist;
	}
	/*
	 * @param[Point Object][Takes point object to access its x and y coords]
	 * @return[True or False based whether the x and y coords of both Point objects are equal]
	*/
	public boolean equals(Point object)
	{
		if (xcoord == object.getX() && ycoord == object.getY())
		{
			return true;
		}
		else
			return false;
	}
	/*
	 * @return[Returns x and y coords in brackets as a string]
	*/
	public String toString()
	{
		String string = "(" + xcoord + "," + ycoord + ")";
		return string;
	}
	/*
	 * @param[Point Object][Takes point object to access its x and y coords]
	 * @return[New point object whose x and y coords are the sum of the two objects used by the method]
	*/
	public Point add(Point object)
	{
		int sum_x = xcoord + object.getX();
		int sum_y = ycoord + object.getY();
		Point sum_point = new Point(sum_x, sum_y);
		return sum_point;
	}
	/*
	 * @return[value of x coord]
	*/
	public int getX() 
	{
		return xcoord;
	}
	/*
	 * @return[value of y coord]
	*/
	public int getY() 
	{
		return ycoord;
	}
	/*
	 * @param[int units][units to move the point by in x plane.]
	*/
	public void moveLeft(int units) 
	{
		xcoord = getX() - units;
	}
	/*
	 * @param[int units][units to move the point by in x plane.]
	*/
	public void moveRight(int units) 
	{
		xcoord = getX() + units;
	}
	/*
	 * @param[int units][units to move the point by in y plane.]
	*/
	public void moveUp(int units) 
	{
		ycoord = getY() + units;
	}
	/*
	 * @param[int units][units to move the point by in y plane.]
	*/
	public void moveDown(int units) 
	{
		ycoord = getY() - units;
	}
	/*
	 * @return[Direction in X plane (east or west)]
	*/
	public String xDir()
	{
		if (xcoord > 0)
		{
			return "East";
		}
		else if (xcoord < 0) 
		{
			return "West";
		}
		else if (xcoord == 0) 
		{
			return "x_orig";
		}
		return "WACK";
	}
	/*
	 * @return[Direction in y plane (north or south))]
	*/
	public String yDir()
	{
		if (ycoord > 0)
		{
			return "North";
		}
		else if (ycoord < 0) 
		{
			return "South";
		}
		else if (ycoord == 0) 
		{
			return "y_orig";
		}
		return "WACK";
	}
	/*
	 * @return[Quadrant that point lies on]
	*/
	public String quadrant()
	{
		if (xDir() == "x_orig" && yDir() == "y_orig") 
		{
			return "origin";
		}
		else if (xDir() == "East" && yDir() == "North") 
		{
			return "NE";
		}
		else if (xDir() == "West" && yDir() == "North") 
		{
			return "NW";
		}
		else if (xDir() == "East" && yDir() == "South") 
		{
			return "SE";
		}
		else if (xDir() == "West" && yDir() == "South") 
		{
			return "SW";
		}
		else if (xDir() == "East" && yDir() == "y_orig") 
		{
			xDir();
		}
		else if (xDir() == "West" && yDir() == "y_orig") 
		{
			xDir();
		}
		else if (xDir() == "x_orig" && yDir() == "North") 
		{
			yDir();
		}
		else if (xDir() == "x_orig" && yDir() == "South") 
		{
			yDir();
		}
		return "WACK";	
	} 
}