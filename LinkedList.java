
public class LinkedList { 

	Node head; // head of list 


	// Method to insert a new node 
	public void insert(int data) 
	{ 
		// Create a new node with given data 
		Node new_node = new Node(data); 
		new_node.next = null; 

		// If the Linked List is empty, 
		// then make the new node as head 
		if (head == null) { 
			head = new_node; 
		} 
		else { 
			// Else traverse till the last node 
			// and insert the new_node there 
			Node last = head; 
			while (last.next != null) { 
				last = last.next; 
			} 

			// Insert the new_node at last node 
			last.next = new_node; 
		} 

	} 

	// Method to print the LinkedList. 
	public void printList() 
	{ 
		Node currNode = head; 
	
		System.out.print("LinkedList: "); 
	
		// Traverse through the LinkedList 
		while (currNode != null) { 
			// Print the data at current node 
			System.out.print(currNode.data + " "); 
	
			// Go to next node 
			currNode = currNode.next; 
		} 
		System.out.println();
	}
	
	// Method to return length of LinkedList
	public int getLength(){
		Node currNode = head;
		int length = 0;
		while(currNode != null){
			length++;
			currNode = currNode.next;
		}
		return length;
	}
	
	/**
	 * Function to rotate the subLinkedList
	 * @param low
	 * @param high
	 * @param noOfRotations
	 */
	public void rotateSubList(int low,int high,int noOfRotations){
		if(low == high)
			return;
		int size = high - low + 1;  
	    
	    if (noOfRotations > size) {  
	    	noOfRotations = noOfRotations % size;  
	    }  
	    
 
	    if (noOfRotations == 0 || noOfRotations == size) {   
	        return;  
	    }  
	    
	    Node mprevious , nprevious , m , n;
	    mprevious = head;
	    nprevious = head;
	    int count = 1;
	    while(count < low-1){
	    	count++;
	    	mprevious = mprevious.next;
	    }
	    count = 1;
	    while(count < high-1){
	    	count++;
	    	nprevious = nprevious.next;
	    }
	    if(low == 1)
	    	m = head;
	    else
	    	m = mprevious.next;
	    n = nprevious.next;
	    
	    if(low == 1){
	    	for(int i=0;i<noOfRotations;i++){

		    	nprevious.next = n.next;
		    	n.next = m;
		    	Node tempN = m;
		    	while(tempN.next != nprevious){
		    		tempN = tempN.next;
		    	}
		    	m = n;
		    	n = nprevious;
		    	nprevious = tempN;
		    	head = m;

		    }
	    }
	    else {
		    for(int i=0;i<noOfRotations;i++){
		    	
		    	mprevious.next = n;
		    	nprevious.next = n.next;
		    	n.next = m;
		    	Node tempN = m;
		    	while(tempN.next != nprevious){
		    		tempN = tempN.next;
		    	}
		    	m = n;
		    	n = nprevious;
		    	nprevious = tempN;

		    }
	    }
	}
	
	/**
	 * Function to detect Loop in LinkedList
	 * @return
	 */
    public boolean detectLoop(){
        Node slow_p = head, fast_p = head;
        int flag = 0;
        while (slow_p != null && fast_p != null
               && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            return true;
        else
            return false;
    }
    
    
    
}
