<%--
  Created by Aaron Fernandes.
  Comp 303 - Section 2
  Assignment 2
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<jsp:useBean id="inventory" scope="session" class="com.AaronFernandes.Assignment2.controllers.Inventory">--%>
	<%--<jsp:setProperty name="inventory" property="*" />--%>
<%--</jsp:useBean>--%>

<%--<c:set var="inventory" value="${inventory}"/>--%>
<%--<c:set var="inventory" value="${inventory}" scope="session" />--%>

<!DOCTYPE html>
<html>
  <head>
    <title>Cart Assignment</title>
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
		<h1>This is a form</h1>
		<div class="container-fluid">
			<div class="row">
			<c:forEach items="${inventory.get_items()}" var="item">
				<form action="cart" method="POST">
				<div class="col-md-5 col-xs-5">
					<h2><c:out value="${item.name}" /></h2>
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-3">
								<img style="width: 8em" class="img-thumbnail" src="<c:out value="${item.imgurl}" />">
							</div>
							<div class="col-md-9 text-left">
								<b>$<c:out value="${item.price}" /></b>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<p><c:out value="${item.description}" />&nbsp;<small>(sku: <c:out value="${item.sku}" />)</small></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label for="quantity">Select Quantity:</label>
								<input type="number" id="quantity" name="quantity" min="1" max="<c:out value="${item.stock}" />" required>
								<input type="hidden" name="sku" value="<c:out value="${item.sku}" />" required>
							</div>
							<div class="col-md-6">
								<input type="submit" value="Add to Cart"/>
							</div>
						</div>
					</div>
				</div>
				</form>
			</c:forEach>
				<div class="row">
		</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>
