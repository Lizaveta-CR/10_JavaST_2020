<%--
  Created by IntelliJ IDEA.
  User: elizaveta
  Date: 30.11.2020
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<h2>Flowers:</h2>>
<div class="container">
    <form method="post" action="/hello">
        <label class="radio-inline"><input type="radio" name="parser" value="DOM_FLOWERS" checked>DOM-parser : </label>
        <label class="radio-inline"><input type="radio" name="parser" value="SAX_FLOWERS">SAX-parser : </label>
        <label class="radio-inline"><input type="radio" name="parser" value="STAX_FLOWERS">StAX-parser : </label>

        <button type="submit" class="btn btn-primary">Check</button>
    </form>
</div>
<h2>Orders:</h2>>
<div class="container">
    <form method="post" action="/hello">
        <label class="radio-inline"><input type="radio" name="parser" value="DOM_ORDERS" checked>DOM-parser : </label>
        <label class="radio-inline"><input type="radio" name="parser" value="SAX_ORDERS">SAX-parser : </label>
        <label class="radio-inline"><input type="radio" name="parser" value="STAX_ORDERS">StAX-parser : </label>

        <button type="submit" class="btn btn-primary">Check</button>
    </form>
</div>
</body>
</html>
