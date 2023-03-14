package addressSort;

import java.util.Comparator;

public class CityZipComparator implements Comparator<Address>{

	@Override
	public int compare(Address address1, Address address2) {
		int comparison = address1.city.compareTo(address2.city);
		if(comparison != 0) {
			return comparison;
		}else{
			if (address1.zip < address2.zip) {
				return -1;
			} else if (address1.zip > address2.zip) {
				return 1;
			} else {
				return 0;
			}
		}
	}

}