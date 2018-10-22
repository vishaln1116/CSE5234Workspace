<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "Header.jsp" %>
<%@ page import="java.util.ArrayList"%> 

<h2>Shopping Cart</h2>

<c:if test = "${isInvalidOrder}">
	<div><p>Invalid order, please resubmit your order.</p></div>		
</c:if>

<form:form modelAttribute="order" method="post" action="purchase/submitItems">
    <table id="t01">
    	<tr>
    		<th>Item name</th>
    		<th>Price</th>
    		<th>Quantity</th>
  		</tr>
		<c:forEach items="${order.items}" var="item" varStatus="loop">
			<tr>
				<td><c:out value="${item.itemName}"></c:out></td>
				<td><%=((ArrayList<Double>)request.getAttribute("itemPrices")).get(0)%></td>
				<td><form:input path="items[${loop.index}].quantity" /></td>
				<form:hidden path="items[${loop.index}].itemName" value="${item.itemName}"/>
			</tr>
		</c:forEach>
    </table>
    <br> </br>
    <td colspan="2"><input type="submit" value="Purchase"></td>
</form:form>

<%@ include file = "Footer.jsp" %>