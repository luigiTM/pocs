export class SelectionSortArray {

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

    selectionSort() {
        let front: number;
        let back: number;
        let minimum: number;
        // Select the smallest remaining value for each position.
        for (back = 0; back < this.count; back++) {
            minimum = back;
            for (front = back + 1; front < this.count; front++) {
                if (this.items[front] < this.items[minimum]) {
                    minimum = front;
                }
            }
            this.swap(back, minimum);
        }
    }

    swap(index: number, otherIndex: number) {
        // Swap two positions without losing either value.
        let temporary = this.items[index];
        this.items[index] = this.items[otherIndex];
        this.items[otherIndex] = temporary;
    }

}
