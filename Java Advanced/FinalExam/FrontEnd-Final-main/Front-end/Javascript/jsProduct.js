$(document).ready(function() {
    var selectedUserId = null;
    let username = sessionStorage.getItem("username");
    let password = sessionStorage.getItem("password");

    console.log(password + username);
    if (username && password) {
        let authHeader = "Basic " + btoa(username+ ':' + password);
        

        $.ajax({
            url: "http://localhost:8080/api/v1/lego",
            type: "GET",
            headers: {
                'Authorization': authHeader
            },
            success: function(response) {
                var data = response;
                populateTable(data);

            },
            error: function(xhr, status, error) {
                console.error(error);
            }
        });
    } else {
        console.log("Không tìm thấy thông tin xác thực trong sessionStorage.");
    }

});



function showUpdateForm(productId) {
    var updateForm = document.getElementById('updateForm');
    updateForm.style.display = 'block';
    document.body.style.overflow = 'hidden';

    console.log(productId);


    const selectedRow = document.getElementById(`row-${productId}`);
    const rowData = getRowData(selectedRow);

    fillUpdateForm(rowData)



    document.addEventListener('mousedown', function(event) {
        var targetElement = event.target;

        if (targetElement !== updateForm && !updateForm.contains(targetElement)) {
            updateForm.style.display = 'none';
            document.body.style.overflow = 'auto';
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
        const columnName = `column${index + 1}`;
        const cellData = cell.textContent.trim(); // Nội dung ô dữ liệu

        // Lưu trữ thông tin vào đối tượng rowData
        rowData[columnName] = cellData;
    });

    return rowData;
}

function fillUpdateForm(rowData){

    console.log(rowData);
    const fieldId = document.getElementById('productId')
    const fieldType = document.getElementById('productType');
    const fieldValuePieces = document.getElementById('valuePieces');
    const fieldName = document.getElementById('nameProduct');
    const fieldPrice = document.getElementById('Price');

     
     fieldValuePieces.value = rowData.column4;
     fieldName.value = rowData.column3;
     fieldPrice.value = rowData.column5;
     fieldId.value = rowData.column1;

}


function handleUpdate(){
    var updateProductID = document.getElementById('productId');
    const productId = parseInt(updateProductID.value);


    const type = document.getElementById('productType').value;
    const pieces = document.getElementById('valuePieces').value;
    const price = document.getElementById('Price').value;
    const name = document.getElementById('nameProduct').value;

    console.log(productId,type,pieces,price,name);

    const updatedData = {
        name: name,
        piece: pieces,
        price: price,
        type: type
    };

    return {updatedData,productId};

}


function updateProduct(updatedDataAndProductID) {
    let username = sessionStorage.getItem("username");
    let password = sessionStorage.getItem("password");
    
    let authHeader = "Basic " + btoa(username + ":" + password);
    console.log(updatedDataAndProductID.updatedData);
    $.ajax({
        url: `http://localhost:8080/api/v1/lego/${updatedDataAndProductID.productId}`,
        type: "PUT",
        data: JSON.stringify(updatedDataAndProductID.updatedData),
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


function showCreateForm() {
    var updateForm = document.getElementById('createForm');
    updateForm.style.display = 'block';
    document.body.style.overflow = 'hidden';

    // Lắng nghe sự kiện mousedown bên ngoài form cập nhật
    document.addEventListener('mousedown', function(event) {
        var targetElement = event.target;
        var updateForm = document.getElementById('createForm');

        // Kiểm tra xem sự kiện mousedown có nằm bên ngoài form cập nhật hay không
        if (targetElement !== updateForm && !updateForm.contains(targetElement)) {
            updateForm.style.display = 'none';
            document.body.style.overflow = 'auto';
        }
    });
}


function getInfoCreate(){
    const type = document.getElementById("productType").value;
    const piece = document.getElementById("pieces").value;
    const name = document.getElementById("name").value;
    const price = document.getElementById("priceProduct").value;


    let productCreate  = {
        type : type,
        price : price,
        piece : piece,
        name : name
    }

    
    return productCreate;


}


function createProduct(productCreate){

    let username = sessionStorage.getItem("username");
    let password = sessionStorage.getItem("password");
    
    console.log(productCreate);


    let authHeader = "Basic " + btoa(username + ":" + password);
  
    // $.ajax({
    //     url: `http://localhost:8080/api/v1/lego`,
    //     type: "POST",
    //     headers: {
    //         Authorization: authHeader
    //     },
    //     success: function(response) {
    //         var data = response;
    //         console.log(data);
    //         alert("Xoá thành công!");
    //        location.reload()
    //     },
    //     error: function(error) {
    //         alert("Đã xảy ra lỗi!");
    //         console.log(error);
    //     }
    // });

    $.ajax({
        url : `http://localhost:8080/api/v1/lego`,
        type : "POST",
        data : JSON.stringify(productCreate),
        headers : {
            Authorization : authHeader
        },
        contentType : 'application/json',
        success: function(response) {
            var data = response;
            console.log(data);
            alert("Yeahhh, tạo thành công rồi , đi ngủ thôi  !!!");
            location.reload();
          },
        error : function(error){
            alert("Đã xảy ra lỗi !!");
            console.log(error);
        }

    });


}



function populateTable(data) {
    var accTableBody = $("#productTableBody");
    accTableBody.empty();

    for (var i = 0; i < data.content.length; i++) {
        var product = data.content[i];
        var row = `<tr id="row-${product.id}">
            <td>${product.id}</td>
            <td>${product.type}</td>
            <td>${product.name}</td>
            <td>${product.piece}</td>
            <td>${product.price}</td>
            <td>${product.createDate}<td>
            <td><button class="btn btn-primary" onclick="showUpdateForm('${product.id}')">Cập nhật</button></td>
            <td><button class="btn btn-danger" onclick="showConfirmationDialog('${product.id}')">Xóa</button></td>
        </tr>`;
        accTableBody.append(row);
    }
}


function showConfirmationDialog(productId) {
    const confirmationDialog = document.getElementById('confirmation-dialog');
    confirmationDialog.style.display = 'block';
  
    // Lưu trữ ID người dùng hiện tại vào biến global selectedUserId
    selectedProductId = productId;

    console.log(selectedProductId)

}

function hideConfirmationDialog() {
    const confirmationDialog = document.getElementById('confirmation-dialog');
    confirmationDialog.style.display = 'none';
}
  
function handleConfirmation() {
    // Thực hiện xoá hàng trên API với selectedUserId đã được lưu trữ
    deleteRow(selectedProductId);
  
    // Ẩn bảng thông báo xoá
    hideConfirmationDialog();
  }
  
  function handleCancel() {
    // Ẩn bảng thông báo xoá
    hideConfirmationDialog();
  }

  function deleteRow(productId) {

    let username = sessionStorage.getItem("username");
    let password = sessionStorage.getItem("password");
    


    let authHeader = "Basic " + btoa(username + ":" + password);
  
    $.ajax({
        url: `http://localhost:8080/api/v1/lego/${productId}`,
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