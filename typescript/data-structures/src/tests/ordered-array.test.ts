import { OrderedArray } from "../ordered-array/ordered-array";

describe("OrderedArray", () => {
    it("keeps values sorted while inserting and removing", () => {
        let orderedArray = new OrderedArray(100);

        [77, 99, 44, 55, 22, 88, 11, 0, 66, 33].forEach((value) => orderedArray.insert(value));

        expect(orderedArray.items.slice(0, orderedArray.size())).toEqual([0, 11, 22, 33, 44, 55, 66, 77, 88, 99]);
        expect(orderedArray.find(44)).toBe(4);
        expect(orderedArray.find(100)).toBe(-1);

        expect(orderedArray.remove(0)).toBe(true);
        expect(orderedArray.remove(55)).toBe(true);
        expect(orderedArray.remove(99)).toBe(true);
        expect(orderedArray.remove(100)).toBe(false);

        expect(orderedArray.items.slice(0, orderedArray.size())).toEqual([11, 22, 33, 44, 66, 77, 88]);
    });
});
