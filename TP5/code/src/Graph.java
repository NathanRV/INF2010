import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

	private List<Node> nodes; // Noeuds
	private List<Edge> edges; // Les arcs

	public Graph() {
		// A compléter
		nodes = new LinkedList<>();
		edges = new LinkedList<>();
	}

	public List<Edge> getEdgesGoingFrom(Node source) {
		// A compléter
		List<Edge> edgesGoingFrom = new LinkedList<>();
		for (Edge edge : edges) {
			if (source == edge.getSource()) {
				edgesGoingFrom.add(edge);
			}
		}
		return edgesGoingFrom;
	}

	public List<Edge> getEdgesGoingTo(Node dest) {
		// A compléter
		List<Edge> edgesGoingTo = new LinkedList<>();
		for (Edge edge : edges) {
			if (dest == edge.getDestination()) {
				edgesGoingTo.add(edge);
			}
		}
		return edgesGoingTo;
	}

	// Accesseurs
	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

}
