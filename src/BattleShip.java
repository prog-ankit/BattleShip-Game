public class BattleShip extends Ship{
	BattleShip(){
		length = 8;
		for(int i=0;i<length;i++)
			hit[i] = false;
	}
	@Override
	String getShipType() {
		return "Battleship";
	}
}
