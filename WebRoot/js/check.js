/**
 * Used to: Check the register form.
 * User: F
 * Date: 13-4-16 - 下午4:21
 */
function check(){
    $(".controls").addClass("text-info");
    $("#password_input").blur(function(){
        var password_input = $("input[id='password_input']+span");
        if(this.value.length < 6 ||this.value.length > 20){
            password_input.removeClass("alert-info").addClass("alert-error");
        }else{
            password_input.html("密码格式正确。").removeClass("alert-info alert-error").addClass("alert-success");
        }
    });
    $("#password_reaffirm").blur(function(){
        var password_reaffirm = $("input[id='password_reaffirm']+span");
        if(this.value != $("#password_input")[0].value){
            password_reaffirm.html("与上上面输入不同，请再次确认您的密码！").removeClass("alert-info").addClass("alert-error");
        }else{
            password_reaffirm.html("两次输入的密码相同。").removeClass("alert-info alert-error").addClass("alert-success");
        }
    });
}
$(document).ready(function(){
    check();
});
