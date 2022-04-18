/* function insert(params) {
    resultado.innerHTML += params 
}

function clean(){
    resultado.innerHTML = ''
}
function back() {
    if (resultado.textContent) {
        let result = document.getElementById('resultado').innerHTML
        resultado.innerHTML = result.substring(0, result.length - 1)
    }
}

function calcula() {
    if(resultado.textContent != 'Erro'){
        document.getElementById('resultado').innerHTML = eval(resultado.innerHTML)
    }
} */

function Calculator(params) {
    var result = params;
    if (result !== undefined && result !== null && result !== '' && result !== 'Erro') {
    }
    if (result == '+' || result == '-' || result == '*' || result == '/' || result == '.' || result == '1' || 
    result == '2' || result == '3' || result == '4' || result == '5' || result == '6' || result == '7' || result == '8' || result == '9' || result == '0' ){
    resultado.innerHTML += result;
    }

    if (result == 'C'){
        resultado.innerHTML = '';
    }
    
    if (result == '<'){
        let result = document.getElementById('resultado').innerHTML;
        resultado.innerHTML = result.substring(0, result.length - 1);
    }

    if (result == '='){
        if(resultado.textContent != 'Erro'){
            document.getElementById('resultado').innerHTML = eval(resultado.innerHTML);
        }
    }

    
}