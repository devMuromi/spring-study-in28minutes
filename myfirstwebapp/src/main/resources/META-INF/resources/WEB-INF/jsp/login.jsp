<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
Welcome to login page!
    <pre>
        ${errorMessage}
    </pre>
    <form method="post">
        <input type="text" name="name" placeholder="username">
        <input type="password" name="password" placeholder="password">
        <input type="submit" value="login">
    </form>
</body>
</html>