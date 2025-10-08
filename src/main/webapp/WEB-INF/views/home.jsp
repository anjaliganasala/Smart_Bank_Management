<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Welcome to Smart Banking</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #e8f0ff, #f8f9fa);
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            color: #333;
        }

        h1 {
            color: #d63031;
            font-size: 2.5em;
            margin-bottom: 15px;
            text-align: center;
        }

        h3 {
            font-size: 1.2em;
            color: #2c3e50;
            margin-bottom: 25px;
            text-align: center;
        }

        .login-options {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .login-link {
            display: flex;
            align-items: center;
            text-decoration: none;
            background: #ffffff;
            border: 2px solid #6c5ce7;
            color: #6c5ce7;
            font-weight: bold;
            font-size: 1.1em;
            padding: 10px 20px;
            margin: 10px;
            border-radius: 6px;
            width: 180px;
            justify-content: center;
            box-shadow: 0 3px 8px rgba(0,0,0,0.1);
            transition: 0.3s ease;
        }

        .login-link:hover {
            background: #6c5ce7;
            color: #ffffff;
            transform: translateY(-3px);
            box-shadow: 0 5px 12px rgba(0,0,0,0.2);
        }

        .icon {
            margin-right: 8px;
            font-size: 1.2em;
        }

        footer {
            position: absolute;
            bottom: 15px;
            font-size: 0.9em;
            color: #555;
        }
    </style>
</head>
<body>

    <h1>Welcome to Smart Banking</h1>
    <h3>Login As</h3>

    <div class="login-options">
        <a class="login-link" href="${pageContext.request.contextPath}/admin/login">
            <span class="icon">👔</span> Employer
        </a>
        <a class="login-link" href="${pageContext.request.contextPath}/customer/login">
            <span class="icon">👤</span> Customer
        </a>
    </div>

</body>
</html>
