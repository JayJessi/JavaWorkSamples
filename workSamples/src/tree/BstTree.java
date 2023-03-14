package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BstTree {
	TreeNode root;

	public void printInOrder(TreeNode root) {
		if (root != null) {
			printInOrder(root.left);
			System.out.println(root.toString());
			printInOrder(root.right);
		}
	}

	public void printLevelOrder() {
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node);
			
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
		}
	}
	
	public void printPreOrder(TreeNode root) {
		System.out.println(root.toString());
		if(root.left != null) {
			printPreOrder(root.left);
		}
		if(root.right != null) {
			printPreOrder(root.right);
		}
	}
	
	public Student search(TreeNode node, int id) {
		Student student = null;
		if(node == null) {
			return null;
		}else if(node.value.id == id) {
			return node.value;
		}else if(node.value.id > id) {
				student = search(node.right, id);
			}else {
				student = search(node.left, id);
			}
		return student;
		}
	}

