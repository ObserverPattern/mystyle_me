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
			System.out.println(" ���� ����:1   ���̾ ����:2   ��Ȳ  ����:3   ���� �̵�:4");
			System.out.println(" ���� �ϱ�:5   ���� ü��ȸ��:6   ���ݷ�����:7   ���� �ϱ�:8");
			System.out.println("--------------------------------------------");
			
			int input= scanner.nextInt();
			
			switch(input){
			case 1:
				System.out.println("������ �̸�:");
				String name = scanner.next();
				Marine marine = new Marine(name);
				
				OnDiedListener onDiedListenerImpl = new OnDiedListener(){
					public void onDied(){
						System.out.println(name +"�� �׾����ϴ�");
					}
				};
				marine.setOnDiedListener(onDiedListenerImpl);
				
				
				
				list.add(marine);
				break;
				
			case 2:
				System.out.println("���̾�� �̸�:");
				String name2 = scanner.next();
				FireBet firebet = new FireBet(name2);
				list.add(firebet);
				break;
				
			case 3:
				System.out.println("*�� "+ list.size()+"����*");
				
				for (Unit unit2 : list) {
					System.out.println(list.indexOf(unit2)+1 +"�� ����:");
					unit2.state();
					
				}
				
				break;
			case 4:
				System.out.println("*���ð����� ����*");
				
				for (Unit unit2 : list) {
					System.out.println(list.indexOf(unit2)+1 +"�� ����:");
					unit2.state();
					
				}
				System.out.println("\n�̵��� ������ �����ϼ���:");
				int unitNum = scanner.nextInt()-1;
				if(unitNum+1 <=list.size()){
					Unit unit = list.get(unitNum);
					
					System.out.print("�̵��� �Ÿ��� �Է����ּ���(x,y):\nx:");
					int dx=scanner.nextInt();
					
					System.out.print("y:");
					int dy=scanner.nextInt();
			
					unit.move(dx, dy);
					
				}else{
					System.out.println("�̵��� �� �����ϴ�");
				}
				
				break;
				
			case 5:
				System.out.println("*���ð����� ����*");
				for (Unit unit2 : list) {
					System.out.println(list.indexOf(unit2)+1 +"�� ����:");
					unit2.state();
				}
				System.out.println("������ ������ �����ϼ��� :");
				int num = scanner.nextInt()-1;
				if(num+1 <=list.size()){
					System.out.println("*���ð����� ����*");
					for (Unit unit2 : list) {
						if(list.indexOf(unit2)!=num){
							System.out.println(list.indexOf(unit2)+1 +"�� ����:");
							unit2.state();
						}
					}
					System.out.println("������ �����Ͻðڽ��ϱ�? \n");
					int num2 = scanner.nextInt()-1;

					if(num2+1 <=list.size() && list.get(num).isAttackable(list.get(num2))){
						list.get(num).attack(list.get(num2));
					}else{
						System.out.println("������ �� �����ϴ�.");
					}
				}else{
					System.out.println("�ٽ� �����ϼ���.");
				}
				break;
			case 6:
				System.out.println("*���ð����� ����*");
				for (Unit unit2 : list) {
					System.out.println(list.indexOf(unit2)+1 +"�� ����:");
					unit2.state();
				}
				System.out.println("ü���� ȸ���� ������ �����ϼ��� :");
				num = scanner.nextInt()-1;
				if(num+1 <=list.size()){
					System.out.println("1.��޹���(+30)   2.��������(+10)   3.�α�������(+5)");
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
						System.out.println("�ش� ������ �����ϴ�.");
						break;
					}
				}else{
					System.out.println("�ٽ� �����ϼ���.");
				}
				break;
			case 7:
				System.out.println("*���ð����� ����*");
				for (Unit unit2 : list) {
					System.out.println(list.indexOf(unit2)+1 +"�� ����:");
					unit2.state();
				}
				System.out.println("���ݷ��� ������ų ������ �����ϼ��� :");
				
				num = scanner.nextInt()-1;
				if(num+1 <=list.size()){
					list.get(num).upgrade();
				}else{
					System.out.println("�ٽ� �����ϼ���.");
				}
				break;
			case 8:
				System.out.println("����Ǿ����ϴ�.");
				return;
			
			default :
				System.out.println("�ٽ� �Է��ϼ���");
			}
		}
	}
}
