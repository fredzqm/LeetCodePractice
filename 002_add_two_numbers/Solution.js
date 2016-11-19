
// Definition for singly-linked list.
function ListNode(val) {
    this.val = val;
    this.next = null;
    this.toString = () => {
        if (this.next)
            return "" + this.val + " " + this.next;
        return "" + this.val;
    }
}

function createNode(i, ls) {
    let x = new ListNode(ls[i]);
    if (i+1 !== ls.length)
        x.next = createNode(i+1, ls);
    return x;
}

var addTwoNumbers = function(l1, l2) {
    function helper(a, b, addOne){
        if (a === null && b === null){
            if (addOne == 1){
                return new ListNode(1);
            }
            return null;
        }
        var v = addOne;
        var n1 = null;
        var n2 = null;
        if (a !== null){
            v += a.val;
            n1 = a.next;
        }
        if (b !== null){
            v += b.val;
            n2 = b.next;
        }
        var ret = new ListNode(v % 10);
        ret.next = helper(n1, n2, Math.floor(v / 10));
        return ret;
    }
    return helper(l1, l2, 0);
};


if (require.main === module) {
    const io = require('../IO');
    io([{type:'int',isList:true},
        {type:'int',isList:true}],
    data => {
        let a = createNode(0, data[0]);
        let b = createNode(0, data[1]);
        let ans = addTwoNumbers(a, b);
        console.log(""+ans);
    });
}