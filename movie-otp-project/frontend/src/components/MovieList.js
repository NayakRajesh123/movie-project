import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function MovieList(){
  const [movies, setMovies] = useState([]);
  const [phone, setPhone] = useState('');
  const [seat, setSeat] = useState('');
  const [msg, setMsg] = useState('');

  useEffect(()=> {
    axios.get('http://localhost:8080/api/movies').then(r=>setMovies(r.data));
  }, []);

  const book = async (movieId) => {
    try {
      await axios.post('http://localhost:8080/api/bookings', { phone, movieId, seat });
      setMsg('Booking confirmed!');
    } catch (err) {
      setMsg('Booking failed. Make sure you verified OTP and provided phone.');
    }
  }

  return (
    <div>
      <h5>Movies</h5>
      <div className="mb-2">
        <input className="form-control" placeholder="Your Phone (used for booking)" value={phone} onChange={e=>setPhone(e.target.value)} />
        <input className="form-control mt-1" placeholder="Seat (e.g. A1)" value={seat} onChange={e=>setSeat(e.target.value)} />
      </div>
      <div className="list-group">
        {movies.map(m=>(
          <div key={m.id} className="list-group-item">
            <div><strong>{m.title}</strong> ({m.language}) - {m.genre}</div>
            <div>Duration: {m.durationMinutes} mins | Rating: {m.rating}</div>
            <button className="btn btn-primary mt-2" onClick={()=>book(m.id)}>Book Seat</button>
          </div>
        ))}
      </div>
      <div className="mt-2 text-success">{msg}</div>
    </div>
  );
}
