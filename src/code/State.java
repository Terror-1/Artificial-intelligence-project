package code;

public class State {

	private int prosperity;
	private int food;
	private int materials;
	private int energy;
	private int moneySpent;
	public State(int prosperity,int food,int materials,int energy,int moneySpent) {
		this.prosperity=prosperity;
		this.food=food;
		this.materials=materials;
		this.energy=energy;
		this.moneySpent=moneySpent;
	}
	public int getProsperity() {
		return prosperity;
	}
	public void setProsperity(int prosperity) {
		this.prosperity = prosperity;
	}
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food = food;
	}
	public int getMaterials() {
		return materials;
	}
	public void setMaterials(int materials) {
		this.materials = materials;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getMoneySpent() {
		return moneySpent;
	}
	public void setMoneySpent(int moneySpent) {
		this.moneySpent = moneySpent;
	}
	

}
