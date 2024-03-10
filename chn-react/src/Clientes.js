// MiComponente.js
import React, { useState, useEffect } from 'react';

import { FaRegEdit } from 'react-icons/fa';
import { MdDelete } from "react-icons/md";

import { Form, Input, Button, Table } from 'reactstrap';
import { postFetchAll, getFetchGET } from './Funciones';


// Definir el componente funcional
const Clientes = () => {

  const [idCliente, setIdCliente] = useState();
  const [nombre, setNombre] = useState();
  const [apellido, setApellido] = useState();
  const [numeroIdentificacion, setNumeroIdentificacion] = useState();
  const [fechaNacimiento, setFechaNacimiento] = useState();
  const [direccion, setDireccion] = useState();
  const [correo, setCorreo] = useState();
  const [telefono, setTelefono] = useState();

  const [listaCliente, setListaCliente] = useState([]);

  const guardarCliente = async () => {

    console.log("idCliente ", idCliente);
    let datosCliente = {};

    if (idCliente !== "") {
      console.log("Ingreso al IFFF ", idCliente);

      datosCliente = {
        "idCliente": idCliente,
        "nombre": nombre,
        "apellido": apellido,
        "numeroIdentificacion": numeroIdentificacion,
        "direccion": direccion,
        "correo": correo,
        "telefono": telefono
      };

    } else {
      datosCliente = {
        "nombre": nombre,
        "apellido": apellido,
        "numeroIdentificacion": numeroIdentificacion,
        "direccion": direccion,
        "correo": correo,
        "telefono": telefono
      };
    }

    console.log("datosClienteEdit ", datosCliente);

    const respuesta = await postFetchAll("http://localhost:8080/api/v1/cliente/saveOrUpdateCliente", "POST", datosCliente);
    console.log("respuesta", respuesta);

    if (respuesta) {
      if (respuesta.estado === "exito") {
        alert("Se guardo con exito.");

        setIdCliente("");
        setNombre("");
        setApellido("");
        setNumeroIdentificacion("");
        setFechaNacimiento("");
        setDireccion("");
        setCorreo("");
        setTelefono("");

        listaClienteAll();

      } else {
        alert("Error al guardar");
      }
    }
  }

  const listaClienteAll = async () => {

    const respuesta = await getFetchGET("http://localhost:8080/api/v1/cliente/getClienteAll", "");
    console.log("respuesta", respuesta.data);

    if (respuesta) {
      if (respuesta.estado === "exito") {
        setListaCliente(respuesta.data);
      }
    }

  }

  const eliminarCliente = async (idCliente) => {

    const respuesta = await postFetchAll("http://localhost:8080/api/v1/cliente/deleteCliente/" + idCliente, "DELETE", {});
    console.log("respuesta", respuesta);
    
    if (respuesta) {
      if (respuesta.estado === "exito") {
        alert("Registro eliminado con exito.");
      } else {
        alert("No se puede realizar la eliminacion, existe solicitudes de prestamo para el cliente.");
      }
    }
    
    listaClienteAll();

  }

  const editarCliente = async (item) => {

    console.log("item ", item);

    setIdCliente(item.idCliente);
    setNombre(item.nombre);
    setApellido(item.apellido);
    setNumeroIdentificacion(item.numeroIdentificacion);
    setFechaNacimiento("");
    setDireccion(item.direccion);
    setCorreo(item.correo);
    setTelefono(item.telefono);

  }


  useEffect(() => {
    listaClienteAll();
  }, []);

  return (
    <div>
      <Form>
        <Input
          id="nombre"
          className="mb-3"
          placeholder="Nombre"
          value={nombre}
          onChange={(texto) => { setNombre(texto.target.value) }}
        />
        <Input
          id="apellido"
          className="mb-3"
          placeholder="Apellido"
          value={apellido}
          onChange={(texto) => { setApellido(texto.target.value) }}
        />
        <Input
          className="mb-3"
          placeholder="Numero Identificacion"
          value={numeroIdentificacion}
          onChange={(texto) => { setNumeroIdentificacion(texto.target.value) }}
        />
        <Input
          className="mb-3"
          placeholder="Fecha Nacimiento"
          value={fechaNacimiento}
          onChange={(texto) => { setFechaNacimiento(texto.target.value) }}
        />
        <Input
          className="mb-3"
          placeholder="Direccion"
          value={direccion}
          onChange={(texto) => { setDireccion(texto.target.value) }}
        />
        <Input
          className="mb-3"
          placeholder="Correo"
          value={correo}
          onChange={(texto) => { setCorreo(texto.target.value) }}
        />
        <Input
          className="mb-3"
          placeholder="Telefono"
          value={telefono}
          onChange={(texto) => { setTelefono(texto.target.value) }}
        />

        <Button color="primary" onClick={() => { guardarCliente() }}>
          Guardar
        </Button>
      </Form>


      <Table
      >
        <thead>
          <tr id="tr">
            <th>
              #
            </th>
            <th>
              Nombre
            </th>
            <th>
              Apellido
            </th>
            <th>
              Numero Identificacion
            </th>
            <th>
              Fecha Nacimiento
            </th>
            <th>
              Direccion
            </th>
            <th>
              Correo
            </th>
            <th>
              Telefono
            </th>
            <th>
            </th>
          </tr>
        </thead>
        <tbody>

          {
            listaCliente.map((item, index) => {
              return (
                <tr id={"tr_" + index}>
                  <th id={"td_" + index} scope="row">
                    {index + 1}
                  </th>
                  <td id={"td1_" + index}>
                    {item.nombre}
                  </td>
                  <td id={"td2_" + index}>
                    {item.apellido}
                  </td>
                  <td id={"td3_" + index}>
                    {item.numeroIdentificacion}
                  </td>
                  <td id={"td4_" + index}>
                  </td>
                  <td id={"td5_" + index}>
                    {item.direccion}
                  </td>
                  <td id={"td6_" + index}>
                    {item.correo}
                  </td>
                  <td id={"td7_" + index}>
                    {item.telefono}
                  </td>
                  <td id={"td8_" + index}>
                    <FaRegEdit fontSize={25} onClick={() => { editarCliente(item) }} />
                    <MdDelete fontSize={25} color='red' onClick={() => { eliminarCliente(item.idCliente) }} />
                  </td>
                </tr>
              )
            })
          }

        </tbody>
      </Table>
    </div>
  );
};

// Exportar el componente para que pueda ser utilizado en otros archivos
export default Clientes;