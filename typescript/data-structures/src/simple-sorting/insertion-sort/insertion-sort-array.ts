export class InsertionSortArray {

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

    insertionSort() {
        let inIndex: number;
        let outIndex: number;
        // Grow a sorted prefix by inserting one new value at a time.
        for (outIndex = 1; outIndex < this.count; outIndex++) {
            let temp = this.items[outIndex];
            inIndex = outIndex;
            // Shift larger values right until the insertion spot opens.
            while (inIndex > 0 && this.items[inIndex - 1] >= temp) {
                this.items[inIndex] = this.items[inIndex - 1];
                --inIndex;
            }
            this.items[inIndex] = temp;
        }
    }
}
