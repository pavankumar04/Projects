package Demo;

public class ComputerFactory {
	public static Computer getComputer(String type, String memory, String hdd) {
		if("Laptop".equalsIgnoreCase(type)) {
			return new  Laptop(memory, hdd);
		}else
			return null;
	}
}
