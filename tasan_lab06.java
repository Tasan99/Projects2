package tasan_lab06;

public class tasan_lab06 {
	private final ArrayList<Integer> vertices;    
	private final ArrayList<Edge> edges;          
	private final boolean isDirected;  
	
	public tasan_Graph(boolean directedValue) {
		vertices = new ArrayList<>();
		edges = new ArrayList<>();
		isDirected = directedValue;
	}
	
	public tasan_Graph() {
		vertices = new ArrayList<>();
		edges = new ArrayList<>();
		isDirected = false;
	}

}
