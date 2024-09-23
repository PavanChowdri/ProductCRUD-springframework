<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Change the product detail</h1>
				<form action="${pageContext.request.contextPath }/handle-product"
					method="post">
					<div class="mb-3">
						<input type="hidden" class="form-control" name="id"
							placeholder="enter the product id" value="${product.id }">
					</div>
					<div class="mb-3">
						<label for="name" class="form-label">ProductName </label> <input
							type="text" class="form-control" name="name"
							placeholder="enter the product name" value="${product.name }">
					</div>
					<div class="mb-3">
						<label for="description" class="form-label">Product
							Description</label>
						<textarea class="form-control" name="description" rows="5"
							placeholder="Enter the product description">${product.description }</textarea>
					</div>
					<div class="mb-3">
						<label for="price" class="form-label">Price</label> <input
							type="text" placeholder="Enter the product price"
							class="form-control" value="${product.price }" name="price">
					</div>

					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-warning">update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>