package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LLAPSearch {

	
	private static String actions[] = {"RequestFood","RequestMaterials","RequestEnergy","Wait","Build1","Build2"};
	private static int numBuilds = 2;
	private static int initalBudget = 100000;
	// food , material , energy
	private static int initalProsperity;
	private static int initalFood;
	private static int initalMaterials;
	private static int initalEnergy;
    private static int unitPriceFood;
    private static int unitPriceMaterials;
    private static int unitPriceEnergy;
	private static int amountRequestFood;
	private static int amountRequestMaterials;
	private static int amountRequestEnergy;
	private static int delayRequestFood;
	private static int delayRequestMaterials;
	private static int delayRequesEnergy;
	private static int priceBuild[]  = new int[numBuilds];
	private static int foodUseBuild[] = new int [numBuilds];
	private static int materialsUseBuild[] = new int [numBuilds];
	
	public static boolean isGoalTest (Node node ) {
		return node.getState().getProsperity()>=100;
	}
	public static ArrayList<Node> expand(Node currNode) {
		ArrayList<Node> expanded = new ArrayList<>();
		for (String action :actions) {
			int currBudget = currNode.getState().getCurrBudget();
			if(action.equals("RequestFood")&& currBudget>unitPriceFood) {
				int childmoneySpent = currNode.getState().getMoneySpent()+unitPriceFood;
				int childCurrBudget = currNode.getState().getCurrBudget()-childmoneySpent;
				State childState = new State(currNode.getState().getProsperity(), currNode.getState().getFood(), currNode.getState().getMaterials(), currNode.getState().getEnergy(),moneySpent ,currBudget);
				Node child = new Node(currNode, "RequestFood", currNode.getDepth()+1, currNode.getPathCost(), childState);
				expanded.add(child);
			}
			else if(action.equals("RequestMaterials") && currBudget>unitPriceMaterials) {
				
			}
			else if(action.equals("RequestEnergy") && currBudget>unitPriceEnergy) {
				
			}
			else if(action.equals("Wait")) {
				
			}
			else if(action.equals("Build1")) {
				
			}
			else if(action.equals("Build2")) {
				
			}
			
		}
		return new ArrayList<Node>();
		
	}
	public static String solve(String initalState , String strategy, boolean visualize ) {
		String solution = "";
		State rootState = new State(initalProsperity, initalFood, initalMaterials, initalEnergy, 0,initalBudget);
		Node root = new Node(null, "", 0, 0, rootState);
		switch (strategy) {
		case "BF":solution = BFS(root);break;
		case "DF":solution = DFS(root);break; 
		case "ID":break;
		case "UC":break;
		
		default:
			break;
		}
		return solution;
	}
	public static String BFS(Node root) {
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		while(true) {
			if(nodes.isEmpty()) return "NOSOLUTION";
			Node currNode = nodes.poll();
			if(isGoalTest(currNode)) return "Solution";
			
		}
		
	}
	public static String DFS(Node root) {
		return "";
				
	}
	
}
