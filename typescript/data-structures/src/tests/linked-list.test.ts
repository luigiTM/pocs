import { LinkedList } from "../linked-list/linked-list";

describe("LinkedList", () => {
    it("inserts and deletes links from the front", () => {
        let linkedList = new LinkedList();

        expect(linkedList.isEmpty()).toBe(true);

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);

        expect(linkedList.deleteFirst()?.data).toBe(5);
        expect(linkedList.deleteFirst()?.data).toBe(4);
        expect(linkedList.deleteFirst()?.data).toBe(3);
        expect(linkedList.deleteFirst()?.data).toBe(2);
        expect(linkedList.deleteFirst()?.data).toBe(1);
        expect(linkedList.deleteFirst()).toBeUndefined();
        expect(linkedList.isEmpty()).toBe(true);
    });
});
