package custom;

public class ReveseStringInplace {

	public static void main(String[] args) {
		String str = "WISDOM";
		System.out.println(reverseString(str));
	}
	
	private static String reverseString(String str) {
		// using StringBuilder as it is mutable, and don't get to create temp object with String
		StringBuilder revString = new StringBuilder(str);
		
		// looping until middle position
		for(int i=0; i<revString.length()/2; i++) {
			Character current = revString.charAt(i);
			Character other = revString.charAt(revString.length()-1-i);
			
			revString.setCharAt(i, other);
			revString.setCharAt(revString.length()-1-i, current);
		}
		return revString.toString();
	}
}
