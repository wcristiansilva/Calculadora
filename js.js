const resultado = document.getElementById('resultado');

function Calculator(params) {

    if (params == '+' || params == '-' || params == '*' || params == '/' || params == '.' || params == '1' || params == '2' ||
        params == '3' || params == '4' || params == '5' || params == '6' || params == '7' || params == '8' || params == '9' || params == '0') {

        resultado.innerHTML += params;
    }

    if (params == 'C') {

        resultado.innerHTML = '';
    }

    if (params == '<') {

        let result = document.getElementById('resultado').innerHTML;
        resultado.innerHTML = result.substring(0, result.length - 1);
    }

    if (params == '=') {

        try {
            if (resultado !== 'Error') {
                let aux = eval(resultado.innerHTML);
                if (aux == Infinity || aux == -Infinity || isNaN(aux) || aux == undefined || aux == null) {
                    resultado.innerHTML = document.getElementById('resultado').innerHTML = '';
                } else {
                    resultado.innerHTML = aux;
                }
            }    
        } catch (error) {
            resultado.innerHTML = document.getElementById('resultado').innerHTML = '';
        }
    }
}