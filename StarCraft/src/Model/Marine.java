package Model;

public class Marine extends Unit{

	public Marine(String name){
		super(100,10,10,name);
		this.name=name;
		
	}
	
	public void bark(){
		System.out.println("�����Դϴ�");
		
	}
			
	public void state(){
		System.out.println(this.name+"(����)�� ü���� "+this.hp+"�Դϴ�."
				+ "("+ location.getX()+","+location.getY()+")"+"  [���ݷ�:"+this.hit+"]");
	}
	

	
}
