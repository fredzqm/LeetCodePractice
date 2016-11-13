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