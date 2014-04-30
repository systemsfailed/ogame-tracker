/**
* The <code>DateComparator</code> class creates an instance of
* a <code>Comparator</code> that is used in the sorting of arrays 
* of the <code>Day</code> class contained in a list
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/

package systemsfailed.otrack.corecomponents;

import java.util.Comparator;


public class DateComparator implements Comparator<Day> {


	/**
	* Takes in two Day objects and compares their dates to
	* return a value used in sorthing them by their date
	* 
	* @param d1
	* 	The day to compare to
	* @param d2
	* 	The day to compare with
	* 
	**/
	
	public int compare(Day d1, Day d2)
	{
		return d1.getDate().compareTo(d2.getDate());
	}

}
