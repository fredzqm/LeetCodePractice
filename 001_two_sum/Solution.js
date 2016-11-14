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
	const readline = require('readline');
	const rl = readline.createInterface({
	  input: process.stdin,
	  output: process.stdout
	});

	let nums = undefined;
	rl.on('line', (input) => {
		if (!nums) {
			nums = input.split(" ").map((x) => {
				return parseInt(x);
			});
		} else {
			let target = parseInt(input);
			let ans = twoSum(nums, target);
			console.log(ans);
			nums = undefined;
		}
	});
}