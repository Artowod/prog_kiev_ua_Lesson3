package ua.prog.java.lesson3;

public class ManyStudentsException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return " Группа уже заполнена. Выгоните кого-то сперва. ";
	}

}
