package addressSort;

public class Address {
String street;
int zip;
String city;

Address(String street, int zip, String city){
	this.street = street;
	this.zip = zip;
	this.city = city;
}
public String toString() {
	return "(" + street + ", " + zip + ", " + city + ")";
}
}
