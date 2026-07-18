# HOL 16 - React Form Validation

**Duration:** 60 minutes

## Objective

Implement form validation in React using event handlers.

## Topics Covered

- Form validation in React
- Controlled components with validation
- Event-driven validation

## Exercise

Create a React app `mailregisterapp` with a `Register` component. Validate:
- **Name** — at least 5 characters
- **Email** — must contain `@` and `.`
- **Password** — at least 8 characters

## Steps

```bash
npx create-react-app mailregisterapp
cd mailregisterapp
```

### Solution

#### `src/Register.js`

```jsx
import React, { Component } from 'react';

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      email: '',
      password: '',
      errors: { name: '', email: '', password: '' }
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  validate() {
    const { name, email, password } = this.state;
    let errors = { name: '', email: '', password: '' };
    let isValid = true;

    if (name.length < 5) {
      errors.name = 'Name must be at least 5 characters';
      isValid = false;
    }
    if (!email.includes('@') || !email.includes('.')) {
      errors.email = 'Email must contain @ and .';
      isValid = false;
    }
    if (password.length < 8) {
      errors.password = 'Password must be at least 8 characters';
      isValid = false;
    }

    this.setState({ errors });
    return isValid;
  }

  handleChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  handleSubmit(e) {
    e.preventDefault();
    if (this.validate()) {
      alert('Registration Successful!');
      this.setState({ name: '', email: '', password: '', errors: { name: '', email: '', password: '' } });
    }
  }

  render() {
    const { errors } = this.state;
    const errorStyle = { color: 'red', fontSize: '12px' };

    return (
      <div style={{ padding: '20px', maxWidth: '400px', margin: '0 auto' }}>
        <h2>Mail Registration</h2>
        <form onSubmit={this.handleSubmit}>
          <div style={{ marginBottom: '15px' }}>
            <label>Name:</label><br />
            <input type="text" name="name" value={this.state.name} onChange={this.handleChange} style={{ width: '100%', padding: '8px' }} />
            {errors.name && <span style={errorStyle}>{errors.name}</span>}
          </div>
          <div style={{ marginBottom: '15px' }}>
            <label>Email:</label><br />
            <input type="text" name="email" value={this.state.email} onChange={this.handleChange} style={{ width: '100%', padding: '8px' }} />
            {errors.email && <span style={errorStyle}>{errors.email}</span>}
          </div>
          <div style={{ marginBottom: '15px' }}>
            <label>Password:</label><br />
            <input type="password" name="password" value={this.state.password} onChange={this.handleChange} style={{ width: '100%', padding: '8px' }} />
            {errors.password && <span style={errorStyle}>{errors.password}</span>}
          </div>
          <button type="submit" style={{ padding: '10px 20px' }}>Register</button>
        </form>
      </div>
    );
  }
}

export default Register;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import Register from './Register';

class App extends Component {
  render() {
    return <Register />;
  }
}

export default App;
```

```bash
npm start
```
