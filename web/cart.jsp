<%--
  Created by IntelliJ IDEA.
  User: aaron
  Date: 2/23/17
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Hello World</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<h1>View Cart</h1>
	<div class="table-responsive">
		<table class="table table-striped table-hover">
			<caption>View items in your cart</caption>
			<thead>
				<tr>
					<th>SKU #</th>
					<th>Name</th>
					<th>Quality</th>
					<th>Unit Price</th>
					<th>Total Price</th>
				</tr>
			</thead>
			<c:set scope="page" value="0" var="totalPrice" />

			<c:forEach var="cartItem" items="${cart.get_cartItems()}">
				<c:set scope="page" value="${inventory.getItemBySku(cartItem.key)}" var="item" />
				<tr>
					<td>${cartItem.key}</td>
					<td>${item.getName()} </td>
					<td>${cartItem.value}</td>
					<td><fmt:formatNumber value="${item.getPrice()}" type="currency" /></td>
					<td><fmt:formatNumber value="${item.getPrice()*cartItem.value}" type="currency" /></td>
					<c:set scope="page" value="${totalPrice=totalPrice+item.getPrice()*cartItem.value}" var="totalPrice" />
				</tr>
			</c:forEach>
			<tr>
				<th colspan="4">Totals:</th>
				<td><fmt:formatNumber value="${totalPrice}" type="currency" /></td>
			</tr>
		</table>
	</div>
	<a class="btn btn-default" href="${pageContext.request.contextPath}" role="button">Continue Shopping</a>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
