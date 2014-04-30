package coreComponents;

import java.util.Comparator;


public class DateComparator implements Comparator<Day> {


	public int compare(Day d1, Day d2)
	{
		return d1.getDate().compareTo(d2.getDate());
	}

}
