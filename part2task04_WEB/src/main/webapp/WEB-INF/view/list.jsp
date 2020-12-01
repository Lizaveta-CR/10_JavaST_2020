<%--
  Created by IntelliJ IDEA.
  User: elizaveta
  Date: 30.11.2020
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Flowers List</title>
    <link href="/resources/core/css/table.css" rel="stylesheet"/>
    <%--    <style type="text/css">--%>
    <%--        TABLE {--%>
    <%--            border-collapse: collapse;--%>
    <%--            width: 300px;--%>
    <%--        }--%>

    <%--        TH {--%>
    <%--            background: #fc0;--%>
    <%--            text-align: left;--%>
    <%--        }--%>

    <%--        TH, TD {--%>
    <%--            border: 1px solid black;--%>
    <%--            padding: 4px;--%>
    <%--        }--%>
    <%--    </style>--%>
</head>
<a href="/hello" Home></a>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Soil</th>
        <th>Origin</th>
        <th>Color stem</th>
        <th>Color leaf</th>
        <th>Size</th>
        <th>Temperature</th>
        <th>Lighting</th>
        <th>First watering</th>
        <th>Watering</th>
        <th>Multiplying</th>
    </tr>
    </thead>
    <c:forEach var="cult" items="${cultivated}">
        <tbody>
        <tr>
            <td><c:out value="${cult.id}"/></td>
            <td><c:out value="${cult.name}"/></td>
            <td><c:out value="${cult.soil}"/></td>
            <td><c:out value="${cult.origin}"/></td>
            <td><c:out value="${cult.parameters.stem_color}"/></td>
            <td><c:out value="${cult.parameters.leaf_color}"/></td>
            <td><c:out value="${cult.parameters.size}"/></td>
            <td><c:out value="${cult.tips.temperature}"/></td>
            <td><c:out value="${cult.tips.light}"/></td>
            <td><c:out value="${cult.tips.first_watering}"/></td>
            <td><c:out value="${cult.tips.watering}"/></td>
            <td><c:out value="${cult.multiplying}"/></td>

                <%--            <c:forEach items="${cult.multiplying}" var="multip">--%>
                <%--                <td>${multip}</td>--%>
                <%--            </c:forEach>--%>
        </tr>
        </tbody>
    </c:forEach>

</table>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Soil</th>
        <th>Origin</th>
        <th>Color stem</th>
        <th>Color leaf</th>
        <th>Size</th>
        <th>Life term</th>
        <th>Multiplying</th>
    </tr>
    </thead>
    <c:forEach var="item" items="${wild}">
        <tbody>
        <tr>
            <td><c:out value="${item.id}"/></td>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.soil}"/></td>
            <td><c:out value="${item.origin}"/></td>
            <td><c:out value="${item.parameters.stem_color}"/></td>
            <td><c:out value="${item.parameters.leaf_color}"/></td>
            <td><c:out value="${item.parameters.size}"/></td>
            <td><c:out value="${item.life_term}"/></td>
            <td><c:out value="${item.multiplying}"/></td>
                <%--            <c:forEach items="${item.multiplying}" var="multip">--%>
                <%--                <td>${multip}</td>--%>
                <%--            </c:forEach>--%>
        </tr>
        </tbody>
    </c:forEach>
</table>
<button onclick="goBack()">Choose another parser</button>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>
