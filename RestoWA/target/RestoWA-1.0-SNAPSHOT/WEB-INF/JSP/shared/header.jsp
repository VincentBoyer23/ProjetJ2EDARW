<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
  <a class="navbar-brand" href="${cp}/">
                                  <img src="https://www.senoujob.com/wp-content/uploads/2015/02/logo_dummy.png" width="60" height="60" alt="">
                                  
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Magasin
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="${cp}/stores">Liste</a>
          <a class="dropdown-item" href="${cp}/store/add">Ajouter</a>
        </div>
      </li>
            <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Promotion
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="${cp}/promotions">Liste</a>
          <a class="dropdown-item" href="${cp}/promotion/add">Ajouter</a>
        </div>
      </li>
    </ul>
        <c:if test = "${sessionScope.logged != true}">
                  <form class="form my-2 my-lg-0" action="${cp}/login" method="post">
          <input class="form-control mr-sm-5" name="email" type="text" placeholder="Email" aria-label="Search">
          <input class="form-control mr-sm-5" name="mdp" type="password" placeholder="password" aria-label="Search">
          <div class="row">
            <a class="btn btn-outline-primary my-4 my-sm-2" href="${cp}/register ">S'inscrire</a>
            <button class="btn btn-outline-success my-2 my-sm-2" type="submit">Se connecter</button>
          </div>
        </form>
        
      </c:if>
                <c:if test = "${sessionScope.logged == true}">
          <div class="row">
            
            <a class="btn btn-outline-primary my-2 my-sm-2" href="${cp}/profile/${sessionScope.user.ID}" ><i class="fa fa-user"></i>${sessionScope.user.email}</a>
            <form action="${cp}/logout" method="post">
            <button class="btn btn-outline-danger my-4 my-sm-2" type="submit">Se déconnecter</button>
            </form>
          </div>
        </form>
        
      </c:if>

        
      

      
    </div>

</nav>
