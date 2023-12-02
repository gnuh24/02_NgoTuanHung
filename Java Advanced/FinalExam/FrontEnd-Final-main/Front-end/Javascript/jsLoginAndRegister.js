function register(){
    let username = document.getElementById("userName").value;
    let password = document.getElementById("password").value;
    
    let confirmPassword = document.getElementById("confirmPassword").value;
    let firstName = document.getElementById("firstName").value;
    let LastName = document.getElementById("LastName").value;


    if(password != confirmPassword) {
        alert("Nhập lại đi ,Pleaseeee !!!");
        return;
    }

    var newUser = {
        username : username,
        password : confirmPassword,
        lastname : LastName,
        firstname : firstName
    }

    $.ajax({
        url : `http://localhost:8080/api/v1/accounts`,
        type : "POST",
        data : JSON.stringify(newUser),
        contentType : 'application/json',
        success: function(response) {
            var data = response;
            console.log(data);
            alert("Đăng Ký thành công gồi đó , đăng nhập đi !!!");
          },
        error : function(error){
            alert("Đã xảy ra lỗi !!");
            console.log(error);
        }

    });
}



function login() {
    let usernameLog = document.getElementById("usernameLg").value;
    let passwordLog = document.getElementById("passwordLg").value;

    console.log(usernameLog);

    let authHeader = "Basic " + btoa(usernameLog + ':' + passwordLog);
    
    
  $.ajax({
    url: 'http://localhost:8080/api/v1/auth/login',
    type: 'GET',
    headers: {
      'Authorization': authHeader
    },
    success: function(response) {
      console.log('Đăng nhập thành công:', response);

      if(response.role == "ADMIN") {
            window.location = "http://127.0.0.1:5500/Front-end/admin/acc.html";
    
            sessionStorage.setItem("username", usernameLog);
            sessionStorage.setItem("password", passwordLog);

            
      }

      if(response.role == "USER") {
        window.location = "http://127.0.0.1:5500/Front-end/user/user.html";

        sessionStorage.setItem("username", usernameLog);
        sessionStorage.setItem("password", passwordLog);
      }

      

    },
    error: function(xhr, status, error) {
      console.log('Đăng nhập thất bại:', error);
      alert('Đăng nhập thất bại. Hãy kiểm tra lại thông tin đăng nhập.');

      console.log(xhr.responseText); // In ra thông báo lỗi chi tiết
    }
  });
}