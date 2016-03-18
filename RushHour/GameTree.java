public class GameTree<GT> {
	private Node<GT> root;

	public Tree(GT data) {
		root = new Node<GT>();
		root.data = data;
		root.children = new ArrayList<Node<GT>>();
	}

	public static class Node<GT> {
		private T data;
		private Node<T> parent;
		private List<Node<T>> children;
	}
}