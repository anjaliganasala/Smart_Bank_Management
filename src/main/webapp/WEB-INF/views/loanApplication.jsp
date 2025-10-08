<%@ page import="com.bank.model.Customer" language="java" contentType="text/html; charset=UTF-8"
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

        .btn-submit {
            display: block;
            width: 100%;
            background: #4a90e2;
            color: #fff;
            padding: 12px 0;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        .btn-submit:hover {
            background: #357abd;
        }

    </style>
</head>
<body>

<div class="container">
	<%  Customer customer=(Customer)request.getAttribute("customer"); %>
    <h2>Loan Application Form</h2>
    <form action="${pageContext.request.contextPath }/customer/applyLoan" method="post">

        <!-- Customer Details -->
        <div class="form-group">
            <label for="fullName">Full Name *</label>
            <input type="text" id="fullName" name="fullName" value="${customer.name }" readonly="readonly">
        </div>

        <div class="form-group">
            <label for="dob">Date of Birth *</label>
            <input type="date" id="dob" name="dob"  value="${customer.dob }" readonly="readonly">
        </div>

        <div class="form-group">
            <label for="phone">Contact Number *</label>
            <input type="text" id="phone" name="phone" maxlength="10"  value="${customer.phoneNumber }" readonly="readonly">
        </div>

        <div class="form-group">
            <label for="address">Address *</label>
            <input type="text" id="address" name="address"  value="${customer.address }" readonly="readonly"/>
        </div>

        <!-- Loan Details -->
        <div class="form-group">
            <label for="loanType">Loan Type *</label>
            <select id="loanType" name="loanType" required>
                <option value="">--Select--</option>
                <option value="Personal">Personal Loan</option>
                <option value="Home">Home Loan</option>
                <option value="Vehicle">Vehicle Loan</option>
                <option value="Education">Education Loan</option>
            </select>
        </div>

        <div class="form-group">
            <label for="amount">Loan Amount (₹) *</label>
            <input type="number" id="amount" name="amount" min="1000" required>
        </div>

        <div class="form-group">
            <label for="tenure">Tenure (Months) *</label>
            <input type="number" id="tenure" name="tenure" min="1" required>
        </div>

        <!-- Declaration -->
        <div class="form-group checkbox-group">
            <input type="checkbox" id="declaration" name="declaration" required>
            <label for="declaration" style="font-weight: normal;">I confirm that the above details are correct.</label>
        </div>

        <button type="submit" class="btn-submit">Submit Application</button>
    </form>
</div>

</body>
</html>
    