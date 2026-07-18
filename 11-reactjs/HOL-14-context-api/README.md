# HOL 14 - React Context API

**Duration:** 30 minutes

## Objective

Replace props drilling with React Context API for sharing data across nested components.

## Topics Covered

- createContext()
- Context Provider and Consumer
- Replacing props-based data sharing

## Exercise

Convert an employee management app from props-based theme passing to React Context API. The app supports light and dark themes for buttons, shared from App → EmployeesList → EmployeeCard.

## Steps

### Solution

#### `src/ThemeContext.js`

```jsx
import React from 'react';

const ThemeContext = React.createContext('light');

export default ThemeContext;
```

#### `src/EmployeeCard.js`

```jsx
import React, { Component } from 'react';
import ThemeContext from './ThemeContext';

class EmployeeCard extends Component {
  static contextType = ThemeContext;

  render() {
    const theme = this.context;
    const { employee } = this.props;
    const buttonStyle = {
      backgroundColor: theme === 'dark' ? '#333' : '#fff',
      color: theme === 'dark' ? '#fff' : '#333',
      border: '1px solid #ccc',
      padding: '5px 10px',
      cursor: 'pointer'
    };

    return (
      <div style={{ border: '1px solid #ccc', padding: '10px', margin: '10px', borderRadius: '8px' }}>
        <h3>{employee.name}</h3>
        <p>Role: {employee.role}</p>
        <button style={buttonStyle}>View Details</button>
      </div>
    );
  }
}

export default EmployeeCard;
```

#### `src/EmployeesList.js`

```jsx
import React, { Component } from 'react';
import EmployeeCard from './EmployeeCard';

class EmployeesList extends Component {
  render() {
    const { employees } = this.props;
    return (
      <div>
        <h2>Employees</h2>
        {employees.map((emp, index) => (
          <EmployeeCard key={index} employee={emp} />
        ))}
      </div>
    );
  }
}

export default EmployeesList;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      theme: 'light',
      employees: [
        { name: 'Alice', role: 'Developer' },
        { name: 'Bob', role: 'Designer' },
        { name: 'Charlie', role: 'Manager' }
      ]
    };
  }

  toggleTheme = () => {
    this.setState(prev => ({
      theme: prev.theme === 'light' ? 'dark' : 'light'
    }));
  }

  render() {
    return (
      <ThemeContext.Provider value={this.state.theme}>
        <div style={{ padding: '20px' }}>
          <h1>Employee Management</h1>
          <button onClick={this.toggleTheme}>
            Toggle Theme (Current: {this.state.theme})
          </button>
          <EmployeesList employees={this.state.employees} />
        </div>
      </ThemeContext.Provider>
    );
  }
}

export default App;
```

```bash
npm start
```
