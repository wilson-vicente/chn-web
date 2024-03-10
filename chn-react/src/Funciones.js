
function postFetch(ruta, method, data, token = "") {
    return new Promise(async function (resolve, reject) {
        var Config = {
            method: method,
            body: JSON.stringify(data),
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
                'Authorization': `Bearer ${token}`,
            }
        }
        await fetch(ruta, Config)
            .then((respuesta) => respuesta.json())
            .then((respuestaJson) => resolve(respuestaJson))
            .catch((error) => reject(error))

    })
}

function postFetchAll(ruta, method, data) {
    return new Promise(async function (resolve, reject) {
        var Config = {
            method: method,
            body: JSON.stringify(data),
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            }
        }
        await fetch(ruta, Config)
            .then((respuesta) => respuesta.json())
            .then((respuestaJson) => resolve(respuestaJson))
            .catch((error) => reject(error))

    })
}

function getFetchGET(ruta, token) {
    return new Promise(async function (resolve, reject) {
        var Config = {
            method: 'GET',
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
                'Authorization': `Bearer ${token}`,
            }
        }
        await fetch(ruta, Config)
            .then((respuesta) => respuesta.json())
            .then((respuestaJson) => resolve(respuestaJson))
            .catch((error) => reject(error))

    })
}

// Función 1
export const suma = (a, b) => {
  return a + b;
};

// Función 2
export const resta = (a, b) => {
  return a - b;
};

// Función 3
export const multiplicacion = (a, b) => {
  return a * b;
};


export {postFetch, postFetchAll, getFetchGET}

