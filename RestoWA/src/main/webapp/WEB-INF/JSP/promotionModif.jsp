<%-- 
    Document   : promotionModif
    Created on : 10-May-2019, 05:44:23
    Author     : Damien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 600px;">
  <div class="row">
    <div class="col">
    </div>
            <c:if test = "${promotionModif == true}">
                      <div class="col-6">
	<h4 class="card-title mt-3 text-center">Modifier Promotion numéro ${promotionform.id}</h4>
    </div>
    <div class="col">
  <form action="${cp}/promotion/delete/${promotionform.id}" method="post">
    <button type="submit" class="btn btn-danger btn-block mt-10"> Supprimer  </button>
</form>
    </div>
        
      </c:if>
      <c:if test = "${promotionAdd == true}">
                      
	<h4 class="card-title mt-3 text-center">Création Promotion</h4>
        
      </c:if>
      

  </div>
	<form:form action="" method="POST" modelAttribute="promotionform">
       	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-font"></i> </span>
		 </div>
        <form:input name="" path="title" class="form-control" placeholder="Titre" type="text"/>
    </div> 
    <div class="row">
    <div class="col-sm">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-key"></i> </span>
		 </div>
        <form:input name="" path="key" class="form-control" placeholder="Clé" type="text"/>
    </div> <!-- form-group// -->
 <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-info"></i> </span>
		 </div>
        <form:input path="shortDescription" name="" class="form-control" placeholder="Résumé" type="text"/>
        <small><errors path="email" cssClass="errormsg" /></small>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-comment"></i> </span>
		</div>
    	<form:textarea name="" class="form-control" path="longDescription" placeholder="Description" type="text"/>
    </div> <!-- form-group// -->
      <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-file-image"></i> </span>
		 </div>
        <form:input name="" class="form-control" path="imageURL" placeholder="image URL" type="text"/>
    </div> 

                                                                                                                                                         </div>
                                                                          </div>
    <div class="form-group">
        <button type="submit" class="btn btn-success btn-block"> Enregistrer  </button>
    </div> <!-- form-group// -->      
                                                      </form:form>
</article>
</div> <!-- card.// -->

</div> 
