// Exercise 7 — DOM Manipulation
const events = [
    { name: "Tech Meetup", seats: 5 },
    { name: "Baking 101",  seats: 0 },
];

const list = document.querySelector("#eventList");

events.forEach(ev => {
    const card = document.createElement("div");
    card.className = "card";
    card.innerHTML = `<h3>${ev.name}</h3><p>Seats: ${ev.seats}</p>`;

    const btn = document.createElement("button");
    btn.textContent = ev.seats > 0 ? "Register" : "Full";
    btn.disabled = ev.seats === 0;
    btn.onclick = () => {
        ev.seats--;
        card.querySelector("p").textContent = `Seats: ${ev.seats}`;
        if (ev.seats === 0) { btn.textContent = "Full"; btn.disabled = true; }
    };

    card.appendChild(btn);
    list.appendChild(card);
});
