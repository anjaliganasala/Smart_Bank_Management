<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>

<style>
    /* ===== Reset & Global Styles ===== */
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
        background: linear-gradient(135deg, #e3f2fd, #ffffff);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    /* ===== Container Card ===== */
    .reset-container {
        background: #fff;
        width: 380px;
        padding: 2rem 2.5rem;
        border-radius: 12px;
        box-shadow: 0 6px 20px rgba(0, 0, 0, 0.12);
        text-align: center;
    }

    h3 {
        font-size: 1.7rem;
        font-weight: 600;
        color: #1976d2;
        margin-bottom: 1.5rem;
    }

    /* ===== Error Message ===== */
    .error-msg {
        font-size: 0.95rem;
        color: #c62828;
        margin-bottom: 1rem;
        background: #ffebee;
        padding: 8px;
        border-radius: 6px;
        border: 1px solid #ffcdd2;
        display: ${empty error ? 'none' : 'block'};
    }

    /* ===== Form Styling ===== */
    form {
        display: flex;
        flex-direction: column;
        gap: 1rem;
        text-align: left;
    }

    label {
        font-size: 0.9rem;
        font-weight: 500;
        color: #555;
        margin-bottom: 4px;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        font-size: 1rem;
        border: 1px solid #ccc;
        border-radius: 6px;
        outline: none;
        transition: border-color 0.3s ease-in-out;
    }

    input[type="text"]:focus,
    input[type="password"]:focus {
        border-color: #1976d2;
    }

    /* ===== Submit Button ===== */
    input[type="submit"] {
        background: #1976d2;
        color: #fff;
        padding: 10px 0;
        font-size: 1rem;
        font-weight: 600;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: background 0.3s ease-in-out;
        margin-top: 0.5rem;
    }

    input[type="submit"]:hover {
        background: #0d47a1;
    }

    /* ===== Responsive ===== */
    @media screen and (max-width: 480px) {
        .reset-container {
            width: 90%;
            padding: 1.5rem;
        }

        h3 {
            font-size: 1.4rem;
        }
    }
</style>

</head>
<body>
    <div class="reset-container">
        <h3>Reset Password</h3>

        <p class="error-msg">${error}</p>

        <form action="${pageContext.request.contextPath}/customer/reset" method="post">
            <div>
                <label>Enter OTP:</label>
                <input type="text" name="otp" placeholder="Enter the OTP" required>
            </div>
            <div>
                <label>New Password:</label>
                <input type="password" name="newPass" placeholder="Enter new password" required>
            </div>
            <div>
                <label>Re-Enter Password:</label>
                <input type="password" name="rePass" placeholder="Re-enter new password" required>
            </div>
            
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
