package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public abstract class GenericSearch {

  
    
	public abstract Node getInitialState(String problem,String strategy) ;
	public abstract boolean isGoalTest(Node node);
	public abstract String getPrint(Node node);
	public abstract String getPlan(Node node);
	public abstract ArrayList<Node> expand(Node node);
    public abstract int getMaxDepth();
    public abstract boolean isVisual();
    public abstract void incrementTotalNum();    
    
    
	public String generalSearch(String problem , String strategy) {
		String solution = "";
		Node root = getInitialState(problem,strategy);
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
	public String BFS(Node root) {
		Queue<Node> nodes = new LinkedList<>();
		HashSet<Integer> visited =  new HashSet<Integer>();
		boolean visual = isVisual();
		nodes.add(root);
		while(true) {
			if(nodes.isEmpty()) return "NOSOLUTION";
			Node currNode = nodes.poll();
			if(visited.contains(currNode.getState().hashCode()))continue;
			else visited.add(currNode.getState().hashCode());
			if(visual) System.out.println(currNode);
			incrementTotalNum();
			if(isGoalTest(currNode)) return getPrint(currNode);
			ArrayList<Node> children = expand(currNode);
			for (Node child:children) {
				nodes.add(child);
			}
		}
	}
	public  String DFS(Node root) {
		Stack<Node> nodes = new Stack<>();
		HashSet<Integer> visited =  new HashSet<Integer>();
		boolean visual = isVisual();
		nodes.push(root);
		while(true) {
			if(nodes.isEmpty()) return "NOSOLUTION";
			Node currNode = nodes.pop();
			if(visited.contains(currNode.getState().hashCode()))continue;
			else visited.add(currNode.getState().hashCode());
			if(visual) System.out.println(currNode);
			incrementTotalNum();
			if(isGoalTest(currNode)) return getPrint(currNode);
			ArrayList<Node> children = expand(currNode);
			for (Node child:children) {
				nodes.push(child);
			}
		}
	}
	public  String depthLimited(Node root, int depth){
		Stack<Node> nodes = new Stack<>();
		boolean visual = isVisual();
		HashSet<Integer> visited =  new HashSet<Integer>();
		nodes.push(root);
		while(true) {
			if(nodes.isEmpty()) return "NOSOLUTION";
			Node currNode = nodes.pop();
			if(visited.contains(currNode.getState().hashCode()))continue;
			else visited.add(currNode.getState().hashCode());
			if(currNode.getDepth() > depth) continue;
			if(visual) System.out.println(currNode);
			incrementTotalNum();
			if(isGoalTest(currNode)) return getPrint(currNode);
			ArrayList<Node> children = expand(currNode);
			for (Node child:children) {
				nodes.push(child);
			}
		}
	}
	public  String IDS(Node root){
		int depth = 0;
		int maxDepth = getMaxDepth();
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

	public  String UCS(Node root) {
		PriorityQueue<Node> nodes = new PriorityQueue<>();
		nodes.add(root);
		HashSet<Integer> visited =  new HashSet<Integer>();
		boolean visual = isVisual();
		while(true) {
			if(nodes.isEmpty()) return "NOSOLUTION";
			Node currNode = nodes.poll();
			if(visited.contains(currNode.getState().hashCode()))continue;
			else visited.add(currNode.getState().hashCode());
			if(visual) System.out.println(currNode);
			incrementTotalNum();
			if(isGoalTest(currNode)) return getPrint(currNode);
			ArrayList<Node> children = expand(currNode);
			for (Node child:children) {
				nodes.add(child);
			}
		}
	}
	

	
	
}
