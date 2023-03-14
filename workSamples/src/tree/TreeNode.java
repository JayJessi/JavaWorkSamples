package tree;

public class TreeNode {
	Student value;
	TreeNode left;
	TreeNode right;
	
	TreeNode(Student object){
		this.value = object;
	}
	
	public String toString(){
		return value.toString();
	}
}
