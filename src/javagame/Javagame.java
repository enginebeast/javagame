package javagame;

class Friend{
	static int[] max_exp = {0, 100, 200, 300 ,400, 500, 800, 900};
	
	String name;
	int lv;
	int exp;
	int hp;
	int atk;
	
	void print() {
		System.out.println("Class: " + name);
		System.out.println("Level: " + lv);
		System.out.println("exp: " + exp);
		System.out.println("HP: " + hp);
		System.out.println("ATK: " + atk + "\n");
	}
	
	int[] cal_exp(int get_exp) {
		//Already max level
		if(lv >= 10) {
			System.out.println(name + "is already max level!");
			return new int[] {lv, 0};
		}
		
		//Not already max level
		else 
			System.out.println(name + " get " + get_exp + "exp!\n");
		
		//Got exp is lack
		if(exp + get_exp < max_exp[lv]) 
			return new int[] {lv, exp + get_exp};

		
		//Character can level up!
		int remain_exp = exp + get_exp;
		for(int i = lv; i<11; i++) {
			//Now max level
			if (i == 10) {
				levelup(i, 0);
				return new int[] {i, 0};
				}
				
			//Calculate end
			else if(remain_exp < max_exp[i]) {
				levelup(i, 0);
				return new int[] {i, remain_exp};
				}
			
			else
				remain_exp -= max_exp[i];
			}
		
		//Safe gear
		return new int[] {lv, exp};
		}
	
	void levelup(int level, int new_exp) {
		lv += level;
		exp = new_exp;
		hp += hp/10;
		atk += atk/10;
		
		System.out.println(name + " level up!");
		System.out.println("Level: " + lv);
		System.out.println("exp: " + exp);
		System.out.println("HP: " + hp);
		System.out.println("ATK: " + atk);
	}
}


class Enemy{
	int lv;
	int hp;
	int atk;
}


public class Javagame {
	public static void main(String[] args) {
		Friend warrior = new Friend();
		Friend hacker = new Friend();
		
		warrior.name = "Warrior";
		warrior.lv = 1;
		warrior.exp = 0;
		warrior.hp = 100;
		warrior.atk = 100;
		
		hacker.name = "Hacker";
		hacker.lv = 1;
		hacker.exp = 0;
		hacker.hp = 100;
		hacker.atk = 10;
		
		warrior.print();
		hacker.print();
		
		hacker.cal_exp(300);
	}
}
