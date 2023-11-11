package code;

import java.util.*;

public class LLAPSearch {

	private static int totalNum = 0;
	private static final String[] actions = {"RequestFood","RequestMaterials","RequestEnergy","WAIT","BUILD1","BUILD2"};
	private static int numBuilds = 2;
	private static int initialBudget = 100000;
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

	private static boolean visual;

	private static final int[] priceBuild = new int[numBuilds];
	private static final int[] foodUseBuild = new int [numBuilds];
	private static final int[] materialsUseBuild = new int [numBuilds];
	private static final int[] energyUseBuild = new int [numBuilds];
	private static final int[] prosperityBuild = new int [numBuilds];
	private static int consumptionCost;
    private static HashSet<State> visited = new HashSet<State>();
	
	public static boolean isGoalTest (Node node ) {
		return node.getState().getProsperity()>=100;
	}
	public static ArrayList<Node> expand(Node currNode) {

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
				if(action.equals("RequestFood")&&currState.getPendingType()==0&&currState.getFood()<Math.max(foodUseBuild[0],foodUseBuild[1])) {
					newState.setDelay(delayRequestFood);
					newState.setPendingType(1);
					handleDelivery(newState);
					Node newNode = new Node(currNode,"RequestFood",currNode.getDepth()+1, newState.getMoneySpent(),newState);
					expanded.add(newNode);
				}
				else if (action.equals("RequestMaterials")&&currState.getPendingType()==0&&currState.getMaterials()<Math.max(materialsUseBuild[0],materialsUseBuild[1])) {
					newState.setDelay(delayRequestMaterials);
					newState.setPendingType(2);
					handleDelivery(newState);
					Node newNode = new Node(currNode,"RequestMaterials",currNode.getDepth()+1, newState.getMoneySpent(),newState);
					expanded.add(newNode);
				}
				else if (action.equals("RequestEnergy")&&currState.getPendingType()==0&&currState.getEnergy()<Math.max(energyUseBuild[0],energyUseBuild[1])) {
					newState.setDelay(delayRequestEnergy);
					newState.setPendingType(3);
					handleDelivery(newState);
					Node newNode = new Node(currNode,"RequestEnergy",currNode.getDepth()+1, newState.getMoneySpent(),newState);
					expanded.add(newNode);
				}
				else if (action.equals("WAIT")&&currState.getPendingType()!=0) {
					newState.setDelay(currState.getDelay()-1);
					newState.setPendingType(currState.getPendingType());
					handleDelivery(newState);
					Node newNode = new Node(currNode,"WAIT",currNode.getDepth()+1, newState.getMoneySpent(),newState);
					expanded.add(newNode);
				}
			}
		}
		return expanded;
	}

	private static Node handleBuild(Node currNode, State currState,int idx) {
		int resourcesCost = foodUseBuild[idx]*unitPriceFood+materialsUseBuild[idx]*unitPriceMaterials+energyUseBuild[idx]*unitPriceEnergy;
		State newState = new State(currState.getProsperity()+prosperityBuild[idx], currState.getFood()-foodUseBuild[idx], currState.getMaterials()-materialsUseBuild[idx], currState.getEnergy()-energyUseBuild[idx],
				currState.getMoneySpent()+priceBuild[idx]+resourcesCost, currState.getCurrBudget()-priceBuild[idx]-resourcesCost, currState.getDelay()-1, currState.getPendingType(),0, currState.getStrategy());
		newState.setH(getH(newState));
		boolean chk = (newState.getCurrBudget() >= 0) && (newState.getFood() >= 0) && (newState.getEnergy() >= 0) && (newState.getMaterials() >= 0);
		handleDelivery(newState);
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
	public static String solve(String initialState , String strategy, boolean visualize) {
		interpreter(initialState);
		String solution = "";
		visual = visualize;
		State rootState = new State(initialProsperity, initialFood, initialMaterials, initialEnergy, 0,initialBudget,0,0,0,strategy);
		rootState.setH(getH(rootState));
		Node root = new Node(null, "", 0, 0, rootState);
		switch (strategy) {
		case "BF":solution = BFS(root);break;
		case "DF":solution = DFS(root);break; 
		case "ID":solution = IDS(root);break;
		case "UC":solution = UCS(root);break;
		case "GR1":solution = UCS(root);break;
		case "GR2":solution = UCS(root);break;
		case "AS1":solution = UCS(root);break;
		case "AS2":solution = UCS(root);break;
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
			if(visited.contains(currNode.getState()))continue;
			else visited.add(currNode.getState());
			if(visual) System.out.println(currNode);
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
			if(visited.contains(currNode.getState()))continue;
			else visited.add(currNode.getState());
			if(visual) System.out.println(currNode);
			totalNum++;
			if(isGoalTest(currNode)) return getPrint(currNode);
			ArrayList<Node> children = expand(currNode);
			for (Node child:children) {
				nodes.push(child);
			}
		}
	}
	public static String depthLimited(Node root, int depth){
		Stack<Node> nodes = new Stack<>();
		visited = new HashSet<>();
		nodes.push(root);
		while(true) {
			if(nodes.isEmpty()) return "NOSOLUTION";
			Node currNode = nodes.pop();
			if(visited.contains(currNode.getState()))continue;
			else visited.add(currNode.getState());
			if(currNode.getDepth() > depth) continue;
			if(visual) System.out.println(currNode);
			totalNum++;
			if(isGoalTest(currNode)) return getPrint(currNode);
			ArrayList<Node> children = expand(currNode);
			for (Node child:children) {
				nodes.push(child);
			}
		}
	}
	public static String IDS(Node root){
		int depth = 0;
		int maxDepth = initialBudget / consumptionCost;
		while(depth <= maxDepth) {
			String answer = depthLimited(root, depth);
			if(!answer.equals("NOSOLUTION"))
			{
				return answer;
			}
			depth++;
		}
		return "NOSOLUTION";
	}

	public static String UCS(Node root) {
		PriorityQueue<Node> nodes = new PriorityQueue<>();
		nodes.add(root);
		while(true) {
			if(nodes.isEmpty()) return "NOSOLUTION";
			Node currNode = nodes.poll();
			if(visited.contains(currNode.getState()))continue;
			else visited.add(currNode.getState());
			if(visual) System.out.println(currNode);
			totalNum++;
			if(isGoalTest(currNode)) return getPrint(currNode);
			ArrayList<Node> children = expand(currNode);
			for (Node child:children) {
				nodes.add(child);
			}
		}
	}

	public static double getH(State s){
		String strat = s.getStrategy();
		int pros = s.getProsperity();
		int resourcesCost1 = priceBuild[0] + foodUseBuild[0] * unitPriceFood + materialsUseBuild[0] * unitPriceMaterials + energyUseBuild[0] * unitPriceEnergy;
		int resourcesCost2 = priceBuild[1] + foodUseBuild[1] * unitPriceFood + materialsUseBuild[1] * unitPriceMaterials + energyUseBuild[1] * unitPriceEnergy;

		if(strat.equals("GR1")||strat.equals("AS1")){
			return Math.min((resourcesCost1 / prosperityBuild[0]), ((resourcesCost2 / prosperityBuild[1]))) * (100 - pros);
		}
		else if (strat.equals("GR2")||strat.equals("AS2")){
			int req1 = (int) (Math.ceil(1.0 * (foodUseBuild[0]- s.getFood()) / amountRequestFood) +
					Math.ceil(1.0 * (materialsUseBuild[0]- s.getMaterials()) / amountRequestMaterials) +
					Math.ceil(1.0 * (energyUseBuild[0]- s.getEnergy()) / amountRequestEnergy));

			int req2 = (int) (Math.ceil(1.0 * (foodUseBuild[1]- s.getFood()) / amountRequestFood) +
					Math.ceil(1.0 * (materialsUseBuild[1]- s.getMaterials()) / amountRequestMaterials) +
					Math.ceil(1.0 * (energyUseBuild[1]- s.getEnergy()) / amountRequestEnergy));
			resourcesCost1 += req1*consumptionCost;
			resourcesCost2 += req2*consumptionCost;
			return Math.min((1.0 * resourcesCost1 / prosperityBuild[0]), ((1.0 * resourcesCost2 / prosperityBuild[1]))) * (100 - pros);
		}
		return 0;
	}
	public static String getPrint(Node node){
		return getPlan(node.getParent()) + node.getOperator() + ";" + node.getPathCost() + ";"+totalNum ;
	}
	public static String getPlan(Node node){
		if(node.getParent() == null) return node.getOperator();
		return getPlan(node.getParent()) + node.getOperator() + ",";
	}
	public static void main(String[] args) {
		System.out.println(solve("32;" +
				"20,16,11;" +
				"76,14,14;" +
				"9,1;9,2;9,1;" +
				"358,14,25,23,39;" +
				"5024,20,17,17,38;","DF",true));
	}
	
}
