package tree;

public class Student {
	int id;
	String name;
	
	Student(int id, String name){
		this.id = id;
		this.name= name;
	}
	
	public String toString() {
		return id + " " + name;
	}
}
