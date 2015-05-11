class A{
	A(){
		System.out.println("A");
	}
}
class B{
	B(){
		System.out.println("B");
	}
}
public class C extends A{
	B b ;
	C(){
		System.out.println("C");
	}
	public static void main(String args[]){
		C c= new C();
	}
}
