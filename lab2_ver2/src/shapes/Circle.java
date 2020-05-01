package shapes;
import java.util.Random;

public class Circle implements Ellipse {
	final float PI = 3.14f; 
	int r; 
	
	@Override
	public float getLength() {
		Random random = new Random();
		r= random.nextInt(10)+1;
    	System.out.println(" R  : " +r);
		 return 0;
	}
	
	@Override
	public double getArea() {
		return PI*r*r;
	}
}
