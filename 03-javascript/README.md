# Module 03 — JavaScript

Theme: **Local Community Event Portal**. Fourteen exercises taking the portal from static markup
to a dynamic, interactive app — core language features, the DOM, events, async, ES6+, forms,
and fetch.

Each exercise has an `index.html` plus a `main.js`. Open the `index.html` in a browser and watch
the **Console** (F12) — several exercises log their output there.

## Exercises

| # | Folder | Focus |
|---|--------|-------|
| 01 | `ex01-basics-setup` | external script, `console.log`, load alert |
| 02 | `ex02-datatypes-operators` | `const`/`let`, template literals, `++`/`--` |
| 03 | `ex03-conditionals-loops` | `if/else`, `forEach`, `try/catch` |
| 04 | `ex04-functions-closures` | closures, higher-order functions, callbacks |
| 05 | `ex05-objects-prototypes` | class, prototype methods, `Object.entries` |
| 06 | `ex06-arrays-methods` | `push`, `filter`, `map` |
| 07 | `ex07-dom-manipulation` | `querySelector`, `createElement`, live UI updates |
| 08 | `ex08-event-handling` | `onclick`, `onchange`, `keydown` |
| 09 | `ex09-async-promises` | Promises, `.then/.catch`, `async/await`, spinner |
| 10 | `ex10-modern-es6` | default params, destructuring, spread |
| 11 | `ex11-forms` | `form.elements`, `preventDefault`, inline validation |
| 12 | `ex12-ajax-fetch` | `fetch` POST, `setTimeout` delay, success/failure |
| 13 | `ex13-debugging` | Console + Network debugging, breakpoints |
| 14 | `ex14-jquery` | jQuery click + `fadeIn/fadeOut`, note on frameworks |

## Notes

- **ex09** uses a mock `setTimeout`-based "API" — no network needed.
- **ex12 / ex13** POST to `jsonplaceholder.typicode.com` (a public fake REST API); needs network access.
- **ex14** loads jQuery 3.7 from a CDN.
- The framework benefit noted in ex14: React/Vue offer declarative, reactive, component-based UI,
  so the DOM updates automatically from state changes instead of manual `createElement` wiring.
