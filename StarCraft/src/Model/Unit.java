package Model;

import listener.OnDiedListener;

public abstract class Unit {

	protected int hp;
	protected int hit;
	protected String name;
	protected Location location;
	protected int range;
	
	private OnDiedListener onDiedListener;
	
	
	
	
	public OnDiedListener getOnDiedListener() {
		return onDiedListener;
	}

	public void setOnDiedListener(OnDiedListener onDiedListener) {
		this.onDiedListener = onDiedListener;
	}

	public Unit(int hp,int hit,int range, String name){
	
		this.hp=hp;
		this.hit=hit;
		this.range=range;
		this.name=name;
		this.location = new Location(0,0);
		
		
	}
	
	public abstract void bark();
	
	
	
	
	public void move(int x, int y){
		this.location.work(x, y);
		
	}

	

	public void state(){
	
		System.out.println(this.name+"의 체력은 "+this.hp+"입니다.");
		System.out.println(this.name+"의 공격력은 "+this.hit+"입니다.\n");
		System.out.println(this.location);
	}
	
<<<<<<< HEAD
	public boolean isAttackable(Unit unit){
		double num = this.location.distance(unit.location);
		if(num>=this.range){
			return false;
		}
		else 
			return true;
	}
=======

>>>>>>> d8c1999da22f104f8bfe0a7947af76ce64da30e3
	
	public void attack(Unit unit){

			if(unit.hp<=0){
				System.out.println("더이상 공격할 수 없습니다.");
				
			}else{
				unit.hp = unit.hp - this.hit;
				
				System.out.println(this.name +"이(가) " +unit.name+"을(를) 공격했습니다.\n"+unit.name+"의 hp가 "+this.hit+" 닳았습니다.\n");
		
				if(unit.hp <= 0){
					
					OnDiedListener targetOnDiedListener = unit.getOnDiedListener();
					if(targetOnDiedListener !=null){
						targetOnDiedListener.onDied();
					}
					
				
				}
			}
<<<<<<< HEAD
		
=======
	}
	
	
	public boolean isAttackable(Unit unit){
		double num = this.location.distance(unit.location);
		if(num>=this.range){
			return false;
		}
		else 
			return true;
>>>>>>> d8c1999da22f104f8bfe0a7947af76ce64da30e3
	}
	

	
	
	public void portion(int x){
		System.out.println(this.name +"이(가) 포션을 먹고 체력이 회복되었습니다.");
		this.hp = this.hp + x;
		System.out.println(this.name + "의 현재 hp: "+hp+"\n");
	}

	public void upgrade(){
		System.out.println(this.name+"의 공격력이 10 증가하였습니다\n");
		this.hit = this.hit +10;
	}
	
}
