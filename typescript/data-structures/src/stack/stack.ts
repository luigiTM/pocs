export class Stack {

    maxSize: number;
    items: Array<number>;
    top: number;

    constructor(size: number) {
        this.maxSize = size;
        this.items = new Array<number>(size);
        // top points to the last inserted item; -1 means the stack is empty.
        this.top = -1;
    }

    push(value: number) {
        // Move top first, then store the new value at that position.
        this.items[++this.top] = value;
    }

    pop(): number {
        // Return the current top value, then move top back one position.
        return this.items[this.top--];
    }

    peek(): number {
        return this.items[this.top];
    }

    isEmpty(): boolean {
        return this.top === -1;
    }

    isFull(): boolean {
        return this.top === this.maxSize - 1;
    }

}
