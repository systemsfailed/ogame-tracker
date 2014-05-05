/**
* The <code>RaidComparator</code> class creates an instance of
* a <code>Comparator</code> that is used in the sorting of arrays 
* of the <code>Raid</code> class contained in a list
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/

package systemsfailed.otrack.corecomponents;

import java.util.Comparator;


public class RaidComparator implements Comparator<Raid> {


	/**
	 * Compares the dates of two raid objects
	 * @return
	 * 	the value 0 if the argument Date is equal to this Date;
	 *  a value less than 0 if this Date is before the Date argument;
	 *  and a value greater than 0 if this Date is after the Date argument. 
	 */
	public int compare(Raid r1, Raid r2)
	{
		return r1.getDate().compareTo(r2.getDate());
	}

}
