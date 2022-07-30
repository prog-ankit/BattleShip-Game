public class BattleCruiser extends Ship{
	BattleCruiser(){
		length = 7;
		for(int i=0;i<length;i++)
			hit[i] = false;
	}
	@Override
	String getShipType() {
		return "Battlecruiser";
	}
}
