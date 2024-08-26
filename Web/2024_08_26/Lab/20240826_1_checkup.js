function valCk(){
    if ($("#userName").val() == "") {
        alert("이름을 입력해주세요.");
        $("#userName").focus();
        return false;
    }
    if ($("#userId").val() == ""){
        alert("아이디를 입력해주세요.");
        $("#userId").focus();
        return false;
    }

    if($("#userPw").val() == ""){
        alert("비밀번호를 입력해주세요.");
        $("#userPw").focus();
        return false;
    }

    if($("#userPwCon").val() == ""){
        alert("비밀번호 확인을 입력해주세요.");
        $("#userPwCon").focus();
        return false;
    }
    else{
        if($("#userPwCon").val() != $("#userPw").val()){
            alert("비밀번호가 일치하지 않습니다.");
            $("#userPwCon").val("");
            return false;
        }
    }
    if(!$("input[id = 'gender']").is(":checked")){
        alert("둘 중에 하나는 선택하셔야 합니다.");
        return false;
    }

    if($("#email").val() == ""){
        alert("이메일을 입력해주세요.");
        $("#email").focus();
        return false;
    }

    if($("#userTel").val() == ""){
        alert("연락처를 입력해주세요.");
        $("#userTel").focus();
        return false;
    }
}