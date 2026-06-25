// Exercise 4 — Functions, Scope, Closures, Higher-Order Functions
let events = [];

function addEvent(name, category) {
    events.push({ name, category });
}

function registerUser(name) {
    console.log(`${name} registered`);
}

// Closure: track registrations per category
function categoryCounter() {
    const counts = {};
    return function (category) {
        counts[category] = (counts[category] || 0) + 1;
        return counts[category];
    };
}

// Higher-order: pass a callback predicate
function filterEvents(list, predicate) {
    return list.filter(predicate);
}

addEvent("Jazz Night", "music");
addEvent("Baking 101", "workshop");
addEvent("Rock Show", "music");

const tally = categoryCounter();
console.log("music count:", tally("music"));
console.log("music count:", tally("music"));

const music = filterEvents(events, e => e.category === "music");
console.log("Music events:", music);
