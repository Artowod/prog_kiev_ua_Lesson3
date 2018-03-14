package ua.prog.java.lesson3;

public class ManyStudentsException extends Exception {

		@Override
		public String getMessage(){
		return " Группа уже заполнена. Выгоните кого-то сперва. ";
		}

}
