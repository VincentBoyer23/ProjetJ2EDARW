<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 600px;">
  <div class="row">
    <div class="col">
    </div>
    <div class="col-6">
	<h4 class="card-title mt-3 text-center">Modifier Magasin numéro ${storeform.ID}</h4>
    </div>
    <div class="col">
  <form action="${cp}/store/delete/${storeform.ID}" method="post">
    <button type="submit" class="btn btn-danger btn-block mt-10"> Supprimer  </button>
</form>
    </div>
  </div>
	<form:form action="" method="POST" modelAttribute="storeform">
       	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-font"></i> </span>
		 </div>
        <form:input name="" path="name" class="form-control" placeholder="Nom" type="text"/>
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
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <form:input path="email" name="" class="form-control" placeholder="E-mail" type="email"/>
        <small><errors path="email" cssClass="errormsg" /></small>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>
    	<form:input name="" class="form-control" path="phoneNumber" placeholder="Numéro téléphone" type="text"/>
    </div> <!-- form-group// -->
      <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-map"></i> </span>
		 </div>
        <form:input name="" class="form-control" path="address.street" placeholder="Rue" type="text"/>
    </div> 

                                                                                 </div>
                                                                                 <div class="col-sm">
        	<!-- form-group// -->
        	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-map"></i> </span>
		 </div>
        <form:input name="" class="form-control" path="address.city" placeholder="Ville" type="text"/>
    </div> <!-- form-group// -->
        	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-map"></i> </span>
		 </div>
        <form:input name="" class="form-control" path="address.state" placeholder="Région" type="text"/>
    </div> <!-- form-group// -->
        	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-map"></i> </span>
		 </div>
        <form:input name="" class="form-control" path="address.zipCode" placeholder="Code Postal" type="number"/>
    </div> <!-- form-group// -->
        	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-map"></i> </span>
		 </div>
        <form:input name="" class="form-control" path="address.country" placeholder="Pays" type="text"/>
        <form:input name="" class="form-control" path="lattitude"  type="hidden"/>      
        <form:input name="" class="form-control" path="longitude" type="hidden"/>
       
    </div> <!-- form-group// -->    
                                                                          </div>
                                                                          </div>
    <div class="form-group">
        <button type="submit" class="btn btn-success btn-block"> Enregistrer  </button>
    </div> <!-- form-group// -->      
                                                      </form:form>
</article>
</div> <!-- card.// -->

</div> 