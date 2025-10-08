<%@ page import="java.util.*" import="com.bank.model.Loan" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>View Loans</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            margin: 30px 0;
            color: #2196F3;
        }
        .table-container {
            max-width: 90%;
            margin: auto;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.2);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            font-size: 15px;
        }
        th, td {
            padding: 12px 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #2196F3;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        a.details-link {
            color: #4CAF50;
            text-decoration: none;
            font-weight: bold;
        }
        a.details-link:hover {
            text-decoration: underline;
        }
        .back-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #f44336;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .back-btn:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
<%
    List<Loan> loans = (List<Loan>) request.getAttribute("loans");
%>

<h1>Loan List</h1>

<div class="table-container">
    <table>
        <tr>
            <th>LoanAccountNumber</th>
            <th>Amount</th>
            <th>Loan Type</th>
            <th>Tenure(Months)</th>
            <th>status</th>
            
        </tr>
        <%-- Replace this block with dynamic rows from DB --%>
        	<%
			if(loans!=null){
				for(Loan loan:loans){
			%>
			<tr>
				<td><%= loan.getLoanAccountNumber() %></td>
				<td><%= loan.getAmount() %></td>
				<td><%= loan.getLoan_type() %></td>
				<td><%= loan.getTenureMonths() %></td>
				<td><%= loan.getStatus() %></td>
			</tr>
			<%
				}
			}
			%>
    </table>

    <a href="${pageContext.request.contextPath}/customer/dashboard" class="back-btn">Back</a>
</div>
</body>
</html>