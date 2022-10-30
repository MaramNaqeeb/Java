
public class Bat extends Mammal {
	
	
	public void fly(int action) {
		for (int i=0; i<action;i++) {
		System.out.println(" the bat flew");
		this.energyLevel-=50;
		System.out.println(this.energyLevel);
	}
	}

	public void eatHumans(int action) {
		for (int i=0; i<action;i++) {
		System.out.println(" the bat ate a human");
		this.energyLevel+=25;
		System.out.println(this.energyLevel);
	}
	}
	
	public void attackTown(int action) {
		for (int i=0; i<action;i++) {
		System.out.println("the bat attacked the town");
		this.energyLevel-=100;
		System.out.println(this.energyLevel);
	}
	}
}
