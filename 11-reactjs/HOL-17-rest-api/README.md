# HOL 17 - REST API Integration

**Duration:** 60 minutes

## Objective

Consume REST APIs from a React application using the Fetch API.

## Exercise

Create a React app `fetchuserapp` with a `Getuser` component that fetches user details from `https://api.randomuser.me/` and displays the title, first name, and image.

## Steps

```bash
npx create-react-app fetchuserapp
cd fetchuserapp
```

### Solution

#### `src/Getuser.js`

```jsx
import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null,
      loading: true
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch('https://api.randomuser.me/');
      const data = await response.json();
      this.setState({ user: data.results[0], loading: false });
    } catch (error) {
      console.error('Error fetching user:', error);
      this.setState({ loading: false });
    }
  }

  render() {
    const { user, loading } = this.state;

    if (loading) return <p>Loading...</p>;
    if (!user) return <p>Error loading user data.</p>;

    return (
      <div style={{ textAlign: 'center', padding: '20px' }}>
        <h2>Random User</h2>
        <img
          src={user.picture.large}
          alt={user.name.first}
          style={{ borderRadius: '50%', width: '150px', height: '150px' }}
        />
        <h3>{user.name.title}. {user.name.first} {user.name.last}</h3>
        <p>Email: {user.email}</p>
        <p>Location: {user.location.city}, {user.location.country}</p>
      </div>
    );
  }
}

export default Getuser;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import Getuser from './Getuser';

class App extends Component {
  render() {
    return <Getuser />;
  }
}

export default App;
```

```bash
npm start
```
