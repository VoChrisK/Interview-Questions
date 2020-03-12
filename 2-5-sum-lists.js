const Node = require("./node");

const sumLists = function(list1, list2) {
    let newList = new Node(0);
    let sentinel = newList;
    let remainder = 0;

    while(list1 !== null && list2 !== null) {
        newList.next = new Node((list1.data + list2.data + remainder) % 10);
        remainder = (list1.data + list2.data + remainder) >= 10 ? 1 : 0;
        list1 = list1.next;
        list2 = list2.next;
        newList = newList.next;
    }

    if(list1 === null) {
        list1 = list2;
    }

    while(remainder === 1 && list1 !== null) {
        newList.next = new Node((list1.data += remainder) % 10);
        remainder = (list1.data + remainder) >= 10 ? 1 : 0;
        list1 = list1.next;
        newList = newList.next;
    }

    if(remainder === 1) newList.next = new Node(remainder);

    return sentinel.next;
};

let list1 = new Node(5);
let list2 = new Node(2);
list1.append(3);
list1.append(7);
list2.append(4);
list2.append(4);
list2.append(9);

let newList = sumLists(list1, list2);

while (newList != null) {
    console.log(newList.data);
    newList = newList.next;
}