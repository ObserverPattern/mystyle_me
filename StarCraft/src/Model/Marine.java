package Model;

public class Marine extends Unit{

	public Marine(String name){
		super(100,10,10,name);
		this.name=name;
		
	}
	
	public void bark(){
		System.out.println("마린입니다");
		
	}
			
	public void state(){
		System.out.println(this.name+"(마린)의 체력은 "+this.hp+"입니다."
				+ "("+ location.getX()+","+location.getY()+")"+"  [공격력:"+this.hit+"]");
	}
	

	
}
