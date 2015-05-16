/*zera checkbox ao fechar o modal*/
$(document).ready(function($) {
    $('#myModal').on('hidden.bs.modal', function (e) {
      $('input:checkbox').removeAttr('checked');
      $('#result').val('R$ 0,00');
    });
 });

String.prototype.formatMoney = function() {
    var v = this;

    if(v.indexOf('.') === -1) {
        v = v.replace(/([\d]+)/, "$1,00");
    }

    v = v.replace(/([\d]+)\.([\d]{1})$/, "$1,$20");
    v = v.replace(/([\d]+)\.([\d]{2})$/, "$1,$2");
    v = v.replace(/([\d]+)([\d]{3}),([\d]{2})$/, "$1.$2,$3");

    return v;
};
String.prototype.toFloat = function() {
    var v = this;

    if (!v) return 0;
    return parseFloat(v.replace(/[\D]+/g, '' ).replace(/([\d]+)(\d{2})$/, "$1.$2"));
};
(function(){
    "use strict";

    var $chs = document.querySelectorAll('input[name="ch[]"]'),
        $result = document.getElementById('result'),
        chsArray = Array.prototype.slice.call($chs);

    chsArray.forEach(function(element, index, array){
        element.addEventListener("click", function(){
            var v = this.value,
                result = 0;
            v = v.toFloat();

            if (this.checked === true) {
                result = $result.value.toFloat() + parseFloat(v);
            } else {
                result = $result.value.toFloat() - parseFloat(v);
            }

            $result.value = "R$ " + String(result).formatMoney();
        });
    });


}());