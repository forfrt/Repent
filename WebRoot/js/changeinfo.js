/**
 * Used to: 响应修改资料和修改资料的表单验证 && 响应修改头像
 * User: F
 * Date: 13-5-1 - 下午12:25
 */
$(document).ready(function(){
    $("#changehead").bind('click',function(){
        //TODO:上传图片的Ajax代码
        $("#ensurehead").removeClass("hide");
    });
    $('#password_input').blur(function(){
        var password= $("#password");
        if((this.value!='' && this.value.length < 6) ||this.value.length > 20){
            password.html("密码格式不正确,请按照正确的密码格式输入密码：6~20位数字、字母的组合，并区分大小写").removeClass("alert-info").addClass("alert-error");
        }
        else if(this.value!=''){
            password.html("密码格式正确。").removeClass("alert-info alert-error").addClass("alert-success");
        }else{
            password.html("不修改密码").removeClass("alert-info alert-error").addClass("alert-success");
        }
    });
    $("#password_reaffirm").blur(function(){
        var password_reaffirm = $("#reaffirm");
        if(this.value != $("#password_input")[0].value){
            password_reaffirm.html("与上上面输入不同，请再次确认您的密码！").removeClass("alert-info").addClass("alert-error");
        }
        else if(this.value != ''){
            password_reaffirm.html("两次输入的密码相同。").removeClass("alert-info alert-error").addClass("alert-success");
        }
        else{
            password_reaffirm.html("不修改密码无需确认密码").removeClass("alert-info alert-error").addClass("alert-success");
        }
    });
});
