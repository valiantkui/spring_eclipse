package class02;

public class Apple implements Fruit {
	private String color;
	
	
	public void init() {
		System.out.println("Apple.init()");
	}
	
	public void destroy() {
		System.out.println("Apple.destroy()");
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Apple() {
		System.out.println("Apple()");
	}

	public void eaten() {
		System.out.println("apple.eaten()");
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + "]";
	}

	
}
