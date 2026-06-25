// Exercise 11 — Working with Forms
const form = document.getElementById("signup");

form.addEventListener("submit", (e) => {
    e.preventDefault();                      // prevent default submission
    const { name, email, event } = form.elements;

    let valid = true;
    document.getElementById("nameErr").textContent = "";
    document.getElementById("emailErr").textContent = "";

    if (!name.value.trim()) {
        document.getElementById("nameErr").textContent = "Name is required";
        valid = false;
    }
    if (!/^[^@]+@[^@]+\.[^@]+$/.test(email.value)) {
        document.getElementById("emailErr").textContent = "Invalid email";
        valid = false;
    }
    if (valid) {
        document.getElementById("result").textContent =
            `Signed up ${name.value} for ${event.value}`;
        form.reset();
    }
});
