package lab3;

import java.util.concurrent.Semaphore;

public class TeacherRobo extends Thread{
	private Subject sub;
	private Students currentStudent;
	private boolean Busy;
	private Semaphore sema;
	private BufferManager buff;
	  
	public TeacherRobo(Subject sub, Semaphore sema, BufferManager buff) {
		this.sub = sub;
		this.sema = sema;
		this.buff = buff;
	}

	@Override
	public void run(){
		Thread.currentThread().setName("Robot " + this.sub);
		System.out.println(Thread.currentThread().getName() + " is ready!");
		while (true){
			if (!this.Busy){
				try{
					this.sema.acquire();
				}
				catch (InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("Student go out the room to robot " + this.sub);
				Students stud = this.buff.pop();
				if (stud == null)
					continue;
				this.currentStudent = stud;
				this.Busy = true;
			}
			else {
				//System.out.println(Thread.currentThread().getName() + " accepts labs...");

				while (this.currentStudent.getNumberOfLabs() > 0) {
					this.currentStudent.setNumberOfLabs(this.currentStudent.getNumberOfLabs() - 5);
					System.out.println(Thread.currentThread().getName() + " remaining " + this.currentStudent.getNumberOfLabs()+ "labs");
					try {
						Thread.sleep(500);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				this.Busy = false;
				this.currentStudent = null;
			}
		}
	}
}