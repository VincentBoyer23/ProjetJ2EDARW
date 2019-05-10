<%-- 
    Document   : storesList
    Created on : 10-May-2019, 02:12:21
    Author     : Damien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div class="container">
    <br>
<form action="" method="get">
    <div class="form-group">
 
    <input type="text" class="form-control" name="q" placeholder="Mots clés">
    <br>
    <button type="submit" class="btn btn-primary btn-block mt-10"> Rechercher  </button>
    </div>
</form>
<br>
<br>
<c:forEach items="${stores}" var="item">
    
<div class="card">
  <h5 class="card-header">${item.key}</h5>
  <div class="card-body">
    <h5 class="card-title">${item.name}</h5>
    <p class="card-text">${item.address.street} ${item.address.city} ${item.address.state} ${item.address.zipCode} ${item.address.country}</p>
    <a href="./store/${item.ID}" class="btn btn-primary">Edit</a>
  </div>
</div>

    <br>
    <br>
</c:forEach>
    </div>