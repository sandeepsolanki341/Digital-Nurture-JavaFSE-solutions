// Exercise 6 — Arrays and Methods
let events = [
    { name: "Jazz Night", category: "music" },
    { name: "Baking 101", category: "workshop" },
];

// push
events.push({ name: "Rock Show", category: "music" });

// filter
const music = events.filter(e => e.category === "music");
console.log("Music events:", music);

// map -> display strings
const cards = events.map(e => `${e.name} (${e.category})`);
console.log(cards);
