$(document).ready(function () {
    $("th .ui-chkbox").css("display", "none");
    $(".ui-chkbox-box").click(function () {
        if ($("tr[aria-selected=true]").size() === 3) {
            $("tr[aria-selected=false] td").removeClass("ui-selection-column");
        } else {
            $("tr[aria-selected=false] td").addClass("ui-selection-column");
        }
    });
});

$(document).ready(function () {
    $('.clear-input').val("");
    $('.cpf').mask("999.999.999-99");
    $('.telefone').mask("(99) 9999-9999");
    $('.celular').mask("(99) 99999-9999");
});