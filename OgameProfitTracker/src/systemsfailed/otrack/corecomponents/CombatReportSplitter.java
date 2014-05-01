/**
* The <code>CombatReportSplitter</code> class contains a 
* static method  <code> splitReports </code> which takes
* an input of multiple combat reports and outputs an array
* of individual combat reports for the system to parse individually.
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/
package systemsfailed.otrack.corecomponents;

public class CombatReportSplitter {
	
	/**
	 * Splits a block of combat reports into individual reports
	 * capable of being parsed.
	 * 
	 * @param s
	 * 	S is the input variable of the block of combat reports
	 * 	that need to be split.
	    **/
	
	public static String[] splitReports(String s)
	{
		return s.split("On ");
	}

}
