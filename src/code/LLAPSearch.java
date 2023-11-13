package code;

import java.util.*;

public class LLAPSearch extends GenericSearch{

	
	private int totalNum ;
	private boolean visual;
	private int maxDepth;
    
	public LLAPSearch() {
		this.totalNum = 0;
		this.maxDepth = initialBudget/consumptionCost;
	}
	//static variables
	private static final String[] actions = {"RequestFood","RequestMaterials","RequestEnergy","WAIT","BUILD1","BUILD2"};
	private static final int numBuilds = 2;
	private static final int initialBudget = 100000;
	// food , material , energy
	private static int initialProsperity;
	private static int initialFood;
	private static int initialMaterials;
	private static int initialEnergy;
    private static int unitPriceFood;
    private static int unitPriceMaterials;
    private static int unitPriceEnergy;
	private static int amountRequestFood;
	private static int amountRequestMaterials;
	private static int amountRequestEnergy;
	private static int delayRequestFood;
	private static int delayRequestMaterials;
	private static int delayRequestEnergy;
	private static int consumptionCost;
	private static final int[] priceBuild = new int[numBuilds];
	private static final int[] foodUseBuild = new int [numBuilds];
	private static final int[] materialsUseBuild = new int [numBuilds];
	private static final int[] energyUseBuild = new int [numBuilds];
	private static final int[] prosperityBuild = new int [numBuilds];
	
	
	// abstract functions
	public boolean isGoalTest (Node node ) {
		return node.getState().getProsperity()>=100;
	}
	public ArrayList<Node> expand(Node currNode) {
		ArrayList<Node> expanded = new ArrayList<>();
		State currState = currNode.getState();

		for (String action :actions) {
			if(action.equals("BUILD1")) {
				Node newNode = handleBuild(currNode, currState,0);
				if(newNode!=null)
					expanded.add(newNode);
			}
			if(action.equals("BUILD2")) {
				Node newNode = handleBuild(currNode, currState,1);
				if(newNode!=null)
					expanded.add(newNode);
			}
			if(currState.getCurrBudget()>consumptionCost&&currState.getFood()>=1&&currState.getMaterials()>=1&&currState.getEnergy()>=1) {
				State newState = new State(currState.getProsperity(),currState.getFood()-1,currState.getMaterials()-1,currState.getEnergy()-1,
						currState.getMoneySpent()+consumptionCost,currState.getCurrBudget()-consumptionCost,0,0,0, currState.getStrategy());
				newState.setH(getH(newState));
				if(action.equals("RequestFood")&&currState.getPendingType()==0&& currState.getFood()<50) {
					newState.setDelay(delayRequestFood);
					newState.setPendingType(1);
					handleDelivery(newState);
					Node newNode = new Node(currNode,"RequestFood",currNode.getDepth()+1, newState.getMoneySpent(),newState);
					expanded.add(newNode);
				}
				else if (action.equals("RequestMaterials")&&currState.getPendingType()==0&&currState.getMaterials()<50) {
					newState.setDelay(delayRequestMaterials);
					newState.setPendingType(2);
					handleDelivery(newState);
					Node newNode = new Node(currNode,"RequestMaterials",currNode.getDepth()+1, newState.getMoneySpent(),newState);
					expanded.add(newNode);
				}
				else if (action.equals("RequestEnergy")&&currState.getPendingType()==0&& currState.getEnergy()<50) {
					newState.setDelay(delayRequestEnergy);
					newState.setPendingType(3);
					handleDelivery(newState);
					Node newNode = new Node(currNode,"RequestEnergy",currNode.getDepth()+1, newState.getMoneySpent(),newState);
					expanded.add(newNode);
				}
				else if (action.equals("WAIT")&&currState.getPendingType()!=0) {
					newState.setDelay(Math.max(0,currState.getDelay()-1));
					newState.setPendingType(currState.getPendingType());
					handleDelivery(newState);
					Node newNode = new Node(currNode,"WAIT",currNode.getDepth()+1, newState.getMoneySpent(),newState);
					expanded.add(newNode);
				}
			}
		}
		return expanded;
	}

	public Node getInitialState(String problem,String strategy) {
		State rootState = new State(initialProsperity, initialFood, initialMaterials, initialEnergy, 0,initialBudget,0,0,0,strategy);
		rootState.setH(getH(rootState));
		return new Node(null, "", 0, 0, rootState);
	}
	
	public String getPrint(Node node){
		return getPlan(node.getParent()) + node.getOperator() + ";" + node.getPathCost() + ";"+totalNum;
	}
	public String getPlan(Node node){
		if(node.getParent() == null) return node.getOperator();
		return getPlan(node.getParent()) + node.getOperator() + ",";
	}	
	
	
	//static functions 
	public static String solve(String initialState , String strategy, boolean visualize) {
		interpreter(initialState);
		LLAPSearch llap = new LLAPSearch();
		llap.visual = visualize;
		String solution = llap.generalSearch(initialState, strategy);
		return solution;
		}
	
	private static Node handleBuild(Node currNode, State currState,int idx) {
		int resourcesCost = foodUseBuild[idx]*unitPriceFood+materialsUseBuild[idx]*unitPriceMaterials+energyUseBuild[idx]*unitPriceEnergy;
		State newState = new State(currState.getProsperity()+prosperityBuild[idx], currState.getFood()-foodUseBuild[idx], currState.getMaterials()-materialsUseBuild[idx], currState.getEnergy()-energyUseBuild[idx],
				currState.getMoneySpent()+priceBuild[idx]+resourcesCost, currState.getCurrBudget()-priceBuild[idx]-resourcesCost, Math.max(0,currState.getDelay()-1), currState.getPendingType(),0, currState.getStrategy());
		newState.setH(getH(newState));
		boolean chk = (newState.getCurrBudget() >= 0) && (newState.getFood() >= 0) && (newState.getEnergy() >= 0) && (newState.getMaterials() >= 0);
		handleDelivery(newState);
		return chk ? new Node(currNode,"BUILD"+(idx+1), currNode.getDepth()+1, newState.getMoneySpent(), newState) : null;
	}
	public static int getH(State s){
		String strat = s.getStrategy();
		int pros = s.getProsperity();
		int resourcesCost1 = priceBuild[0] + foodUseBuild[0] * unitPriceFood + materialsUseBuild[0] * unitPriceMaterials + energyUseBuild[0] * unitPriceEnergy;
		int resourcesCost2 = priceBuild[1] + foodUseBuild[1] * unitPriceFood + materialsUseBuild[1] * unitPriceMaterials + energyUseBuild[1] * unitPriceEnergy;

		if(strat.equals("GR1")||strat.equals("AS1")){
			return (int) Math.ceil(Math.min((resourcesCost1 / prosperityBuild[0]), ((resourcesCost2 / prosperityBuild[1]))) * Math.max(0,(100 - pros)));
		}
		else if (strat.equals("GR2")||strat.equals("AS2")){
			int req1 = (int) (Math.ceil(1.0 * Math.max(0,foodUseBuild[0]- s.getFood()) / amountRequestFood) +
					Math.ceil(1.0 * Math.max(0,materialsUseBuild[0]- s.getMaterials()) / amountRequestMaterials) +
					Math.ceil(1.0 * Math.max(0,energyUseBuild[0]- s.getEnergy()) / amountRequestEnergy));

			int req2 = (int) (Math.ceil(1.0 * Math.max(0,foodUseBuild[1]- s.getFood()) / amountRequestFood) +
					Math.ceil(1.0 * Math.max(0,materialsUseBuild[1]- s.getMaterials()) / amountRequestMaterials) +
					Math.ceil(1.0 * Math.max(0,energyUseBuild[1]- s.getEnergy()) / amountRequestEnergy));
			resourcesCost1 += req1*consumptionCost;
			resourcesCost2 += req2*consumptionCost;
			return (int) Math.ceil(Math.min((1.0 * resourcesCost1 / prosperityBuild[0]), ((1.0 * resourcesCost2 / prosperityBuild[1]))) *Math.max(0,(100-pros)));
		}
		return 0;
	}

	private static void handleDelivery(State currState){
		if(currState.getPendingType()!=0&&currState.getDelay()==0){
			if(currState.getPendingType()==1){
				currState.setFood(Math.min(50,currState.getFood()+amountRequestFood));
			}if(currState.getPendingType()==2){
				currState.setMaterials(Math.min(50,currState.getMaterials()+amountRequestMaterials));
			}if(currState.getPendingType()==3){
				currState.setEnergy(Math.min(50,currState.getEnergy()+amountRequestEnergy));
			}
			currState.setPendingType(0);
		}
	}
	private static void interpreter(String initialState){
		String [] vals = initialState.split("[;,]");
		initialProsperity = Integer.parseInt(vals[0]);
		initialFood = Integer.parseInt(vals[1]);
		initialMaterials = Integer.parseInt(vals[2]);
		initialEnergy = Integer.parseInt(vals[3]);
		unitPriceFood = Integer.parseInt(vals[4]);
		unitPriceMaterials = Integer.parseInt(vals[5]);
		unitPriceEnergy = Integer.parseInt(vals[6]);
		amountRequestFood = Integer.parseInt(vals[7]);
		delayRequestFood = Integer.parseInt(vals[8]);
		amountRequestMaterials = Integer.parseInt(vals[9]);
		delayRequestMaterials = Integer.parseInt(vals[10]);
		amountRequestEnergy = Integer.parseInt(vals[11]);
		delayRequestEnergy = Integer.parseInt(vals[12]);
		priceBuild[0] = Integer.parseInt(vals[13]);
		foodUseBuild[0]=Integer.parseInt(vals[14]);
		materialsUseBuild[0] = Integer.parseInt(vals[15]);
		energyUseBuild[0] = Integer.parseInt(vals[16]);
		prosperityBuild[0] = Integer.parseInt(vals[17]);
		priceBuild[1] = Integer.parseInt(vals[18]);
		foodUseBuild[1]=Integer.parseInt(vals[19]);
		materialsUseBuild[1] = Integer.parseInt(vals[20]);
		energyUseBuild[1] = Integer.parseInt(vals[21]);
		prosperityBuild[1] = Integer.parseInt(vals[22]);
		consumptionCost = unitPriceEnergy+unitPriceFood+unitPriceMaterials;
	}
	
	public int getMaxDepth() {
		return this.maxDepth;
	}
	public boolean isVisual() {
		return this.visual;
	}
	public void incrementTotalNum() {
		this.totalNum++;
	}
}
