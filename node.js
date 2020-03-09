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
}