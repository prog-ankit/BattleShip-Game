import java.util.Scanner;
public class BattleshipGame {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean play = false;
		while(play!=true) {
			Ocean ocean1=new Ocean();
			System.out.println("---------------------------------------------------");			
			System.out.println("Name: Ankit Bose" + "\nEnrollment: 186230307011");
			System.out.println("Welcome to play BattleShip on behalf of ANKIT BOSE");
			System.out.println("---------------------------------------------------");			
			ocean1.placeAllShipsRandomly();
			ocean1.print();
			while(!ocean1.isGameOver())
			{	
				System.out.println("\nEnter five Co-ordinates to make hit: ");
				String inputs = scn.nextLine();
				String[] x = inputs.split(";",5);
				String[] y=new String[5];
				for(int i=0;i<5;i++) {
					y=x[i].split(",",10);
					int row=Integer.parseInt (y[0]);
					int column=Integer.parseInt(y[1]);
					if(ocean1.shootAt(row,column)) 
					{;}
				}
				int shots = ocean1.getShotsFired();
				System.out.println("Shots Fired: "+shots);
				int hits = ocean1.getHitCount();
				System.out.println("hits count: "+hits);
				int sunk = ocean1.getShipSunk();	
				System.out.println("Ships Sunk: "+sunk);
				ocean1.print();
			}
			System.out.println("Wanna PlayAgain??");
			System.out.println("Enter Yes or No");
			String ack = scn.nextLine();
			if (ack.equals("No")) {
				System.out.println("*Your Game is Over*-Loved it then play again!!");
				play=true;
			}
			else
				ocean1=null;
				scn.close();
		}
	}
}	