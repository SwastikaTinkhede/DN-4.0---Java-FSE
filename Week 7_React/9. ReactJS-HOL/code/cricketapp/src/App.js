import React from 'react';
import { OddPlayers, EvenPlayers, IndianPlayers } from './components/IndianPlayers';
import ListofPlayers from './components/ListofPlayers';

function App() {
  const flag = false;

  return (
    <div className="App">
      {flag ? (
        <>
          <ListofPlayers />
        </>
      ) : (
        <div>
          <OddPlayers first="Sachin1" third="Virat3" fifth="Yuvraj5" />
          <EvenPlayers second="Dhoni2" fourth="Rohit4" sixth="Raina6" />
          
          <h3>List of Indian Players Merged:</h3>
          <ul>
            {IndianPlayers.map((player, index) => (
              <li key={index}>{player}</li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
}

export default App;
