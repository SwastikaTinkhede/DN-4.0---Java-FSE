import React from 'react';

export const BlogDetails = ({ blog, showInstallation }) => {

  let typeStatus;
  switch (blog.type) {
    case 'React':
      typeStatus = 'Status: React-focused blog.';
      break;
    case 'Angular':
      typeStatus = 'Status: Angular-focused blog.';
      break;
    default:
      typeStatus = 'Status: Other tech.';
  }
 
  return (
    <div className="section">
      <h1>Blog Details</h1>
      <h2 style={{ margin: '4px 0' }}>{blog.title}</h2>
      <p style={{ margin: '4px 0', fontWeight: 600 }}>{blog.author}</p>
      <p style={{ margin: '4px 0' }}>{blog.description}</p>

      {showInstallation ? (
        <div style={{ marginTop: '12px' }}>
          <h2 style={{ margin: '4px 0' }}>{blog.installationTitle}</h2>
          <p style={{ margin: '2px 0', fontWeight: 600 }}>{blog.installationAuthor}</p>
          <p style={{ margin: '2px 0' }}>{blog.installation}</p>
        </div>
      ) : (
        <p style={{ fontStyle: 'italic' }}>Installation instructions are hidden.</p>
      )}

      <p>{typeStatus}</p>
    </div>
  );
};
