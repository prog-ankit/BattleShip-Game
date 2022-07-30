public class EmptySea extends Ship{
	EmptySea(){
		length=1;
	}
	@Override
	public String toString() {
		return ".";
	}
	@Override
	public boolean shootAt(int row, int column) {
		return false;
	}
	@Override
	public boolean isSunk() {
		return false;
	}
	@Override
	String getShipType() {
		return "empty";
	}
}