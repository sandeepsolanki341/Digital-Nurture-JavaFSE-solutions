// Exercise 9 — Async JS, Promises, Async/Await
// Mock "API" that resolves after a delay
function fetchEvents() {
    return new Promise(resolve => {
        setTimeout(() => resolve([
            { name: "Tech Meetup" }, { name: "Baking 101" }, { name: "Jazz Night" }
        ]), 1000);
    });
}

// .then() / .catch() version
fetchEvents()
    .then(data => console.log("via .then():", data))
    .catch(err => console.error(err));

// async/await version with spinner
async function loadEvents() {
    const spinner = document.getElementById("spinner");
    const list = document.getElementById("events");
    try {
        const events = await fetchEvents();
        events.forEach(ev => {
            const li = document.createElement("li");
            li.textContent = ev.name;
            list.appendChild(li);
        });
    } catch (e) {
        list.textContent = "Failed to load events.";
    } finally {
        spinner.style.display = "none";
    }
}
loadEvents();
