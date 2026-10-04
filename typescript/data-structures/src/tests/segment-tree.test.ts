import { SegmentTree } from "../segment-tree/segment-tree";

describe("SegmentTree", () => {
    let consoleSpy: jest.SpyInstance;

    beforeEach(() => {
        consoleSpy = jest.spyOn(console, "log").mockImplementation(() => {});
    });

    afterEach(() => {
        consoleSpy.mockRestore();
    });

    it("queries sums across full, partial, and single-value ranges", () => {
        let segmentTree = new SegmentTree([1, 3, 5, 7, 9, 11]);

        expect(segmentTree.query(0, 5)).toBe(36);
        expect(segmentTree.query(1, 3)).toBe(15);
        expect(segmentTree.query(2, 4)).toBe(21);
        expect(segmentTree.query(4, 4)).toBe(9);
    });

    it("updates a value and uses the new sums in later queries", () => {
        let segmentTree = new SegmentTree([2, 4, 6, 8]);

        expect(segmentTree.query(0, 3)).toBe(20);

        segmentTree.update(2, 10);

        expect(segmentTree.query(0, 3)).toBe(24);
        expect(segmentTree.query(1, 2)).toBe(14);
        expect(segmentTree.query(2, 2)).toBe(10);
    });
});
