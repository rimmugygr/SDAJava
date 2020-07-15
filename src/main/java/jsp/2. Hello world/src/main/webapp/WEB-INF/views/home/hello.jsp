<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<body>
<h2> Hej! Dzisiejsza data to:  <fmt:formatDate pattern = "yyyy-MM-dd" value = "${now}" /></h2>
<h2> Hej! Dzisiejsza data to:  <fmt:formatDate pattern = " G yyyy-MM-dd" value = "${now}" /></h2>
</body>

</html>