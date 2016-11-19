const EventEmitter = require('events');
const readline = require('readline');

const METHODS = {
	string: a => a,
	int: parseInt
}

module.exports = function(format, handle){
	const rl = readline.createInterface({
	  input: process.stdin,
	  output: process.stdout
	});
	let nums = 0;
	let data = [];
	rl.on('line', (input) => {
		let f = format[nums];
		let m = METHODS[f.type];
		let d = input.split(" ");
		for (let i = 0 ; i < d.length; i++)
			d[i] = m(d[i]);
		if (f.isList) {
			data.push(d);
		} else {
			data.push(d[0]);
		}
		nums++;
		if (nums === format.length) {
			handle(data);
			nums = 0;
			data = [];
		}
	});
};