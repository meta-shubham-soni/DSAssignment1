import java.util.*;

/**
 * Here we are representing Polynomial as List of LinkedList
 * Each element will have a separate LinkList ,
 * in which first node will coeff and rest will be the powers of variables 
 */

public class Polynomial {
	List<LinkedList> poly = new ArrayList<LinkedList>();
	int degree = 0;
	
	/**
	 * Function to add new Element to polynomial
	 * @param vars
	 * @param coeff
	 */
	public void addElement(int[] vars,int coeff ){
		LinkedList newElement = new LinkedList();
		newElement.insert(coeff);
		int elementDegree = 0;
		for(int i=0;i<vars.length;i++){
			elementDegree += vars[i];
			newElement.insert(vars[i]);
		}
		this.degree = elementDegree > degree ? elementDegree : degree;
		poly.add(newElement);
	}
	
	/**
	 * Function to return degree of polynomial
	 * @return
	 */
	public int getDegree(){
		return degree;
	}
	
	/**
	 * Function to print Polynomial
	 */
	public void printPoly(){
		for(int i=0;i<poly.size();i++){
			char var  = 97;
			LinkedList element = poly.get(i);
			Node head = element.head;
			
			if(i!=0 && head.data > 0){
				System.out.print("+");
			}
			
			if(head.data == 1){
				if(head.next == null)
					System.out.print(head.data);
			}
			else
				System.out.print(head.data);
			
			head = head.next;
			while(head != null){
				System.out.print(var+"^"+head.data);
				head = head.next;
				var++;
			}
			System.out.print(" ");
		}
	}
}
