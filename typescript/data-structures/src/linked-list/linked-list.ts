import { Link } from "./link";

export class LinkedList {

    first?: Link;

    constructor() {
        // first is the head of the list; undefined means there are no nodes.
        this.first = undefined;
    }

    isEmpty(): boolean {
        return this.first === undefined;
    }

    insertFirst(data: number) {
        let newLink = new Link(data);
        // Point the new node at the current head, then make it the new head.
        newLink.next = this.first;
        this.first = newLink;
    }

    deleteFirst(): Link | undefined {
        if (this.first === undefined) {
            return undefined;
        }
        let temporary = this.first;
        // Move the head forward; the old head becomes detached from the list.
        this.first = this.first.next;
        return temporary;
    }

    displayList() {
        console.log("List (first -> last)");
        let current = this.first;
        // Follow next pointers until the end of the list.
        while (current !== undefined) {
            current.display();
            current = current.next;
        }
        console.log("\n");
    }

}
