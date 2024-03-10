// MiComponente.js
import React, { useState, useEffect } from 'react';

import { FaRegEdit } from 'react-icons/fa';
//import { MdDelete } from "react-icons/md";

import { Form, Input, Button, Table, FormGroup, Label } from 'reactstrap';
import { postFetchAll, getFetchGET } from './Funciones';


// Definir el componente funcional
const SolicitarPrestamo = () => {

    const [idSolicitudPrestamo, setIdSolicitudPrestamo] = useState();
    const [opcionSeleccionadaCliente, setOpcionSeleccionadaCliente] = useState();
    const [listaCliente, setListaCliente] = useState([]);

    const [opcionSeleccionadaPlazoSolicitado, setOpcionSeleccionadaPlazoSolicitado] = useState();
    const [montoSolicitado, setMontoSolicitado] = useState();
    const [opcionSeleccionadaEstado, setOpcionSeleccionadaEstado] = useState();

    const [listaSolicitudPrestamo, setListaSolicitudPrestamo] = useState([]);

    const listaClienteAll = async () => {
        const respuesta = await getFetchGET("http://localhost:8080/api/v1/cliente/getClienteAll", "");
        console.log("respuesta", respuesta.data);

        if (respuesta) {
            if (respuesta.estado === "exito") {
                setListaCliente(respuesta.data);
            }
        }
    }

    const listaSolicitudPrestamoTable = async () => {

        const respuesta = await getFetchGET("http://localhost:8080/api/v1/solicitudPrestamo/getSolicitudesPrestamoAllTable", "");
        console.log("respuesta", respuesta.data);

        if (respuesta) {
            if (respuesta.estado === "exito") {
                setListaSolicitudPrestamo(respuesta.data);
            }
        }

    }

    const guardarSolicitudPrestamo = async () => {

        let datosSolitudPrestamo = {};
        
        if(idSolicitudPrestamo !== "") {
            datosSolitudPrestamo = {
                "idSolicitudPrestamo": idSolicitudPrestamo,
                "idCliente": opcionSeleccionadaCliente,
                "idPlazoDeseado": opcionSeleccionadaPlazoSolicitado,
                "montoSolicitado": montoSolicitado,
                "estado": opcionSeleccionadaEstado
            };
        } else {
            datosSolitudPrestamo = {
                "idCliente": opcionSeleccionadaCliente,
                "idPlazoDeseado": opcionSeleccionadaPlazoSolicitado,
                "montoSolicitado": montoSolicitado,
                "estado": opcionSeleccionadaEstado
            };
        }
   
        const respuesta = await postFetchAll("http://localhost:8080/api/v1/solicitudPrestamo/saveOrUpdateSolicitudPrestamo", "POST", datosSolitudPrestamo);
        console.log("respuesta", respuesta);

        if (respuesta) {
            if (respuesta.estado === "exito") {
                alert("Se guardo con exito.");
                setIdSolicitudPrestamo("");
                setOpcionSeleccionadaCliente("");
                setOpcionSeleccionadaPlazoSolicitado("");
                setMontoSolicitado("");
                setOpcionSeleccionadaEstado("");

                listaClienteAll();
                listaSolicitudPrestamoTable();
            } else {
                alert("Error al guardar");
            }
        }
    }

    const editarSolicitudPrestamo = async (item) => {

        console.log("item ", item);
        setIdSolicitudPrestamo(item.idSolicitudPrestamo);
        setOpcionSeleccionadaCliente(item.idCliente);
        setOpcionSeleccionadaPlazoSolicitado(item.idPlazodeseado);
        setMontoSolicitado(item.montoSolicitado);
        setOpcionSeleccionadaEstado(item.estado);

    }

    useEffect(() => {
        listaClienteAll();
        listaSolicitudPrestamoTable();
    }, []);

    return (
        <div>
            <Form>
                <input
                    type="hidden"
                    name="idSolicitudPrestamo"
                    value={idSolicitudPrestamo}
                    onChange={(texto) => { setIdSolicitudPrestamo(texto.target.value) }}
                />

                <FormGroup>
                    <Label for="clienteSolicitudPrestamo">Selecciona una opción</Label>
                    <Input
                        type="select"
                        name="select"
                        id="clienteSolicitudPrestamo"
                        value={opcionSeleccionadaCliente}
                        onChange={(texto) => { setOpcionSeleccionadaCliente(texto.target.value) }}
                    >
                        <option value="">Seleccionar cliente</option>
                        {
                            listaCliente.map((item, index) => {
                                return (
                                    <option value={item.idCliente}>{item.nombre}</option>
                                )
                            })
                        }
                    </Input>
                </FormGroup>

                <FormGroup>
                    <Label for="plazoSolicitadoPrestamo">Selecciona una opción</Label>
                    <Input
                        type="select"
                        name="plazoSolicitadoPrestamo"
                        id="plazoSolicitadoPrestamo"
                        value={opcionSeleccionadaPlazoSolicitado}
                        onChange={(texto) => { setOpcionSeleccionadaPlazoSolicitado(texto.target.value) }}
                    >

                        <option value="">Seleccionar plazo...</option>
                        <option value="1">12 Meses</option>
                        <option value="2">24 Meses</option>
                        <option value="3">36 Meses</option>
                        <option value="4">48 Meses</option>
                        <option value="5">60 Meses</option>
                    </Input>
                </FormGroup>

                <Input
                    className="mb-3"
                    placeholder="Monto Solicitado"
                    value={montoSolicitado}
                    onChange={(texto) => { setMontoSolicitado(texto.target.value) }}
                />

                <FormGroup>
                    <Label for="estadoSolicitudPrestamo">Selecciona una opción</Label>
                    <Input
                        type="select"
                        name="estadoSolicitudPrestamo"
                        id="estadoSolicitudPrestamo"
                        value={opcionSeleccionadaEstado}

                        onChange={(texto) => { setOpcionSeleccionadaEstado(texto.target.value) }}
                    >

                        <option value="">Selecciona estado...</option>
                        <option value="1">Rechazado</option>
                        <option value="2">En proceso</option>
                        <option value="3">Aprobado</option>
                    </Input>
                </FormGroup>

                <Button color="primary" onClick={() => { guardarSolicitudPrestamo() }}>
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
                            Plaza Solicitado
                        </th>
                        <th>
                            Monto Solicitado
                        </th>
                        <th>
                            Estado
                        </th>
                        <th>
                        </th>
                    </tr>
                </thead>
                <tbody>

                    {
                        listaSolicitudPrestamo.map((item, index) => {
                            return (
                                <tr id={"tr_" + index}>
                                    <th id={"td_" + index} scope="row">
                                        {index + 1}
                                    </th>
                                    <td id={"td1_" + index}>
                                        {item.nombre}
                                    </td>
                                    <td id={"td2_" + index}>
                                        {
                                            item.idPlazodeseado === 1 ? "12 Meses" :
                                                item.idPlazodeseado === 2 ? "24 Meses" :
                                                    item.idPlazodeseado === 3 ? "36 Meses" :
                                                        item.idPlazodeseado === 4 ? "48 Meses" : "60 Meses"
                                        }
                                    </td>
                                    <td id={"td3_" + index}>
                                        {item.montoSolicitado}
                                    </td>
                                    <td id={"td4_" + index}>
                                        {item.estado === 1 ? "Rechazado" : item.estado === 2 ? "En proceso" : "Aprobado"}
                                    </td>
                                    <td id={"td8_" + index}>
                                        <FaRegEdit fontSize={25} onClick={() => { editarSolicitudPrestamo(item) }} />
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
export default SolicitarPrestamo;