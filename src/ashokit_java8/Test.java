package ashokit_java8;

import java.util.function.Supplier;

class Doctor{

	public Doctor() {
		System.out.println("doctor constructor .....");
		
		
	}
	
}
public class Test {

	public static void main(String[] args) {
		
		//Doctor d = new Doctor();
		
		Supplier<Doctor> d = Doctor::new;
		System.out.println(d.get().hashCode());
	}

}
