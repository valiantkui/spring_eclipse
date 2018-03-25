package class02;

public class Depart {

	private String name;
	
	

	public Depart() {
		System.out.println("Depart()");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Depart [name=" + name + "]";
	}
	
	
}
