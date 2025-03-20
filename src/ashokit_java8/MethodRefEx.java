package ashokit_java8;

@FunctionalInterface
interface MyInter{
	public void m1();
}

public class MethodRefEx {
	
	public static void m2() {
		System.out.println("method m2 is called..........");
	}
	public static void main(String[] args) {
		
	 MyInter i = MethodRefEx::m2;
	 i.m1();
		
	}
}
