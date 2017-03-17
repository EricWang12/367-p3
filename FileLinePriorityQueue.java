import java.util.Comparator;

/**
 * An implementation of the MinPriorityQueueADT interface. This implementation stores FileLine objects.
 * See MinPriorityQueueADT.java for a description of each method. 
 *
 */
public class FileLinePriorityQueue implements MinPriorityQueueADT<FileLine> {
    // TODO
    private Comparator<FileLine> cmp;
    private int maxSize;
    private int numItems;
    private FileLine[] fileLine;
    private FileLine temp;
    public FileLinePriorityQueue(int initialSize, Comparator<FileLine> cmp) {
		this.cmp = cmp;
		maxSize = initialSize;
		fileLine = new FileLine[maxSize];
		
		// TODO
    }

    public FileLine removeMin() throws PriorityQueueEmptyException {
		// TODO
    	if(isEmpty()) throw new PriorityQueueEmptyException();
    	FileLine tmp = fileLine[0]; 
    	fileLine[0] = fileLine[numItems - 1];
    	compareChild();
    	numItems--; 
    	return tmp;
		
		
    }

    public void insert(FileLine fl) throws PriorityQueueFullException {
		if (numItems >= maxSize){
			throw new PriorityQueueFullException();// TODO		
		}
		//int tmp = 0; 
		if(fl == null) throw new IllegalArgumentException();         
		if(numItems == 0) {
			fileLine[0] = fl;     
			return;
		}
		fileLine[numItems] = fl;
		int pos = compareParent(numItems);
		//swap{     
		numItems++;
    }

    public boolean isEmpty() {
		// TODO
		return numItems == 0;
    }
    
    
    
    
    
    
    
    public int compareParent(int numItems){
    	int parentNum = numItems / 2;
    	if (cmp.compare(fileLine[numItems],fileLine[parentNum]) >= 0|| numItems <1){
    		return numItems;
    	}else{
    		Fswap(numItems, parentNum);
    		numItems = compareParent(parentNum);
    	}
    	
    	return numItems;
    }
    
    
    
    
    
    
    public int compareChild(){
    	return compareChild(0) ;
    }
    
    public int compareChild(int numItems){
    	int smallChild;
    	if ( cmp.compare(fileLine[numItems] , fileLine [numItems * 2 +1 ]) < 0 && cmp.compare(fileLine[numItems] , fileLine [numItems * 2 +2 ]) < 0 ){
    		return numItems;
   		}else{
    		int tmp = cmp.compare(fileLine[numItems * 2 +1 ], fileLine [numItems * 2 +2]);
    		if( tmp == -1){
    			smallChild = numItems * 2 +1 ;
    		}else{
    			smallChild = numItems *2 + 2 ;
    		}
    		Fswap(numItems, smallChild);
    		compareChild(smallChild);    	
    	}
      	return numItems;
    }

    
    //////////////////////////////////////////////////////////
    
    
    
    
    
    public void Fswap(int x, int y){
    	temp = fileLine[x];
		fileLine [x] = fileLine[y];
		fileLine[y] = temp;
    	
    }
}
