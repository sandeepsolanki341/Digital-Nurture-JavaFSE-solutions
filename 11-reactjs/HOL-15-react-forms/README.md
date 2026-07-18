# HOL 15 - React Forms

**Duration:** 60 minutes

## Objective

Implement React forms with controlled components and form submission.

## Topics Covered

- Controlled components
- Input controls (textbox, button, textarea)
- Handling form submission

## Exercise

Create a React app `ticketraisingapp` with a `ComplaintRegister` component. Form has a textbox for employee name, textarea for complaint, and a submit button that generates a reference number via alert.

## Steps

```bash
npx create-react-app ticketraisingapp
cd ticketraisingapp
```

### Solution

#### `src/ComplaintRegister.js`

```jsx
import React, { Component } from 'react';

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employeeName: '',
      complaint: ''
    };
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(e) {
    e.preventDefault();
    const refNumber = 'REF-' + Math.floor(Math.random() * 100000);
    alert(
      `Complaint Registered!\n` +
      `Employee: ${this.state.employeeName}\n` +
      `Reference Number: ${refNumber}`
    );
    this.setState({ employeeName: '', complaint: '' });
  }

  render() {
    return (
      <div style={{ padding: '20px', maxWidth: '500px', margin: '0 auto' }}>
        <h2>Complaint Register</h2>
        <form onSubmit={this.handleSubmit}>
          <div style={{ marginBottom: '15px' }}>
            <label>Employee Name:</label><br />
            <input
              type="text"
              value={this.state.employeeName}
              onChange={(e) => this.setState({ employeeName: e.target.value })}
              style={{ width: '100%', padding: '8px' }}
            />
          </div>
          <div style={{ marginBottom: '15px' }}>
            <label>Complaint:</label><br />
            <textarea
              value={this.state.complaint}
              onChange={(e) => this.setState({ complaint: e.target.value })}
              rows="5"
              style={{ width: '100%', padding: '8px' }}
            />
          </div>
          <button type="submit" style={{ padding: '10px 20px' }}>
            Submit Complaint
          </button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import ComplaintRegister from './ComplaintRegister';

class App extends Component {
  render() {
    return (
      <div>
        <ComplaintRegister />
      </div>
    );
  }
}

export default App;
```

```bash
npm start
```
