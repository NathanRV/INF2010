import java.util.LinkedList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		System.out.println("TP05 : Graphes");
		
		// Partie 1: A completer : Création du graphe

		//Creation des noeuds et ajout dans graphes
		List<Node> nodes = new LinkedList<>();
		nodes.add(new Node(0, "A"));
		nodes.add(new Node(1, "B"));
		nodes.add(new Node(2, "C"));
		nodes.add(new Node(3, "D"));
		nodes.add(new Node(4, "E"));
		nodes.add(new Node(5, "F"));
		nodes.add(new Node(6, "G"));
		g.setNodes(nodes);

		//Creation des arcs et ajout dans graphes
		List<Edge> edges = new LinkedList<>();
		edges.add(new Edge(nodes.get(0), nodes.get(1), 2));
		edges.add(new Edge(nodes.get(0), nodes.get(2), 1));
		edges.add(new Edge(nodes.get(1), nodes.get(0), 2));
		edges.add(new Edge(nodes.get(1), nodes.get(2), 2));
		edges.add(new Edge(nodes.get(1), nodes.get(3), 1));
		edges.add(new Edge(nodes.get(1), nodes.get(4), 3));
		edges.add(new Edge(nodes.get(2), nodes.get(0), 1));
		edges.add(new Edge(nodes.get(2), nodes.get(1), 2));
		edges.add(new Edge(nodes.get(2), nodes.get(3), 4));
		edges.add(new Edge(nodes.get(2), nodes.get(4), 3));
		edges.add(new Edge(nodes.get(2), nodes.get(5), 5));
		edges.add(new Edge(nodes.get(3), nodes.get(1), 2));
		edges.add(new Edge(nodes.get(3), nodes.get(2), 4));
		edges.add(new Edge(nodes.get(3), nodes.get(5), 6));
		edges.add(new Edge(nodes.get(3), nodes.get(6), 5));
		edges.add(new Edge(nodes.get(4), nodes.get(1), 3));
		edges.add(new Edge(nodes.get(4), nodes.get(2), 3));
		edges.add(new Edge(nodes.get(4), nodes.get(5), 1));
		edges.add(new Edge(nodes.get(5), nodes.get(2), 5));
		edges.add(new Edge(nodes.get(5), nodes.get(3), 6));
		edges.add(new Edge(nodes.get(5), nodes.get(4), 1));
		edges.add(new Edge(nodes.get(5), nodes.get(6), 2));
		edges.add(new Edge(nodes.get(6), nodes.get(3), 5));
		edges.add(new Edge(nodes.get(6), nodes.get(5), 2));
		g.setEdges(edges);
		
		// Partie 2: A completer : Implémentation de l’algorithme Dijkstra
		
		Dijkstra d = new Dijkstra(g);

		//A to G
		d.findPath(g.getNodes().get(0), g.getNodes().get(6)/* Spécifiez les paramètres */);
		
		d.showTable();

		// Affichage le chemin le plus court :
		System.out.println(d.printShortPath(g.getNodes().get(0), g.getNodes().get(6)/* Spécifiez les paramètres */));
	
	}
}
