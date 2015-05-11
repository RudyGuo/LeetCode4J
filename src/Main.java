import java.util.Scanner;
public class Main {
	public static void main(String args[])throws Exception{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int v = (int)Math.sqrt(a*b*c);
		System.out.println((v/a+v/b+v/c)*4);
	}
}
