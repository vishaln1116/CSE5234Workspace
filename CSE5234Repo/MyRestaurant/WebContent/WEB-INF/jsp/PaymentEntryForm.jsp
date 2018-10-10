<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "Header.jsp" %>

<h2>Choose Your Payment Method</h2>

<form:form modelAttribute="payment" method="post" action="purchase/submitPayment">
    <table id="t01">
    		<tr>
    			<th colspan="2">Payment info</th>
  			</tr>
			<tr>
				<td><c:out value="Credit Card"></c:out></td>
				<td><form:input path="creditCard" /></td>											
			</tr>
			
			<tr>
				<td><c:out value="Expiration Date"></c:out></td>
				<td><form:input path="expirationDate" /></td>									
			</tr>
			
			<tr>
				<td><c:out value="CVV Code"></c:out></td>
				<td><form:input path="cvvCode" /></td>										
			</tr>
			
			<tr>
				<td><c:out value="Holder Name"></c:out></td>
				<td><form:input path="holderName" /></td>											
			</tr>	
    </table>
    <br> </br>
    <td colspan="2"><input type="submit" value="Submit"></td>
</form:form>
<%@ include file = "Footer.jsp" %>