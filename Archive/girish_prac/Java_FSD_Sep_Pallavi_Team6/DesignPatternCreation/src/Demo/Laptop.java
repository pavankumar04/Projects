package Demo;

public class Laptop extends Computer {
	private String memory;
	private String hdd;
	
	public Laptop() {}
	
	public Laptop(String memory, String hdd) {
		super();
		this.memory = memory;
		this.hdd = hdd;
	}
	
	public String getHdd() {
		return hdd;
	}
	
	public String getMemory() {
		return memory;
	}
}
