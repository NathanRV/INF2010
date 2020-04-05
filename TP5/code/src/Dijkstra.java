import java.util.*;


public class Dijkstra {
	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;

	public Dijkstra(Graph g) {
		this.graph = g;
	}

	public void findPath(Node s, Node d) {
		dijkstraTable = new HashMap[graph.getNodes().size()];
		path = new Stack<Edge>();

		for (int j = 0; j < graph.getNodes().size(); j++) {
			dijkstraTable[j] = new HashMap<Node, Edge>();
		}

		List<Node> checkedNodes = new LinkedList<>();
		checkedNodes.add(s);
		dijkstraTable[0].put(s, new Edge(s, s, 0));
		List<Edge> edgesToCheck = graph.getEdgesGoingFrom(s);
		int counter = 1;
		while (!edgesToCheck.isEmpty() && !checkedNodes.contains(d)) {

			Edge min = edgesToCheck.get(0);
			Edge currentEdge = null;
			Edge previousEdge;
			int previousDistance = 0;
			for (Edge edge : edgesToCheck) {
				previousEdge = null;
				int copyCounter = counter;
				while (previousEdge == null) {
					previousEdge = dijkstraTable[--copyCounter].get(edge.getSource());
				}
				previousDistance = previousEdge.getDistance();

				if (dijkstraTable[counter].containsKey(edge.getDestination())) {
					currentEdge = dijkstraTable[counter].get(edge.getDestination());
					if (edge.getDistance() + previousDistance < currentEdge.getDistance()) {
						Edge edgeToAdd = new Edge(edge.getSource(), edge.getDestination(), edge.getDistance() + previousDistance);
						dijkstraTable[counter].replace(edge.getDestination(), edgeToAdd);
					}
				} else {
					Edge edgeToAdd = new Edge(edge.getSource(), edge.getDestination(), edge.getDistance() + previousDistance);
					dijkstraTable[counter].put(edge.getDestination(), edgeToAdd);
				}
				min = getMinimum(min, edge);
			}

			edgesToCheck.addAll(graph.getEdgesGoingFrom(min.getDestination()));

			checkedNodes.add(min.getDestination());

			Iterator<Edge> itr = edgesToCheck.iterator();
			while (itr.hasNext()) {
				Edge edge = itr.next();
				if (checkedNodes.contains(edge.getDestination()))
					itr.remove();
			}

			counter++;
		}

		Edge minEdge = null;
		for (int i = 0; i < counter; i++) {
			minEdge = new Edge(s, d, Integer.MAX_VALUE);
			for (Edge edge : dijkstraTable[i].values()) {
				if (path.isEmpty() || edge.getSource() == path.peek().getDestination())
					minEdge = getMinimum(minEdge, edge);
			}
			if (path.isEmpty() || minEdge.getSource() == path.peek().getDestination())
				path.add(minEdge);
		}
	}

	private Node getMinimum(Map<Node, Edge> map) {
		Edge min = null;
		for (Node Key : map.keySet()) {
			if (min == null || map.get(Key).getDistance() < min.getDistance()) {
				min = map.get(Key);
			}
		}
		return min.getDestination();
	}

	private Edge getMinimum(Edge e1, Edge e2) {
		if (e2.getDistance() < e1.getDistance())
			return e2;
		return e1;
	}


	public void showTable() {

		List<Node> output = new ArrayList<>();
		System.out.print("Iteration  ");
		for (Node node : graph.getNodes()) {
			System.out.print(node.getName() + "  ");
			output.add(node);
		}

		System.out.println();
		for (int i = 0; i < dijkstraTable.length; i++) {
			System.out.print("    " + (i + 1));
			for (int j = 0; j < 5 - (i + 1) / 10; j++)
				System.out.print(" ");
			for (int k = 0; k < dijkstraTable.length; k++) {
				if (dijkstraTable[i].containsKey(output.get(k))) {
					System.out.print(dijkstraTable[i].get(output.get(k)).getDistance() + dijkstraTable[i].get(output.get(k)).getSource().getName());
				} else {
					boolean ignoreThis = false;
					for (int l = 0; l < i; l++) {
						if (dijkstraTable[l].containsKey(output.get(k))) {
							ignoreThis = true;
							break;
						}
					}
					if (ignoreThis) System.out.print("  ");
					else System.out.print("..");
				}
				System.out.print(" ");
			}
			System.out.println();
		}

	}

	public String printShortPath(Node source, Node destination) {

		this.findPath(source, destination);
		StringBuilder chemin = new StringBuilder();
		Edge lastEdge = path.pop();

		int longueurDuChemin = lastEdge.getDistance();
		chemin.append(lastEdge.getDestination().getName() + "  ");

		while (!path.empty()) {
			if (!path.empty() && path.peek().getDestination() == lastEdge.getSource()) {
				chemin.append(lastEdge.getSource().getName() + " ");
				lastEdge = path.pop();
			} else {
				path.pop();
			}
		}
		System.out.print("La longueur du plus court chemin est : ");
		System.out.println(longueurDuChemin);
		return "Le chemin le plus court est : " + chemin.reverse().toString();
	}
}
