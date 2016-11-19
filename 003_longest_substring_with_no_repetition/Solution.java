import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int j = 0, max = 0;
        for (int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if (!set.contains(c)){
                set.add(c);
            }else{
                max = Math.max(max, i - j);
                while (s.charAt(j) != c){
                    set.remove(s.charAt(j));
                    j++;
                }
                j++;
            }
        }
        return Math.max(max, s.length() - j);
    }


	public static void main(String[] args) {
		IO in = new IO();
		Solution sol = new Solution();
		while (in.hasNext()) {
			String s = in.nextLine();
			int ans = sol.lengthOfLongestSubstring(s);
			System.out.println(ans);
		}
	}
}