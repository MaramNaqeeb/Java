
public class Mammal {


	int energyLevel;
	
	public Mammal() {
		this.energyLevel=300;
	}

		
	public int displayEnergy(){
		System.out.println(this.energyLevel);
		return energyLevel;
	}
}
