# HOL 07 - Props & ReactDOM.render()

**Duration:** 60 minutes

## Objective

Use Props to pass data between components and render using ReactDOM.

## Topics Covered

- Props and Default Props
- State vs Props differences
- ReactDOM.render()

## Exercise

Create a React app `shoppingapp` with class components `OnlineShopping` and `Cart`. Cart has `Itemname` and `Price` properties. OnlineShopping initializes 5 Cart items and displays them.

## Steps

```bash
npx create-react-app shoppingapp
cd shoppingapp
```

### Solution

#### `src/Cart.js`

```jsx
import React, { Component } from 'react';

class Cart extends Component {
  render() {
    return (
      <tr>
        <td>{this.props.itemname}</td>
        <td>₹{this.props.price}</td>
      </tr>
    );
  }
}

export default Cart;
```

#### `src/OnlineShopping.js`

```jsx
import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [
        { itemname: 'Laptop', price: 55000 },
        { itemname: 'Mobile', price: 25000 },
        { itemname: 'Headphones', price: 2000 },
        { itemname: 'Keyboard', price: 1500 },
        { itemname: 'Mouse', price: 800 }
      ]
    };
  }

  render() {
    return (
      <div>
        <h2>Online Shopping Cart</h2>
        <table border="1" cellPadding="10">
          <thead>
            <tr>
              <th>Item Name</th>
              <th>Price</th>
            </tr>
          </thead>
          <tbody>
            {this.state.items.map((item, index) => (
              <Cart key={index} itemname={item.itemname} price={item.price} />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import OnlineShopping from './OnlineShopping';

class App extends Component {
  render() {
    return (
      <div>
        <OnlineShopping />
      </div>
    );
  }
}

export default App;
```

```bash
npm start
```
