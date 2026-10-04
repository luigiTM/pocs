export class BubbleSortArray {

    items: Array<number>;
    count: number;

    constructor(size: number) {
        this.items = new Array<number>(size);
        // count is the active length; the rest is unused capacity.
        this.count = 0;
    }

    insert(value: number) {
        this.items[this.count] = value;
        this.count++;
    }

    display() {
        for (let index = 0; index < this.count; index++) {
            console.log(this.items[index]);
        }
        console.log("\n");
    }

    bubbleSort() {
        let front: number;
        let back: number;
        // Each pass bubbles the largest remaining value toward the back.
        for (back = this.count - 1; back > 1; back--) {
            for (front = 0; front < back; front++) {
                if (this.items[front] > this.items[front + 1]) {
                    this.swap(front, front + 1);
                }
            }
        }
    }

    swap(index: number, otherIndex: number) {
        // Swap two positions without losing either value.
        let temporary = this.items[index];
        this.items[index] = this.items[otherIndex];
        this.items[otherIndex] = temporary;
    }

}
