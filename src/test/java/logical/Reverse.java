package logical;

public class Reverse {
	
	public static void reversethestring(String s) {
		String s1="";
		String rev="";
		String[] split = s.split(" ");
		
		for (int i =0; i <split.length; i++) {
			s1= split[i];
			String s2= "";
			for (int j =s1.length()-1 ; j >=0; j--) {
				char c=s1.charAt(j);
				
				s2=s2+c;
				
				
			}
			
			rev=rev+s2+" ";
			
		}
	
		System.out.println(rev);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		reversethestring("i love my mom");
		
	

	}

}
