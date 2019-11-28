
var tooLittle ;
if (window.innerWidth <1190){
        $('.fullscreen-video-wrap').css("display","none");
        $('.apple').css("display","block");
}else{
        $('.fullscreen-video-wrap').css("display","block");
        $('.apple').css("display","none");
}

$(".account").hover(function(){
    $("#btn").css("transition-delay",".5s");
    $("#btn").css("transition-duration","0.5s");
    $("#btn").css("display","block");
    $("#btn").css("opacity","1");
    
    $(".compte").css("transition-delay",".5s");
    $(".compte").css("transition-duration","0.5s");
    $(".compte").css("display","block");
    $(".compte").css("opacity","1");
    
}, function (){
    $("#btn").css("transition-delay","0s");
    $("#btn").css("transition-duration","0.1s");
    $("#btn").css("opacity","0");
    
    $(".compte").css("transition-delay","0s");
    $(".compte").css("transition-duration","0.1s");
    $(".compte").css("opacity","0");
})


$(".compte").click(function (){
    window.location.href = "login.html";
});

$("#btn").click(function (){
    window.location.href = "login.html";
});



window.onresize = function (){
    if (window.innerWidth < 1190){
        $('.fullscreen-video-wrap').css("display","none");
        $('.apple').css("display","block");
    }else{
        $('.fullscreen-video-wrap').css("display","block");
        $('.apple').css("display","none");
    }
}