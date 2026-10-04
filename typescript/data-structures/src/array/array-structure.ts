export class ArrayStructure {

    items: Array<number>;
    count: number;

    constructor(size: number) {
        this.items = new Array<number>(size);
        // count is the number of meaningful values currently stored.
        this.count = 0;
    }

    insert(value: number) {
        // Insert at the first unused position.
        this.items[this.count] = value;
        this.count++;
    }

    find(value: number): boolean {
        let index: number;
        // Linear search scans only the used part of the array.
        for (index = 0; index < this.count; index++) {
            if (this.items[index] === value) {
                break;
            }
        }
        if (index === this.count) {
            return false;
        }
        return true;
    }

    remove(value: number): boolean {
        let index: number;
        for (index = 0; index < this.count; index++) {
            if (this.items[index] === value) {
                break;
            }
        }
        if (index === this.count) {
            return false;
        }
        // Shift everything after the removed item one slot to the left.
        for (let shiftIndex = index; shiftIndex < this.count; shiftIndex++) {
            this.items[shiftIndex] = this.items[shiftIndex + 1];
        }
        this.count--;
        return true;
    }

    display() {
        for (let index = 0; index < this.count; index++) {
            console.log(this.items[index]);
        }
    }

    size(): number {
        return this.count;
    }

}
