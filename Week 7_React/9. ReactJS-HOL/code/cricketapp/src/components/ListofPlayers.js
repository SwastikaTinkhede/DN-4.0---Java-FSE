import React from 'react';

function ListofPlayers() {
  const players = [
    { name: 'Virat Kohli', score: 80 },
    { name: 'Rohit Sharma', score: 65 },
    { name: 'KL Rahul', score: 72 },
    { name: 'Shubman Gill', score: 55 },
    { name: 'Rishabh Pant', score: 90 },
    { name: 'Hardik Pandya', score: 68 },
    { name: 'Ravindra Jadeja', score: 88 },
    { name: 'Bumrah', score: 45 },
    { name: 'Ashwin', score: 77 },
    { name: 'Shami', score: 60 },
    { name: 'Surya Kumar', score: 85 }
  ];

  const below70 = players.filter(player => player.score < 70); //arrow function

  return (
    <div>
      <h2>All Players</h2>
        <ul>
            {players.map((player, index) => (
            <li key={index}>{player.name} - {player.score}</li>
             ))}
        </ul>
    
        <hr /> 

      <h2>Players with Score below 70</h2>
        <ul>
            {below70.map((player, index) => (
            <li key={index}>{player.name} - {player.score}</li>
            ))}
        </ul>

    </div>
  );
}

export default ListofPlayers;
