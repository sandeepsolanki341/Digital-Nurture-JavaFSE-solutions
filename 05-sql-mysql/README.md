# Module 05 — ANSI SQL Using MySQL

Theme: **Local Community Event Portal**. Six related tables — users, events, sessions,
registrations, feedback, resources — exercised through 25 analytical queries.

## Setup

```bash
mysql -u root -p < schema.sql     # creates the event_portal database + tables
mysql -u root -p < seed.sql       # loads the sample dataset
```

Run any solution:

```bash
mysql -u root -p event_portal < solutions/q01-user-upcoming-events.sql
```

## Schema overview

| Table | Key columns | Notes |
|-------|-------------|-------|
| `users` | user_id (PK), email (UNIQUE) | residents of the portal |
| `events` | event_id (PK), organizer_id → users | status: upcoming / completed / cancelled |
| `sessions` | session_id (PK), event_id → events | talks within an event |
| `registrations` | registration_id (PK), user_id, event_id | user ↔ event sign-ups |
| `feedback` | feedback_id (PK), rating CHECK 1–5 | post-event ratings |
| `resources` | resource_id (PK), resource_type ENUM | pdf / image / link |

## Exercises

| # | Title | Concepts |
|---|-------|----------|
| 01 | User Upcoming Events | JOIN, filter, correlated city match, ORDER BY |
| 02 | Top Rated Events | GROUP BY, AVG, HAVING COUNT ≥ 10 |
| 03 | Inactive Users | NOT IN subquery, date interval |
| 04 | Peak Session Hours | TIME(), BETWEEN, GROUP BY |
| 05 | Most Active Cities | COUNT DISTINCT, LIMIT |
| 06 | Event Resource Summary | conditional SUM pivot |
| 07 | Low Feedback Alerts | multi-table JOIN, filter |
| 08 | Sessions per Upcoming Event | LEFT JOIN, COUNT |
| 09 | Organizer Event Summary | conditional aggregation by status |
| 10 | Feedback Gap | registrations present, NOT IN feedback |
| 11 | Daily New User Count | date grouping, last 7 days |
| 12 | Event with Maximum Sessions | subquery for MAX, ties included |
| 13 | Average Rating per City | AVG grouped by event city |
| 14 | Most Registered Events | COUNT, ORDER, LIMIT 3 |
| 15 | Event Session Time Conflict | self-join overlap detection |
| 16 | Unregistered Active Users | NOT EXISTS, recent accounts |
| 17 | Multi-Session Speakers | GROUP BY HAVING > 1 |
| 18 | Resource Availability Check | LEFT JOIN … IS NULL |
| 19 | Completed Events Feedback Summary | LEFT JOINs, AVG |
| 20 | User Engagement Index | dual COUNT DISTINCT |
| 21 | Top Feedback Providers | COUNT, LIMIT 5 |
| 22 | Duplicate Registrations Check | GROUP BY HAVING COUNT > 1 |
| 23 | Registration Trends | DATE_FORMAT month bucketing |
| 24 | Average Session Duration | TIMESTAMPDIFF minutes |
| 25 | Events Without Sessions | LEFT JOIN … IS NULL |

## A note on the sample data

The seed dataset is intentionally tiny (5 users, 3 events, 3 feedbacks). A few exercises specify
thresholds the seed data cannot meet — e.g. **Q2** requires events with **≥ 10 feedback submissions**,
which none have, so it correctly returns zero rows. The queries are written to satisfy the stated
requirement against the schema, not hard-coded to the small dataset. To see richer output, insert
additional rows.
