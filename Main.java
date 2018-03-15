package ua.prog.java.lesson3;

public class Main {

	public static void main(String[] args) {
		Group newGroup = new Group(1);
		Student newStudent = new Student("Serg6", "Lukavenko", "male", 39);
		newGroup.addStudent(new Student("Serg1", "Lukavenko", "m", 39));
		newGroup.addStudent(new Student("DSerg2", "Bukavenko", "m", 39));
		newGroup.addStudent(new Student("Serg3", "Vladimenko", "m", 39));
		newGroup.addStudent(new Student("CXAXA4", "Lopata", "m", 39));
		newGroup.addStudent(new Student("Serg10", "Bravo", "m", 39));
		newGroup.addStudent(newStudent);
		newGroup.addStudent(new Student("Serg7", "Charly", "m", 39));
		newGroup.addStudent(new Student("XSerg10", "Vladimenko", "f", 22));
		newGroup.addStudent(new Student("Serg9", "Ribokon", "m", 39));
		newGroup.addStudent(new Student("Rerg10", "Tramp", "m", 39));
		newGroup.addStudent(new Student("ZSerg11", "Zoorroo", "m", 39));

		System.out.println("\n --------- Состав группы студентов ---------");
		System.out.print(newGroup.toString());
		System.out.println(" -------------------------------------------\n");

		newGroup.deleteStudent(new Student("CXAXA4", "Lopata", "m", 39));

		System.out.println("\n --------- Состав группы студентов ---------");
		System.out.print(newGroup.toString());
		System.out.println(" -------------------------------------------\n");

		String studentSurname = "Vladimenko";

		System.out.println("Найти студентов с фамилией " + studentSurname + ":");
		for (Student foundStudent : newGroup.getStudentsBySurname(studentSurname)) {
			System.out.println(foundStudent);
		}

		System.out.println("\nСортируем студентов по их фамилиям: ");
		newGroup.sortStudentsBySurname();
	}
}
