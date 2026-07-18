# HOL 05 - CSS Modules & Inline Styles

**Duration:** 30 minutes

## Objective

Style React components using CSS Modules and inline styles.

## Topics Covered

- CSS Modules in React
- Inline styles with conditional logic
- className and style properties

## Exercise

Style a Cohort Dashboard application using CSS Modules. Create a `CohortDetails.module.css` with a `box` class and apply conditional inline styles (green for "ongoing" cohorts, blue otherwise).

## Steps

### Solution

#### `src/CohortDetails.module.css`

```css
.box {
  width: 300px;
  display: inline-block;
  margin: 10px;
  padding: 10px 20px;
  border: 1px solid black;
  border-radius: 10px;
}

dt {
  font-weight: 500;
}
```

#### `src/CohortDetails.js`

```jsx
import React, { Component } from 'react';
import styles from './CohortDetails.module.css';

class CohortDetails extends Component {
  render() {
    const { cohort } = this.props;
    const headingStyle = {
      color: cohort.status === 'ongoing' ? 'green' : 'blue'
    };

    return (
      <div className={styles.box}>
        <h3 style={headingStyle}>{cohort.name}</h3>
        <dl>
          <dt>Status</dt>
          <dd>{cohort.status}</dd>
          <dt>Trainer</dt>
          <dd>{cohort.trainer}</dd>
          <dt>Participants</dt>
          <dd>{cohort.participants}</dd>
        </dl>
      </div>
    );
  }
}

export default CohortDetails;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import CohortDetails from './CohortDetails';

class App extends Component {
  render() {
    const cohorts = [
      { name: 'GenC Cohort 1', status: 'completed', trainer: 'John', participants: 30 },
      { name: 'GenC Cohort 2', status: 'ongoing', trainer: 'Jane', participants: 25 },
      { name: 'GenC Cohort 3', status: 'ongoing', trainer: 'Smith', participants: 28 }
    ];

    return (
      <div>
        <h1>Cohort Dashboard</h1>
        {cohorts.map((cohort, index) => (
          <CohortDetails key={index} cohort={cohort} />
        ))}
      </div>
    );
  }
}

export default App;
```
