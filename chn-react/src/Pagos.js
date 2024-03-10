
// MiComponente.js
import React, { useState, useEffect } from 'react';

//import { FaRegEdit } from 'react-icons/fa';
//import { MdDelete } from "react-icons/md";
import { GrTransaction } from "react-icons/gr";
import { BsTicketDetailed } from "react-icons/bs";

import { Table, Button, Modal, ModalHeader, ModalBody, ModalFooter, Form, Input } from 'reactstrap';
import { postFetchAll, getFetchGET } from './Funciones';


// Definir el componente funcional
const Pagos = () => {

    const [listaPagoPrestamoCliente, setListaPagoPrestamoCliente] = useState([]);
    const [listaDetPagoPrestamo, setListaDetPagoPrestamo] = useState([]);

    const [idSolicitudPrestamo, setIdSolicitudPrestamo] = useState();
    const [montoSolicitado, setMontoSolicitado] = useState();
    const [montoAbono, setMontoAbono] = useState();
    const [montoPago, setMontoPago] = useState();
    const [montoSaldo, setMontoSaldo] = useState();

    const listaPagoPrestamoAll = async () => {
        const respuesta = await getFetchGET("http://localhost:8080/api/v1/pago/getPagoPrestamosAllTable", "");
        console.log("respuesta", respuesta.data);

        if (respuesta) {
            if (respuesta.estado === "exito") {
                setListaPagoPrestamoCliente(respuesta.data);
            }
        }
    }


    const listaPagoPestamoByAprobadosAll = async (idPrestamosAprobado) => {
        const respuesta = await getFetchGET("http://localhost:8080/api/v1/pago/getPagoBySolicitudAprobada/" + idPrestamosAprobado, "");
        console.log("respuesta", respuesta.data);

        if (respuesta) {
            if (respuesta.estado === "exito") {
                setListaDetPagoPrestamo(respuesta.data);
            }
        }
    }


    const guardarPago = async () => {

        console.log("montoSaldo: ", montoSaldo);
        console.log("montoPago: ", montoPago);
        console.log("montoSolicitado: ", montoSolicitado);
        console.log("montoAbono: ", montoAbono);



        let datosPago = {};

        datosPago = {
            "idPrestamosAprobados": idSolicitudPrestamo,
            "montoPago": montoPago
        };

        console.log("datosPago ", datosPago);


        const respuesta = await postFetchAll("http://localhost:8080/api/v1/pago/saveOrUpdatePago", "POST", datosPago);
        console.log("respuesta", respuesta);

        if (respuesta) {
            if (respuesta.estado === "exito") {
                alert("Se guardo con exito.");

                setIdSolicitudPrestamo("");
                setMontoPago("");
                toggle(); // Cerrar el modal después de guardar exitosamente
                listaPagoPrestamoAll();

            } else {
                alert("Error al guardar");
            }
        }

    }

    // Para cargar datos al ingresar a la pagina
    useEffect(() => {
        listaPagoPrestamoAll();
    }, []);

    // Para Modal agregar pago
    const [modal, setModal] = useState(false);
    const toggle = () => setModal(!modal);

    // Para Modal pagos realizados
    const [modalPagosRealizados, setModalPagosRealizados] = useState(false);
    const togglePagosRealizados = () => setModalPagosRealizados(!modalPagosRealizados);

    return (
        <div>

            <Table>
                <thead>
                    <tr id="tr">
                        <th>
                            #
                        </th>
                        <th style={{ textAlign: 'center' }}>
                            Nombre Cliente
                        </th>
                        <th style={{ textAlign: 'center' }}>
                            Estado
                        </th>
                        <th style={{ textAlign: 'center' }}>
                            Fecha Aprobación
                        </th>
                        <th style={{ textAlign: 'center' }}>
                            Monto Solicitado
                        </th>
                        <th style={{ textAlign: 'center' }}>
                            Abono
                        </th>
                        <th style={{ textAlign: 'center' }}>
                            Saldo
                        </th>
                        <th style={{ textAlign: 'center' }}>
                            Realizar Pago
                        </th>
                        <th style={{ textAlign: 'center' }}>
                            Pago Realizados
                        </th>
                    </tr>
                </thead>
                <tbody>

                    {
                        listaPagoPrestamoCliente.map((item, index) => {
                            return (
                                <tr id={"tr_" + index}>
                                    <th id={"td_" + index} scope="row">
                                        {index + 1}
                                    </th>
                                    <td id={"td1_" + index} style={{ textAlign: 'left' }}>
                                        {item.nombre}
                                    </td>
                                    <td id={"td2_" + index} style={{ textAlign: 'center' }}>
                                        {
                                            item.estado === 1 ? "Activo" : "Finiquitado"
                                        }
                                    </td>
                                    <td id={"td3_" + index} style={{ textAlign: 'center' }}>
                                        {item.fechaAprobacion}
                                    </td>
                                    <td id={"td4_" + index} style={{ textAlign: 'right' }}>
                                        {item.montoSolicitado}
                                    </td>
                                    <td id={"td5_" + index} style={{ textAlign: 'right' }}>
                                        {item.montoPago}
                                    </td>
                                    <td id={"td6_" + index} style={{ textAlign: 'right' }}>
                                        {item.saldo}
                                    </td>
                                    <td id={"td7_" + index} style={{ textAlign: 'center' }}>
                                        <GrTransaction fontSize={25} onClick={() => { toggle(); setIdSolicitudPrestamo(item.idPrestamosAprobados); setMontoSolicitado(item.montoSolicitado); setMontoAbono(item.montoPago); setMontoSaldo(item.saldo); }} />
                                    </td>
                                    <td id={"td8_" + index} style={{ textAlign: 'center' }}>
                                        <BsTicketDetailed fontSize={25} onClick={() => { togglePagosRealizados(); listaPagoPestamoByAprobadosAll(item.idPrestamosAprobados); }} />
                                    </td>
                                </tr>
                            )
                        })
                    }

                </tbody>
            </Table>

            <div>
                <Modal isOpen={modal} toggle={toggle}>
                    <ModalHeader toggle={toggle}>Realizar Pago</ModalHeader>
                    <ModalBody>
                        <div>
                            <Form>

                                <Input
                                    className="mb-3"
                                    placeholder="Monto"
                                    value={montoPago}
                                    onChange={(texto) => { setMontoPago(texto.target.value) }}
                                />

                            </Form>
                        </div>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => { guardarPago() }}>
                            Guardar
                        </Button>
                        <Button color="secondary" onClick={toggle}>
                            Cancel
                        </Button>
                    </ModalFooter>
                </Modal>
            </div>

            <div>
                <Modal isOpen={modalPagosRealizados} toggle={togglePagosRealizados}>
                    <ModalHeader toggle={togglePagosRealizados}>Pagos Realizados</ModalHeader>
                    <ModalBody>
                        <div>
                            <Form>

                                <Table>
                                    <thead>
                                        <tr id="trDetPago">
                                            <th>
                                                #
                                            </th>
                                            <th style={{ textAlign: 'center' }}>
                                                Fecha Pago
                                            </th>
                                            <th style={{ textAlign: 'center' }}>
                                                Monto Pago
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        {
                                            listaDetPagoPrestamo.map((item, index) => {
                                                return (
                                                    <tr id={"trDetPago_" + index}>
                                                        <th id={"tdDetPago_" + index} scope="row">
                                                            {index + 1}
                                                        </th>
                                                        <td id={"td1DetPago_" + index} style={{ textAlign: 'center' }}>
                                                            {item.fechaPago}
                                                        </td>
                                                        <td id={"td2DetPago_" + index} style={{ textAlign: 'right' }}>
                                                            {item.montoPago}
                                                        </td>
                                                    </tr>
                                                )
                                            })
                                        }

                                    </tbody>
                                </Table>



                            </Form>
                        </div>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="secondary" onClick={togglePagosRealizados}>
                            Salir
                        </Button>
                    </ModalFooter>
                </Modal>
            </div>


        </div>
    );
};

// Exportar el componente para que pueda ser utilizado en otros archivos
export default Pagos;