package ua.prog.java.lesson3;

import java.util.Arrays;

public class Group {
	private int groupNumber;
	private int groupSize = 10;
	private Student[] groupOfStudents = new Student[groupSize];

	public Group(int groupNumber) {
		super();
		this.groupNumber = groupNumber;
	}

	public Group() {
		super();
	}

	public Student getStudentBySurname(String surname) {

		return new Student();
	}

	public void addStudent(Student newStudent) {
		if (isStudentAlreadyIn(newStudent)) {
			System.out.println("Cтудент " + newStudent.toString() + " уже есть в группе.");
		} else {
			try {
				putUniqueStudentToGroup(newStudent);
			} catch (ManyStudentsException ex) {
				System.out.println(ex.getMessage());
			}
		}

	}

	private Boolean isStudentAlreadyIn(Student checkedStudent) {
		for (Student student : groupOfStudents) {
			if (student != null) {
				if (student.equals(checkedStudent)) {
					return true;
				}
			}
		}

		return false;
	}

	public void putUniqueStudentToGroup(Student newStudent) throws ManyStudentsException {
		int counterFirstFreeSpaceInGroup = -1;
		int counterStudentInGroup = 0;
		for (Student student : groupOfStudents) {
			counterFirstFreeSpaceInGroup += 1;
			if (student == null) {
				groupOfStudents[counterFirstFreeSpaceInGroup] = newStudent;
				break;
			} else {
				counterStudentInGroup += 1;
			}
		}
		if (counterStudentInGroup == groupSize)
			throw new ManyStudentsException();
	}

	public void deleteStudent(Student deletingStudent) {
		int counterStudentPositionInGroup = -1;
		for (Student student : groupOfStudents) {
			counterStudentPositionInGroup += 1;
			if (student != null) {
				if (student.equals(deletingStudent)) {
					groupOfStudents[counterStudentPositionInGroup] = null;
					System.out.println("Cтудент " + deletingStudent + " успешно удалён.");
					break;
				}
			}
		}
		if (counterStudentPositionInGroup == groupSize - 1) {
			System.out.println("Заданный студент не числится в данной группе.");
		}
	}

	@Override
	public String toString() {
		String groupOfStudent = "";
		for (Student student : groupOfStudents) {
			if (student != null) {
				groupOfStudent += student.toString() + "\n";
			}
		}

		return groupOfStudent;
	}

}
