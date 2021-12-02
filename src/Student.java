public class Student extends User {

	public Student(String id, String password, String name) {
		super(id, password, name);
	}

	@Override
	public String getType() {
		return "Student";
	}
}
