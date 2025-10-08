<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Customer Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: #f5f6fa;
            color: #333;
        }
         .header {
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        nav {
            background: #34495e;
            display: flex;
            justify-content: center;
        }
        nav a {
            color: white;
            padding: 12px 20px;
            text-decoration: none;
            font-weight: bold;
        }
        nav a:hover {
            background: #2c3e50;
        }
        .container {
            width: 80%;
            max-width: 900px;
            margin: 30px auto;
            background: white;
            padding: 25px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 8px;
        }
        h2 {
            text-align: center;
            color: #2c3e50;
        }
        .info {
            margin: 20px 0;
            font-size: 1.1em;
            line-height: 1.6em;
        }
        .info p {
            margin: 10px 0;
        }
        .btns {
            text-align: center;
            margin-top: 20px;
        }
        .btns a {
            display: inline-block;
            padding: 10px 20px;
            background: #27ae60;
            color: white;
            text-decoration: none;
            margin: 0 10px;
            border-radius: 4px;
        }
        .btns a:hover {
            background: #2ecc71;
        }
        footer {
            background: #2c3e50;
            color: white;
            text-align: center;
            padding: 10px 0;
            margin-top: 40px;
            font-size: 0.9em;
        }
        .logout-btn {
            padding: 10px 20px;
            background-color: #f44336;
            border: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }

        .logout-btn:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
 <!-- Header -->
    <div class="header">
        <h2>Welcome, ${customer.name}</h2>
        <form action="${pageContext.request.contextPath}/customer/login">
            <button class="logout-btn">Logout</button>
        </form>
    </div>
<div class="container">

    <div class="info">
        <p><strong>Account Number:</strong> ${account.accountNumber}</p>
        <p><strong>Current Balance:</strong> ₹${account.balance}</p>

    </div>

    <div class="btns">
        <a href="${pageContext.request.contextPath}/customer/tranferAmount">Transfer Funds</a>
        <a href="${pageContext.request.contextPath}/customer/transactions">View Mini Statement</a>
        <a href="${pageContext.request.contextPath }/customer/applyLoan">Apply for Loan</a>
        <a href="${pageContext.request.contextPath }/customer/viewLoans">viewLoans</a>
    </div>
</div>
</body>
</html>
