/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    var j = 0;
    var max = 0;
    var st = new Set();
    for (let i = 0; i < s.length; i++){
        var c = s[i];
        if (st.has(c)){
            if (i - j > max)
                max = i - j;
            while (s[j] !== c){
                st.delete(s[j]);
                j++;
            }
            j++;
        } else {
            st.add(c);
        }
    }
    if (s.length - j > max)
        max = s.length - j;
    return max;
};

if (require.main === module) {
    const io = require('../IO');
    io([{type:'string'}],
        data => {
            let ans = lengthOfLongestSubstring(data[0]);
            console.log(ans);
        });
}
