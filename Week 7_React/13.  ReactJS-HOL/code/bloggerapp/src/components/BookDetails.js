import React from 'react';

export const BookDetails = ({ books, showDetails }) => {
  if (!books) {
    return (
      <div className="section">
        <h1>Book Details</h1>
        <p>Loading books...</p>
      </div>
    );
  }

  return (
    <div className="section">
      <h1>Book Details</h1>

      {showDetails ? (
        books.length > 0 ? (
          <div>
            {books.map((book) => (
              <div key={book.id} style={{ marginBottom: '8px' }}>
                <h3 style={{ margin: 0, fontWeight: '600' }}>{book.bname}</h3>
                <h4 style={{ margin: 0, fontWeight: '400' }}>{book.price}</h4>
              </div>
            ))}
          </div>
        ) : (
          <p>No books available.</p>
        )
      ) : (
        <p>Book section is hidden. Toggle to show it.</p>
      )}
    </div>
  );
};
