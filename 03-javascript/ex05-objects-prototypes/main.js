// Exercise 5 — Objects and Prototypes
class Event {
    constructor(name, seats) {
        this.name = name;
        this.seats = seats;
    }
}
// Method on the prototype
Event.prototype.checkAvailability = function () {
    return this.seats > 0 ? `${this.name}: ${this.seats} seats` : `${this.name}: full`;
};

const e = new Event("Tech Meetup", 3);
console.log(e.checkAvailability());

// Object.entries
console.log(Object.entries(e));
