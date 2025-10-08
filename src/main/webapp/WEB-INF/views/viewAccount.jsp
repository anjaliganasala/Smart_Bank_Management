<%@ page import="java.util.*, com.bank.model.Account,com.bank.model.BankTransactions" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Account Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            margin: 30px 0 10px 0;
            color: #4CAF50;
        }
       .container {
		    justify-content: center; 
		    display:flex;       
		    gap: 20px;                      
		    margin-top: 50px;  
		    margin-bottom: 30px              
			}
		
		.account-info {
		    max-width: 500px;                   
		    padding: 15px;
		    background-color: #f9f9f9;
		    border: 1px solid #ddd;
		    border-radius: 8px;
		    box-shadow: 0 4px 6px rgba(0,0,0,0.1);
		    font-family: Arial, sans-serif;
		}
		
		.info-row {
		    margin: 10px 0;
		    max-width:500px
		    font-size: 16px;
		}
        .info-row strong {
            width: 180px;
            display: inline-block;
            color: #555;
        }

        .table-container {
            max-width: 900px;
            margin: 0 auto 40px auto;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.2);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            font-size: 14px;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }

        .back-btn {
            display: block;
            text-align: center;
            width: 150px;
            margin: 20px auto;
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

<h1>Account Details</h1>
<% Account account=(Account)session.getAttribute("account");%>
<!-- Customer & Account Summary -->
<div class="container">
	<div class="account-info">
    <div class="info-row"><strong>Customer Name:</strong> <%= account.getCustomer().getName() %></div>
    <div class="info-row"><strong>Account Number:</strong> <%= account.getAccountNumber() %></div>
    <div class="info-row"><strong>Account Type:</strong> <%= account.getAccountType() %></div>
    <div class="info-row"><strong>Current Balance:</strong> ₹<%= account.getBalance() %></div>
	</div>
	<div class="account-info">
   		<div class="info-row"><strong>Manage Balance</strong></div>
   		<div class="info-row">
   			<form action="${pageContext.request.contextPath}/admin/account/<%= account.getCustomer().getCustomerId() %>" method="post">
   				<label for="transactionType">Choose Transaction Type:</label>
				<select id="transactionType" name="transactionType" required="required">
				  <option value="" disabled selected >-- Choose Type --</option>
				  <option value="debit">Debit</option>
				  <option value="credit">Credit</option>
				</select><br><br>
				<label for="transactionType">Enter Amount:</label>
				<input type="number" name="amount" min="1"/><br><br>
				<p style="color: ${not empty success ? 'green' : 'red'}">${not empty success ? success : error}</p>
				<input type="submit" value="submit">
   			</form>
   		</div>
	</div>
</div>

<!-- Passbook Table -->
<div class="table-container">
	
    <table>
        <tr>
        	<th>TransactionId</th>
        	<th>Amount</th>
            <th>Date</th>
            <th>status</th>
            <th>Time</th>
            <th>TransactionType</th>
        </tr>

        <%if(account!=null){
        	List<BankTransactions> transactions=account.getTransactions();
        	for(BankTransactions transaction:transactions){
        		
        	%>
        	<tr>
        		<td><%= transaction.getTransactionId()%></td>
        		<td><%= transaction.getAmount() %></td>
        		<td><%= transaction.getDate() %></td>
        		<td><%= transaction.getStatus()%></td>
        		<td><%= transaction.getTime() %></td>
        		<td><%= transaction.getTransactionType() %></td>
        	</tr>
        	
        <% 
        	}
        } %>
      
    </table>
</div>

<a href="${pageContext.request.contextPath}/admin/customers" class="back-btn">Back to Customers</a>

</body>
</html>
    