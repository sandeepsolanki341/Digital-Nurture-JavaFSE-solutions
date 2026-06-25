// Exercise 3 — Conditionals, Loops, Error Handling
const events = [
    { name: "Tech Meetup",  date: "2025-12-01", seats: 5  },
    { name: "Past Concert", date: "2024-01-01", seats: 10 },
    { name: "Full Workshop",date: "2025-12-10", seats: 0  },
];

const today = new Date();

events.forEach(ev => {
    const isUpcoming = new Date(ev.date) >= today;
    if (isUpcoming && ev.seats > 0) {
        console.log(`Available: ${ev.name} (${ev.seats} seats)`);
    } else {
        console.log(`Hidden: ${ev.name} (past or full)`);
    }
});

// Registration with error handling
function register(ev) {
    try {
        if (ev.seats <= 0) throw new Error(`${ev.name} is full`);
        ev.seats--;
        console.log(`Registered for ${ev.name}`);
    } catch (e) {
        console.error("Registration failed:", e.message);
    }
}
register(events[2]); // full -> throws
