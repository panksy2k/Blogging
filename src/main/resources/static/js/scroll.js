/**
 * Created by pankajpardasani on 01/09/2016.
 */
$('body').scrollspy({ target: '.navbar',
    offset: 160 });

//smooth scrolling
$('nav a').bind('click', function () {
    $('html, body').stop().animate({
        scrollTop: $($(this).attr('href')).offset().top - 100
    }, 1500, 'easeInOutExpo');
    event.preventDefault();
});