/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function userIsEmpty(){
    return valIsEmpty($('#user').val(),"Ingrese Un Usuario Valido");
}
function passIsEmpty(){
    return valIsEmpty($('#pass').val(),"Ingrese Un Password Valido");
}
function valIsEmpty(value,message){
    if(value.length == 0){
        $('#result').hide();
        $("#result").html("<h3>"+message+"</h3>")
        .fadeIn("slow");
        return true;
    }
    return false;
}
//if everything ok return true :)
function testData(){
    return (!userIsEmpty() && !passIsEmpty());
//    if(!userIsEmpty() && !passIsEmpty()){
//        return true;
//    }else{
//        return false;
//    }
//    return false;
}
