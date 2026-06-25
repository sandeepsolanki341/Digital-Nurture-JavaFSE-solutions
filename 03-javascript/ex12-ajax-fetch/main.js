// Exercise 12 — AJAX & Fetch API
// Posts to a public mock endpoint (jsonplaceholder) to simulate a backend.
document.getElementById("submitBtn").onclick = async () => {
    const status = document.getElementById("status");
    status.textContent = "Submitting…";

    const payload = { user: "Alice", event: "Tech Meetup" };

    // Simulate a delayed response
    setTimeout(async () => {
        try {
            const res = await fetch("https://jsonplaceholder.typicode.com/posts", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(payload),
            });
            if (!res.ok) throw new Error("HTTP " + res.status);
            const data = await res.json();
            status.textContent = `Success! Server assigned id ${data.id}`;
        } catch (err) {
            status.textContent = "Failed: " + err.message;
        }
    }, 800);
};
