package javagame;

class Friend{
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
		System.out.println("ATK: " + atk);
		System.out.println("");
	}
	
	void levelup(int level) {
		lv += level;
		hp += hp/10;
		atk += atk/10;
		
		System.out.println(name + " level up!");
		System.out.println("class: " + name);
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
		
		hacker.levelup(1);
	}
}
