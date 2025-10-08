<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Customer</title>
    <style>
        body { font-family: Arial; background-color: #f5f5f5; margin:0; padding:0; }
        .container { background-color:white; width:400px; margin:50px auto; padding:30px; border-radius:10px; box-shadow:0 2px 8px rgba(0,0,0,0.3);}
        h2 { text-align:center; color:#2196F3; margin-bottom:20px; }
        label { margin-top:10px; display:block; }
        input, select { width:100%; padding:8px; margin-bottom:15px; border-radius:5px; border:1px solid #ccc; }
        .btn-group { text-align:center; }
        .btn { padding:10px 20px; border:none; border-radius:5px; margin:5px; cursor:pointer; }
        .btn-save { background-color:#4CAF50; color:white; }
        .btn-cancel { background-color:#f44336; color:white; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Edit Customer</h2>
        <form action="updateCustomer" method="post">
            <label>Account Number</label>
            <input type="text" name="accountNo" value="<%= request.getAttribute("accountNo") %>" readonly>

            <label>Name</label>
            <input type="text" name="name" value="<%= request.getAttribute("name") %>" required>

            <label>Email</label>
            <input type="email" name="email" value="<%= request.getAttribute("email") %>" required>

            <label>Phone Number</label>
            <input type="text" name="phone" value="<%= request.getAttribute("phone") %>" required>

            <label>Address</label>
            <input type="text" name="address" value="<%= request.getAttribute("address") %>">

            <label>Account Type</label>
            <select name="accountType">
                <option value="Savings" <%= "Savings".equals(request.getAttribute("accountType")) ? "selected" : "" %>>Savings</option>
                <option value="Current" <%= "Current".equals(request.getAttribute("accountType")) ? "selected" : "" %>>Current</option>
            </select>

            <label>Balance</label>
            <input type="number" name="balance" value="<%= request.getAttribute("balance") %>">

            <label>Status</label>
            <select name="status">
                <option value="Active" <%= "Active".equals(request.getAttribute("status")) ? "selected" : "" %>>Active</option>
                <option value="Inactive" <%= "Inactive".equals(request.getAttribute("status")) ? "selected" : "" %>>Inactive</option>
                <option value="Closed" <%= "Closed".equals(request.getAttribute("status")) ? "selected" : "" %>>Closed</option>
            </select>

            <div class="btn-group">
                <button type="submit" class="btn btn-save">Save</button>
                <button type="button" onclick="window.location.href='adminDashboard.jsp'" class="btn btn-cancel">Cancel</button>
            </div>
        </form>
    </div>
</body>
</html>
    