import React from 'react';
import { Link } from "react-router-dom";

function Clientes(args) {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="container-fluid">
        <h4 className="navbar-brand">CHN</h4>

        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div className="navbar-nav">
            <Link className="nav-link" to="Clientes">Clientes</Link>
            <Link className="nav-link" to="SolicitarPrestamo">Solicitud Prestamo</Link>
            <Link className="nav-link" to="Pagos">Pagos</Link>
          </div>
        </div>
      </div>
    </nav>
  );
}

export default Clientes;