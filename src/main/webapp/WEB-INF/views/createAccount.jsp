<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Account - SmartBank</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f8;
        }

        header {
            background-color: #003366;
            color: white;
            padding: 20px 0;
            text-align: center;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        header h1 {
            margin: 0;
            font-size: 32px;
            letter-spacing: 1px;
        }

        .container {
            max-width: 400px;
            background-color: white;
            margin: 40px auto;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .container h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #003366;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            color: #333;
        }

        .form-group input,select {
            width: 100%;
            padding: 8px 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        .form-group input:focus {
            border-color: #003366;
            outline: none;
        }

        .submit-btn {
            width: 100%;
            background-color: #003366;
            color: white;
            padding: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
        }

        .submit-btn:hover {
            background-color: #0055a5;
        }

       input[type="date"] {
		    padding: 10px;
		    border-radius: 6px;
		    border: 1px solid #ccc;
		    font-size: 14px;
		}
    </style>
</head>
<body>

    <header>
        <h1>SmartBank</h1>
    </header>

    <div class="container">
        <h2>Create Account</h2>
        <form action="${pageContext.request.contextPath}/admin/createAccount" method="post">
            <div class="form-group">
                <label for="name">FullName:</label>
                <input type="text" id="name" name="name" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            
            <div class="form-group">
	            <label for="dob">Date of Birth *</label>
	            <input type="date" id="dob" name="dob" required="required">
        	</div>

            <div class="form-group">
                <label for="phone">Phone Number:</label>
                <input type="text" id="phone" name="phoneNumber" maxlength="10" required>
            </div>

            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>
            </div>
            
             <div class="form-group">
                <label for="accountType">accountType:</label>
                <select name="accountType" required>
		            <option value="SAVINGS">Savings</option>
		            <option value="CURRENT">Current</option>
		        </select><br><br>
            </div>

            <div class="form-group">
                <label for="email">Initial Balance:</label>
                <input type="number" id="balance" name="balance" required>
            </div>

            <div class="form-group">
                <label for="ifscCode">IFSC Code:</label>
                <input type="text" id="ifscCode" name="ifscCode" required>
            </div>

            <button type="submit" class="submit-btn">Create Account</button>
        </form>
        <button><a href="${pageContext.request.contextPath}/admin/dashboard" class="back-btn">Back</a></button>
    </div>
    

</body>
</html>

