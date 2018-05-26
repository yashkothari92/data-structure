package tree;

public class LexicographCompare {

	public static void main(String[] args) {
		String s1 = "Geeks";
		String s2 = "Practice";
		String s3 = "GeeksForGeels";
		
		System.out.println(" >> "+ (compare(s1, s2) > 0 ? s1 +" larger" : s2+" larger")); // -9
		System.out.println(" >> "+ (compare(s2, s3) > 0 ? s2 +" larger" : s3+" larger")); // +9
		System.out.println(" >> "+ (compare(s1, s3) > 0 ? s1 +" larger" : s3+" larger"));//
		System.out.println(" >> "+ (compare(s3, s1) > 0 ? s3 +" larger" : s1+" larger"));// 
	}

	private static int compare(String s1, String s2) {
		System.out.println("\n"+s1+" "+s2);
		System.out.println("-------------");
		for(int i=0; i<s1.length() && i<s2.length(); i++){
			System.out.println((int)s1.charAt(i) +" "+ (int)s2.charAt(i));
			if((int)s1.charAt(i) == (int)s2.charAt(i)){
				continue;
			}else{
				int dif = (int)s1.charAt(i) - (int)s2.charAt(i);
				return dif;
			}
		}
		
		 if (s1.length() < s2.length()) {
	         return -1;
	     } 
	     else if (s2.length() < s1.length()) {
	         return (int)s1.charAt(s2.length());
	     }
	     else{
			return 0;
		}
	}
}
