// Exercise 14 — jQuery and JS Frameworks
$(function () {
    $('#registerBtn').click(function () {
        const card = $('#eventCard');
        card.is(':visible') ? card.fadeOut() : card.fadeIn();
    });
});

// Benefit of frameworks like React/Vue:
// They provide declarative, component-based UI with reactive state, so the DOM updates
// automatically when data changes — eliminating manual, error-prone DOM manipulation.
