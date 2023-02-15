package Demo;

public abstract class Computer {
	public abstract String getMemory();
	public abstract String getHdd();
	
	public String toString() {
		return "RAM: " + getMemory() + ", HardDisk: " + getHdd();
	}
}
