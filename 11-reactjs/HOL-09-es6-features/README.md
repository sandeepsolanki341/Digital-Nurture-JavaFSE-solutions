# HOL 09 - ES6 Features in React

**Duration:** 60 minutes

## Objective

Use ES6 features like `map()`, arrow functions, destructuring, and array merging in React.

## Topics Covered

- let, const, var differences
- ES6 classes and inheritance
- Arrow functions, map(), Set
- Destructuring and spread operator

## Exercise

Create a React app `cricketapp` with:
- **ListofPlayers** — array of 11 players with names & scores, filtered (score < 70) using arrow functions
- **IndianPlayers** — display odd/even team players using destructuring, merge T20 and Ranji arrays

Toggle between components using a flag variable.

## Steps

```bash
npx create-react-app cricketapp
cd cricketapp
```

### Solution

#### `src/ListofPlayers.js`

```jsx
import React, { Component } from 'react';

class ListofPlayers extends Component {
  render() {
    const players = [
      { name: 'Virat', score: 85 },
      { name: 'Rohit', score: 92 },
      { name: 'Dhawan', score: 65 },
      { name: 'Pant', score: 55 },
      { name: 'Rahul', score: 78 },
      { name: 'Jadeja', score: 42 },
      { name: 'Ashwin', score: 38 },
      { name: 'Bumrah', score: 15 },
      { name: 'Shami', score: 22 },
      { name: 'Siraj', score: 68 },
      { name: 'Gill', score: 88 }
    ];

    // Using map() to display all players
    const allPlayers = players.map((player, index) => (
      <li key={index}>{player.name} - Score: {player.score}</li>
    ));

    // Using arrow function to filter players with score below 70
    const lowScorers = players.filter(player => player.score < 70);

    return (
      <div>
        <h2>All Players</h2>
        <ul>{allPlayers}</ul>

        <h2>Players with Score Below 70</h2>
        <ul>
          {lowScorers.map((player, index) => (
            <li key={index}>{player.name} - Score: {player.score}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export default ListofPlayers;
```

#### `src/IndianPlayers.js`

```jsx
import React, { Component } from 'react';

class IndianPlayers extends Component {
  render() {
    const teamPlayers = ['Virat', 'Rohit', 'Dhawan', 'Pant', 'Rahul', 'Jadeja'];

    // Destructuring - Odd and Even index players
    const oddTeam = teamPlayers.filter((_, index) => index % 2 !== 0);
    const evenTeam = teamPlayers.filter((_, index) => index % 2 === 0);

    // Merging two arrays using spread operator
    const t20Players = ['Virat', 'Rohit', 'Pant'];
    const ranjiPlayers = ['Gill', 'Iyer', 'Sarfaraz'];
    const mergedPlayers = [...t20Players, ...ranjiPlayers];

    return (
      <div>
        <h2>Odd Index Players</h2>
        <ul>
          {oddTeam.map((p, i) => <li key={i}>{p}</li>)}
        </ul>

        <h2>Even Index Players</h2>
        <ul>
          {evenTeam.map((p, i) => <li key={i}>{p}</li>)}
        </ul>

        <h2>Merged T20 + Ranji Players</h2>
        <ul>
          {mergedPlayers.map((p, i) => <li key={i}>{p}</li>)}
        </ul>
      </div>
    );
  }
}

export default IndianPlayers;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { flag: true };
  }

  render() {
    return (
      <div>
        <h1>Cricket App</h1>
        <button onClick={() => this.setState({ flag: !this.state.flag })}>
          Toggle View
        </button>
        {this.state.flag ? <ListofPlayers /> : <IndianPlayers />}
      </div>
    );
  }
}

export default App;
```

```bash
npm start
```
