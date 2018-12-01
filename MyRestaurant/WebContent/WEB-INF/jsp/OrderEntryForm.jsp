<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "Header.jsp" %>
<%@ page import="java.util.ArrayList"%> 

<h2>Shopping Cart</h2>

<c:if test = "${isInvalidOrder}">
	<div><p>Invalid order, please resubmit your order.</p></div>		
</c:if>

<form:form modelAttribute="order" method="post" action="purchase/submitItems">
    <table id="t01" class="table table-hover">
    	<tr>
    		<th scope="col">Item name</th>
    		<th scope="col">Preview</th>
    		<th scope="col">Price</th>
    		<th scope="col">Quantity</th>
  		</tr>
		<c:forEach items="${order.items}" var="item" varStatus="loop">
			<tr>
				<td id="rowName"><c:out value="${item.itemName}"></c:out></td>
			    <td><img src="/MyRestaurant/css/${item.itemName}.jpg" height="145" width="200"></img></td>
				<td><c:out value = "$${itemPrices[loop.index]}0"></c:out></td>
				<td><form:input path="items[${loop.index}].quantity" /></td>
				<form:hidden path="items[${loop.index}].itemId" value="${item.itemId}"/>
				<form:hidden path="items[${loop.index}].itemName" value="${item.itemName}"/>
			</tr>
		</c:forEach>
    </table>
    <br> </br>
    <table id="t01" class="table table-hover">
        <tr>
			<td id="rowName"><c:out value="Name"></c:out></td>
			<td><form:input path="customerName" /></td>											
    	</tr>
    	
    	<tr>
			<td id="rowName"><c:out value="Email Address"></c:out></td>
			<td><form:input path="emailAddress" /></td>											
    	</tr>
    </table>
    <td colspan="2"><input type="submit" value="Purchase"></td>
</form:form>

<%@ include file = "Footer.jsp" %>