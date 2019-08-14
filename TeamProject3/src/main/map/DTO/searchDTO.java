package main.map.DTO;

public class searchDTO {
	private String day;
	private String time;
	private String sex;
	private String age;
	private String max;

	public searchDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public searchDTO(String day, String time, String sex, String age, String max) {
		super();
		this.day = day;
		this.time = time;
		this.sex = sex;
		this.age = age;
		this.max = max;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	@Override
	public String toString() {
		return "searchDTO [day=" + day + ", time=" + time + ", sex=" + sex + ", age=" + age + ", max=" + max + "]";
	}

}
