<%@ page import="java.util.*,com.bank.model.Customer" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        h1 {
            margin: 0;
        }
        .header {
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

       
        .dashboard-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin: 50px auto;
            gap: 30px;
            max-width: 1000px;
        }

        
        .card {
            background-color: white;
            width: 220px;
            height: 150px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.2);
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 18px;
            font-weight: bold;
            color: #333;
            text-align: center;
            cursor: pointer;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            text-decoration: none;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 12px rgba(0,0,0,0.3);
        }

        .card-blue { border-top: 5px solid #2196F3; }
        .card-green { border-top: 5px solid #4CAF50; }
        .card-orange { border-top: 5px solid #FF9800; }
        .card-purple { border-top: 5px solid #9C27B0; }
        .card-red { border-top: 5px solid #f44336; }

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
        <h1>Welcome! ${admin.name}</h1>
        <form action="${pageContext.request.contextPath}/admin/login">
            <button class="logout-btn">Logout</button>
        </form>
    </div>

    <!-- DashBoard Options -->
    <div class="dashboard-container">
        <a href="${pageContext.request.contextPath}/admin/registerCustomer" class="card card-green">Create Customer Account</a>
        <a href="${pageContext.request.contextPath}/admin/customers" class="card card-blue">View Customers</a>
        <a href="${pageContext.request.contextPath }/admin/reviewLoans" class="card card-orange">Review & Approve Loans</a>
        <a href="${pageContext.request.contextPath}/admin/transactions" class="card card-purple">View Transactions</a>
        <a href="generateReports.jsp" class="card card-red">Generate Reports</a>
    </div>

</body>
</html>





