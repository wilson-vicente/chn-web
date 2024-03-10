import './App.css';

import 'bootstrap/dist/css/bootstrap.min.css';

import { BrowserRouter, Routes, Route } from "react-router-dom";

import Menu from "./Menu";
import Clientes from "./Clientes";
import SolicitarPrestamo from "./SolicitarPrestamo";
import Pagos from "./Pagos";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Menu />} />
        <Route path="Clientes" element={<Clientes />} />
        <Route path="SolicitarPrestamo" element={<SolicitarPrestamo />} />
        <Route path="Pagos" element={<Pagos />} />
      </Routes>
    </BrowserRouter>
  );
}

//const root = ReactDOM.createRoot(document.getElementById('root'));
//root.render(<App />);
