export class Link {

    data: number;
    next: Link | undefined;

    constructor(data: number) {
        this.data = data;
        // next points to the following node, or undefined at the end.
        this.next = undefined;
    }

    display() {
        console.log(`Data: ${this.data}`);
    }
}
