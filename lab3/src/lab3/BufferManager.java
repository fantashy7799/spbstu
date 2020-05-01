package lab3;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class BufferManager {
	private CopyOnWriteArrayList<Students> queueOfStudents = new CopyOnWriteArrayList<>();
	private Semaphore semMath;
	private Semaphore semOOP;
	private Semaphore semPhysics;
	
	public BufferManager(Semaphore semMath, Semaphore semOOP, Semaphore semPhysics) {
		this.semMath = semMath;
		this.semOOP = semOOP;
		this.semPhysics = semPhysics;
	}
	
	private void release(Students student) {
		if (student.getNameSubject() == Subject.Math)
			this.semMath.release();
		else if (student.getNameSubject() == Subject.OOP) 
			this.semOOP.release();
		else if (student.getNameSubject() == Subject.Physics)
			this.semPhysics.release();
	}
	
	public boolean canAdd() {
		return this.queueOfStudents.size() < 10;
	}
	
	public Students pop() {
		if (queueOfStudents.size() != 0) {
			Students student = this.queueOfStudents.get(0);
			this.queueOfStudents.remove(0);
			System.out.println("Total Student in the room: " + this.queueOfStudents.size());
			if (queueOfStudents.size() != 0){
				Students stud = this.queueOfStudents.get(0);
				release(stud);
			}
			return student;
		}
		return null;
	}

	public void push(Students student) {
		boolean canRelease = this.queueOfStudents.size() == 0;
		this.queueOfStudents.add(student);
		System.out.println("New student come in the room, room have:" + this.queueOfStudents.size());
		if (canRelease)
			release(student);
	}
}