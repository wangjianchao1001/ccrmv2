$(function() {
    /* 忽略空链接 */
    $('a[href="#"]').click(function(e) {
        e.preventDefault();
    });

});