<%-- 
    Document   : register
    Created on : 05-May-2019, 16:46:44
    Author     : Damien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link rel="stylesheet" type="text/css" href="   resources/css/site.css" /> 
        <link rel="stylesheet" href="webjars/bootstrap/css/bootstrap.min.css" />
        <script src="resources/js/js.js"></script> 
        <script src="webjars/jquery/jquery.min.js"></script>
        <script src="webjars/bootstrap/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <title>Inscription</title>
    </head>
    <body>
<!------ Include the above in your HEAD tag ---------->




<div class="container">





<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 600px;">
	<h4 class="card-title mt-3 text-center">Créer votre compte gratuitement !</h4>
	<form:form action="register" method="POST" modelAttribute="userform">
    <div class="row">
    <div class="col-sm">
            <div>
        <small><form:errors path="firstname" class="errormsg" /></small>
        </div>
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <form:input name="" path="firstname" class="form-control" placeholder="Prénom" type="text"/>
    </div> <!-- form-group// -->
        <div>
        <small><form:errors path="lastname" class="errormsg" /></small>
        </div>
    	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <form:input name="" path="lastname" class="form-control" placeholder="Nom" type="text"/>
    </div> <!-- form-group// -->
        <div>
        <small><form:errors path="email" class="errormsg" /></small>
        </div>
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <form:input path="email" name="" class="form-control" placeholder="E-mail" type="text"/>
        
    </div> <!-- form-group// -->
        <div>
        <small><form:errors path="phoneNumber" class="errormsg" /></small>
        </div>

    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>
    	<form:input name="" class="form-control" path="phoneNumber" placeholder="Numéro téléphone" type="text"/>
    </div> <!-- form-group// -->
        <div>
        <small><form:errors path="password" class="errormsg" /></small>
        </div>
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <form:input class="form-control" path="password" placeholder="Créer un mot de passe" type="password"/>
    </div> <!-- form-group// -->
                                                                                 </div>
                                                                                 <div class="col-sm">
                                                                                         <div>
        <small><form:errors path="address.street" class="errormsg" /></small>
        </div>
        	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-map"></i> </span>
		 </div>
        <form:input name="" class="form-control" path="address.street" placeholder="Rue" type="text"/>
    </div> <!-- form-group// -->
        <div>
        <small><form:errors path="address.city" class="errormsg" /></small>
        </div>
        	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-map"></i> </span>
		 </div>
        <form:input name="" class="form-control" path="address.city" placeholder="Ville" type="text"/>
    </div> <!-- form-group// -->
        <div>
        <small><form:errors path="address.state" class="errormsg" /></small>
        </div>
        	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-map"></i> </span>
		 </div>
        <form:input name="" class="form-control" path="address.state" placeholder="Région" type="text"/>
    </div> <!-- form-group// -->
        <div>
        <small><form:errors path="address.zipCode" class="errormsg" /></small>
        </div>
        	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-map"></i> </span>
		 </div>
        <form:input name="" class="form-control" path="address.zipCode" placeholder="Code Postal" type="number"/>
    </div> <!-- form-group// -->
        <div>
        <small><form:errors path="address.country" class="errormsg" /></small>
        </div>
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
    <p class="text-center">Déjà un compte ? <a href="./">Se connecter</a> </p> 
                                                      </form:form>
</article>
</div> <!-- card.// -->

</div> 
<!--container end.//-->
    </body>
</html>
