# HOL 19 - Mocking & Isolation Testing

**Duration:** 60 minutes

## Objective

Unit test modules in isolation using Jest mocks and spies.

## Topics Covered

- Isolation in testing
- Mocking with Jest
- Spies and mock implementations

## Exercise

Create a React app `gitclientapp` that fetches GitHub repositories for a user. Write unit tests with mocked axios calls.

## Steps

```bash
npx create-react-app gitclientapp
cd gitclientapp
npm install axios
```

### Solution

#### `src/GitClient.js`

```jsx
import axios from 'axios';

class GitClient {
  static async getRepos(username) {
    const response = await axios.get(`https://api.github.com/users/${username}/repos`);
    return response.data.map(repo => repo.name);
  }
}

export default GitClient;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import GitClient from './GitClient';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { repos: [], loading: true };
  }

  async componentDidMount() {
    try {
      const repos = await GitClient.getRepos('sandeepsolanki341');
      this.setState({ repos, loading: false });
    } catch (error) {
      console.error('Error:', error);
      this.setState({ loading: false });
    }
  }

  render() {
    const { repos, loading } = this.state;
    if (loading) return <p>Loading...</p>;

    return (
      <div style={{ padding: '20px' }}>
        <h2>GitHub Repositories</h2>
        <ul>
          {repos.map((repo, index) => (
            <li key={index}>{repo}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export default App;
```

#### `src/GitClient.test.js`

```jsx
import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {

  test('should return repository names for a given user', async () => {
    const mockRepos = [
      { name: 'react-project' },
      { name: 'spring-boot-app' },
      { name: 'portfolio' }
    ];

    axios.get.mockResolvedValue({ data: mockRepos });

    const repos = await GitClient.getRepos('sandeepsolanki341');

    expect(repos).toEqual(['react-project', 'spring-boot-app', 'portfolio']);
    expect(axios.get).toHaveBeenCalledWith(
      'https://api.github.com/users/sandeepsolanki341/repos'
    );
  });

  test('should handle API error', async () => {
    axios.get.mockRejectedValue(new Error('Network Error'));

    await expect(GitClient.getRepos('invaliduser'))
      .rejects.toThrow('Network Error');
  });
});
```

```bash
# Run tests
npm test
```
