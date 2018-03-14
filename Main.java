package ua.prog.java.lesson3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Group newGroup = new Group(1);
		Student newStudent = new Student("Serg6", "Lukavenko", "male", 39);

		newGroup.addStudent(new Student("Serg1", "L", "m", 39));
		newGroup.addStudent(new Student("Serg2", "L", "m", 39));
		newGroup.addStudent(new Student("Serg3", "L", "m", 39));
		newGroup.addStudent(new Student("XAXA4", "L", "m", 39));
		newGroup.addStudent(new Student("Serg5", "L", "m", 39));
		newGroup.addStudent(newStudent);
		newGroup.addStudent(new Student("Serg7", "L", "m", 39));
		newGroup.addStudent(new Student("Serg8", "L", "m", 39));
		newGroup.addStudent(new Student("Serg9", "L", "m", 39));
		newGroup.addStudent(new Student("Serg10", "L", "m", 39));
		newGroup.addStudent(new Student("Serg11", "L", "m", 39));


		System.out.println("\n --------- Состав группы студентов ---------");
		System.out.print(newGroup.toString());
		System.out.println(" -------------------------------------------\n");

		newGroup.deleteStudent(new Student("XAXA4", "L", "m", 39));

		System.out.println("\n --------- Состав группы студентов ---------");
		System.out.print(newGroup.toString());
		System.out.println(" -------------------------------------------\n");

	}

}
