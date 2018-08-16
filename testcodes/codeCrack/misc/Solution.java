package misc;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	List contactList;

	public Solution() {
		this.contactList = new ArrayList<String>();
	}

	public void addContact(String contact) {
		if (!contact.isEmpty()) {
			int count = findContact(contact);
			if (count > 0) {
				return;
			} else {
				contactList.add(contact);
			}

		}

	}

	public int findContact(String name) {
		int count = 0;
		if (name.isEmpty()) {
			return 0;
		}
		if (contactList != null) {
			for (Object contact : contactList) {
				if (contact.toString().length() > name.length()) {

					String subString = contact.toString().substring(0, (name.length()));
					if (subString.equals(name)) {
						count = count + 1;
					}
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		try {
			n = in.nextInt();
			
			Solution solution = new Solution();
			for (int a = 0; a < n; a++) {
				String op = in.next();
				String contact = in.next();
				in.nextLine();
				if (contact.length() >= 1 && contact.length() <= 21) {
					if (!op.isEmpty() && op.contains("add")) {
						solution.addContact(contact.toLowerCase());
					} else if (!op.isEmpty() && op.contains("find")) {
						System.out.println(solution.findContact(contact.toLowerCase()));
					}
				}

			}
			in.nextLine();
		} catch (Exception e) {
			System.out.println("input id incorrect");
		}
		 finally {
			 in.close();
	        }

	}
}
