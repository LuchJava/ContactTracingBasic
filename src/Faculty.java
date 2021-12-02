public class Faculty extends User {

	public Faculty(String id, String password, String name) {
		super(id, password, name);
	}

	@Override
	public String getType() {
		return "Faculty";
	}
}
