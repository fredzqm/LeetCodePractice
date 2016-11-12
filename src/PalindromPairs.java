import java.util.Collections;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class PalindromPairs {

	static class Pair {
		StringWrapper first;
		StringWrapper second;

		public Pair(StringWrapper a, StringWrapper b) {
			first = a;
			second = b;
		}

		public List<Integer> getRet() {
			List<Integer> x = new ArrayList<>(2);
			x.add(first.id);
			x.add(second.id);
			return x;
		}

		@Override
		public String toString() {
			return "<" + first + ", " + second + ">";
		}

		public boolean isValid() {
			return first != second;
		}
	}

	static class Node {
		StringWrapper str;
		Character c;
		ArrayList<Node> nodes;

		public Node() {
			nodes = new ArrayList<>();
		}

		public Node(char c) {
			this.c = c;
			nodes = new ArrayList<>(1);
		}

		public void add(StringWrapper w) {
			if (w.atEnd()) {
				str = w;
				return;
			}
			char c = w.charAtIndex();
			Node n;
			if (nodes.size() == 0 || nodes.get(nodes.size() - 1).c < c) {
				n = new Node(c);
				nodes.add(n);
			} else {
				n = findNode(c);
				if (n == null)
					throw new RuntimeException("cannot find node " + c);
			}
			w.increIndex();
			n.add(w);
		}

		public void checkPalindom(List<Pair> ret, StringWrapper w) {
			if (str != null) {
				if (w.isPalindomUpToIndex()) {
					ret.add(new Pair(str, w));
				}
			}
			if (w.atBeginning()) {
				List<StringWrapper> pals = new LinkedList<>();
				for (Node n : nodes)
					n.getPalindoms(pals, "");
				for (StringWrapper a : pals) {
					ret.add(new Pair(a, w));
				}
				return;
			}
			char c = w.charAtIndex();
			Node n = findNode(c);
			if (n != null) {
				w.decreIndex();
				n.checkPalindom(ret, w);
			}
		}

		private void getPalindoms(List<StringWrapper> ret, String cur) {
			String next = cur + c;
			if (str != null) {
				if (isPalindrom(next)) {
					ret.add(str);
				}
			}
			for (Node n : nodes) {
				n.getPalindoms(ret, next);
			}
		}

		private Node findNode(char c) {
			int i = 0, j = nodes.size();
			while (j > i) {
				int mid = (i + j) / 2;
				char midc = nodes.get(mid).c;
				if (midc < c) {
					i = mid + 1;
				} else if (midc > c) {
					j = mid;
				} else {
					return nodes.get(mid);
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return c + " " + nodes;
		}
	}

	static class StringWrapper implements Comparable<StringWrapper> {
		private String s;
		private int id;
		private int index;

		public StringWrapper(String string, int index) {
			s = string;
			id = index;
		}

		public int getID() {
			return id;
		}

		public char charAtIndex() {
			return s.charAt(index);
		}

		public boolean isPalindomUpToIndex() {
			int i = 0, j = index;
			while (j > i) {
				if (s.charAt(i++) != s.charAt(j--))
					return false;
			}
			return true;
		}

		public void increIndex() {
			index++;
		}

		public void decreIndex() {
			index--;
		}

		public boolean atEnd() {
			return index == s.length();
		}

		public boolean atBeginning() {
			return index == -1;
		}

		public void setIndexBegining() {
			index = 0;
		}

		public void setIndexEnd() {
			index = s.length() - 1;
		}

		@Override
		public int compareTo(StringWrapper o) {
			return s.compareTo(o.s);
			// String s1 = s, s2 = o.s;
			// int len = s1.length() - s2.length();
			// if (len != 0)
			// return len;
			// return s1.compareTo(s2);
		}

		@Override
		public String toString() {
			return s;
		}
	}

	public static List<List<Integer>> palindromePairs(String[] words) {
		ArrayList<StringWrapper> ls = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			ls.add(new StringWrapper(words[i], i));
		}
		Collections.sort(ls);
		System.out.println("ls: " + ls);

		List<Pair> pairs = new LinkedList<>();
		Node a = new Node();
		for (StringWrapper w : ls) {
			w.setIndexBegining();
			a.add(w);
		}
		for (StringWrapper w : ls) {
			w.setIndexEnd();
			a.checkPalindom(pairs, w);
		}
		System.out.println("pairs: " + pairs);
		List<List<Integer>> ret = new LinkedList<>();
		for (Pair p : pairs)
			if (p.isValid())
				ret.add(p.getRet());
		return ret;
	}

	public static boolean isPalindrom(String x) {
		int i = 0, j = x.length() - 1;
		while (j > i) {
			if (x.charAt(i++) != x.charAt(j--))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] ls = new String[] { "a", "" };
		System.out.println("result: " + palindromePairs(ls));
	}

}
