function salvaCookie(nomeCookie, valorCookie, diasValidadeCookie) {
    var data = new Date();
    data.setTime(d.getTime() + (diasValidadeCookie * 24 * 60 * 60 * 1000));
    
    var validade = "validade=" + data.toGMTString();
    document.cookie = nomeCookie + "=" + valorCookie + ";" + validade + ";path=/";
}

function buscaCookie(nomeCookie) {
	
    var nomeCookieFormat = nomeCookie + "=";
    
    var listaCookies = document.cookie.split(';');
    
    for(var i = 0; i < listaCookies.length; i++) {
    	
        var cookie = listaCookies[i];
        
        while (cookie.charAt(0) == ' ') {
        	cookie = cookie.substring(1);
        }
        
        if (cookie.indexOf(nomeCookieFormat) == 0) {
            return cookie.substring(nomeCookieFormat.length, cookie.length);
        }
    }
    
    return "";
}

function verificaUsuarioAutenticado() {
	
    var usuario = buscaCookie("usuario");
    
    if (usuario != "") {
        // usuário já fez login há pouco tempo. Direciona para Home.
    } else {
       // é a primeira vez do usuário. Deixa na tela de login (e chama salvaCookie quando ele fizer login).
    }
}