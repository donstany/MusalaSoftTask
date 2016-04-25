package Entry;

import java.util.SortedSet;
import java.util.TreeSet;

public class PhonebookEntry implements Comparable<PhonebookEntry> {

	private String contactName;
	private String contactNameLowerInvariant;
	private SortedSet<String> phoneNumbers;
	
	
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
		this.contactNameLowerInvariant = contactName.toLowerCase();
	}

	//the structure can be HashSet
	public SortedSet<String> getPhoneNumber() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(SortedSet<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}


	@Override
	public String toString() {
	
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append('[');
		sBuilder.append(this.contactName);
		Boolean isFiratNumber = true;
		
		for (String phoneNumber : this.phoneNumbers) {
			if(isFiratNumber){
				sBuilder.append(": ");
				isFiratNumber = false;
			} else{
				sBuilder.append(", ");
			}
			
			sBuilder.append(phoneNumber);
		}
		sBuilder.append(']');
		return sBuilder.toString();
	}
	
	@Override
	public int compareTo(PhonebookEntry other) {
	  return this.contactNameLowerInvariant.compareTo(other.contactNameLowerInvariant);
	}
}

	
