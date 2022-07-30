public class Destroyer extends Ship{
	Destroyer(){
		length = 4;
		for(int i=0;i<length;i++)
			hit[i] = false;
	}
	@Override
	String getShipType() {
		return "destroyer";
	}
}
