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
    
    public FileLinePriorityQueue(int initialSize, Comparator<FileLine> cmp) {
		this.cmp = cmp;
		maxSize = initialSize;
		
		// TODO
    }

    public FileLine removeMin() throws PriorityQueueEmptyException {
		// TODO

		return null;
    }

    public void insert(FileLine fl) throws PriorityQueueFullException {
		if (numItems >= maxSize){
			throw new PriorityQueueFullException();// TODO
		}
    }

    public boolean isEmpty() {
		// TODO
		return numItems == 0;
    }
}
