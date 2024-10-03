document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission

    // Get student details
    const name = document.getElementById('name').value;
    const gender = document.getElementById('gender').value;
    const email = document.getElementById('email').value;
    const mobilenumber = document.getElementById('mobilenumber').value;
    const password = document.getElementById('password').value; // Note: don't display passwords
    const age = document.getElementById('age').value;

    // Create a new window/tab with registration details
    const newWindow = window.open('', '_blank');
    if (newWindow) {
        newWindow.document.write(`
            <html>
                <head>
                    <title>Registration Successful</title>
                </head>
                <body>
                    <h1>Registration Successful</h1>
                    <p>Name: ${name}</p>
                    <p>Gender: ${gender}</p>
                    <p>Email: ${email}</p>
                    <p>Mobile Number: ${mobilenumber}</p>
                    <p>Age: ${age}</p>
                    <p><strong>Password is not displayed for security reasons.</strong></p>
                </body>
            </html>
        `);
        newWindow.document.close(); // Close the document to finish rendering
    } else {
        alert('Please allow popups for this website');
    }
});