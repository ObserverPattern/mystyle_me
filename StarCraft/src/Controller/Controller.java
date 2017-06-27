package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import listener.OnDiedListener;
import Model.FireBet;
import Model.Marine;
import Model.Unit;

import com.kyh0209.Module;
import com.won2gonzo.MyModule;

public class Controller {
	static List<Unit> list =new ArrayList<Unit>();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		Module m = new Module();
		m.run();
		
		MyModule m2 = new MyModule();
		m2.run();
		
		while(true){
			System.out.println("--------------------------------------------");
			System.out.println(" 마린 생성:1   파이어벳 생성:2   현황  보기:3   유닛 이동:4");
			System.out.println(" 공격 하기:5   유닛 체력회복:6   공격력증가:7   종료 하기:8");
			System.out.println("--------------------------------------------");
			
			int input= scanner.nextInt();
			
			switch(input){
			case 1:
				System.out.println("마린의 이름:");
				String name = scanner.next();
				Marine marine = new Marine(name);
				
				OnDiedListener onDiedListenerImpl = new OnDiedListener(){
					public void onDied(){
						System.out.println(name +"가 죽었습니다");
					}
				};
				marine.setOnDiedListener(onDiedListenerImpl);
				
				
				
				list.add(marine);
				break;
				
			case 2:
				System.out.println("파이어벳의 이름:");
				String name2 = scanner.next();
				FireBet firebet = new FireBet(name2);
				list.add(firebet);
				break;
				
			case 3:
				System.out.println("*총 "+ list.size()+"마리*");
				
				for (Unit unit2 : list) {
					System.out.println(list.indexOf(unit2)+1 +"번 유닛:");
					unit2.state();
					
				}
				
				break;
			case 4:
				System.out.println("*선택가능한 유닛*");
				
				for (Unit unit2 : list) {
					System.out.println(list.indexOf(unit2)+1 +"번 유닛:");
					unit2.state();
					
				}
				System.out.println("\n이동할 유닛을 선택하세요:");
				int unitNum = scanner.nextInt()-1;
				if(unitNum+1 <=list.size()){
					Unit unit = list.get(unitNum);
					
					System.out.print("이동할 거리를 입력해주세요(x,y):\nx:");
					int dx=scanner.nextInt();
					
					System.out.print("y:");
					int dy=scanner.nextInt();
			
					unit.move(dx, dy);
					
				}else{
					System.out.println("이동할 수 없습니다");
				}
				
				break;
				
			case 5:
				System.out.println("*선택가능한 유닛*");
				for (Unit unit2 : list) {
					System.out.println(list.indexOf(unit2)+1 +"번 유닛:");
					unit2.state();
				}
				System.out.println("공격할 유닛을 선택하세요 :");
				int num = scanner.nextInt()-1;
				if(num+1 <=list.size()){
					System.out.println("*선택가능한 유닛*");
					for (Unit unit2 : list) {
						if(list.indexOf(unit2)!=num){
							System.out.println(list.indexOf(unit2)+1 +"번 유닛:");
							unit2.state();
						}
					}
					System.out.println("누구를 공격하시겠습니까? \n");
					int num2 = scanner.nextInt()-1;

					if(num2+1 <=list.size() && list.get(num).isAttackable(list.get(num2))){
						list.get(num).attack(list.get(num2));
					}else{
						System.out.println("공격할 수 없습니다.");
					}
				}else{
					System.out.println("다시 선택하세요.");
				}
				break;
			case 6:
				System.out.println("*선택가능한 유닛*");
				for (Unit unit2 : list) {
					System.out.println(list.indexOf(unit2)+1 +"번 유닛:");
					unit2.state();
				}
				System.out.println("체력을 회복할 유닛을 선택하세요 :");
				num = scanner.nextInt()-1;
				if(num+1 <=list.size()){
					System.out.println("1.고급물약(+30)   2.빨간물약(+10)   3.싸구려물약(+5)");
					int num3 = scanner.nextInt();
					switch(num3){
					case 1:
						list.get(num).portion(30);
						break;
					case 2:
						list.get(num).portion(10);
						break;
					case 3:
						list.get(num).portion(5);
						break;
					default:
						System.out.println("해당 물약이 없습니다.");
						break;
					}
				}else{
					System.out.println("다시 선택하세요.");
				}
				break;
			case 7:
				System.out.println("*선택가능한 유닛*");
				for (Unit unit2 : list) {
					System.out.println(list.indexOf(unit2)+1 +"번 유닛:");
					unit2.state();
				}
				System.out.println("공격력을 증가시킬 유닛을 선택하세요 :");
				
				num = scanner.nextInt()-1;
				if(num+1 <=list.size()){
					list.get(num).upgrade();
				}else{
					System.out.println("다시 선택하세요.");
				}
				break;
			case 8:
				System.out.println("종료되었습니다.");
				return;
			
			default :
				System.out.println("다시 입력하세요");
			}
		}
	}
}
