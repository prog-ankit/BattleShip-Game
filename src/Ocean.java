import java.util.Scanner;
public class Ocean {
	private Ship[][] ships = new Ship[20][20];
	public boolean[][] temp_help=new boolean[20][20];
	Ship battleship = new BattleShip();
	Ship battlecruiser = new BattleCruiser();
	Ship cruiser_1 = new Cruiser();
	Ship cruiser_2 = new Cruiser();
	Ship lightcruiser_1 = new LightCruiser();
	Ship lightcruiser_2 = new LightCruiser();
	Ship destroyer_1 = new Destroyer();
	Ship destroyer_2 = new Destroyer();
	Ship destroyer_3 = new Destroyer();
	Ship submarine_1 = new Submarine();
	Ship submarine_2 = new Submarine();
	Ship submarine_3 = new Submarine();
	Ship submarine_4 = new Submarine();
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	public EmptySea empty=new EmptySea();
	Ocean ocean;
	Scanner s = new Scanner(System.in);
	Ocean(){
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
		for(int i=0; i<20;i++){
			for(int j=0; j<20; j++){
				temp_help[i][j] = false;
				ships[i][j] = empty;
			}
		}
	}	
	void placeAllShipsRandomly() {
		if(battleship.okToPlaceShipAt(12,3,false,this))
			battleship.placeShipAt(12,3,false,this);
		else 
			System.out.println("Cannot place battleship");
		if(battlecruiser.okToPlaceShipAt(2,2,true,this))
			battlecruiser.placeShipAt(2,2,true,this);
		else 
			System.out.println("Cannot place battlecruiser");
		if(cruiser_1.okToPlaceShipAt(10,0,true,this))
			cruiser_1.placeShipAt(10,0,true,this);
		else
			System.out.println("Cannot place cruiser_1");
		if(cruiser_2.okToPlaceShipAt(2,9,false,this))
			cruiser_2.placeShipAt(2,9,false,this);
		else
			System.out.println("Cannot place cruiser_2");
		if(lightcruiser_1.okToPlaceShipAt(0,4,false,this))
			lightcruiser_1.placeShipAt(0,4,false,this);
		else
			System.out.println("Cannot place lightcruiser_1");
		if(lightcruiser_2.okToPlaceShipAt(5,8,false,this))
			lightcruiser_2.placeShipAt(5,8,false,this);
		else
			System.out.println("Cannot place lightcruiser_2");
		if(destroyer_1.okToPlaceShipAt(15,15,true,this))
			destroyer_1.placeShipAt(15,15,true,this);
		else
			System.out.println("Cannot place destroyer_1");
		if(destroyer_2.okToPlaceShipAt(4,0,true,this))
			destroyer_2.placeShipAt(4,0,true,this);
		else
			System.out.println("Cannot place destroyer_2");
		if(destroyer_3.okToPlaceShipAt(7,11,false,this))
			destroyer_3.placeShipAt(7,11,false,this);
		else
			System.out.println("Cannot place destroyer_3");
		if(submarine_1.okToPlaceShipAt(18,6,false,this))
			submarine_1.placeShipAt(18,6,false,this);
		else
			System.out.println("Cannot place submarine_1");
		if(submarine_2.okToPlaceShipAt(8,15,true,this))
			submarine_2.placeShipAt(8,15,true,this);
		else 
			System.out.println("Cannot place submarine_2");
		if(submarine_3.okToPlaceShipAt(19,2,false,this))
			submarine_3.placeShipAt(19,2,false,this);
		else 
			System.out.println("Cannot place submarine_3");
		if(submarine_4.okToPlaceShipAt(7,7,true,this))
			submarine_4.placeShipAt(7,7,true,this);
		else 
			System.out.println("Cannot place submarine_4");	
	}
	boolean isOccupied(int row,int column) {
		if(ships[row][column]==empty)
			return false;
		return true;
	}
	boolean shootAt(int row, int column) {
		shotsFired++;
		if(temp_help[row][column]==false){
			Ship sobj=ships[row][column];
			temp_help[row][column]=true;
			if(!sobj.shootAt(row,column))
				return false;		
			hitCount++;
			return true;
		}
		return false;
	}
	public int getShotsFired() {
		return shotsFired;
	}
	public int getHitCount(){
		return hitCount;
	}
	Ship[][] getShipArray(){
		return ships;
	}
	int getShipSunk() {
		shipsSunk=0;
		shipsSunk += battleship.countSunk("");
		shipsSunk += battlecruiser.countSunk("");
		shipsSunk += cruiser_1.countSunk("1");
		shipsSunk += cruiser_2.countSunk("2");
		shipsSunk += lightcruiser_1.countSunk("1");
		shipsSunk += lightcruiser_2.countSunk("2");
		shipsSunk += destroyer_1.countSunk("1");
		shipsSunk += destroyer_2.countSunk("2");
		shipsSunk += destroyer_3.countSunk("3");
		shipsSunk += submarine_1.countSunk("1");
		shipsSunk += submarine_2.countSunk("2");
		shipsSunk += submarine_3.countSunk("3");
		shipsSunk += submarine_4.countSunk("4");
		return shipsSunk;
	}
	boolean isGameOver() {
		if(shipsSunk==13)
			return true;
		return false;
	}	
	void print() {
		System.out.print("   ");
		for(int a=0;a<20;a++)
			System.out.printf(" %5d",a);
		System.out.println();
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				if(j==0) 
					System.out.printf("%5d ",i);
				if(temp_help[i][j]==true) {
					Ship obj=ships[i][j];
					String str=obj.toString();
					if(str=="x") 
						System.out.print("   X  ");
					else if(str=="s"){				
						boolean ans=temp_help[i][j];
						if(ans) 
							System.out.print("   S  ");
						else 
							System.out.print("   .  ");
					}
					else 
						System.out.print("   -  ");
				}
				else
					System.out.print("   .  ");				
			}
			System.out.println();
		}	
	}
}