import java.time.LocalTime;

abstract public class User {
    public String id;
    public String password;
    public String name;
    public String enterTime;
    public String exitTime;

    public User(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    // To be implemented
    abstract public String getType();

    public boolean enterCampus(String id, String password) {
        if (this.id.equals(id) && this.password.equals(password)) {
            System.out.println("Welcome " + name + "!");
            System.out.println("You are entering TUPT Campus.");
            this.enterTime = String.valueOf(LocalTime.now());
            return true;
        }

        return false;
    }

    public boolean exitCampus(String id) {
        if (this.id.equals(id)) {
            System.out.println("Thank you, " + name +"!");
            System.out.println("You are leaving TUPT Campus.");
            this.exitTime = String.valueOf(LocalTime.now());
            return true;
        }

        return false;
    }
}
