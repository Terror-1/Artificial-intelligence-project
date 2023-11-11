package code;

public class Node implements Comparable<Node> {
	
	
	private Node parent;
	private String operator;
	private int depth;
	private int pathCost;
	private State state;
	
	public Node(Node parent,String operator,int depth,int pathCost,State state) {
		this.parent = parent;
		this.operator = operator;
		this.depth = depth;
		this.pathCost = pathCost;
		this.state = state;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getPathCost() {
		return pathCost;
	}

	public void setPathCost(int pathCost) {
		this.pathCost = pathCost;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int compareTo(Node o) {
		if(this.state.getStrategy().startsWith("GR")){
			return (int)(this.state.getH() - o.state.getH());
		}
		else
			return (int)((this.pathCost + this.state.getH()) - (o.pathCost + o.state.getH()));
	}

	@Override
	public String toString() {
		return "Node{" +
				"operator=" + operator +
				", depth=" + depth +
				", pathCost=" + pathCost +
				", state=" + state.toString() +
				'}';
	}
}
