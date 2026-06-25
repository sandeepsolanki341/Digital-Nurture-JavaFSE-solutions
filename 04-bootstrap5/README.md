# Module 04 — Bootstrap 5

Theme: **Restyling the Local Community Event Portal with Bootstrap 5**. Nineteen exercises covering
the grid, components, utilities, JavaScript plugins, and Sass customization.

Exercises 01–18 load Bootstrap **5.3.3** from the jsDelivr CDN — just open each `index.html`.
Exercise 19 is a Sass build (Node required); see its own README.

## Exercises

| # | Folder | Focus |
|---|--------|-------|
| 01 | `ex01-setup` | linking the CSS + bundle JS via CDN |
| 02 | `ex02-structure-files` | dist folder structure, bundle (Popper) + tooltip init |
| 03 | `ex03-responsive-grid` | `container`/`row`/`col`, responsive breakpoints |
| 04 | `ex04-column-layouts` | sidebar + content, equal columns |
| 05 | `ex05-alignment-reorder` | `justify-content`, `align-items`, `order-*` |
| 06 | `ex06-flexbox-utilities` | `d-flex`, direction, `justify-content-between` |
| 07 | `ex07-typography` | `display-*`, `lead`, `text-muted`, weight/transform |
| 08 | `ex08-forms` | `form-control`, `form-select`, `form-check`, grid form |
| 09 | `ex09-buttons` | variants, sizes, `btn-group`, outline |
| 10 | `ex10-navbars` | responsive `navbar`, collapse toggle, search form |
| 11 | `ex11-cards-media` | `card`, `card-img-top`, footer, responsive card grid |
| 12 | `ex12-spacing` | margin/padding utilities (`m-*`, `p-*`, `mx-auto`) |
| 13 | `ex13-colors-backgrounds` | `text-*`, `bg-*`, alerts, badges |
| 14 | `ex14-display-visibility` | responsive `d-none`/`d-*-block`, `d-inline` |
| 15 | `ex15-borders-shadows` | `border-*`, `rounded-*`, `shadow-*` |
| 16 | `ex16-positioning` | `position-absolute`, `top/start`, `translate-middle` |
| 17 | `ex17-icons` | Bootstrap Icons in buttons and text |
| 18 | `ex18-js-plugins` | modal + accordion (require the bundle JS) |
| 19 | `ex19-sass-customization` | override Sass variables, recompile — **build step** |

## Notes

- **ex02 / ex18** depend on `bootstrap.bundle.min.js` (modal, accordion, tooltips). The bundle
  includes Popper, so no separate Popper script is needed.
- **ex11 / ex17** pull placeholder images / the Bootstrap Icons CDN; need network access.
- **ex19** is the only exercise with a build step:
  ```bash
  cd ex19-sass-customization && npm install && npm run css
  ```
  It compiles `scss/custom.scss` → `dist/custom.css`, demonstrating brand-color overrides applied
  before `@import "bootstrap"`.
