import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from './components/Login';
import OtpVerify from './components/OtpVerify';
import MovieList from './components/MovieList';

function App() {
  return (
    <div className="container mt-4">
      <h2>Movie Ticket Booking (OTP Login)</h2>
      <Login />
      <hr/>
      <OtpVerify />
      <hr/>
      <MovieList />
    </div>
  );
}

export default App;
