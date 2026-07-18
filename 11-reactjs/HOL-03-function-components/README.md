# HOL 03 - Function Components & Styling

**Duration:** 30 minutes

## Objective

Create a function component with props and apply CSS styles.

## Topics Covered

- Function components
- Props in function components
- External CSS styling

## Exercise

Create a React app `scorecalculatorapp` with a function component `CalculateScore` that accepts Name, School, Total, and Goal to calculate and display a student's average score.

## Steps

```bash
npx create-react-app scorecalculatorapp
cd scorecalculatorapp
```

### Solution

#### `src/Components/CalculateScore.js`

```jsx
import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore(props) {
  const average = props.total / props.goal;

  return (
    <div className="score-card">
      <h2>Student Score Calculator</h2>
      <p><strong>Name:</strong> {props.name}</p>
      <p><strong>School:</strong> {props.school}</p>
      <p><strong>Total:</strong> {props.total}</p>
      <p><strong>Goal:</strong> {props.goal}</p>
      <p><strong>Average Score:</strong> {average.toFixed(2)}</p>
    </div>
  );
}

export default CalculateScore;
```

#### `src/Stylesheets/mystyle.css`

```css
.score-card {
  width: 400px;
  margin: 20px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
  font-family: Arial, sans-serif;
  box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
}

.score-card h2 {
  color: #333;
  text-align: center;
}
```

#### `src/App.js`

```jsx
import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore name="Sandeep" school="VIT Bhopal" total={450} goal={6} />
    </div>
  );
}

export default App;
```

```bash
npm start
```
