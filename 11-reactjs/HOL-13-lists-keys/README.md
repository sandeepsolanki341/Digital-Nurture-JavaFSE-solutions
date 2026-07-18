# HOL 13 - Lists, Keys & Conditional Rendering

**Duration:** 60 minutes

## Objective

Render multiple components using lists and keys, with various conditional rendering techniques.

## Topics Covered

- Rendering multiple components
- List component and keys
- map() function
- Multiple conditional rendering approaches

## Exercise

Create a React app `bloggerapp` with 3 components — BookDetails, BlogDetails, CourseDetails. Implement conditional rendering using as many techniques as possible (if-else, ternary, &&, switch).

## Steps

```bash
npx create-react-app bloggerapp
cd bloggerapp
```

### Solution

#### `src/BookDetails.js`

```jsx
import React from 'react';

function BookDetails() {
  const books = [
    { id: 1, title: 'Clean Code', author: 'Robert C. Martin' },
    { id: 2, title: 'Design Patterns', author: 'Gang of Four' },
    { id: 3, title: 'Refactoring', author: 'Martin Fowler' }
  ];

  return (
    <div>
      <h2>Book Details</h2>
      <ul>
        {books.map(book => (
          <li key={book.id}><strong>{book.title}</strong> by {book.author}</li>
        ))}
      </ul>
    </div>
  );
}

export default BookDetails;
```

#### `src/BlogDetails.js`

```jsx
import React from 'react';

function BlogDetails() {
  const blogs = [
    { id: 1, title: 'Getting Started with React', date: '2026-01-15' },
    { id: 2, title: 'Understanding State', date: '2026-02-20' },
    { id: 3, title: 'React Router Deep Dive', date: '2026-03-10' }
  ];

  return (
    <div>
      <h2>Blog Details</h2>
      <ul>
        {blogs.map(blog => (
          <li key={blog.id}><strong>{blog.title}</strong> — {blog.date}</li>
        ))}
      </ul>
    </div>
  );
}

export default BlogDetails;
```

#### `src/CourseDetails.js`

```jsx
import React from 'react';

function CourseDetails() {
  const courses = [
    { id: 1, name: 'ReactJS', duration: '40 hours' },
    { id: 2, name: 'Spring Boot', duration: '60 hours' },
    { id: 3, name: 'Node.js', duration: '30 hours' }
  ];

  return (
    <div>
      <h2>Course Details</h2>
      <ul>
        {courses.map(course => (
          <li key={course.id}><strong>{course.name}</strong> — {course.duration}</li>
        ))}
      </ul>
    </div>
  );
}

export default CourseDetails;
```

#### `src/App.js`

```jsx
import React, { Component } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { view: 'books' };
  }

  renderContent() {
    // Using switch-case for conditional rendering
    switch (this.state.view) {
      case 'books': return <BookDetails />;
      case 'blogs': return <BlogDetails />;
      case 'courses': return <CourseDetails />;
      default: return <BookDetails />;
    }
  }

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h1>Blogger App</h1>
        <button onClick={() => this.setState({ view: 'books' })}>Books</button>{' '}
        <button onClick={() => this.setState({ view: 'blogs' })}>Blogs</button>{' '}
        <button onClick={() => this.setState({ view: 'courses' })}>Courses</button>
        <hr />
        {this.renderContent()}

        {/* Ternary operator example */}
        {this.state.view === 'books' && <p><em>Showing book recommendations</em></p>}
      </div>
    );
  }
}

export default App;
```

```bash
npm start
```
