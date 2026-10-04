export class SegmentTree {
    size: number;
    tree: number[];

    constructor(vector: number[]) {
        this.size = vector.length;
        // 4 * n is a safe upper bound for storing all segment tree nodes.
        // Index 0 is unused so children are 2 * index and 2 * index + 1.
        this.tree = new Array<number>(this.size * 4);
        if (this.size > 0) {
            this.build(vector, 1, 0, this.size - 1);
        }
    }

    // Private methods ##
    private build(vector: number[], index: number, left: number, right: number) {
        console.log(`Building node ${index} for range [${left}, ${right}]`);

        // Leaf nodes represent exactly one value from the original vector.
        if (left === right) {
            this.tree[index] = vector[left];
            console.log(`Leaf node ${index}: tree[${index}] = vector[${left}] = ${vector[left]}`);
            return;
        }

        // Internal nodes split their range and store the sum of both children.
        const midPoint = Math.floor((left + right) / 2);
        const leftChild = 2 * index;
        const rightChild = 2 * index + 1;
        console.log(
            `Node ${index}: split [${left}, ${right}] into [${left}, ${midPoint}] and [${midPoint + 1}, ${right}]`
        );
        this.build(vector, leftChild, left, midPoint);
        this.build(vector, rightChild, midPoint + 1, right);
        this.tree[index] = this.tree[leftChild] + this.tree[rightChild];
        console.log(
            `Node ${index}: tree[${index}] = tree[${leftChild}] + tree[${rightChild}] = ${this.tree[leftChild]} + ${this.tree[rightChild]} = ${this.tree[index]}`
        );
    }

    private _query(index: number, left: number, right: number, queryLeft: number, queryRight: number): number {
        // No overlap: this node contributes nothing to the requested sum.
        if (queryLeft > right || queryRight < left) {
            return 0;
        }

        // Total overlap: reuse the precomputed sum stored at this node.
        if (queryLeft <= left && right <= queryRight) {
            return this.tree[index];
        }

        // Partial overlap: ask both children and combine their contributions.
        const midPoint = Math.floor((left + right) / 2);
        return (
            this._query(2 * index, left, midPoint, queryLeft, queryRight) +
            this._query(2 * index + 1, midPoint + 1, right, queryLeft, queryRight)
        );

    }

    private _update(index: number, left: number, right: number, position: number, value: number) {
        // Update the leaf that represents the changed vector position.
        if(left === right) {
            this.tree[index] = value;
            return;
        }

        // Only one child contains the position; after updating it, rebuild this sum.
        const midPoint = Math.floor((left + right) / 2);
        if(position <= midPoint) {
            this._update(2 * index, left, midPoint, position, value);
        } else {
            this._update(2 * index + 1, midPoint + 1, right, position, value);
        }
        this.tree[index] = this.tree[2 * index] + this.tree[2 * index + 1];
    }
    // ##

    // Public methods ##
    public query(left: number, right: number): number {
        return this._query(1, 0, this.size - 1, left, right);
    }

    public update(position: number, value: number) {
        this._update(1, 0, this.size -1, position, value);
    }
    // ##

}
