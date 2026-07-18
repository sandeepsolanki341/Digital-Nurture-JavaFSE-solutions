# HOL 12 - Conditional Rendering

**Duration:** 60 minutes

## Objective

Implement conditional rendering to show different UI based on application state.

## Topics Covered

- Conditional rendering techniques
- Element variables
- Preventing component rendering

## Exercise

Create a React app `ticketbookingapp` where a guest user can browse flight details but only a logged-in user can book tickets. Login/Logout buttons toggle between User and Guest pages.

## Steps

```bash
npx create-react-app ticketbookingapp
cd ticketbookingapp
```

### Solution

#### `src/GuestPage.js`

```jsx
import React from 'react';

function GuestPage() {
  return (
    <div>
      <h2>Welcome, Guest!</h2>
      <p>Browse available flights below. Please login to book tickets.</p>
      <ul>
        <li>Flight AI-101 — Delhi to Mumbai — ₹4,500</li>
        <li>Flight AI-202 — Bangalore to Chennai — ₹3,200</li>
        <li>Flight AI-303 — Pune to Kolkata — ₹5,800</li>
      </ul>
    </div>
  );
}

export default GuestPage;
```

#### `src/UserPage.js`

```jsx
import React from 'react';

function UserPage() {
  return (
    <div>
      <h2>Welcome, User!</h2>
      <p>You can now book your tickets.</p>
      <button>Book AI-101 (Delhi → Mumbai)</button><br /><br />
      <button>Book AI-202 (Bangalore → Chennai)</button><br /><br />
      <button>Book AI-303 (Pune → Kolkata)</button>
    </div>
  );
}

export default UserPage;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { isLoggedIn: false };
  }

  render() {
    const { isLoggedIn } = this.state;
    let button, page;

    if (isLoggedIn) {
      button = <button onClick={() => this.setState({ isLoggedIn: false })}>Logout</button>;
      page = <UserPage />;
    } else {
      button = <button onClick={() => this.setState({ isLoggedIn: true })}>Login</button>;
      page = <GuestPage />;
    }

    return (
      <div style={{ padding: '20px' }}>
        <h1>Ticket Booking App</h1>
        {button}
        <hr />
        {page}
      </div>
    );
  }
}

export default App;
```

```bash
npm start
```
