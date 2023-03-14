package addressSort;

import java.util.Comparator;

public class ZipComparator implements Comparator<Address> {

	@Override
	public int compare(Address address1, Address address2) {

		if (address1.zip < address2.zip) {
			return -1;
		} else if (address1.zip > address2.zip) {
			return 1;
		} else {
			return 0;
		}
	}

}
