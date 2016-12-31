import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	private String name, greeting;
	private ServerSocket serverSocket;
	private Socket socket;
	private Scanner scanner;
	private PrintStream printStream;

	public Server(){
		init();
		logic();
	}

	private void init() {
		try {
			serverSocket = new ServerSocket(12);
			socket = serverSocket.accept();
			scanner = new Scanner(socket.getInputStream());
			printStream = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {}
	}

	private void logic() {
		name = scanner.nextLine();
		greeting = "Hello " + name;
		
		printStream.println(greeting);
	}

	public static void main(String args[]) {
		new Server();
	}
}
