package main.map.DTO;

public class mapDTO {
	private String x;
	private String y;
	private String dong;
	private int count;

	public mapDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public mapDTO(String x, String y, String dong, int count) {
		super();
		this.x = x;
		this.y = y;
		this.dong = dong;
		this.count = count;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "mapDTO [x=" + x + ", y=" + y + ", dong=" + dong + ", count=" + count + "]";
	}

}
