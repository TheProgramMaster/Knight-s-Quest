
public class Cleric {
	private int health;
	private int healingPower;
	private int defense;
	public Cleric(int health, int healingPower, int defense) {
		this.health = health;
		this.healingPower = healingPower;
		this.defense = defense;
	}
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHealingPower() {
		return this.healingPower;
	}
	public void setHealingPower(int healingPower) {
		this.healingPower = healingPower;
	}
	public int getDefense() {
		return this.defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public String toString() {
		String result = "";
		result += "Health of Cleric: " + this.getHealth() + "\n" + 
		"Healing Power of Cleric: " + this.getHealingPower() + "\n" +
		"Defense of Cleric: " + this.getDefense();
		return result;
	}
}
