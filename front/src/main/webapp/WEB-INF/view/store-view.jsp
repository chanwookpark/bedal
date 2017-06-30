<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>가게조회</title>
</head>
<body>

<h3>${store.storeName}</h3>
<i>${store.promotionTitle}</i>
<ul>
    <li>주소 : ${store.storeAddress}</li>
    <li>가게ID: ${store.storeId}</li>
</ul>

</body>
</html>