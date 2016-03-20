package edu.uz.lab.list1;

import java.util.Date;

public class zad8 {

	public static void main(String[] args) {
		Date date1 = new Date(2015 - 1900, 11, 11);
		Date date2 = new Date(2015 - 1900, 11, 10);

		if (date1.compareTo(date2) < 0)
			System.out.println("Data " + date1 + " jest starsza niz " + date2);
		else if (date1.compareTo(date2) > -1)
			System.out.println("Data " + date2 + " jest starsza niz " + date1);

	}

}
