<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Admin Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(to right, #2c3e50, #34495e);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .login-container {
            background: #ffffff;
            padding: 40px 30px;
            border-radius: 8px;
            box-shadow: 0 6px 15px rgba(0,0,0,0.2);
            width: 320px;
            text-align: center;
        }

        h2 {
            margin-bottom: 25px;
            color: #2c3e50;
        }

        label {
            display: block;
            text-align: left;
            font-weight: bold;
            margin-bottom: 5px;
            color: #555;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px 8px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 1em;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background: #27ae60;
            border: none;
            color: white;
            font-size: 1em;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background: #2ecc71;
        }

        .error {
            color: red;
            font-size: 0.9em;
            margin-bottom: 15px;
        }

        footer {
            position: absolute;
            bottom: 15px;
            width: 100%;
            text-align: center;
            color: white;
            font-size: 0.9em;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Admin Login</h2>

    <!-- Display error message if present -->
        <div class="error">${error}</div>

    <form action="${pageContext.request.contextPath}/admin/login" method="post">
        <label>Username:</label>
        <input type="text" name="email" placeholder="Enter username" required>

        <label>Password:</label>
        <input type="password" name="password" placeholder="Enter password" required>

        <input type="submit" value="Login">
    </form>
    <p>New User?<a href="${pageContext.request.contextPath }/admin/signUp">SignUp</a></p>
</div>

</body>
</html>
