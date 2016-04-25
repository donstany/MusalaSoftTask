package Interfaces;

public interface PhoneBookRepository {
	
	Boolean addPhone (String name, Iterable<String> phoneNumber);
	Boolean deletebyName(String name);
	Boolean serachByName(String name);
	
}
