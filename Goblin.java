
public class Goblin {
	private int health;
	private int strength;
	private int defense;
	public Goblin(int health, int strength, int defense) {
		this.health = health;
		this.strength = strength;
		this.defense = defense;
	}
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getStrength() {
		return this.strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getDefense() {
		return this.defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public String toString() {
		String result = "";
		result += "Health of Goblin: " + this.getHealth() + "\n" +
		"Strength of Goblin: " + this.getStrength() + "\n" +
		"Defense of Goblin: " + this.getDefense();
		return result;
	}
}
