package lab3;
import java.util.Random;

public class Generator extends Thread {
	private BufferManager buff;
	public Generator(BufferManager buff) {
		this.buff = buff;
	}

	@Override
	public void run() {
    Thread.currentThread().setName("Generator");
    System.out.println(Thread.currentThread().getName() + " generated!");
	    for(int i =1; i<15; i++) {
	    	if (this.buff.canAdd()) {
			    int labsCount = 0;
			    Subject subjectName = null;
			    Random rand = new Random();
			    int random1 = rand.nextInt(3);
			    switch (random1) {
				case 0: {
					labsCount = 10;
					break;
				}
				case 1: {
					labsCount = 20;
					break;
				}
				case 2: {
					labsCount = 100;
					break;
				}
				}
			    int random2 = rand.nextInt(3);
			    switch (random2) {
				case 0: {
					subjectName = Subject.Math;
					break;
				}
				case 1: {
					subjectName = Subject.OOP;
					break;
				}
				case 2: {
					subjectName = Subject.Physics;
					break;
				}
			}
	    Students student = new Students(labsCount, subjectName);
	    this.buff.push(student);
      }
    }
  }
}