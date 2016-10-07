public class Point {
	//attribute definitions
	private int xcoord;
	private int ycoord;
	//constructor definitions
	Point() {
		xcoord = 0;
		ycoord = 0;
	}
	Point(int x, int y) {
		xcoord = x;
		ycoord = y;
	}
	//methods
	public int getX() {
		return xcoord;
	}
	public int getY() {
		return ycoord;
	}
	public void moveLeft(int units) {
		xcoord = getX() - units;
	}
	public void moveRight(int units) {
		xcoord = getX() + units;
	}
	public void moveUp(int units) {
		ycoord = getY() + units;
	}
	public void moveDown(int units) {
		ycoord = getY() - units;
	}
}