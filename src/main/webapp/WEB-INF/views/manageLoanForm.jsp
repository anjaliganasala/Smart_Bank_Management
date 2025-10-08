<%@ page import="com.bank.model.Loan" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Loan Application Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f7fa;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 650px;
            margin: 40px auto;
            background: #ffffff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        .form-group {
            margin-bottom: 18px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 6px;
            color: #333;
        }

        input[type="text"],
        input[type="number"],
        input[type="date"],
        select,
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
            background: #fafafa;
            transition: border-color 0.3s ease;
        }

        input:focus,
        select:focus,
        textarea:focus {
            border-color: #4a90e2;
            outline: none;
            background: #fff;
        }

        textarea {
            resize: vertical;
            height: 70px;
        }

        .checkbox-group {
            display: flex;
            align-items: center;
            margin-top: 10px;
        }

        .checkbox-group input[type="checkbox"] {
            margin-right: 10px;
        }

    </style>
</head>
<body>

<div class="container">
	<%  Loan loan=(Loan)request.getAttribute("loan"); %>
    <h2>Review Loan Application</h2>
    <form action="${pageContext.request.contextPath }/admin/reviewLoans" method="post">

        <!-- Customer Details -->
        <div class="form-group">
            <label for="fullName">Full Name</label>
            <input type="text" id="fullName" name="fullName" value="${loan.customer.name }" readonly="readonly">
        </div>

        <div class="form-group">
            <label for="dob">Date of Birth</label>
            <input type="date" id="dob" name="dob"  value="${loan.customer.dob }" readonly="readonly">
        </div>

        <div class="form-group">
            <label for="phone">Contact Number</label>
            <input type="text" id="phone" name="phone" maxlength="10"  value="${loan.customer.phoneNumber }" readonly="readonly">
        </div>

        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" id="address" name="address"  value="${loan.customer.address }" readonly="readonly"/>
        </div>

        <!-- Loan Details -->
        <div class="form-group">
            <label for="loanType">Loan Type</label>
            <input type="text" id="loanType" name="loanType"  value="${loan.loan_type}" readonly="readonly"/>
        </div>

        <div class="form-group">
            <label for="amount">Loan Amount (₹)</label>
            <input type="number" id="amount" name="amount" value="${loan.amount}" readonly="readonly">
        </div>

        <div class="form-group">
            <label for="tenure">Tenure (Months)</label>
            <input type="number" id="tenure" name="tenure" value="${loan.tenureMonths}" readonly="readonly">
        </div>
        
	     <!-- Approve button -->
    <button type="submit"
            name="action"
            class="btn-submit"
            value="approve"
            ${loan.status != 'PENDING' ? 'disabled hidden' : ''}>
        Approve
    </button>

    <!-- Reject button -->
    <button type="submit"
            name="action"
            class="btn-submit"
            value="reject"
            ${loan.status != 'PENDING' ? 'disabled hidden' : ''}>
        Reject
    </button>
	 <button><a href="${pageContext.request.contextPath }/admin/reviewLoans" >back</a></button>
    <!-- Status button (shows only after a decision) -->
    <button type="button"
            disabled
            ${loan.status == 'PENDING' ? 'hidden' : ''}>
        ${loan.status}
    </button>
    </form>
</div>

</body>
</html>
    