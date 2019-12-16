

$(".account").hover(function(){
    $("#btn").css("transition-delay",".5s");
    $("#btn").css("transition-duration","0.5s");
    $("#btn").css("display","block");
    $("#btn").css("opacity","1");
    
    $(".compte").css("transition-delay",".5s");
    $(".compte").css("transition-duration","0.5s");
    $(".compte").css("display","block");
    $(".compte").css("opacity","1");
    
    $(".connected").css("transition-delay",".5s");
    $(".connected").css("transition-duration","0.5s");
    $(".connected").css("display","block");
    $(".connected").css("opacity","1");
    $(".blur").css("filter","blur(4px)");
    
    
}, function (){
    $("#btn").css("transition-delay","0s");
    $("#btn").css("transition-duration","0.1s");
    $("#btn").css("opacity","0");
    
    $(".compte").css("transition-delay","0s");
    $(".compte").css("transition-duration","0.1s");
    $(".compte").css("opacity","0");
    
    $(".connected").css("transition-delay","0s");
    $(".connected").css("transition-duration","0.1s");
    $(".connected").css("opacity","0");
    $(".blur").css("filter","none");
});


$(".panier").hover(function(){
    $(".panierItems").css("transition-delay",".5s");
    $(".panierItems").css("transition-duration","0.5s");
    $(".panierItems").css("display","block");
    $(".panierItems").css("opacity","1");

    
    
}, function (){
    $(".panierItems").css("transition-delay","0s");
    $(".panierItems").css("transition-duration","0.1s");
    $(".panierItems").css("opacity","0");


});



$(".compte").click(function (){
    window.location.href = "compteInfos.html";
});

$(".connected").click(function (){
    console.log("test");
    window.location.href = "compteInfos.html";
});

$(".commandes").click(function (){
    window.location.href = "compteCommandes.html";
});

$(".deconnexion").click(function (){
    window.location.href = "login.html";
});

$("#btn").click(function (){
    window.location.href = "login.html";
});



