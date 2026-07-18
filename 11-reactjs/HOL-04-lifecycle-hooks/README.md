# HOL 04 - Component Lifecycle Hooks

**Duration:** 60 minutes

## Objective

Implement component lifecycle methods including `componentDidMount()` and `componentDidCatch()`.

## Topics Covered

- Component lifecycle hook methods
- Fetching data with Fetch API
- Error boundaries with componentDidCatch()

## Exercise

Create a React app `blogapp` that fetches posts from `https://jsonplaceholder.typicode.com/posts` and displays them using lifecycle hooks.

## Steps

```bash
npx create-react-app blogapp
cd blogapp
```

### Solution

#### `src/Post.js`

```jsx
class Post {
  constructor(userId, id, title, body) {
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.body = body;
  }
}

export default Post;
```

#### `src/Posts.js`

```jsx
import React, { Component } from 'react';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: []
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        this.setState({ posts: data });
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert('An error occurred: ' + error.message);
  }

  render() {
    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ margin: '10px', padding: '10px', border: '1px solid #ddd' }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import Posts from './Posts';

class App extends Component {
  render() {
    return (
      <div>
        <Posts />
      </div>
    );
  }
}

export default App;
```

```bash
npm start
```
