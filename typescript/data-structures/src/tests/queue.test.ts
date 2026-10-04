import { Queue } from "../queue/queue";

describe("Queue", () => {
    it("enqueues and dequeues in FIFO order", () => {
        let queue = new Queue(10);

        expect(queue.isEmpty()).toBe(true);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        expect(queue.dequeue()).toBe(10);
        expect(queue.dequeue()).toBe(20);
        expect(queue.dequeue()).toBe(30);

        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);

        expect(queue.dequeue()).toBe(40);
        expect(queue.dequeue()).toBe(50);
        expect(queue.dequeue()).toBe(60);
        expect(queue.dequeue()).toBe(70);
        expect(queue.dequeue()).toBe(80);
        expect(queue.isEmpty()).toBe(true);
    });
});
