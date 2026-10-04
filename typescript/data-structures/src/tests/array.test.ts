import { ArrayStructure } from "../array/array-structure";

describe("ArrayStructure", () => {
    it("inserts, finds, and removes values", () => {
        let array = new ArrayStructure(15);

        for (let value = 1; value <= 10; value++) {
            array.insert(value);
        }

        expect(array.size()).toBe(10);
        expect(array.find(5)).toBe(true);
        expect(array.find(99)).toBe(false);

        expect(array.remove(1)).toBe(true);
        expect(array.remove(6)).toBe(true);
        expect(array.remove(10)).toBe(true);
        expect(array.remove(99)).toBe(false);

        expect(array.size()).toBe(7);
        expect(array.items.slice(0, array.size())).toEqual([2, 3, 4, 5, 7, 8, 9]);
    });
});
