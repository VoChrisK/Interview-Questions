module.exports = class Node {
    constructor(data) {
        this.next = null;
        this.data = data;
    }

    append(data) {
        let end = new Node(data);
        let n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    printNodes() {
        let n = this;
        let string = "";

        while(n != null) {
            string = string.concat(n.data + " -> ");
            n = n.next;
        }

        console.log(string.substring(0, string.length - 4));
    }
}