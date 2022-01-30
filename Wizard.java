
public class Wizard {
	private int health;
	private int power;
	private int defense;
	public Wizard(int health, int power, int defense) {
		this.health = health;
		this.power = power;
		this.defense = defense;
	}
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getPower() {
		return this.power;
	}
	public void setpower(int power) {
		this.power = power;
	}
	public int getDefense() {
		return this.defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public String toString() {
		String result = "";
		result += "Health of Wizard: " + this.getHealth() + "\n" +
		"Power of Wizard: " + this.getPower() + "\n" + 
		"Defense of Wizard: " + this.getDefense();
		return result;
	}
}
