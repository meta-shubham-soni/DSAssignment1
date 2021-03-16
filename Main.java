
public class Main {
	
	public static void main(String args[]){
		LinkedList head = new LinkedList();
		head.insert(1);
		head.insert(2);
		head.insert(3);
		head.insert(4);
		head.insert(5);
		head.insert(6);
		head.insert(7);
		head.insert(8);
		head.rotateSubList(1, 8, 2);
		head.printList();		
		System.out.println(head.detectLoop());
		
		Polynomial multivariatePoly = new Polynomial();
		int[] e1 = {2,4};
		multivariatePoly.addElement(e1,3);
		int[] e2 = {2};
		multivariatePoly.addElement(e2,1);
		int[] e3 = new int[0];
		multivariatePoly.addElement(e3,-2);
		
		System.out.println("Degree :- "+multivariatePoly.getDegree());
		
		multivariatePoly.printPoly();
	}
}
