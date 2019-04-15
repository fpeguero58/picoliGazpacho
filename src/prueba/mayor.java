package prueba;

public class mayor extends ser{
	int ahorro=0;
	public mayor(int edad) {
		super(edad);
	}
	public static void main(String[] args) {
		ser Ser= new ser(10);
		mayor Mayor= new mayor(Ser.edad);
		System.out.println(Mayor.getClass());
	}

}
