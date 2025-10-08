package javagame;


// Friend class
class Friend{
	static int[] max_exp = {0, 100, 200, 300 ,400, 500, 800, 900};
	
	String name;
	int lv;
	int exp;
	int hp;
	int atk;
	
	void print_party() {
		System.out.printf("%-10s%-10s\n", "Class: ", name);
		System.out.printf("%-10s%-10d\n", "Level: ", lv);
		System.out.printf("%-10s%-10d\n", "exp: ", exp);
		System.out.printf("%-10s%-10d\n", "HP: ", hp);
		System.out.printf("%-10s%-10d\n", "ATK: ", atk);
		System.out.printf("\n");
		}
	
	
	// Calculate exp method
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
				levelup(i - 1, remain_exp);
				return new int[] {i - 1, remain_exp};
				}
			
			else
				remain_exp -= max_exp[i];
			}
		
		//Safe gear
		return new int[] {lv, exp};
		}
	
	
	void levelup(int level, int new_exp) {
		int saved_level = level - lv;
		lv += level;
		exp = new_exp;
		hp += hp/10*saved_level;
		atk += atk/10*saved_level;
		
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


//Main
public class Javagame {
	public static void main(String[] args) {
		Friend party[] = new Friend[4];
		Friend warrior = new Friend();
		Friend hacker = new Friend();
		
		warrior.name = "Warrior";
		warrior.lv = 1;
		warrior.exp = 0;
		warrior.hp = 100;
		warrior.atk = 100;
		party[0] = warrior;
		
		hacker.name = "Hacker";
		hacker.lv = 1;
		hacker.exp = 0;
		hacker.hp = 100;
		hacker.atk = 10;
		party[1] = hacker;
		
		warrior.print_party();
		hacker.print_party();
		
		hacker.cal_exp(450);
	}
}
