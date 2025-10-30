import React, { useState } from 'react';
import axios from 'axios';

export default function Login(){
  const [phone, setPhone] = useState('');
  const [msg, setMsg] = useState('');

  const sendOtp = async () => {
    try {
      const res = await axios.post('http://localhost:8080/api/auth/send-otp', { phone });
      setMsg('OTP sent! (for demo, OTP = ' + res.data.otp + ')');
    } catch (err) {
      setMsg('Error sending OTP');
    }
  }

  return (
    <div>
      <h5>Login / Register (Phone)</h5>
      <div className="mb-3">
        <input className="form-control" placeholder="+911234567890" value={phone} onChange={e=>setPhone(e.target.value)} />
      </div>
      <button className="btn btn-primary" onClick={sendOtp}>Send OTP</button>
      <div className="mt-2 text-success">{msg}</div>
    </div>
  );
}
