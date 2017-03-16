import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
/**
 * The ThesaurusRecord class is the child class of Record to be used when merging thesaurus data.
 */

public class ThesaurusRecord extends Record{
    // TODO declare data structures required
		ArrayList<String> list;
		String word;
	/**
	 * Constructs a new ThesaurusRecord by passing the parameter to the parent constructor
	 * and then calling the clear method()
	 */
    public ThesaurusRecord(int numFiles) {
	super(numFiles);
	clear();
    }

    /**
	 * This Comparator should simply behave like the default (lexicographic) compareTo() method
	 * for Strings, applied to the portions of the FileLines' Strings up to the ":"
	 * The getComparator() method of the ThesaurusRecord class will simply return an
	 * instance of this class.
	 */
	private class ThesaurusLineComparator implements Comparator<FileLine> {
		public int compare(FileLine l1, FileLine l2) {
			// TODO implement compare() functionality
			String[] L1 = l1.getString().split(":");
			String[] L2 = l2.getString().split(":");
			return L1[0].compareTo(L2[0]); // TODO implement compare() functionality
		}
		
		public boolean equals(Object o) {
			return this.equals(o);
		}
    }
    
	/**
	 * This method should simply create and return a new instance of the ThesaurusLineComparator class.
	 */
    public Comparator<FileLine> getComparator() {
		return new ThesaurusLineComparator();
    }
	
	/**
	 * This method should (1) set the word to null and (2) empty the list of synonyms.
	 */
    public void clear() {
		// TODO initialize/reset data members
    	list = new ArrayList<String>();
    	word = null;
    	
    }
	
	/**
	 * This method should parse the list of synonyms contained in the given FileLine and insert any
	 * which are not already found in this ThesaurusRecord's list of synonyms.
	 */
    public void join(FileLine w) {
		// TODO implement join() functionality
    	String[] tmp1 = w.getString().split(":");
    	String[] tmp2;
    	if (word == null){
    		word = tmp1[0];
    	}
    	
    	 tmp2 = tmp1[1].split(",");
    	 for (int i=0; i<tmp2.length; i++){
    		 if (!list.contains(tmp2[i]))
    		 list.add(tmp2[i]);
    	 }
    }
	
	/**
	 * See the assignment description and example runs for the exact output format.
	 */
    public String toString() {
		// TODO
    	Collections.sort(list);
    	String rtrn = word + ":";
    	for (int i = 0; i<list.size(); i++){
    		rtrn = rtrn + list.get(i) + ",";
    	}
		return rtrn;
	}
}
