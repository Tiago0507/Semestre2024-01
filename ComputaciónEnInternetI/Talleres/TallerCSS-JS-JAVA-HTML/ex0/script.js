function sumar() {
    const numberInput1 = document.getElementById('numberInput1');
    const numberInput2 = document.getElementById('numberInput2');
    
    const number1 = parseFloat(numberInput1.value);
    const number2 = parseFloat(numberInput2.value);

    if (isNaN(number1) || isNaN(number2)) {
        alert("Ingresa un valor válido")
    } else {
        const outputDiv = document.getElementById('output')
        result = number1 + number2
        outputDiv.textContent = `La suma entre ${number1} y ${number2} es ${result}.`
    }
}

function restar() {
    const numberInput1 = document.getElementById('numberInput1');
    const numberInput2 = document.getElementById('numberInput2');
    
    const number1 = parseFloat(numberInput1.value);
    const number2 = parseFloat(numberInput2.value);

    if (isNaN(number1) || isNaN(number2)) {
        alert("Ingresa un valor válido")
    } else {
        const outputDiv = document.getElementById('output')
        result = number1 - number2
        outputDiv.textContent = `La resta entre ${number1} y ${number2} es ${result}.`
    }
}

function multiplicar() {
    const numberInput1 = document.getElementById('numberInput1');
    const numberInput2 = document.getElementById('numberInput2');
    
    const number1 = parseFloat(numberInput1.value);
    const number2 = parseFloat(numberInput2.value);

    if (isNaN(number1) || isNaN(number2)) {
        alert("Ingresa un valor válido")
    } else {
        const outputDiv = document.getElementById('output')
        result = number1 * number2
        outputDiv.textContent = `La multiplicación entre ${number1} y ${number2} es ${result}.`
    }
}

function dividir() {
    const numberInput1 = document.getElementById('numberInput1');
    const numberInput2 = document.getElementById('numberInput2');
    
    const number1 = parseFloat(numberInput1.value);
    const number2 = parseFloat(numberInput2.value);

    if (isNaN(number1) || isNaN(number2)) {
        alert("Ingresa un valor válido")
    } else if (number2 == 0){
        alert("La división entre 0 no está definida")
    } else {
        const outputDiv = document.getElementById('output')
        result = number1 / number2
        outputDiv.textContent = `La división entre ${number1} y ${number2} es ${result}.`
    }
}
