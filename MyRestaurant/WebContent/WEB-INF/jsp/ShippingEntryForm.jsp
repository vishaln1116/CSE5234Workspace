<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "Header.jsp" %>

<h2>Choose Your Shipment address</h2>

<form:form modelAttribute="shipping" method="post" action="purchase/submitShipping">
    <table id="t01">
    		<tr>
    			<th colspan="2">Shipment info</th>
  			</tr>
			<tr>
				<td><c:out value="Name"></c:out></td>
				<td><form:input path="name" /></td>											
			</tr>
			
			<tr>
				<td><c:out value="Address Line 1"></c:out></td>
				<td><form:input path="addressLine1" /></td>									
			</tr>
			
			<tr>
				<td><c:out value="Address Line 2"></c:out></td>
				<td><form:input path="addressLine2" /></td>									
			</tr>
			
			<tr>
				<td><c:out value="City"></c:out></td>
				<td><form:input path="city" /></td>										
			</tr>
			
			<tr>
				<td><c:out value="State"></c:out></td>
				<td><form:input path="state" /></td>											
			</tr>	
			
			<tr>
				<td><c:out value="Zip"></c:out></td>
				<td><form:input path="zip" /></td>									
			</tr>
    </table>
    <br> </br>
    <td colspan="2"><input type="submit" value="Submit"></td>
</form:form>

<%@ include file = "Footer.jsp" %>