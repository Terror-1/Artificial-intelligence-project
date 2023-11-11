package code;

import java.util.Objects;

public class State {


	private int prosperity;
	private int food;
	private int materials;
	private int energy;
	private int moneySpent;
	private int currBudget;
	private int delay;
	private int pendingType;
	private double h;
	private String strategy;



	
	public State(int prosperity, int food, int materials, int energy, int moneySpent, int currBudget, int delay, int pendingType, double h, String strategy) {
		this.prosperity=prosperity;
		this.food=food;
		this.materials=materials;
		this.energy=energy;
		this.moneySpent=moneySpent;
		this.currBudget = currBudget;
		this.delay = delay;
		this.pendingType = pendingType;
		this.h = h;
		this.strategy = strategy;
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
	public int getCurrBudget() {
		return currBudget;
	}
	public void setCurrBudget(int currBudget) {
		this.currBudget = currBudget;
	}
	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getPendingType() {
		return pendingType;
	}

	public void setPendingType(int pendingType) {
		this.pendingType = pendingType;
	}
	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}


	@Override
	public int hashCode() {
		return Objects.hash(currBudget, delay, energy, food, h, materials, moneySpent, pendingType, prosperity,
				strategy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		return currBudget == other.currBudget && delay == other.delay && energy == other.energy && food == other.food
				&& Double.doubleToLongBits(h) == Double.doubleToLongBits(other.h) && materials == other.materials
				&& moneySpent == other.moneySpent && pendingType == other.pendingType && prosperity == other.prosperity
				&& Objects.equals(strategy, other.strategy);
	}

	@Override
	public String toString() {
		return "State{" +
				"moneySpent=" + moneySpent +
				", currBudget=" + currBudget +
				", prosperity=" + prosperity +
				", food=" + food +
				", materials=" + materials +
				", energy=" + energy +
				", delay=" + delay +
				", pendingType=" + pendingType +
				", heuristic=" + h +
				'}';
	}
}
