public abstract class Ship {
	protected int bowRow;
	protected int bowColumn;
	protected int length;
	protected boolean horizontal;
	boolean[] hit=new boolean[8];
	abstract String getShipType(); 
	boolean okToPlaceShipAt(int row, int column, boolean horizontal,Ocean ocean){
		int counter=0;
		if( row<0||row>19||column<0||column>19 )
			return false;
		if(!horizontal)
		{
			if(!(column+length < 20))
				return false;
			for(int i=column;i<length+column;i++){
				if(!ocean.isOccupied(row,i))
				{;}
				else
					counter=1;
			}
			if(counter==1)
				return false;
			else
				return true;
		}
		if(!(row+length < 20))
			return false;
		for(int i=row;i<length+row;++i){
			if(!ocean.isOccupied(i,column)) 
			{;}
			else
				counter=1;
		}
		if(counter==1)
			return false;
		else
			return true;
	}
	void placeShipAt(int row, int column, boolean horizontal,Ocean ocean){	
		Ship[][] tempship = ocean.getShipArray();
		this.bowRow = row;
		this.bowColumn = column;
		this.horizontal = horizontal;
		if(!horizontal) {
			for(int i=column;i<column+length;i++)			
				tempship[row][i]=this;
		}
		else {
			for(int i=row;i<row+length;i++)
				tempship[i][column]=this;
		}
	}
	public boolean shootAt(int row, int column)
	{	
		for(int i=0;i<this.length;i++) {
			if(this.hit[i]==false) { 
				this.hit[i]=true;
				return true;
			}
		}
		return false;	
	}
	public boolean isSunk() {
		int j=0;
		for(int i=0;i<this.length;i++) {
			if(!(this.hit[i]==true))
				j=1;
		}
		if(j==0) 
			return true;
		else
			return false;
	}
	public int countSunk(String str) {
		if(this.isSunk()) {
			if(str.equals(""))
				System.out.println("---"+this.getShipType()+str+"---");
			else
				System.out.println("---"+this.getShipType()+"_"+str+"---");
			return 1;
		}
		else
			return 0;
	}
	@Override
	public String toString() {
		if(this.isSunk())
			return "x";
		return "s";
	}				
}