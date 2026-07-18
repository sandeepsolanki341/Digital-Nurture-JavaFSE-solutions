# HOL 10 - JSX & Inline CSS

**Duration:** 60 minutes

## Objective

Use JSX syntax and inline CSS to create elements, attributes, and render DOM.

## Topics Covered

- JSX syntax and ECMA Script
- React.createElement()
- Inline CSS in JSX
- Conditional styling

## Exercise

Create a React app `officespacerentalapp` that displays office space listings. Show heading, image, and office details (Name, Rent, Address). Display Rent in **red** if below ₹60,000 and **green** if above.

## Steps

```bash
npx create-react-app officespacerentalapp
cd officespacerentalapp
```

### Solution

#### `src/App.js`

```jsx
import React, { Component } from 'react';

class App extends Component {
  render() {
    const offices = [
      { name: 'TechPark Tower', rent: 55000, address: 'Whitefield, Bangalore' },
      { name: 'Innovation Hub', rent: 75000, address: 'Hinjewadi, Pune' },
      { name: 'Startup Loft', rent: 45000, address: 'Koramangala, Bangalore' },
      { name: 'Corporate Center', rent: 85000, address: 'BKC, Mumbai' }
    ];

    return (
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1 style={{ textAlign: 'center' }}>Office Space Rental</h1>
        <img
          src="https://via.placeholder.com/600x200?text=Office+Space"
          alt="Office Space"
          style={{ display: 'block', margin: '0 auto 20px', width: '600px' }}
        />
        {offices.map((office, index) => (
          <div key={index} style={{ border: '1px solid #ccc', padding: '15px', margin: '10px', borderRadius: '8px' }}>
            <h3>{office.name}</h3>
            <p style={{ color: office.rent < 60000 ? 'red' : 'green', fontWeight: 'bold' }}>
              Rent: ₹{office.rent}
            </p>
            <p>Address: {office.address}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default App;
```

```bash
npm start
```
