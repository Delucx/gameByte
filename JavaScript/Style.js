document.querySelector('.signin').addEventListener('submit', function (event) {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if (!validateUsernameAndPassword(username, password)) {
        event.preventDefault();  // Prevent form submission if validation fails
    }
});

function validateUsernameAndPassword(username, password) {
    const usernameRegex = /^[a-zA-Z0-9]{5,15}$/;
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    let usernameValid = usernameRegex.test(username);
    let passwordValid = passwordRegex.test(password);

    const usernameError = document.getElementById('usernameError');
    const passwordError = document.getElementById('passwordError');

    usernameError.style.display = 'none';
    passwordError.style.display = 'none';

    if (!usernameValid) {
        usernameError.textContent = "Invalid username. It should be 5-15 characters long and contain only alphanumeric characters.";
        usernameError.style.display = 'block';
    }

    if (!passwordValid) {
        passwordError.textContent = "Invalid password. It should be at least 8 characters long, and include at least one uppercase letter, one lowercase letter, one digit, and one special character.";
        passwordError.style.display = 'block';
    }

    return usernameValid && passwordValid;
}