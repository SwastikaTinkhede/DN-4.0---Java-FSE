import React, { useState } from 'react';
import './App.css';
import { books, courses, blog } from './data';
import { BookDetails } from './components/BookDetails';
import { BlogDetails } from './components/BlogDetails';
import { CourseDetails } from './components/CourseDetails';

function App() {
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogInstall, setShowBlogInstall] = useState(true);

  return (
    <div className="App">
      <div className="container">
        <div className="column">
          <CourseDetails courses={courses} />
        </div>

        <div className="column with-border">
          <BookDetails books={books} showDetails={showBooks} />
        </div>

        <div className="column with-border">
          <BlogDetails blog={blog} showInstallation={showBlogInstall} />
        </div>
      </div>

      <div className="toggles">
        <button onClick={() => setShowBooks((s) => !s)}>
          {showBooks ? 'Hide' : 'Show'} Books
        </button>
        <button onClick={() => setShowBlogInstall((s) => !s)}>
          Toggle Installation
        </button>
      </div>
    </div>
  );
}

export default App;
