<%@ page import="com.bank.model.Account" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Money Transfer</title>

<style>
    /* Global Reset & Font */
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
        background: linear-gradient(135deg, #e0f7fa, #ffffff);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    /* Card Container */
    .transfer-container {
        background: #fff;
        padding: 2rem 2.5rem;
        border-radius: 12px;
        box-shadow: 0 6px 20px rgba(0, 0, 0, 0.1);
        width: 400px;
        text-align: center;
    }

    h2 {
        margin-bottom: 1.5rem;
        font-size: 1.8rem;
        color: #00796b;
        font-weight: 600;
    }

    /* Status Message */
    .status-message {
        margin-bottom: 1rem;
        font-size: 1rem;
        font-weight: 500;
        padding: 10px;
        border-radius: 6px;
        display: inline-block;
        min-height: 24px;
    }

    /* Form Styling */
    form {
        display: flex;
        flex-direction: column;
        gap: 1rem;
        text-align: left;
    }

    label {
        font-size: 0.95rem;
        font-weight: 500;
        color: #555;
        margin-bottom: 4px;
    }

    input[type="text"],
    input[type="number"] {
        width: 100%;
        padding: 10px;
        font-size: 1rem;
        border: 1px solid #ccc;
        border-radius: 6px;
        outline: none;
        transition: border-color 0.3s ease-in-out;
    }

    input[type="text"]:focus,
    input[type="number"]:focus {
        border-color: #00796b;
    }

    /* Buttons */
    input[type="submit"] {
        background: #00796b;
        color: #fff;
        padding: 10px 0;
        font-size: 1rem;
        font-weight: 600;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: background 0.3s ease-in-out;
    }

    input[type="submit"]:hover {
        background: #004d40;
    }

    .back-btn {
        display: inline-block;
        text-align: center;
        text-decoration: none;
        background: #f5f5f5;
        color: #555;
        padding: 10px 0;
        font-size: 1rem;
        font-weight: 600;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: background 0.3s ease-in-out, color 0.3s ease-in-out;
    }

    .back-btn:hover {
        background: #e0e0e0;
        color: #000;
    }

    /* Status Colors */
    .success {
        background: #e8f5e9;
        color: #2e7d32;
        border: 1px solid #a5d6a7;
    }

    .error {
        background: #ffebee;
        color: #c62828;
        border: 1px solid #ef9a9a;
    }

    .warning {
        background: #fff8e1;
        color: #f9a825;
        border: 1px solid #ffe082;
    }
</style>
</head>
<body>
    <div class="transfer-container">
        <h2>Fund Transfer</h2>
        
        <p class="status-message
            ${status == 'Amount Transfer Success!!' ? 'success' : 
              (status == 'Insufficient Balance' ? 'error' : 
              (status == 'No Receiver Account Found!!' ? 'warning' : ''))}">
            ${status}
        </p>

        <form action="${pageContext.request.contextPath }/customer/transferAmount" method="post">
            <div>
                <label>Your Account No:</label>
                <input type="text" value="${account.accountNumber }" name="senderNo" readonly="readonly">
            </div>
            <div>
                <label>Available Balance:</label>
                <input type="text" value="${account.balance }" name="availableBalance" readonly="readonly">
            </div>
            <div>
                <label>Receiver Account No:</label>
                <input type="text" name="receiverNo" required>
            </div>
            <div>
                <label>Enter Amount:</label>
                <input type="number" name="transferAmount" min="1" required>
            </div>

            <input type="submit" value="Transfer">
            <a class="back-btn" href="${pageContext.request.contextPath }/customer/dashboard">Back</a>
        </form>
    </div>
</body>
</html>
