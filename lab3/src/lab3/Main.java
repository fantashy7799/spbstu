package lab3;

import java.util.concurrent.Semaphore;

enum Subject
{
  Math,
  OOP,
  Physics
}
public class Main {
	public static void main(String[] args)  {
	    Semaphore semMath = new Semaphore(0);
	    Semaphore semOOP = new Semaphore(0);
	    Semaphore semPhysics = new Semaphore(0);
	    BufferManager buffer = new BufferManager(semMath, semOOP, semPhysics);
	
	    TeacherRobo mathTeacher = new TeacherRobo(Subject.Math, semMath, buffer);
	    TeacherRobo OOPTeacher = new TeacherRobo(Subject.OOP, semOOP, buffer);
	    TeacherRobo physicsTeacher = new TeacherRobo(Subject.Physics, semPhysics, buffer);
	    Generator generator = new Generator(buffer);
	    
	    generator.start();
	    mathTeacher.start();
	    OOPTeacher.start();
	    physicsTeacher.start();	
  }
}