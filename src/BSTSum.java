import java.util.ArrayList;
import java.util.Scanner;

public class BSTSum {

	ArrayList<Integer> nodeList = new ArrayList<>();

	public static Node newNode(int node_data) {
		Node temp = new Node();

		temp.left = null;
		temp.data = node_data;
		temp.right = null;

		return temp;
	}

	public void insert(Node root, Node nn) {
		if (nn.data < root.data) {
			if (root.left == null) {
				root.left = nn;
			} else {
				insert(root.left, nn);
			}
		} else {
			if (root.right == null) {
				root.right = nn;
			} else {
				insert(root.right, nn);
			}
		}
	}

	private void traverse(Node root) {
		if (root != null) {
			traverse(root.left);
			nodeList.add(root.data);
			traverse(root.right);
		}

	}

	public static void main(String[] args) {

		BSTSum bst = new BSTSum();
		Node root = null;
		Node new_node = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of nodes: ");
		int noOfNodes = sc.nextInt();

		for (int i = 1; i <= noOfNodes; i++) {
			System.out.println("Enter data for the node:");
			int node_data = sc.nextInt();

			new_node = newNode(node_data);

			if (root == null) {
				root = new_node;
			} else {
				bst.insert(root, new_node);
			}
		}

		bst.traverse(root);

		System.out.println("Enter the sum: ");
		int sum = sc.nextInt();
		int flag = 0;

		for (int i = 0; i < bst.nodeList.size(); i++) {
			int a = bst.nodeList.get(i);
			int b = sum - bst.nodeList.get((i));

			if (bst.nodeList.contains(b) && a != b) {
				System.out.println("[" + a + "," + b + "]");
				flag = 1;
				break;
			}
		}
		
		if (flag == 0) {
			System.out.println("Nodes are not found");
		}

		sc.close();
	}
}
