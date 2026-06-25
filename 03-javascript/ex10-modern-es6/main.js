// Exercise 10 — Modern JavaScript Features
// Default parameters
function createEvent(name, seats = 20) {
    return { name, seats };
}

const events = [createEvent("Meetup"), createEvent("Workshop", 5)];

// Destructuring
const [{ name: firstName }] = events;
console.log("First event:", firstName);

const { seats } = events[1];
console.log("Workshop seats:", seats);

// Spread — clone before filtering (no mutation)
const clone = [...events];
const small = clone.filter(e => e.seats < 10);
console.log("Small events:", small);
console.log("Original untouched:", events.length === 2);
