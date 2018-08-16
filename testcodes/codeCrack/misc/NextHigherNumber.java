package misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*---------------Problem Statement------------------------
 * Given a number, find next higher number with the same digit.
 * eg : 32841 --> 34821*
 * logic : 1. Check the from last if the digits are in assending order.
 * 		   2. If they are not ascending order, get the location where they are not in ascending the order eg: 32841 - 148 are in asending but 1482 is not.
 * 		   3. swap 4 with 2 so the new number ber will be 34821.
 *         4. Sort the sub list 821*/

public class NextHigherNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number = 32841;
		int temp = 32841;
		/*
		 * int number = 32814; int temp = 32814;
		 */
		// 14823
		// 12843
		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
		ArrayList<Integer> newList = new ArrayList<Integer>();

		while (temp > 0) {
			int digit = temp % 10;
			temp = temp / 10;
			listOfNumbers.add(digit);
		}

		int i = 0;
		int j = i + 1;
		// Checking the asecending order
		for (i = 0; i < listOfNumbers.size() - 1; i++) {

			if (listOfNumbers.get(j) < listOfNumbers.get(i)) {
				System.out.println(listOfNumbers.get(i + 1));
				System.out.println(i + 1);
				break;
			}
			System.out.println(j);
			j++;
		}

		// j = 0;

		// replacing the 2 and 4
		for (int m = 0; m < listOfNumbers.size() - 1; m++) {

			if ((Integer) listOfNumbers.get(m) > (Integer) listOfNumbers.get(i + 1)) {
				System.out.println(" i = " + i);
				System.out.println("value at m is  " + listOfNumbers.get(m));
				System.out.println("value at i is " + listOfNumbers.get(i + 1));
				int swap = listOfNumbers.get(m);
				listOfNumbers.set(m, listOfNumbers.get(i + 1));
				listOfNumbers.set(i + 1, swap);
				break;

			}
		}
		// getting the sub list and sorting them
		List<Integer> subList = listOfNumbers.subList(0, i + 1);
		Collections.sort(subList);
		Collections.reverse(subList);

		// creating a new list wit the next higher number
		for (int k = listOfNumbers.size(); k > i + 1; k--) {
			newList.add(listOfNumbers.get(k - 1));
		}

		for (int k = 0; k < subList.size(); k++) {
			newList.add(subList.get(k));
		}

		for (int k = 0; k < newList.size(); k++) {
			System.out.print(newList.get(k));
		}
	}

}
