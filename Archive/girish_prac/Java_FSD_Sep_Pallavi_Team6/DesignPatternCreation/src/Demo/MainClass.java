package Demo;

public class MainClass {
	public static void main(String[] args) {
		Computer obj = ComputerFactory.getComputer("Laptop", "16 gb", "1 tb");
		
		System.out.println("Factory Config: " + obj.toString());
	}
}
