export class Queue {

    maxSize: number;
    items: Array<number>;
    front: number;
    rear: number;
    count: number;

    constructor(size: number) {
        this.maxSize = size;
        this.items = new Array<number>(size);
        // front removes items, rear inserts items, and count tracks occupancy.
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    enqueue(value: number) {
        // Wrap rear to the beginning when it reaches the end of the array.
        if (this.rear === this.maxSize - 1) {
            this.rear = -1;
        }
        this.items[++this.rear] = value;
        this.count++;
    }

    dequeue(): number {
        let temp = this.items[this.front++];
        // Wrap front so the fixed-size array behaves like a circle.
        if (this.front === this.maxSize) {
            this.front = 0;
        }
        this.count--;
        return temp;
    }

    peekFront(): number {
        return this.items[this.front];
    }

    isEmpty(): boolean {
        return this.count === 0;
    }

    isFull(): boolean {
        return this.count === this.maxSize;
    }

    size(): number {
        return this.count;
    }
}
