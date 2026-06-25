# Exercise 19 — Customizing Bootstrap with Sass

Override Bootstrap's Sass variables (colors, fonts, border-radius) and recompile.

## Build steps
```bash
npm install                # installs bootstrap + sass locally
npm run css                # compiles scss/custom.scss -> dist/custom.css
# or live-rebuild while editing:
npm run watch
```

Then open `index.html` — it links `dist/custom.css` (your compiled build), not the CDN.

## What to notice
- `$primary` is overridden **before** `@import "bootstrap"`, so every `.btn-primary`,
  `.bg-primary`, `.text-primary`, etc. picks up the new brand blue automatically.
- Custom rules (e.g. `.event-hero`) are added **after** the import so they can use
  Bootstrap's Sass functions like `lighten()`.
