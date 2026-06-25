// Exercise 8 — Event Handling
const out = document.getElementById("output");

document.getElementById("registerBtn").onclick = () => {
    out.textContent = "Registered!";
};

document.getElementById("category").onchange = (e) => {
    out.textContent = "Filtering by: " + e.target.value;
};

document.getElementById("search").addEventListener("keydown", (e) => {
    out.textContent = `Searching: ${e.target.value}${e.key.length === 1 ? e.key : ""}`;
});
