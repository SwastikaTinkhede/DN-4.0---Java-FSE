import React from 'react';

// Destructured props for Odd and Even Players
export function OddPlayers({ first, third, fifth }) {
  return (
    <div>
      <h3>Odd Players</h3>
      <ul>
        <li>First: {first}</li>
        <li>Third: {third}</li>
        <li>Fifth: {fifth}</li>
      </ul>
      <hr />
    </div>
  );
}

export function EvenPlayers({ second, fourth, sixth }) {
  return (
    <div>
      <h3>Even Players</h3>
      <ul>
        <li>Second: {second}</li>
        <li>Fourth: {fourth}</li>
        <li>Sixth: {sixth}</li>
      </ul>
      <hr />
    </div>
  );
}

// Merge Feature
const T20Players = ['Mr. First Player', 'Mr. Second Player', 'Mr. Third Player'];
const RanjiTrophyPlayers = ['Mr. Fourth Player', 'Mr. Fifth Player', 'Mr. Sixth Player'];

export const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];
