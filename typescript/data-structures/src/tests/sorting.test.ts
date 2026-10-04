import { BubbleSortArray } from "../simple-sorting/bubble-sort/bubble-sort-array";
import { InsertionSortArray } from "../simple-sorting/insertion-sort/insertion-sort-array";
import { SelectionSortArray } from "../simple-sorting/selection-sort/selection-sort-array";

const values = [77, 99, 44, 55, 22, 88, 11, 0, 66, 33];
const sortedValues = [0, 11, 22, 33, 44, 55, 66, 77, 88, 99];

describe("Sorting arrays", () => {
    it("sorts using bubble sort", () => {
        let bubbleSortArray = new BubbleSortArray(100);
        insertValues(bubbleSortArray);

        bubbleSortArray.bubbleSort();

        expect(bubbleSortArray.items.slice(0, bubbleSortArray.count)).toEqual(sortedValues);
    });

    it("sorts using insertion sort", () => {
        let insertionSortArray = new InsertionSortArray(100);
        insertValues(insertionSortArray);

        insertionSortArray.insertionSort();

        expect(insertionSortArray.items.slice(0, insertionSortArray.count)).toEqual(sortedValues);
    });

    it("sorts using selection sort", () => {
        let selectionSortArray = new SelectionSortArray(100);
        insertValues(selectionSortArray);

        selectionSortArray.selectionSort();

        expect(selectionSortArray.items.slice(0, selectionSortArray.count)).toEqual(sortedValues);
    });
});

function insertValues(array: { insert(value: number): void }) {
    values.forEach((value) => array.insert(value));
}
