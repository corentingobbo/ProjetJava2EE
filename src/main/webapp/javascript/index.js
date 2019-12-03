

$(".account").hover(function(){
    $("#btn").css("transition-delay",".5s");
    $("#btn").css("transition-duration","0.5s");
    $("#btn").css("display","block");
    $("#btn").css("opacity","1");
    
    $(".compte").css("transition-delay",".5s");
    $(".compte").css("transition-duration","0.5s");
    $(".compte").css("display","block");
    $(".compte").css("opacity","1");
    $(".blur").css("filter","blur(4px)");
    
    
}, function (){
    $("#btn").css("transition-delay","0s");
    $("#btn").css("transition-duration","0.1s");
    $("#btn").css("opacity","0");
    
    $(".compte").css("transition-delay","0s");
    $(".compte").css("transition-duration","0.1s");
    $(".compte").css("opacity","0");
    $(".blur").css("filter","none");
})


$(".compte").click(function (){
    window.location.href = "login.html";
});

$("#btn").click(function (){
    window.location.href = "login.html";
});



