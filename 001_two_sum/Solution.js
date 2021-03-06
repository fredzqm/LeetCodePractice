/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var m = new Map();
    for (var i = 0; i < nums.length; i ++){
        var comp = target - nums[i];
        if (comp in m){
            return [m[comp] , i];
        }
        m[nums[i]] = i;
    }
    return undefined;
};


if (require.main === module) {
    const io = require('../IO');
    io([{type:'int',isList:true},
        {type:'int'}],
        data => {
            let ans = twoSum(data[0], data[1]);
            console.log(ans);
        });
}
