

const calculator = (() => {
  const add = (a, b) => a + b;
  const sub = (a, b) => a - b;
  const mul = (a, b) => a * b;
  const div = (a, b) => a / b;
  return {
    add,
    sub,
    mul,
    div,
  };
})();






const operate = (a, b, operator) => {
  switch (operator) {
    case '+':
      return calculator.add(a, b);
      break;

    case '-':
      return calculator.sub(a, b);
      break;

    case 'x':
      return calculator.mul(a, b);
      break;

    case '/':
      if (b != 0) {
        return calculator.div(a, b);
      }
      else {
        display.textContent = "CAN'T DIVIDE BY 0";
      }
      break;
  }
}






const digits = document.getElementById('digits');
const display = document.getElementById('display-result');
const operators = document.getElementById('operators');
const equal = document.getElementById('equal');





const populateDisplay = (e) => {
  display.textContent += e.target.textContent;
  const displayNumber = parseFloat(display.textContent);
  return displayNumber;
}




digits.addEventListener('click', (e) => {
  if (e.target.textContent === '=' || e.target.textContent === 'C') {
    return;
  } else {
    if (display.textContent.length < 13 && display.textContent != 'TROPPO LUNGO')
      populateDisplay(e);
    operatorIsPressed = false;
  }
});




let firstNumber;
let secondNumber;
let operator;
let operatorIsPressed = true;




operators.addEventListener('click', (e) => {
  if (operatorIsPressed == false) {
    if (e.target.textContent === '.') {
      return;
    } else {
      let result;
      if (operator) {
        secondNumber = parseFloat(display.textContent);
        result = operate(firstNumber, secondNumber, operator);
        operator = e.target.textContent;
        display.textContent = result;
        firstNumber = result;
        display.textContent = '';
        operatorIsPressed = true;
      }
      else {
        firstNumber = parseFloat(display.textContent);
        operator = e.target.textContent;
        display.textContent = '';
        operatorIsPressed = true;
      }
    }
  }
})






equal.addEventListener('click', () => {
  if (operator != null) {
    let secondNumber = parseFloat(display.textContent);
    display.textContent = ''
    let result = operate(firstNumber, secondNumber, operator);
    if (!Number.isInteger(result)) {
      display.textContent = result.toFixed(8);
    } else {
      if (result > 9999999999999) {
        display.textContent = 'TROPPO LUNGO';
      }
      else {
        display.textContent = result;
      }
    }
    firstNumber = result;
    operator = null;
    secondNumber = null;
    operatorIsPressed = false;
  }
});






const clear = document.getElementById('clear');

clear.addEventListener('click', () => {
  firstNumber = null;
  secondNumber = null;
  operator = null;
  operatorIsPressed = true;
  display.textContent = '';
})





const float = document.getElementById('float');

float.addEventListener('click', (e) => {
  if (!display.textContent.includes('.'))
    display.textContent += e.target.textContent;

})
