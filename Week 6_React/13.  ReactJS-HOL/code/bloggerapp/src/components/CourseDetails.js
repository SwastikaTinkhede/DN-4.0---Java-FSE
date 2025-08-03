import React from 'react';

export const CourseDetails = ({ courses }) => {
  return (
    <div className="section">
      <h1>Course Details</h1>
      <div style={{ marginTop: '8px' }}>
        {courses.map((c) => (
          <div key={c.id} style={{ marginBottom: '16px' }}>
            <h2 style={{ margin: 0, fontWeight: '600' }}>{c.name}</h2>
            <p style={{ margin: 0 }}>{c.date}</p>
          </div>
        ))}
      </div>
    </div>
  );
};
