/**
 * Created by pankajpardasani on 01/09/2016.
 */

$(function () {
    $(window).on("load resize", function () {
        $(".fill-screen").css("height", window.innerHeight);
    });

    $('body').scrollspy({ target: '#bs-example-navbar-collapse-1',
        offset: 160 });

    //smooth scrolling
    $('nav a').bind('click', function () {
        $('html, body').stop().animate({
            scrollTop: $($(this).attr('href')).offset().top - 100
        }, 1500, 'easeInOutExpo');
        event.preventDefault();
    });
});


