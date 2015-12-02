$(function () {
    $("#tabs").tabs();
});

$(document).ready(function () {
    var frm = $("#formCreate")
    frm.submit(function (event) {
        event.preventDefault();
        $.ajax({
            type: frm.attr('method'),
            url: frm.attr('action'),
            data: frm.serialize(),
            success: function (data) {
                alert('Username:' + data.userName + "\nrole:" + data.authorities[0]);
            },
            error: function (xhr, str) {
                alert('User exist!');
            }
        });
        return false;
    });
});