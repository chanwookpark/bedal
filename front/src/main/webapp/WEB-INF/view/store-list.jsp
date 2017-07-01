<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>가게조회</title>
</head>
<body>

<!-- 배너 영역 노출 -->
<c:if test="${banner != null}">
    <img src="${banner.bannerImageUrl}" alt="${banner.eventTitle}"/>
</c:if>

<h3>우리동네가게</h3>
<c:forEach var="store" items="${storeList.list}">
    <p>
        <a href="/store/view.html?storeId=${store.storeId}">
            <strong>${store.storeName}</strong> <i>${store.promotionTitle}</i>
        </a>
        <br/>
            ${store.storeAddress}
    </p>
</c:forEach>

</body>
</html>