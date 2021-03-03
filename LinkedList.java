
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
	
	// Method to rotate a part of LinkedList
	public void rotateSubList(int low,int high,int noOfRotations){
		
		int size = high - low + 1;  
	    
	    // If k is greater than size of sublist then   
	    // we will take its modulo with size of sublist  
	    if (noOfRotations > size) {  
	    	noOfRotations = noOfRotations % size;  
	    }  
	    
	    // If k is zero or k is equal to size or k is  
	    // a multiple of size of sublist then list   
	    // remains intact  
	    if (noOfRotations == 0 || noOfRotations == size) {   
	        return;  
	    }  
	    
	    Node link = null;  // m-th node  
	    if (low == 1) {  
	        link = head;  
	    }  
	    
	    // This loop will traverse all node till  
	    // end node of sublist.      
	    Node c = head;  // Current traversed node  
	    int count = 0;  // Count of traversed nodes  
	    Node end = null;    
	    Node pre = null; // Previous of m-th node  
	    while (c != null) {  
	        count++;  
	    
	        // We will save (m-1)th node and later  
	        // make it point to (n-k+1)th node  
	        if (count == low - 1) {  
	            pre = c;  
	            link = c.next;  
	        }  
	        if (count == high - noOfRotations) {  
	            if (low == 1) {  
	                end = c;  
	                head = c.next;  
	            }  
	            else {  
	                end = c;  
	    
	                // That is how we bring (n-k+1)th  
	                // node to front of sublist.  
	                pre.next = c.next;  
	            }  
	        }  
	    
	        // This keeps rest part of list intact.  
	        if (count == high) {  
	            Node d = c.next;  
	            c.next = link;  
	            end.next = d;  
	            Node head = this.head;  
	            while (head != null) {  
	                System.out.print( head.data+" ");  
	                head = head.next;  
	            }  
	            return;  
	        }  
	        c = c.next;  
		
	    }
	
	}
	
	
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
