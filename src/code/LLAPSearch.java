package code;

import java.util.*;

public class LLAPSearch {

	private static int totalNum = 0;
	private static final String[] actions = {"RequestFood","RequestMaterials","RequestEnergy","WAIT","BUILD1","BUILD2"};
	private static int numBuilds = 2;
	private static int initalBudget = 100000;
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

	private static final int[] priceBuild = new int[numBuilds];
	private static final int[] foodUseBuild = new int [numBuilds];
	private static final int[] materialsUseBuild = new int [numBuilds];
	private static final int[] energyUseBuild = new int [numBuilds];
	private static final int[] prosperityBuild = new int [numBuilds];
	private static int consumptionCost;
	
	public static boolean isGoalTest (Node node ) {
		return node.getState().getProsperity()>=100;
	}
	public static ArrayList<Node> expand(Node currNode) {

		ArrayList<Node> expanded = new ArrayList<>();
		State currState = currNode.getState();

		for (String action :actions) {


			if(currState.getCurrBudget()>consumptionCost&&currState.getFood()>=1&&currState.getMaterials()>=1&&currState.getEnergy()>=1) {
				State newState = new State(currState.getProsperity(),currState.getFood()-1,currState.getMaterials()-1,currState.getEnergy()-1,
						currState.getMoneySpent()+consumptionCost,currState.getCurrBudget()-consumptionCost,0,0);

				if (action.equals("RequestFood")&&currState.getPendingType()==0) {
					newState.setDelay(delayRequestFood);
					newState.setPendingType(1);
					handleDelivery(newState);
					Node newNode = new Node(currNode,"RequestFood",currNode.getDepth()+1, newState.getMoneySpent(),newState);
					expanded.add(newNode);

				} else if (action.equals("RequestMaterials")&&currState.getPendingType()==0) {
					newState.setDelay(delayRequestMaterials);
					newState.setPendingType(2);
					handleDelivery(newState);
					Node newNode = new Node(currNode,"RequestMaterials",currNode.getDepth()+1, newState.getMoneySpent(),newState);
					expanded.add(newNode);

				} else if (action.equals("RequestEnergy")&&currState.getPendingType()==0) {
					newState.setDelay(delayRequestEnergy);
					newState.setPendingType(3);
					handleDelivery(newState);
					Node newNode = new Node(currNode,"RequestEnergy",currNode.getDepth()+1, newState.getMoneySpent(),newState);
					expanded.add(newNode);

				} else if (action.equals("WAIT")&&currState.getPendingType()!=0) {
					newState.setDelay(currState.getDelay()-1);
					newState.setPendingType(currState.getPendingType());
					handleDelivery(newState);
					Node newNode = new Node(currNode,"WAIT",currNode.getDepth()+1, newState.getMoneySpent(),newState);
					expanded.add(newNode);
				}

			}
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
			
		}
		return expanded;
	}

	private static Node handleBuild(Node currNode, State currState,int idx) {
		int resourcesCost = foodUseBuild[idx]*unitPriceFood+materialsUseBuild[idx]*unitPriceMaterials+energyUseBuild[idx]*unitPriceEnergy;
		State newState = new State(currState.getProsperity()+prosperityBuild[idx], currState.getFood()-foodUseBuild[idx], currState.getMaterials()-materialsUseBuild[idx], currState.getEnergy()-energyUseBuild[idx],
				currState.getMoneySpent()+priceBuild[idx]+resourcesCost, currState.getCurrBudget()-priceBuild[idx]-resourcesCost, currState.getDelay()-1, currState.getPendingType());
		boolean chk = (newState.getCurrBudget() >= 0) && (newState.getFood() >= 0) && (newState.getEnergy() >= 0) && (newState.getMaterials() >= 0);
		return chk ? new Node(currNode,"BUILD"+(idx+1), currNode.getDepth()+1, newState.getMoneySpent(), newState) : null;
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
	public static String solve(String initialState , String strategy, boolean visualize ) {
		interpreter(initialState);
		String solution = "";
		State rootState = new State(initialProsperity, initialFood, initialMaterials, initialEnergy, 0,initalBudget,0,0);
		Node root = new Node(null, "", 0, 0, rootState);

		switch (strategy) {
		case "BF":solution = BFS(root);break;
		case "DF":solution = DFS(root);break; 
		case "ID":break;
		case "UC":solution = UCS(root);break;
		case "GR1":break;
		case "GR2":break;
		case "AS1":break;
		case "AS2":break;
		default:break;
		}
		return solution;
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
	public static String BFS(Node root) {
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		while(true) {
			if(nodes.isEmpty()) return "NOSOLUTION";
			Node currNode = nodes.poll();
			totalNum++;
			if(isGoalTest(currNode)) return getPrint(currNode);
			ArrayList<Node> children = expand(currNode);
			for (Node child:children) {
				nodes.add(child);
			}
		}
	}
	public static String DFS(Node root) {
		Stack<Node> nodes = new Stack<>();
		nodes.push(root);
		while(true) {
			if(nodes.isEmpty()) return "NOSOLUTION";
			Node currNode = nodes.pop();
			totalNum++;
			if(isGoalTest(currNode)) return getPrint(currNode);
			ArrayList<Node> children = expand(currNode);
			for (Node child:children) {
				nodes.push(child);
			}
		}
	}

	public static String UCS(Node root) {
		PriorityQueue<Node> nodes = new PriorityQueue<>();
		nodes.add(root);
		while(true) {
			if(nodes.isEmpty()) return "NOSOLUTION";
			Node currNode = nodes.poll();
			totalNum++;
			if(isGoalTest(currNode)) return getPrint(currNode);
			ArrayList<Node> children = expand(currNode);
			for (Node child:children) {
				nodes.add(child);
			}
		}
	}

	public static String getPrint(Node node){
		return getPlan(node.getParent()) + node.getOperator() + ";" + node.getPathCost() + ";"+totalNum ;
	}
	public static String getPlan(Node node){
		if(node.getParent() == null) return node.getOperator();
		return getPlan(node.getParent()) + node.getOperator() + ",";
	}
	public static void main(String[] args) {
		System.out.println(solve("50;"+
				"22,22,22;" +
				"50,60,70;" +
				"30,2;19,1;15,1;" +
				"300,5,7,3,20;" +
				"500,8,6,3,40;","UC",false));
	}
	
}
