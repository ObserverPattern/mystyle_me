package Model;



public class Location {
	
	private int x;
	private int y;

	public Location(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
	}
	
	public void work(int x, int y){
		this.x += x;
		this.y += y;
	}
	
	public double distance(Location unit){
		int xd = unit.x - x;
		int yd = unit.y - y;
		return Math.sqrt(
				Math.pow(xd,2)
				+Math.pow(yd,2)
				);
	
	}



}
