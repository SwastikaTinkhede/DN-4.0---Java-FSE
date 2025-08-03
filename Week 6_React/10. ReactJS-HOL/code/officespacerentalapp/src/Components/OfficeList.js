import React from 'react';
import './OfficeList.css'; 

const offices = [
  {
    name: 'DBS',
    rent: 50000,
    address: 'Chennai',
    image: 'https://images.unsplash.com/photo-1497366754035-f200968a6e72?q=80&w=869&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'
  },
  {
    name: 'Regus',
    rent: 75000,
    address: 'Mumbai',
    image: 'https://images.unsplash.com/photo-1705909773171-4ba952b9c0af?q=80&w=872&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'
  },
  {
    name: 'SmartWorks',
    rent: 60000,
    address: 'Bangalore',
    image: 'https://images.unsplash.com/photo-1497366811353-6870744d04b2?q=80&w=869&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'
  }
];

export default function OfficeList() {
  return (
    <div>
      <h2>Office Space , at Affordable Range</h2>

      {offices.map((office, index) => {
        const rentClass = office.rent <= 60000 ? 'textRed' : 'textGreen';

        return (
          <div key={index}>
            <img src={office.image} alt={office.name} width="300" height="200" />
            <h3>Name: {office.name}</h3>
            <p className={rentClass}>Rent: Rs. {office.rent}</p>
            <p>Address: {office.address}</p>
            <hr />
          </div>
        );
      })}
    </div>
  );
}
