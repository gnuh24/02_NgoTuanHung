$(document).ready(function() {
    var selectedUserId = null;
    let username = sessionStorage.getItem("username");
    let password = sessionStorage.getItem("password");

    console.log(password + username);
    if (username && password) {
        let authHeader = "Basic " + btoa(username+ ':' + password);
        

        $.ajax({
            url: "http://localhost:8080/api/v1/accounts",
            type: "GET",
            headers: {
                'Authorization': authHeader
            },
            success: function(response) {
                var data = response;
                populateTable(data);
                inputForm(authHeader);
            },
            error: function(xhr, status, error) {
                console.error(error);
            }
        });
    } else {
        console.log("Không tìm thấy thông tin xác thực trong sessionStorage.");
    }

});

function inputForm(authHeader){
    const buttonForm = document.getElementById("buttonSearch");
    buttonForm.addEventListener("click", function() {
        clickForm(authHeader);
    }); 
}


function clickForm(){
    const createDate = document.getElementById("createDay").value;
    const userRole = document.getElementById("userRole").value;
    const minCreateDate = document.getElementById("minCreateDay").value;
    const maxCreateDate = document.getElementById("maxCreateDay").value;
    const search = document.getElementById("inputSearch").value;
    
    let form = {
        createDate: createDate,
        role: userRole,
        minDate: minCreateDate,
        maxDate: maxCreateDate,
    }

    let username = sessionStorage.getItem("username");
    let password = sessionStorage.getItem("password");

    if (username && password) {
        let authHeader = "Basic " + btoa(username+ ':' + password);
        

        $.ajax({
            url: "http://localhost:8080/proxy",
            type: "GET",
            data: {
              url: `http://localhost:8080/api/v1/accounts?search=${search}&form=${JSON.stringify(form)}`,
              headers: {
                Authorization: authHeader
              }
            },
            success: function(response) {
                var data = response;
                console.log(data);
                alert("Tìm thành công !!");
                populateTable(data);
            },
            error: function(error) {
                alert("Đã xảy ra lỗi!");
                console.log(error);
            }
        });
    

    } else {
        console.log("Không tìm thấy thông tin xác thực trong sessionStorage.");
    }
    
}



function showUpdateForm(userId) {

    const updateForm = document.getElementById('updateForm');
    updateForm.style.display = 'block';
    document.body.style.overflow = 'hidden';
 
    // Lưu trữ ID người dùng hiện tại vào trường ẩn trong form cập nhật
    const userIdInput = document.getElementById('updateUserId');
    userIdInput.value = userId;

    // Lấy thông tin từ hàng đang được chọn
    const selectedRow = document.getElementById(`row-${userId}`);
    const rowData = getRowData(selectedRow);

    
    // Đổ thông tin vào bảng cập nhật
    updateFormFields(rowData);

    document.addEventListener('mousedown', function(event) {
        var targetElement = event.target;
        if (targetElement !== updateForm && !updateForm.contains(targetElement)) {
            updateForm.style.display = 'none';
            document.body.style.overflow = 'auto';
        }
    });
}

function updateFormFields(rowData) {
    // Lấy thông tin từ các trường dữ liệu trong form
    const updateUserName = document.getElementById('updateUserName');
    const updateLastName = document.getElementById('updateLastName');
    const updateFirstName = document.getElementById('updateFirstName');
    const updateUserRole = document.getElementById('updateUserRole');

    // Gán giá trị cho các trường dữ liệu trong form
    updateUserName.value = rowData.column2;
    updateLastName.value = rowData.column4;
    updateFirstName.value = rowData.column3;
    updateUserRole.value = rowData.column5;
}


function handleUpdate() {
    // Lấy ID người dùng từ trường ẩn trong form cập nhật
    const userIdInput = document.getElementById('updateUserId');
    const userId = parseInt(userIdInput.value);


    // Lấy thông tin từ các trường dữ liệu trong form
    const updateUserName = document.getElementById('updateUserName').value;
    const updateLastName = document.getElementById('updateLastName').value;
    const updateFirstName = document.getElementById('updateFirstName').value;
    const updateUserRole = document.getElementById('updateUserRole').value;

    // Tạo đối tượng dữ liệu cần cập nhật lên API
    const updatedData = {
        username: updateUserName,
        lastname: updateLastName,
        firstname: updateFirstName,
        role: updateUserRole
    };

    console.log(updatedData);
    

    return {updatedData,userId};
   
}

function updateUser(updatedDataAndUserID) {
    let username = sessionStorage.getItem("username");
    let password = sessionStorage.getItem("password");
    


    let authHeader = "Basic " + btoa(username + ":" + password);
    console.log(updatedDataAndUserID.updatedData);
    $.ajax({
        url: `http://localhost:8080/api/v1/accounts/${updatedDataAndUserID.userId}`,
        type: "PUT",
        data: JSON.stringify(updatedDataAndUserID.updatedData),
        contentType: 'application/json',
        headers: {
            Authorization: authHeader
        },
        success: function(response) {
            var data = response;
            console.log(data);
            alert("Cập nhật thành công!");
           location.reload()
        },
        error: function(error) {
            alert("Đã xảy ra lỗi!");
            console.log(error);
        }
    });

  }



function getRowData(row) {
    // Lấy các ô dữ liệu trong hàng
    const cells = row.querySelectorAll('td');

    // Tạo một đối tượng lưu trữ thông tin từ hàng
    const rowData = {};

    // Lặp qua các ô dữ liệu và lấy thông tin
    cells.forEach((cell, index) => {
        const columnName = `column${index + 1}`; // Tên cột tương ứng (column1, column2, ...)
        const cellData = cell.textContent.trim(); // Nội dung ô dữ liệu

        // Lưu trữ thông tin vào đối tượng rowData
        rowData[columnName] = cellData;
    });

    return rowData;
}

function populateTable(data) {
    var accTableBody = $("#accTableBody");
    accTableBody.empty();

    console.log(data);
    for (let i = 0; i < data.content.length; i++) {
        var user = data.content[i];
        var row = `<tr id="row-${user.id}">
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.firstname}</td>
            <td>${user.lastname}</td>
            <td>${user.role}</td>
            <td><button class="btn btn-primary" onclick="showUpdateForm('${user.id}')">Cập nhật</button></td>
            <td><button class="btn btn-danger" onclick="showConfirmationDialog('${user.id}')">Xóa</button></td>
        </tr>`;
        accTableBody.append(row);
    }
}

document.addEventListener('click', function(event) {
    if (event.target.matches('[id^="update-button-"]')) {
        const updateButtonId = event.target.id;
        console.log(updateButtonId);
        handleUpdate(updateButtonId);
    }
});


// Function để hiển thị bảng thông báo xoá
function showConfirmationDialog(userId) {
    const confirmationDialog = document.getElementById('confirmation-dialog');
    confirmationDialog.style.display = 'block';
  
    // Lưu trữ ID người dùng hiện tại vào biến global selectedUserId
    selectedUserId = userId;

}
  
  // Function để ẩn bảng thông báo xoá
  function hideConfirmationDialog() {
    const confirmationDialog = document.getElementById('confirmation-dialog');
    confirmationDialog.style.display = 'none';
  }
  
  function handleConfirmation() {
    deleteRow(selectedUserId);
  
    hideConfirmationDialog();
  }
  
  function handleCancel() {
    
    hideConfirmationDialog();
  }
  


  function deleteRow(userId) {

    let username = sessionStorage.getItem("username");
    let password = sessionStorage.getItem("password");
    


    let authHeader = "Basic " + btoa(username + ":" + password);
  
    $.ajax({
        url: `http://localhost:8080/api/v1/accounts/${userId}`,
        type: "DELETE",
        headers: {
            Authorization: authHeader
        },
        success: function(response) {
            var data = response;
            console.log(data);
            alert("Xoá thành công!");
           location.reload()
        },
        error: function(error) {
            alert("Đã xảy ra lỗi!");
            console.log(error);
        }
    });

  }