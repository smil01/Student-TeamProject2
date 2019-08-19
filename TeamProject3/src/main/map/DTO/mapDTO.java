package main.map.DTO;

public class mapDTO {
	private String x;
	private String y;
	private String dong;
	private int count;
	private String img;
	private String addr;

	public mapDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public mapDTO(String x, String y, String dong, int count, String img, String addr) {
		super();
		this.x = x;
		this.y = y;
		this.dong = dong;
		this.count = count;
		this.img = img;
		this.addr = addr;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "mapDTO [x=" + x + ", y=" + y + ", dong=" + dong + ", count=" + count + ", img=" + img + ", addr=" + addr
				+ "]";
	}

}
