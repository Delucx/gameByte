const form = document.getElementById('form');
const firstName = document.getElementById('firstName');
const lastName = document.getElementById('lastName');
const email = document.getElementById('email');
const number = document.getElementById('number');
const username = document.getElementById('username');
const password = document.getElementById('password');
const confirmPassword = document.getElementById('confirmPassword');
const step1Button = document.getElementById('step1NextButton');

// Initially hide step-2
document.getElementById('step-2').style.display = 'none';

form.addEventListener('submit', e => {
    e.preventDefault();
    // You can optionally validate all fields again before final submission
    validateInputs();
});

const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    errorDisplay.hidden = false;
    inputControl.classList.add('error');
    inputControl.classList.remove('success');
};

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    errorDisplay.hidden = true;
    inputControl.classList.add('success');
    inputControl.classList.remove('error');
};

const isValidEmail = email => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
};

const validatePhoneNumber = phoneNumber => {
    const phonePattern = /^\+?\d{1,4}[-.\s]?\(?\d{1,4}\)?[-.\s]?\d{1,4}[-.\s]?\d{1,4}[-.\s]?\d{1,9}$/;
    if (phonePattern.test(phoneNumber)) {
        const cleanedNumber = phoneNumber.replace(/\D/g, '');
        return cleanedNumber.length === 10;
    } else {
        return false;
    }
};


const isValidPassword = password => {
    const minLength = 8;
    const hasUpperCase = /[A-Z]/.test(password);
    const hasNumber = /\d/.test(password);
    const hasSpecialChar = /[!@#$%^&*(),.?":{}|<>]/.test(password);
    return password.length >= minLength && hasUpperCase && hasNumber && hasSpecialChar;
};

const validateStep1 = () => {
    const firstNameValue = firstName.value.trim();
    const lastNameValue = lastName.value.trim();
    const emailValue = email.value.trim();
    const numberValue = number.value.trim();

    let isValid = true;

    if (firstNameValue === '') {
        setError(firstName, 'First Name is required');
        isValid = false;
    } else {
        setSuccess(firstName);
    }

    if (lastNameValue === '') {
        setError(lastName, 'Last Name is required');
        isValid = false;
    } else {
        setSuccess(lastName);
    }

    if (emailValue === '') {
        setError(email, 'Email is required');
        isValid = false;
    } else if (!isValidEmail(emailValue)) {
        setError(email, 'Provide a valid email address');
        isValid = false;
    } else {
        setSuccess(email);
    }

    if (numberValue === '') {
        setError(number, 'Phone number is required');
        isValid = false;
    } else if (!validatePhoneNumber(numberValue)) {
        setError(number, 'Provide a valid phone number');
        isValid = false;
    } else {
        setSuccess(number);
    }

    if (isValid) {
        // If all inputs are valid, move to step-2
        document.getElementById('step-1').style.display = 'none';
        document.getElementById('step-2').style.display = 'block';
    }
};

const validateInputs = () => {
    const usernameValue = username.value.trim();
    const passwordValue = password.value.trim();
    const confirmPasswordValue = confirmPassword.value.trim();

    let isValid = true;

    if (usernameValue === '') {
        setError(username, 'Username is required');
        isValid = false;
    } else {
        setSuccess(username);
    }

    if (passwordValue === '') {
        setError(password, 'Password is required');
        isValid = false;
    } else if (!isValidPassword(passwordValue)) {
        setError(password, 'Password must be at least 8 characters long and contain at least one uppercase letter, one number, and one special character');
        isValid = false;
    } else {
        setSuccess(password);
    }

    if (confirmPasswordValue === '') {
        setError(confirmPassword, 'Please confirm your password');
        isValid = false;
    } else if (confirmPasswordValue !== passwordValue) {
        setError(confirmPassword, 'Passwords do not match');
        isValid = false;
    } else {
        setSuccess(confirmPassword);
    }

    // If all inputs on step-2 are valid, submit the form
    if (isValid) {
        form.submit();
    }
};

step1NextButton.addEventListener('click', () => {
    validateStep1();
});

function showNextPage() {
    // Validate step-1 before moving to step-2
    validateStep1();
}

function showPreviousPage() {
    document.getElementById('step-1').style.display = 'block';
    document.getElementById('step-2').style.display = 'none';
}
