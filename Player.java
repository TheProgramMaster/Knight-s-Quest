
public class Player {
	private int health;
	private int strength;
	private int defense;
	public Player(int health, int strength, int defense) {
		this.health = health;
		this.strength = strength;
		this.defense = defense;
	}
	public int getStrength() {
		return this.strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getDefense() {
		return this.defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int fight() {
		return (int)(Math.random()*this.getStrength());
	}
	public int block() {
		return (int)(Math.random()*this.getDefense());
	}
	public String toString() {
		String result = "";
		result += "Health of Player: " + this.getHealth() + "\n" +
		"Strength of Player: " + this.getStrength() + "\n" +
		"Defense of Player: " + this.getDefense();
		return result;
		
	}
}
