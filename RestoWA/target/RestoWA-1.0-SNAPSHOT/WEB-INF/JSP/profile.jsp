<%-- 
    Document   : profile
    Created on : 10-May-2019, 04:17:11
    Author     : Damien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<div class="container">





<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 600px;">
	<h4 class="card-title mt-3 text-center">Votre compte</h4>
	<form:form action="" method="POST" modelAttribute="userform">
    <div class="row">
    <div class="col-sm">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <form:input name="" path="firstname" class="form-control" placeholder="Prénom" type="text"/>
    </div> <!-- form-group// -->
    	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <form:input name="" path="lastname" class="form-control" placeholder="Nom" type="text"/>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <form:input path="email" name="" class="form-control" placeholder="E-mail" type="email"/>
        <small><form:errors path="email" cssClass="errormsg" /></small>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>
    	<form:input name="" class="form-control" path="phoneNumber" placeholder="Numéro téléphone" type="text"/>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <form:input class="form-control" path="password" placeholder="Créer un mot de passe" type="password"/>
    </div> <!-- form-group// -->
                                                                                 </div>
                                                                                 <div class="col-sm">
        	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-map"></i> </span>
		 </div>
        <form:input name="" class="form-control" path="address.street" placeholder="Rue" type="text"/>
    </div> <!-- form-group// -->
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
                                                               </select>
       
    </div> <!-- form-group// -->    
                                                                          </div>
                                                                          </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Créer Compte  </button>
    </div> <!-- form-group// -->      
    <p class="text-center">Déjà un compte ? <a href="">Se connecter</a> </p> 
                                                      </form:form>
</article>
</div> <!-- card.// -->

</div> 
