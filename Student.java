package ua.prog.java.lesson3;

public class Student extends Human {
	public Student(String name, String surname, String sex, int age) {
		super(name, surname, sex, age);
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "������� [���:" + getName() + ", �������:" + getSurname() + ", ���:" + getSex() + ", �������:" + getAge()
				+ "]";
	}

}
