<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "Header.jsp" %>

<h1>Order confirmed!</h1>
<h3>Your order is on its way!</h3>

Your order number is <%= request.getSession().getAttribute("confirmationCode") %>


<table id="t01" class="table table-hover">
	<tr>
   		<th colspan="3" scope="col">Order Summary</th>
  	</tr>
	<c:forEach items="${order.items}" var="item" varStatus="loop">
		<tr>
			<td><c:out value="${item.itemName}"></c:out></td>
			<td><c:out value="${item.quantity}"></c:out></td>
		</tr>
	</c:forEach>
	
</table>
<table id="t01" class="table table-hover">	
	
</table>
<br> </br>
<table id="t01" class="table table-hover">	
	<tr>
   		<th colspan="2" scope="col">Shipment Address</th>
  	</tr>
	<tr>
		<td><c:out value="Shipping: Name"></c:out></td>
		<td><c:out value="${shipping.name}"></c:out></td>
	</tr>
	<tr>
		<td><c:out value="Shipping: Address Line 1"></c:out></td>
		<td><c:out value="${shipping.addressLine1}"></c:out></td>
	</tr>
	<tr>
		<td><c:out value="Shipping: Address Line 2"></c:out></td>
		<td><c:out value="${shipping.addressLine2}"></c:out></td>
	</tr>
	<tr>
		<td><c:out value="Shipping: City"></c:out></td>
		<td><c:out value="${shipping.city}"></c:out></td>
	</tr>
	<tr>
		<td><c:out value="Shipping: State"></c:out></td>
		<td><c:out value="${shipping.state}"></c:out></td>
	</tr>
	<tr>
		<td><c:out value="Shipping: Country"></c:out></td>
		<td><c:out value="${shipping.country}"></c:out></td>
	</tr>
	<tr>
		<td><c:out value="Shipping: Zip"></c:out></td>
		<td><c:out value="${shipping.zip}"></c:out></td>
	</tr>
</table>
<br> </br>
<table id="t01" class="table table-hover">	
	<tr>
   		<th colspan="2" scope="col">Payment Information</th>
  	</tr>
	<tr>
		<td><c:out value="Credit Card: Holder Name"></c:out></td>
		<td><c:out value="${payment.holderName}"></c:out></td>
	</tr>
	<tr>
		<td><c:out value="Credit Card: Number"></c:out></td>
		<td><c:out value="${payment.creditCard}"></c:out></td>
	</tr>
	<tr>
		<td><c:out value="Credit Card: Expiration Date"></c:out></td>
		<td><c:out value="${payment.expirationDate}"></c:out></td>
	</tr>
	<tr>
		<td><c:out value="Credit Card: CVV Code"></c:out></td>
		<td><c:out value="${payment.cvvCode}"></c:out></td>
	</tr>
</table>

<%@ include file = "Footer.jsp" %>