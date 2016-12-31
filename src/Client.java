import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private String ip = "127.0.0.1";
	private String name, greeting;
	private Socket socket;
	private Scanner scanner, reader;
	private PrintStream printStream;

	public Client() {
		init();
		logic();
	}

	private void init() {
		try {
			socket = new Socket(ip, 12);
			scanner = new Scanner(System.in);
			reader = new Scanner(socket.getInputStream());
			printStream = new PrintStream(socket.getOutputStream());
		} catch (Exception e) {
		}
	}

	private void logic() {
		System.out.println("What is your name?");
		name = scanner.nextLine();
		printStream.println(name);
		greeting = reader.nextLine();
		System.out.println(greeting);
	}

	public static void main(String args[]) {
		new Client();
	}
}
