package main.map.DTO;

public class chartDTO {
	private int total;
	private int M;
	private int W;

	public chartDTO() {
		super();
	}

	public chartDTO(int total, int m, int w) {
		super();
		this.total = total;
		M = m;
		W = w;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getM() {
		return M;
	}

	public void setM(int m) {
		M = m;
	}

	public int getW() {
		return W;
	}

	public void setW(int w) {
		W = w;
	}

	@Override
	public String toString() {
		return "chartDTO [total=" + total + ", M=" + M + ", W=" + W + "]";
	}

}
