package main.test.DTO;

public class TestDTO {
	public String test;

	public TestDTO(String test) {
		super();
		this.test = test;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "TestDTO [test=" + test + "]";
	}

}
