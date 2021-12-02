import java.util.Scanner;

public class MainClass {
	static Scanner input = new Scanner(System.in);
	static String id;
	static String password;
	static User[] users = new User[10];
	static User[] enteredUsers = new User[100];
	static User[] exitedUsers = new User[100];

	public static void main(String[] args) {
		createInitialUsers();

		char choice;
		int enteredUsersIndex = 0;
		int exitedUsersIndex = 0;

		do {
			System.out.println("A - Enter Campus");
			System.out.println("B - Exit Campus");
			System.out.println("C - Show Entry History");
			System.out.println("D - Show Exit History");
			System.out.println("X - Exit Program");
			System.out.print("Choice: ");

			choice = input.nextLine().toUpperCase().charAt(0);

			switch (choice) {
				case 'A': // Enter Campus
					enterCampus();
					boolean isLoggedIn = false;

					for (User currentUser : users) {
						isLoggedIn = currentUser.enterCampus(id, password);
						if (isLoggedIn) {
							enteredUsers[enteredUsersIndex] = currentUser;
							enteredUsersIndex++;
							break;
						}
					}

					if (! isLoggedIn) {
						System.out.println("Invalid login Credentials.");
					}

					break;

				case 'B': // Exit Campus
					exitCampus();
					boolean isLoggedOut = false;

					for (User currentUser : users) {
						isLoggedOut = currentUser.exitCampus(id);
						if (isLoggedOut) {
							exitedUsers[exitedUsersIndex] = currentUser;
							exitedUsersIndex++;
							break;
						}
					}

					if (! isLoggedOut) {
						System.out.println("User ID does not exist.");
					}

					break;

				case 'C': // Show Entry History
					System.out.println("\nEntry History");

					for (int i = 0; i < enteredUsersIndex; i++) {
						User enteredUser = enteredUsers[i];
						System.out.println("-------------------------------");
						System.out.println("ID Number: " + enteredUser.id);
						System.out.println("Type: " + enteredUser.getType());
						System.out.println("Entry Time: " + enteredUser.enterTime);
						System.out.println("-------------------------------\n");
					}

					break;

				case 'D': // Show Exit History
					System.out.println("\nExit History");

					for (int i = 0; i < exitedUsersIndex; i++) {
						User exitedUser = exitedUsers[i];
						System.out.println("-------------------------------");
						System.out.println("ID Number: " + exitedUser.id);
						System.out.println("Entry Time: " + exitedUser.exitTime);
						System.out.println("-------------------------------\n");
					}

					break;
				}
		} while (choice != 'X');
	}

	public static void createInitialUsers() {
		users[0] = new Faculty("TUPT1234", "4321", "PJ");
		users[1] = new Faculty("TUPT5678", "8765", "Tom Nook");
		users[2] = new Faculty("TUPT7878", "7878", "Merenque");
		users[3] = new Faculty("TUPT4545", "4545", "Marshall");
		users[4] = new Faculty("TUPT9292", "9292", "Tommy Nook");
		users[5] = new Student("TUPT4321", "4321", "JP");
		users[6] = new Student("TUPT8765", "8765", "Nook Tom");
		users[7] = new Student("TUPT8787", "7878", "Quemeren");
		users[8] = new Student("TUPT5454", "4545", "ShallMar");
		users[9] = new Student("TUPT2929", "9292", "Nook Tommy");
	}
	
	public static void enterCampus() {
		System.out.println("-----------------------------------");
		System.out.println("|   TUPT Campus Contact Tracing   |");
		System.out.println("-----------------------------------");
		System.out.println("|          Enter Campus           |");
		System.out.println("-----------------------------------");
		System.out.print("|Enter ID Number: ");
		id = input.nextLine();
		System.out.print("|Enter Password: ");
		password = input.nextLine();
		System.out.println("-----------------------------------\n");
	}
	
	public static void exitCampus() {
		System.out.println("-----------------------------------");
		System.out.println("|   TUPT Campus Contact Tracing   |");
		System.out.println("-----------------------------------");
		System.out.println("|           Exit Campus           |");
		System.out.println("-----------------------------------");
		System.out.print("|Enter ID Number: ");
		id = input.nextLine();
		System.out.println("-----------------------------------\n");
	}
}



