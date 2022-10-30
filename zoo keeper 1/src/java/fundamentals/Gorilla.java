package java.fundamentals;
public class Gorilla extends Mammal {
	
	

	public void throwSomething(int action) {
		// TODO Auto-generated constructor stub
		for (int i=0;i<action; i++) {
		System.out.println("the gorilla throw something.");
		this.energyLevel -=5;
	}
	}
	
	public void eatBananas(int action) {
		for (int i=0;i<action; i++) {
		System.out.println("the gorilla ate bananas" );
		
		this.energyLevel+=10;
	}
	}
	
	public void climb(int action) {
		for (int i=0;i<action; i++) {
		System.out.println("the gorilla climed a tree" );
		this.energyLevel-=10;
	}
	}
	
	

}
