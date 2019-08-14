package main.map.DTO;

import java.util.ArrayList;

public class setMapDTO {
	private String col_name;
	private ArrayList<mapDTO> list;

	public setMapDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public setMapDTO(String col_name, ArrayList<mapDTO> list) {
		super();
		this.col_name = col_name;
		this.list = list;
	}

	public String getCol_name() {
		return col_name;
	}

	public void setCol_name(String col_name) {
		this.col_name = col_name;
	}

	public ArrayList<mapDTO> getList() {
		return list;
	}

	public void setList(ArrayList<mapDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "setMapDTO [col_name=" + col_name + ", list=" + list + "]";
	}

}
