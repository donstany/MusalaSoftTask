import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import TextProcessing.ReadText;

public class Engine {

	private static final String filePathStr = "SourceContacts.txt";
	private static final String patStringEntry = "\\((.+?)\\)";
	private static final String zeroZeroLeadingStr = "00";
	private static final String zeroLeadingStr = "0";
	private static final String bgCodeStr = "+359";
	private static final String plusStr = "+";
	private static final String normalPhoneNum = "\\+359[8][7|8|9][2-9]{1}[0-9]{6}";
	public static void run() {
		
		String fileToken= ReadText.fromFile(filePathStr);
	
		Pattern p = Pattern.compile(patStringEntry);
		Matcher m = p.matcher(fileToken);
	
		TreeMap<String, String> tm=new TreeMap<>();
		
		while (m.find()) {
			String[] parts = (m.group(1)).split(", "); 
			String contactName = parts[0];
			String phoneNumber = parts[1];
			//check only for correct normalize number
			
			//replace 00 with +359 - ZeroZero leading -ZZ
			String zzPhoneNumber= (phoneNumber.substring(0, 2)).equals(zeroZeroLeadingStr) ? phoneNumber.replace(zeroZeroLeadingStr, plusStr) : phoneNumber;
			//replace 0 with +359 - OneZero -OZ
			String ozPhoneNumber= (zzPhoneNumber.substring(0, 1)).equals(zeroLeadingStr) ? zzPhoneNumber.replace(zeroLeadingStr, bgCodeStr) : zzPhoneNumber;
					
			// check for exact pattern 
			Pattern pat = Pattern.compile(normalPhoneNum);
			Matcher match = pat.matcher(ozPhoneNumber);

			while (match.find()) {
				tm.put(contactName, match.group());
			}
			if(tm.isEmpty()){
				System.out.println("No valid entries in text file!");
			}
		} 
		for (Entry<String, String> userD : tm.entrySet()) {
			System.out.println(userD.getKey() + ": " + userD.getValue() + " ");
		}
	}
}
	
	
