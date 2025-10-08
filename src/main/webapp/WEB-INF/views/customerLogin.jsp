<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Customer Login</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #2980b9, #6dd5fa);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
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
            color: #2c3e50;
            margin-bottom: 25px;
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
            transition: background 0.3s ease;
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
    <h2>Customer Login</h2>

    <!-- Error message placeholder -->
        <div class="error">${error}</div>

    <form action="${pageContext.request.contextPath}/customer/login" method="post">
        <label for="accountNumber">Account Number:</label>
        <input type="text" id="accountNumber" name="accountNumber" placeholder="Enter account number" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="pass" placeholder="Enter password" required>

        <input type="submit" value="Login">
    </form>
</div>


</body>
</html>
    