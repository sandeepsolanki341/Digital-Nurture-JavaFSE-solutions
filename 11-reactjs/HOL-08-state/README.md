# HOL 08 - React State

**Duration:** 60 minutes

## Objective

Use the React State object to manage and update component data.

## Exercise

Create a React app `counterapp` with a `CountPeople` component that tracks mall entry and exit counts using State. Two buttons — Login (increments entry count) and Exit (increments exit count).

## Steps

```bash
npx create-react-app counterapp
cd counterapp
```

### Solution

#### `src/CountPeople.js`

```jsx
import React, { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
    this.updateEntry = this.updateEntry.bind(this);
    this.updateExit = this.updateExit.bind(this);
  }

  updateEntry() {
    this.setState({ entrycount: this.state.entrycount + 1 });
  }

  updateExit() {
    this.setState({ exitcount: this.state.exitcount + 1 });
  }

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h2>Mall People Counter</h2>
        <p>People Entered: {this.state.entrycount}</p>
        <p>People Exited: {this.state.exitcount}</p>
        <button onClick={this.updateEntry} style={{ margin: '5px', padding: '10px 20px' }}>
          Login
        </button>
        <button onClick={this.updateExit} style={{ margin: '5px', padding: '10px 20px' }}>
          Exit
        </button>
      </div>
    );
  }
}

export default CountPeople;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import CountPeople from './CountPeople';

class App extends Component {
  render() {
    return (
      <div>
        <CountPeople />
      </div>
    );
  }
}

export default App;
```

```bash
npm start
```
