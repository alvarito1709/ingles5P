var urlBase = "http://localhost:8080"

var container = document.getElementById("container");
var body = document.getElementById("boardBody");

const apartado = "LISTENING";

function showPersonalData(){

    var url = urlBase+'/test/level'
    const test = document.getElementById("prueba").value;


    $.ajax({
        type: 'POST',
        url: url,
        data:{
            prueba: test
        },
        success: [function (data){
            $("#tester").html(data);
        },
        function (){
            container.style.display = "flex";
            body.style.display = "none";
        }],
        error: [function () {

        }]
    })

    window.scrollTo({top: 0, behavior: 'smooth'});

}

function showLevel1(){
    var url = urlBase+'/test/level'
    const test = document.getElementById("level1").value;


    $.ajax({
        type: 'POST',
        url: url,
        data:{
            prueba: test,
            level: 1,
            apartado: apartado
        },
        success: [function (data){
            $("#tester").html(data);
        },
            function (){
                container.style.display = "flex";
                body.style.display = "none";
            }],
        error: [function () {

        }]
    })

    window.scrollTo({top: 0, behavior: 'smooth'});

}

function showLevel2(){
    var url = urlBase+'/test/level'
    const test = document.getElementById("level2").value;

    $.ajax({
        type: 'POST',
        url: url,
        data:{
            prueba: test,
            level: 2,
            apartado: apartado
        },
        success: [function (data){
            $("#tester").html(data);
        },
            function (){
                container.style.display = "flex";
                body.style.display = "none";
            }],
        error: [function () {

        }]
    })

    window.scrollTo({top: 0, behavior: 'smooth'});
}

function showLevel3(){
    var url = urlBase+'/test/level'
    const test = document.getElementById("level3").value;

    $.ajax({
        type: 'POST',
        url: url,
        data:{
            prueba: test,
            level: 3,
            apartado: apartado
        },
        success: [function (data){
            $("#tester").html(data);
        },
            function (){
                container.style.display = "flex";
                body.style.display = "none";
            }],
        error: [function () {

        }]
    })

    window.scrollTo({top: 0, behavior: 'smooth'});
}

function showLevel4(){
    var url = urlBase+'/test/level'
    const test = document.getElementById("level4").value;

    $.ajax({
        type: 'POST',
        url: url,
        data:{
            prueba: test,
            level: 4,
            apartado: apartado
        },
        success: [function (data){
            $("#tester").html(data);
        },
            function (){
                container.style.display = "flex";
                body.style.display = "none";
            }],
        error: [function () {

        }]
    })

    window.scrollTo({top: 0, behavior: 'smooth'});

}

function showLevel(nivel){
    const url = urlBase+'/test/level'


    $.ajax({
        type: 'POST',
        url: url,
        data:{
            prueba: nivel,
            level: 4,
            apartado: apartado
        },
        success: [function (data){
            $("#tester").html(data);
        },
            function (){
                container.style.display = "flex";
                body.style.display = "none";
            }],
        error: [function () {

        }]
    })

    window.scrollTo({top: 0, behavior: 'smooth'});

}



    window.onbeforeunload = function (){
        if( body.style.display === 'none'){
            return confirm("¿Seguro que quieres recargar la página? Se contará como un intento y los datos no serán guardados.",
                {confirmButtom:"Aceptar", cancelButtom: "Cancelar"}
            );
        }

}


