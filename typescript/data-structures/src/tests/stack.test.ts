import { Stack } from "../stack/stack";

describe("Stack", () => {
    it("pushes, peeks, and pops in LIFO order", () => {
        let stack = new Stack(10);

        expect(stack.isEmpty()).toBe(true);

        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);

        expect(stack.peek()).toBe(80);
        expect(stack.pop()).toBe(80);
        expect(stack.pop()).toBe(60);
        expect(stack.pop()).toBe(40);
        expect(stack.pop()).toBe(20);
        expect(stack.isEmpty()).toBe(true);
    });
});
