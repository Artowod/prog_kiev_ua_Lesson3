package ua.prog.java.lesson3;

import java.util.ArrayList;
import java.util.List;

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

	public Student[] sortStudentsBySurname() {
		Student[] sortedStudentsBySurname = getArrayWithoutNulls(groupOfStudents);
		Student tempStudent;
		/*
		 * String.compareTo(String) : Abbaa Gamma = -6 Gamma Betta = 5
		 */
		for (int y = sortedStudentsBySurname.length - 1; y > 0; y--) {
			for (int x = 0; x < y; x++) {
				int i = sortedStudentsBySurname[x].getSurname().compareTo(sortedStudentsBySurname[x + 1].getSurname());
				if (i > 0) {
					tempStudent = sortedStudentsBySurname[x + 1];
					sortedStudentsBySurname[x + 1] = sortedStudentsBySurname[x];
					sortedStudentsBySurname[x] = tempStudent;
				}
			}
		}
		for (Student student : sortedStudentsBySurname)
			System.out.println(student.toString());
		return sortedStudentsBySurname;
	}

	private Student[] getArrayWithoutNulls(Student[] arrayWithNulls) {
		int arrayWithoutNullsLength = 0;
		for (Student st : arrayWithNulls) {
			if (st != null) {
				arrayWithoutNullsLength++;
			}
		}
		Student[] arrayWithoutNulls = new Student[arrayWithoutNullsLength];
		int y = 0;
		for (int x = 0; x < arrayWithNulls.length; x++) {
			if (arrayWithNulls[x] != null) {
				arrayWithoutNulls[y++] = arrayWithNulls[x];
			}
		}
		return arrayWithoutNulls;
	}

	public List<Student> getStudentsBySurname(String surname) {
		List<Student> foundStudentsBySurname = new ArrayList<Student>();
		Boolean isStudentsDetected = false;
		for (Student student : groupOfStudents) {
			if (student != null) {
				if (student.getSurname() == surname) {
					foundStudentsBySurname.add(student);
					isStudentsDetected = true;
				}
			}
		}
		if (!isStudentsDetected) {
			System.out.println("Студентов по заданному параметру не обнаружено.");
		}
		return foundStudentsBySurname;
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

	private void putUniqueStudentToGroup(Student newStudent) throws ManyStudentsException {
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
