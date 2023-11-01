window.onload = function(){
    const buttonAdd = document.getElementById("btn_addNew");
    readData();
    var isCreate = true;
    var formIDUpdate;
    var formIDDelete;
    buttonAdd.addEventListener("click", function(){
        openForm();
    });

    function openForm(){
        // Tạo một thẻ div mới
        var newForm = document.createElement("form");
        newForm.id="formInput";

        // Thêm nội dung vào thẻ div
        newForm.innerHTML = 
        `<div class="mb-3" id="formInput__name">
        <label for="formInputName" class="form-label">Tên phòng ban</label>
        <input type="text" class="form-control" id="formInputName" placeholder="Nhập tên phòng ban">
        </div>
        <button type="button" class="btn btn-primary" id="btn-save">Lưu</button>
        <button type="button" class="btn btn-danger" id="btn-hide">X</button>`;

        // Thêm thẻ div vào body của trang
        document.body.appendChild(newForm);

        const buttonClose = document.getElementById("btn-hide");
        const buttonSave = document.getElementById("btn-save");
        buttonClose.addEventListener("click", function(){
            closeForm();
            isCreate = true;
        })

        buttonSave.addEventListener("click", function(event){
            event.preventDefault();
            if ( isCreate ){
                createData();
            }
            else {
                updateDate( parseInt(formIDUpdate) );
                isCreate = true;
            }
            closeForm();
        })
      
    }

    function closeForm(){
        // Lấy thẻ cần xóa
        var formToRemove = document.getElementById("formInput");

        // Lấy ra thẻ cha của form và gọi phương thức removeChild()
        formToRemove.parentNode.removeChild(formToRemove);
    }

    function readData(){
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/v1/departments",
            success: function (response) {
                // Xử lý dữ liệu ở đây
                $("tbody").empty();
                response.forEach(function (item, index) {
                    $("tbody").append(`
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>
                            <button type="button" class="btn btn-warning btn-update" data-id="${item.id}">Change</button>
                            <button type="button" class="btn btn-danger btn-delete" data-id="${item.id}">Delete</button>
                        </td>
                    </tr>`);
                    let updateButton = $(`.btn-update[data-id="${item.id}"]`);
                    let deleteButton = $(`.btn-delete[data-id="${item.id}"]`);
                
                    // Thêm sự kiện cho nút Update
                    updateButton.on("click", function () {
                        // Xử lý sự kiện khi nút Update được click
                        console.log(`Update button clicked for item with ID: ${item.id}`);
                        formIDUpdate = item.id;
                        isCreate = false;
                        openForm();
                    });
                
                    // Thêm sự kiện cho nút Delete
                    deleteButton.on("click", function () {
                        // Xử lý sự kiện khi nút Delete được click
                        console.log(`Delete button clicked for item with ID: ${item.id}`);
                        formIDDelete = item.id;
                        deleteData(item.id);

                    });

                });

            },
            error: function (response) {
                console.log("Lỗi không thể tải được bảng !! Hãy kiểm tra lại API");
            }
        });
    }

    function createData() {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/v1/departments",
            data: JSON.stringify({ 
                "name": $("#formInputName").val()
            }), 
            contentType: "application/json",
            success: function(response) {
                alert("Thêm thành công!!");
                readData();
                //location.reload();
            },
            error: function(error) {
                alert("Thêm thất bại!!");
            }
        });
    }

    function updateDate(id){
        alert(`Bạn sẽ thay đổi tên của ${id} thành ${ $("#formInputName").val()}`)
        $.ajax({
            type: "PUT",  // Sử dụng phương thức PUT
            url: `http://localhost:8080/api/v1/departments/${id}`,  // Thêm id vào URL
            data: JSON.stringify({ 
                "name": $("#formInputName").val(),
            }), 
            
            contentType: "application/json",
            success: function(response) {
                alert("Cập nhật thành công !!");
                readData();

                //location.reload();
            },
            error: function(error) {
                alert("Cập nhật thất bại !!");
            }
        });
        
    }

    function deleteData(id) {
        var userDecision = confirm("Bạn có muốn xóa ID: " + id + "?");
    
        if (userDecision) {
            $.ajax({
                type: "DELETE",
                url: `http://localhost:8080/api/v1/departments/${id}`,
                success: function(response) {
                    alert("Xóa thành công!!");
                    readData();
                    //location.reload();
                },
                error: function(error) {
                    alert("Xóa thất bại!!");
                }
            });
        } else {
            // Người dùng đã chọn Cancel
            console.log("Không xóa ID: " + id);
        }
    } 

}

