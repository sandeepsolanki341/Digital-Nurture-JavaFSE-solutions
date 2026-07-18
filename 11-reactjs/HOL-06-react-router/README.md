# HOL 06 - React Router & Navigation

**Duration:** 60 minutes

## Objective

Implement client-side routing and navigation using React Router.

## Topics Covered

- React Router components (BrowserRouter, Route, Link)
- Navigation menu
- URL parameter passing

## Exercise

Create a React app `TrainersApp` to maintain a list of trainers with T-ID, Name, Phone, Email, Stream, and Skills. Implement navigation using React Router.

## Steps

```bash
npx create-react-app TrainersApp
cd TrainersApp
npm install react-router-dom
```

### Solution

#### `src/trainer.js`

```jsx
class Trainer {
  constructor(trainerId, name, email, phone, stream, skills) {
    this.trainerId = trainerId;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.stream = stream;
    this.skills = skills;
  }
}

export default Trainer;
```

#### `src/Components/TrainerList.js`

```jsx
import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class TrainerList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      trainers: [
        { trainerId: 'T001', name: 'John', email: 'john@mail.com', phone: '1234567890', stream: 'Java', skills: 'Spring Boot, Hibernate' },
        { trainerId: 'T002', name: 'Jane', email: 'jane@mail.com', phone: '0987654321', stream: 'React', skills: 'React, Redux, Node.js' },
        { trainerId: 'T003', name: 'Smith', email: 'smith@mail.com', phone: '1122334455', stream: 'Python', skills: 'Django, Flask, ML' }
      ]
    };
  }

  render() {
    return (
      <div>
        <h2>Trainer List</h2>
        <table border="1" cellPadding="10">
          <thead>
            <tr>
              <th>T-ID</th><th>Name</th><th>Email</th><th>Stream</th><th>Details</th>
            </tr>
          </thead>
          <tbody>
            {this.state.trainers.map(t => (
              <tr key={t.trainerId}>
                <td>{t.trainerId}</td>
                <td>{t.name}</td>
                <td>{t.email}</td>
                <td>{t.stream}</td>
                <td><Link to={`/trainer/${t.trainerId}`}>View</Link></td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default TrainerList;
```

#### `src/Components/Home.js`

```jsx
import React from 'react';

function Home() {
  return <h2>Welcome to Trainers App</h2>;
}

export default Home;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import Home from './Components/Home';
import TrainerList from './Components/TrainerList';

class App extends Component {
  render() {
    return (
      <Router>
        <div>
          <nav>
            <Link to="/">Home</Link> | <Link to="/trainers">Trainers</Link>
          </nav>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/trainers" element={<TrainerList />} />
          </Routes>
        </div>
      </Router>
    );
  }
}

export default App;
```

```bash
npm start
```
