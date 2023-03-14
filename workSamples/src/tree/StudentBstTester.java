package tree;

import hdm.shared.Toolbox;

public class StudentBstTester {
	
public static void main(String[] args) {
	BstTree tree = new BstTree();
	Student idFound;
	int searchedId;
	
	tree = new BstTree();
	tree.root = new TreeNode(new Student(24152, "Hobbs"));
	tree.root.left = new TreeNode(new Student(20121, "Eriksen"));
	tree.root.right = new TreeNode(new Student(25000, "Aldrin"));
	tree.root.left.right = new TreeNode(new Student(21282, "Scherbatsky"));
	tree.root.left.left = new TreeNode(new Student(19253, "Mosby"));
	tree.root.right.left = new TreeNode(new Student(24999, "Stinson"));
	tree.root.right.right = new TreeNode(new Student(26377, "Zinman"));
	
	tree.printInOrder(tree.root);
	System.out.println("--------------------------------------");
	tree.printLevelOrder();
	System.out.println("--------------------------------------");
	tree.printPreOrder(tree.root);
	System.out.println("--------------------------------------");
	
	do {
	searchedId = Toolbox.readInt("Bitte Matrikelnummer eingeben: ");
	idFound = tree.search(tree.root, searchedId);
	if(idFound == null) {
		System.out.println("Matrikelnummer nicht gefunden.");
	}else {
		System.out.println(idFound.toString());
	}
	}while(idFound == null);
}
}
