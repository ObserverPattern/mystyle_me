package Model;

public class FireBet extends Unit{

	public FireBet(String name){
		super(130,10,3,name);
		this.name=name;
	}

	public void bark(){
		System.out.println("���̾���Դϴ�");
		
	}
	
	public void state(){
		
		System.out.println(this.name+"(���̾)�� ü���� "+this.hp+"�Դϴ�."
				+ "("+ location.getX()+","+location.getY()+")"+"  [���ݷ�:"+this.hit+"]");
	}
	
}
