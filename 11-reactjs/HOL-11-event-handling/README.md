# HOL 11 - Event Handling

**Duration:** 90 minutes

## Objective

Implement various event handling patterns in React applications.

## Topics Covered

- React events and event handlers
- Synthetic events
- Event naming conventions
- Passing arguments to event handlers

## Exercise

Create a React app `eventexamplesapp` with:
1. **Increment/Decrement counter** — Increase button invokes multiple methods (increment + say hello)
2. **"Say Welcome" button** — passes "welcome" as an argument to a function
3. **Synthetic event button** — displays "I was clicked" using `onPress`
4. **CurrencyConvertor component** — converts Indian Rupees to Euro on button click

## Steps

```bash
npx create-react-app eventexamplesapp
cd eventexamplesapp
```

### Solution

#### `src/EventExamples.js`

```jsx
import React, { Component } from 'react';

class EventExamples extends Component {
  constructor(props) {
    super(props);
    this.state = { counter: 0 };
    this.increment = this.increment.bind(this);
    this.decrement = this.decrement.bind(this);
  }

  increment() {
    this.setState({ counter: this.state.counter + 1 });
    this.sayHello();
  }

  decrement() {
    this.setState({ counter: this.state.counter - 1 });
  }

  sayHello() {
    console.log('Hello! The counter was incremented.');
  }

  sayMessage(msg) {
    alert(msg);
  }

  handlePress(e) {
    alert('I was clicked');
  }

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h2>Event Examples</h2>

        <h3>Counter: {this.state.counter}</h3>
        <button onClick={this.increment}>Increment</button>{' '}
        <button onClick={this.decrement}>Decrement</button>

        <br /><br />
        <button onClick={() => this.sayMessage('Welcome')}>Say Welcome</button>

        <br /><br />
        <button onClick={(e) => this.handlePress(e)}>Synthetic Event</button>
      </div>
    );
  }
}

export default EventExamples;
```

#### `src/CurrencyConvertor.js`

```jsx
import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euro: 0
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(e) {
    this.setState({ rupees: e.target.value });
  }

  handleSubmit() {
    const euroRate = 0.011; // 1 INR ≈ 0.011 EUR
    const result = (parseFloat(this.state.rupees) * euroRate).toFixed(2);
    this.setState({ euro: result });
  }

  render() {
    return (
      <div style={{ padding: '20px', border: '1px solid #ccc', margin: '20px', borderRadius: '8px' }}>
        <h2>Currency Convertor (INR to EUR)</h2>
        <input
          type="number"
          placeholder="Enter amount in Rupees"
          value={this.state.rupees}
          onChange={this.handleChange}
        />
        <button onClick={this.handleSubmit} style={{ marginLeft: '10px' }}>Convert</button>
        <p><strong>Euro: €{this.state.euro}</strong></p>
      </div>
    );
  }
}

export default CurrencyConvertor;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import EventExamples from './EventExamples';
import CurrencyConvertor from './CurrencyConvertor';

class App extends Component {
  render() {
    return (
      <div>
        <EventExamples />
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
```

```bash
npm start
```
