
public class Point {
	//attribute definitions
	private int xcoord;
	private int ycoord;
	//constructor definitions
	Point() 
	{
		xcoord = 0;
		ycoord = 0;
	}
	Point(int x, int y) 
	{
		xcoord = x;
		ycoord = y;
	}
	//methods
	public double distance(Point object)
	{
		double dist;
		double x_dist = xcoord - object.getX();
		double y_dist = ycoord - object.getY();
		double val = (y_dist * y_dist) + (x_dist * x_dist);
		dist = Math.sqrt(val);
		return dist;
	}
	public int getX() 
	{
		return xcoord;
	}
	public int getY() 
	{
		return ycoord;
	}
	public void moveLeft(int units) 
	{
		xcoord = getX() - units;
	}
	public void moveRight(int units) 
	{
		xcoord = getX() + units;
	}
	public void moveUp(int units) 
	{
		ycoord = getY() + units;
	}
	public void moveDown(int units) 
	{
		ycoord = getY() - units;
	}
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