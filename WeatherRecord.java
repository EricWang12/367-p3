import java.util.Comparator;

/**
 * The WeatherRecord class is the child class of Record to be used when merging weather data. Station and Date
 * store the station and date associated with each weather reading that this object stores.
 * l stores the weather readings, in the same order as the files from which they came are indexed.
 */
public class WeatherRecord extends Record{
	// TODO declare data structures required
	
	/**
	 * Constructs a new WeatherRecord by passing the parameter to the parent constructor
	 * and then calling the clear method()
	 */
    public WeatherRecord(int numFiles) {
		super(numFiles);
		clear();
    }
	
	/**
	 * This comparator should first compare the stations associated with the given FileLines. If 
	 * they are the same, then the dates should be compared. 
	 */
    private class WeatherLineComparator implements Comparator<FileLine> {
		public int compare(FileLine l1, FileLine l2) throws NullPointerException{
			if ( l1 == null || l2 == null ){
				throw new NullPointerException();// TODO implement compare() functionality
			}
			if ( l1.getString().equals(l2.getString())){
				return 0;
			}
			/*
			//String Station1 =  l1.getString().substring(0, l1.getString().indexOf(","));
			//String Station2 =  l2.getString().substring(0, l2.getString().indexOf(","));
			
			
			int compareStation =  Station1.compareTo(Station2);
			if ( compareStation == 0){
				String L1 = l1.getString().substring(Station1.length() + 1);
				String Date1 = L1.substring ( 0, L1.indexOf(","));
				String L2 = l2.getString().substring(Station2.length() + 1);
				String Date2 = L2.substring ( 0, L2.indexOf(","));
				int compareDate = Date1.compareTo(Date2);
				return compareDate;
				
			}
			else{
				return compareStation;
			}
			*/
			String[] L1 = l1.getString().split(",");
			String[] L2 = l2.getString().split(",");
			int compareStation = L1[0].compareTo(L2[0]);
			if ( compareStation == 0){
				return L1[1].compareTo(L2[1]);
			}
			else {
				return compareStation;
			}
			
		}
		
		public boolean equals(Object o) {
			return this.equals(o);
		}
    }
    
	/**
	 * This method should simply create and return a new instance of the WeatherLineComparator
	 * class.
	 */
    public Comparator<FileLine> getComparator() {
		return new WeatherLineComparator();
    }
	
	/**
	 * This method should fill each entry in the data structure containing
	 * the readings with Double.MIN_VALUE
	 */
    public void clear() {
		// TODO initialize/reset data members
    }

	/**
	 * This method should parse the String associated with the given FileLine to get the station, date, and reading
	 * contained therein. Then, in the data structure holding each reading, the entry with index equal to the parameter 
	 * FileLine's index should be set to the value of the reading. Also, so that
	 * this method will handle merging when this WeatherRecord is empty, the station and date associated with this
	 * WeatherRecord should be set to the station and date values which were similarly parsed.
	 */
    public void join(FileLine li) {
		// TODO implement join() functionality
    }
	
	/**
	 * See the assignment description and example runs for the exact output format.
	 */
    public String toString() {
		// TODO
		
		return null;
    }
}
