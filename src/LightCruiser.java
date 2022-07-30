public class LightCruiser extends Ship{
	LightCruiser(){
		length = 5;
		for(int i=0;i<length;i++)
			hit[i] = false;
	}
	@Override
	String getShipType() {
		return "lightcruiser";
	}
}
