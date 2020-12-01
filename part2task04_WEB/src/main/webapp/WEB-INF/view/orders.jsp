<%--
  Created by IntelliJ IDEA.
  User: elizaveta
  Date: 01.12.2020
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Orders list</title>
    <link href="/resources/core/css/table.css" rel="stylesheet"/>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Date</th>
        <th>Login</th>
        <th>Email</th>
        <th>Telephone</th>
        <th>Country</th>
        <th>City</th>
        <th>Street</th>
        <th>Apartment number</th>
        <th>House number</th>
        <th>Amount</th>
        <th>Type</th>
        <th>Price</th>
        <th>Product name</th>
        <th>Product country</th>
    </tr>
    </thead>
    <c:forEach var="order" items="${orders}">
        <tbody>
        <tr>
            <td><c:out value="${order.id}"/></td>
            <td><c:out value="${order.date}"/></td>

            <td><c:out value="${order.person.login}"/></td>
            <td><c:out value="${order.person.email}"/></td>
            <td><c:out value="${order.person.telephone}"/></td>

            <td><c:out value="${order.person.address.country}"/></td>
            <td><c:out value="${order.person.address.city}"/></td>
            <td><c:out value="${order.person.address.street}"/></td>
            <td><c:out value="${order.person.address.apartment_number}"/></td>
            <td><c:out value="${order.person.address.house_number}"/></td>

            <c:forEach items="${order.products}" var="product" varStatus="status">
                <td>${product.amount}</td>
                <td>${product.productItem.type}</td>
                <td>${product.productItem.price}</td>
                <td>${product.productItem.producer.name}</td>
                <td>${product.productItem.producer.country}</td>
            </c:forEach>
        </tr>
        </tbody>
    </c:forEach>

</table>
</body>
</html>
