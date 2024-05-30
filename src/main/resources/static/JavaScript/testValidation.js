

function validateListening1 (){
    const dropContainer = document.querySelectorAll(".dropQuestion");
    let preguntasCorrectas = 0;

    for (let i = 0; i < dropContainer.length; i++){


        let respuestaEnElDrop = dropContainer[i].children[0].getAttribute('data-value');

        if (respuestaEnElDrop === 'true'){

            preguntasCorrectas ++;
        }
    }

    if (preguntasCorrectas > 5){
        submitApartado('listening1');
    } else {
        window.location.href = '/board'
    }

}