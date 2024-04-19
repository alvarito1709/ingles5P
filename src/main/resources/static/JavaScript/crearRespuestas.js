var urlBase = "http://localhost:8080"


//MUESTRA QUE FORMULARIO VER
function formDisplay(){
    var formulary = document.getElementById("formDisplay").value;

    switch (formulary){
        case ("AGREGAR"):
            document.getElementById("agregarRespuesta").style.display= "flex";
            document.getElementById("edicionRespuesta").style.display= "none";
            document.getElementById("eliminarRespuesta").style.display= "none";

        break;
        case ("EDITAR"):
            document.getElementById("edicionRespuesta").style.display= "flex";
            document.getElementById("agregarRespuesta").style.display= "none";
            document.getElementById("eliminarRespuesta").style.display= "none";
            break;

        case ("ELIMINAR"):
            document.getElementById("edicionRespuesta").style.display= "none";
            document.getElementById("agregarRespuesta").style.display= "none";
            document.getElementById("eliminarRespuesta").style.display= "flex";
            break;
    }

}


function crearRespuesta(){
    var url = urlBase + "/admin/submitRespuesta"


    var nivel = document.getElementById("nivel");
    var apartado = document.getElementById("apartado");
    var cuerpo = document.getElementById("cuerpo");
    var tipo = document.getElementById("tipo");
    var respuestaCorrecta = document.getElementById("respuestaCorrecta");
    var pregunta = document.getElementById("pregunta");

    var data = {
        nivel: nivel.value,
        apartado: apartado.value,
        cuerpoRespuesta: cuerpo.value,
        tipo: tipo.value,
        respuestaCorrecta: respuestaCorrecta.value,
        pregunta: {id: pregunta.value}
    }

    var dataJson = JSON.stringify(data);




    console.log(dataJson);

    var requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: dataJson
    };

    fetch(url, requestOptions).then(response => response.json()).then(result =>{
        console.log("respuesta del servidor", result)
    })
}




//FILTRA PREGUNTAS SEGUN EL NIVEL Y APARTADO SELECCIONADO Y LOS REPRESENTA EN EL HTML SEGUN EL FORMULARIO SELECCIONADO (AGREGAR, EDITAR O ELIMINAR)

function change(){
    var formulary = document.getElementById("formDisplay").value;

    var level;
    var apartado;
    var modelo
    const url = urlBase + "/admin/filtrarPreguntas"

    var contenedorid;

    switch (formulary){
        case("AGREGAR"):

            level = parseInt(document.getElementById("nivel").value);
            apartado = document.getElementById("apartado").value;
            contenedorid = "#pregunta";
            modelo = "preg";

            break;

        case("EDITAR"):

            level = parseInt(document.getElementById("nivelEdicion").value);
            apartado = document.getElementById("apartadoEdicion").value;
            contenedorid = "#preguntaEdicion";
            modelo = "pregEdit";
            break;

        case("ELIMINAR"):

            level = parseInt(document.getElementById("nivelBorrar").value);
            apartado = document.getElementById("apartadoBorrar").value;
            contenedorid = "#preguntaBorrar";
            modelo = "pregDelete";
            break;

    }

    $.ajax({
        type: 'POST',
        url: url,
        data:{
            level: level,
            apartado: apartado,
            modelo: modelo
        },
        success: [function (data){
            $(contenedorid).html(data);
        }],
        error: [function () {

        }]
    })

}

//FILTRA LAS RESPUESTAS SEGUN LA PREGUNTA SELECCIONADA Y AL SELECCIONAR LA RESPUESTA TRAE LOS DATOS PARA SER EDITADA.
function answerFilter(data){

    switch (data){


        //TRAE UNA LISTA DE RESPUESTAS
        case(preguntaEdicion):
            var url = urlBase+'/admin/filtrarRespuestas'
            var dato = document.getElementById("preguntaEdicion");
            var contenedor = document.getElementById("respuestaEdicion");
            var modelo = "resp";
            break;

            //TRAE SOLO UNA RESPUESTA CON TODOS SUS DATOS
        case (respuestaEdicion):
            var url = urlBase+'/admin/buscarRespuesta'
            var dato = document.getElementById("respuestaEdicion");
            var contenedor = document.getElementById("edicionRespuesta");
            break;


            //FILTRA LAS RESPUESTAS PARA PODER ELIMINARLA
        case(preguntaBorrar):
            var url = urlBase+'/admin/filtrarRespuestas'
            var dato = document.getElementById("preguntaBorrar");
            var contenedor = document.getElementById("respuestaBorrar");
            var modelo = "respEliminar";
            break;

    }

    $.ajax({
        type: 'POST',
        url: url,
        data: {
            dato: dato.value,
            modelo: modelo
        },
        success: function (data){
            $(contenedor).html(data);
        },
        error: function (e){

        }
    })

}

function editarRespuesta(){

    var id = document.getElementById("respuestaID");
    var cuerpoRespuesta = document.getElementById("cuerpoEdicion");
    var nivel = document.getElementById("nivelEdit");
    var respuestaCorrecta = document.getElementById("respuestaCorrectaEdicion");
    var tipo = document.getElementById("tipoEdicion");
    var preguntaId = document.getElementById("preguntaIdEdit");

    var url = urlBase + "/admin/editarRespuesta/" + id.value;

    var data = {
        id: id.value,
        cuerpoRespuesta: cuerpoRespuesta.value,
        nivel: nivel.value,
        respuestaCorrecta: respuestaCorrecta.value,
        tipo: tipo.value,
        preguntaId: {id:preguntaId.value}
    }

    var dataJson = JSON.stringify(data);

    console.log(dataJson);

    var request = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: dataJson
    };

    fetch(url, request)
        .then(response => response.json())
        .then(result => console.log("RESPUESTA DEL SERVIDOR " + result));

}

function eliminarRespuesta(){

    var respuestaId = document.getElementById("respuestaBorrar").value;
    var url = urlBase + "/admin/borrarRespuesta/" + respuestaId;

    var request = {
        method: 'DELETE',
        headers:{
            'Content-Type':'application/json'
        },
        body:respuestaId
    };

    fetch(url, request)
        .then(result => console.log(result))
}







