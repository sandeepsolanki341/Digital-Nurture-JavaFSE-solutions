# HOL 02 - Class Components

**Duration:** 30 minutes

## Objective

Create multiple class components and render them in a React application.

## Topics Covered

- React components vs JavaScript functions
- Class components & Function components
- Component constructor & render()

## Exercise

Create a React app `StudentApp` for a Student Management Portal with three components:
- **Home** — displays "Welcome to the Home page of Student Management Portal"
- **About** — displays "Welcome to the About page of the Student Management Portal"
- **Contact** — displays "Welcome to the Contact page of the Student Management Portal"

## Steps

```bash
npx create-react-app StudentApp
cd StudentApp
```

### Solution

#### `src/Components/Home.js`

```jsx
import React, { Component } from 'react';

class Home extends Component {
  render() {
    return (
      <div>
        <h2>Welcome to the Home page of Student Management Portal</h2>
      </div>
    );
  }
}

export default Home;
```

#### `src/Components/About.js`

```jsx
import React, { Component } from 'react';

class About extends Component {
  render() {
    return (
      <div>
        <h2>Welcome to the About page of the Student Management Portal</h2>
      </div>
    );
  }
}

export default About;
```

#### `src/Components/Contact.js`

```jsx
import React, { Component } from 'react';

class Contact extends Component {
  render() {
    return (
      <div>
        <h2>Welcome to the Contact page of the Student Management Portal</h2>
      </div>
    );
  }
}

export default Contact;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';

class App extends Component {
  render() {
    return (
      <div>
        <Home />
        <About />
        <Contact />
      </div>
    );
  }
}

export default App;
```

```bash
npm start
```
