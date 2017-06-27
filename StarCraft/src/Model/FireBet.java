package Model;

public class FireBet extends Unit{

	public FireBet(String name){
		super(130,10,3,name);
		this.name=name;
	}

	public void bark(){
		System.out.println("파이어뱃입니다");
		
	}
	
	public void state(){
		
		System.out.println(this.name+"(파이어벳)의 체력은 "+this.hp+"입니다."
				+ "("+ location.getX()+","+location.getY()+")"+"  [공격력:"+this.hit+"]");
	}
	
}
