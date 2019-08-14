package main.map.DTO;

public class mapDTO {
	private double x;
	private double y;
	private int count;

	public mapDTO() {

	}

	public mapDTO(double x, double y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "mapDTO [x=" + x + ", y=" + y + ", count=" + count + "]";
	}

}
