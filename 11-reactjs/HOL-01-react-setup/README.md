# HOL 01 - React Setup & First Application

**Duration:** 30 minutes

## Objective

Set up a React development environment and create your first React application.

## Topics Covered

- Single Page Application (SPA) and its benefits
- SPA vs MPA differences
- Virtual DOM
- create-react-app tool

## Exercise

Create a new React Application named `myfirstreact` that displays **"Welcome to the first session of React"** as a heading.

## Steps

```bash
# Install create-react-app and create the project
npx create-react-app myfirstreact

# Navigate into the project
cd myfirstreact
```

### Solution - `src/App.js`

```jsx
import React, { Component } from 'react';

class App extends Component {
  render() {
    return (
      <div>
        <h1>Welcome to the first session of React</h1>
      </div>
    );
  }
}

export default App;
```

```bash
# Run the application
npm start
# Open http://localhost:3000
```
