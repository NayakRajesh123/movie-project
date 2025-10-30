import React, { useState } from 'react';
import axios from 'axios';

export default function OtpVerify(){
  const [phone, setPhone] = useState('');
  const [otp, setOtp] = useState('');
  const [msg, setMsg] = useState('');

  const verify = async () => {
    try {
      const res = await axios.post('http://localhost:8080/api/auth/verify-otp', { phone, otp });
      setMsg('Verified! You can now book tickets.');
    } catch (err) {
      setMsg('Invalid or expired OTP');
    }
  }

  return (
    <div>
      <h5>Verify OTP</h5>
      <div className="mb-2">
        <input className="form-control mb-1" placeholder="+911234567890" value={phone} onChange={e=>setPhone(e.target.value)} />
        <input className="form-control" placeholder="Enter OTP" value={otp} onChange={e=>setOtp(e.target.value)} />
      </div>
      <button className="btn btn-success" onClick={verify}>Verify OTP</button>
      <div className="mt-2 text-info">{msg}</div>
    </div>
  );
}
