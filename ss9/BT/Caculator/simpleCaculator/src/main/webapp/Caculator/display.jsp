<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/18/2022
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>${sum}
    <c:choose>
        <c:when  test = "${operator == '1'}">
           ${sum}
        </c:when>


    </c:choose>
<%--    <c:if test =" ${operator} == '+'">--%>
<%--        + ${num2} = ${sum}--%>
<%--    </c:if>--%>
<%--    <c:if test =" ${operator} == '*' ">--%>
<%--        - ${num2} = ${tru}--%>
<%--    </c:if>--%>

</h1>
</body>
</html>
