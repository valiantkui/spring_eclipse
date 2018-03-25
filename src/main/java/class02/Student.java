package class02;

public class Student {
	private Depart depart;
	private String name;
	private int age;
	public Depart getDepart() {
		return depart;
	}
	public void setDepart(Depart depart) {
		this.depart = depart;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [depart=" + depart + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
