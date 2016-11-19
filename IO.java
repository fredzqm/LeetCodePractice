import java.util.Scanner;
import java.io.PrintStream;

public class IO {
	private Scanner in = new Scanner(System.in);

	public boolean hasNext(){
		return in.hasNext();
	}

	public String nextLine(){
		return in.nextLine();
	}

	public String[] nextStrings() {
		String line = nextLine();
		if (line.length() == 0)
			line = in.nextLine();
		return line.split(" ");
	}

	public int[] nextIntArray(){
		String[] sp = nextStrings();
		int[] ret = new int[sp.length];
		for (int i = 0; i < sp.length; i++)
			ret[i] = Integer.parseInt(sp[i]);
		return ret;
	}

	public int nextInt() {
		return in.nextInt();
	}

}