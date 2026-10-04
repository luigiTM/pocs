# Data Structures and Algorithms in TypeScript

This project implements fundamental data structures and sorting algorithms in TypeScript. It is an educational codebase for practicing classic computer science concepts with small, direct implementations.

## Data Structures

### Array

- Implemented by `ArrayStructure`
- Supports insertion, removal, search, display, and size tracking

### Ordered Array

- Implemented by `OrderedArray`
- Maintains values in sorted order as they are inserted
- Uses binary search for lookups

### Stack

- Implemented by `Stack`
- Classic LIFO data structure
- Supports `push`, `pop`, `peek`, `isEmpty`, and `isFull`

### Queue

- Implemented by `Queue`
- Classic FIFO data structure
- Supports `enqueue`, `dequeue`, `peekFront`, `isEmpty`, `isFull`, and `size`

### Linked List

- Implemented by `LinkedList`
- Singly linked list using the `Link` class for nodes
- Supports `insertFirst`, `deleteFirst`, `displayList`, and `isEmpty`

## Sorting Algorithms

### Bubble Sort

- Implemented by `BubbleSortArray`
- Repeatedly compares adjacent elements and swaps them when they are out of order
- Time complexity: O(n²)

### Selection Sort

- Implemented by `SelectionSortArray`
- Repeatedly selects the smallest item from the unsorted region
- Time complexity: O(n²)

### Insertion Sort

- Implemented by `InsertionSortArray`
- Builds the sorted array one item at a time
- Time complexity: O(n²)

## Project Structure

```text
src/
├── app.ts
├── array/
│   └── array-structure.ts
├── linked-list/
│   ├── link.ts
│   └── linked-list.ts
├── ordered-array/
│   └── ordered-array.ts
├── queue/
│   └── queue.ts
├── simple-sorting/
│   ├── bubble-sort/
│   │   └── bubble-sort-array.ts
│   ├── insertion-sort/
│   │   └── insertion-sort-array.ts
│   └── selection-sort/
│       └── selection-sort-array.ts
├── stack/
│   └── stack.ts
└── tests/
    ├── array.test.ts
    ├── linked-list.test.ts
    ├── ordered-array.test.ts
    ├── queue.test.ts
    ├── sorting.test.ts
    └── stack.test.ts
```

## Development

Install dependencies:

```bash
npm install
```

Build the project:

```bash
npm run build
```

Run the Jest test suite:

```bash
npm test
```

Run the application entry point:

```bash
npm start
```
