package shapes;
import java.util.Random;

public class Rectangle implements Polygon{
	int length;
	int width;

	@Override
	public double getPerimeter() {
		Random random = new Random();
		length = random.nextInt(10)+1;
		width = random.nextInt(10)+1;
		System.out.println(" 2 edges in Rectangle : " +length +"_" +width );
		return 0;
	}

	@Override
	public double getArea() {
		 return (length*width);
	}
}
