<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@include file="./base.jsp"%>

</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mt-3">Welcome to Product App</h1>

				<table class="table mt-5">
					<thead class="table-dark">
						<tr>
							<th scope="col">id</th>
							<th scope="col">Product Name</th>
							<th scope="col">Product Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>

						</tr>
					</thead>
					<tbody>
					<c:forEach items="${product }" var="p">
						<tr>
							<th scope="row">${p.id }</th>
							<td>${p.name }</td>
							<td>${p.description }</td>
							<td class="fw-bold">&#8377; ${p.price }</td>
							<td><a href="delete/${p.id }"><i class="fa-solid fa-trash-can text-danger"></i></a>
							<a href="update/${p.id }"><i class="fa-solid fa-pen-to-square"></i></a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="container text-center mt-5">
					<a href="add_product" class="btn btn-outline-success">Add
						product</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
