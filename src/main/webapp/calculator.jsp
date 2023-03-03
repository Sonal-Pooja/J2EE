<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mortgage Calculator</title>
<style>
	form {
		position: relative;
		left: 400px;
		top: 50px;
		border: 1px solid grey;
		width: 400px;
		height: 300px;
	}
	body {
    	font-family: system-ui, system-ui, sans-serif ;
    	font-size: 120% ;
    	font-weight: bold ;
	}
	div {
		width:100%;
		 padding:1px;
	}
	input[type=submit], input[type=reset] {
		 background-color: darkblue;
		 border: 1px white;
		 border-style: double;
		 color: white;
		 padding: 8px 20px;
		 margin: 2px 2px;
		 cursor: pointer;
	}
	
</style>
</head>
<body>
	<form method="get" action="CalculatorServlet">
		<div style="color:darkblue; background-color:lightgrey; height: 35px;">
			Please enter the following information:
		</div><br>
		<div>
			Mortgage Amount:  <input type="text" name="amount"/><br><br>
			Interest Rate:    <input type="text" name="rate"/><br><br>
			Interest Term:    <input type="number" name="years" style="width:10%"/> Years  
			<input type="number" name="months" placeholder="0" style="width:10%"/> Months<br><br>
		</div><br>
		<div>	
			<input type="reset" value="Reset" style="margin-left:30px; margin-right: 100px;"/><input type="submit" value="Calculate"/>				
		</div>
	</form>	
</body>
</html>