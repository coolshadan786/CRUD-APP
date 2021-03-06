<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<%@include file="./base.jsp" %>
</head>
<body background="pink">
	
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Change Product Details</h1>
			
				<form action="${pageContext.request.contextPath}/handle-product" method="post">
				
				<input type="hidden" value="${product.id }" name="id"/>
					<div class="form-group">
						<label for="name">Product Name</label>
						<input type="text" class="form-control" id="name" aria-describedby="emailHelp"
						name="name" placeholder="Enter the product name here"
						value="${product.name }"></input>
						
					</div>
					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea class="form-control" name="description" id="description" rows="5"
						 placeholder="Enter the product description">${product.description }</textarea>
					
					</div>
					<div class="form-group">
						<label for="price">Product Price</label>
						<input type="text" class="form-control" id="price" aria-describedby="emailHelp"
						name="price" placeholder="Enter the product price" value="${product.price }"></input>	
					</div>
					
					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/"
							class="btn btn-outline-danger">Back</a>
							<button type="submit" class="btn btn-warning">Update</button>					
					</div>				
				</form>
			</div>	
		</div>
	</div>	
</body>
</html>