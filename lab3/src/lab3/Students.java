package lab3;

public class Students {
	private int labsCount;
	private Subject subjectName;
	
	public Students(int labsCount, Subject subjectName) {
		this.labsCount = labsCount;
		this.subjectName = subjectName;
	}

	public int getNumberOfLabs() {
		return labsCount;
	}

	public void setNumberOfLabs(int labsCount) {
		this.labsCount = labsCount;
	}

	public Subject getNameSubject() {
		return subjectName;
	}
}
