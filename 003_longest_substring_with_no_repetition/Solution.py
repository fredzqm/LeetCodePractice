class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        st = set()
        j = 0
        mx = 0
        for i in range(len(s)):
            c = s[i]
            if c in st:
                if i - j > mx:
                    mx = i - j
                while s[j] != c:
                    st.remove(s[j])
                    j += 1
                j += 1
            else:
                st.add(c);
        if len(s) - j > mx:
            mx = len(s) - j
        return mx


if __name__ == '__main__':
    try:
        sol = Solution()
        while (True):
            s = input()
            ans = sol.lengthOfLongestSubstring(s)
            print(ans)
    except EOFError:
        pass

