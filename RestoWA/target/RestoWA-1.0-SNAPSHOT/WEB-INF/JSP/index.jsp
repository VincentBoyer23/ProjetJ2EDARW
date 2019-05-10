<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" /> 
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Spring 5 Web MVC via Annotations</title> 
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/site.css" /> 
        <link rel="stylesheet" href="${cp}/webjars/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <script src="${cp}/resources/js/js.js"></script> 
        <script src="${cp}/webjars/jquery/jquery.min.js"></script>
        <script src="${cp}/webjars/bootstrap/js/bootstrap.min.js"></script>
        
        
    </head> 
    <jsp:include page="./shared/header.jsp" />
    <body> 
              <c:if test = "${storeModif == true}">
                  <jsp:include page="./storeModif.jsp" />
        
      </c:if>
            <c:if test = "${storeAdd == true}">
                  <jsp:include page="./storeModif.jsp" />
        
      </c:if>
      <c:if test = "${storesList == true}">
                  <jsp:include page="./storesList.jsp" />
        
      </c:if>
              <c:if test = "${profile == true}">
                  <jsp:include page="./profile.jsp" />
        
      </c:if>
              <c:if test = "${promotionsList == true}">
                  <jsp:include page="./promotionsList.jsp" />
        
      </c:if>
      <c:if test = "${promotionModif == true}">
                  <jsp:include page="./promotionModif.jsp" />
        
      </c:if>
            <c:if test = "${promotionAdd == true}">
                  <jsp:include page="./promotionModif.jsp" />
        
      </c:if>
                    <c:if test = "${success == true}">
                  <jsp:include page="./success.jsp" />
        
      </c:if>
                    <c:if test = "${failure == true}">
                  <jsp:include page="./failure.jsp" />
        
      </c:if>
        <jsp:include page="./shared/footer.jsp" />
    </body> 
</html>