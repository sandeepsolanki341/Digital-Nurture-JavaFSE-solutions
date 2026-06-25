// Exercise 2 — Syntax, Data Types, Operators
const eventName = "Tech Innovators Meetup";
const eventDate = "2025-06-10";
let availableSeats = 50;

// Template literal
console.log(`${eventName} on ${eventDate} — seats left: ${availableSeats}`);

// Register one attendee
availableSeats--;
console.log(`After registration: ${availableSeats} seats left`);
