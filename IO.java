import java.util.Scanner;
import java.io.PrintStream;

public class IO {
	private Scanner in = new Scanner(System.in);
	private PrintStream out = System.out;

	public boolean hasNext(){
		return in.hasNext();
	}

	public String[] nextStrings() {
		String line = in.nextLine();
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

	public void println(int[] x){
		for (int i : x)
			out.print(" "+i);
		out.println();
	}
}