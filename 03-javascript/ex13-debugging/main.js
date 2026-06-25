// Exercise 13 — Debugging and Testing
// Use the Console + Network tabs and breakpoints to trace this submission.
document.getElementById("regForm").addEventListener("submit", (e) => {
    e.preventDefault();
    const email = e.target.elements.email.value;

    console.log("Step 1: form submitted");          // log each step
    console.log("Step 2: email =", email);

    const payload = { email };
    console.log("Step 3: payload built", payload);   // inspect payload before fetch

    // debugger;  // uncomment to pause execution here in DevTools

    fetch("https://jsonplaceholder.typicode.com/posts", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload),
    })
        .then(r => r.json())
        .then(d => console.log("Step 4: response", d))
        .catch(err => console.error("Fetch error:", err));
});
