package lab2_ver2;

import java.util.Random;
import shapes.*;
import shapes.Circle;

public class Main {
    public static void main(String[] args) {
    	Random random;
    	random = new Random();
    	//int k = 0;
    	int choose;
        Shape[] shapes = new Shape[10]; 
    	double[] areaShapes = new double[10];
     
    	for (int i=0;i<10;i++) {

    		choose = random.nextInt(3) +1;
    		
    		if (choose == 1) {
    			System.out.println(+i+1 +") Circle ");
    			Circle C = new Circle();
    			//shapes[i]  = new Circle();
    			C.getLength();
    			shapes[i]  = C;
    		};
			if (choose == 2) {
				System.out.println(+i+1 +") Retangle");

				//shapes[i] = new Rectangle();
				Rectangle R = new Rectangle();
				R.getPerimeter();
				shapes[i] = R;
			};
    		if (choose == 3) {
    			System.out.println(+i+1 +") Triangle ");
    			shapes[i] = new Triangle();
    			Triangle T = new Triangle();
				T.getPerimeter();
				shapes[i] = T;
				//System.out.println(" Area : " +T.getArea());
    		};
    		areaShapes[i] = shapes[i].getArea();
    		//System.out.println(" Area : " +areaShapes[i]);
        	System.out.println(" Area : " +shapes[i].getArea());

    	}; 
    	
    	 findMaxArea(shapes);	
    }

	private static void findMaxArea(Shape[] shapes)
    {
      double maxArea = 0;

      for (Shape shape : shapes)
      {
        double area = shape.getArea();
        if (area > maxArea)
        {
          maxArea = area;
        }
      }
  	System.out.println("\nMax Area : " +maxArea);
    }
}
