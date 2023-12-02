$(document).ready(function () {
    readData();
    hideModal();
    $("#btn-addNew").click(createData);

    function openModal() {
        $("#myModal").css({
            display: "block",
            top: "20px",
        });
    }

    function hideModal() {
        $("#myModal").css({
            display: "none"
        });
    }

    function readData() {
        $.ajax({
            type: "GET",
            url: "https://6528c32d931d71583df26e60.mockapi.io/Gamer",
            success: function (response) {
                // Xử lý dữ liệu ở đây
                $("tbody").empty();
                response.forEach(function (item, index) {
                    $("tbody").append(`
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.phone}</td>
                        <td>${item.ingame}</td>
                        <td>
                            <button type="button" class="btn btn-warning btn-update" onclick="openUpdateModal(${item.id})">Change</button>
                            <button type="button" class="btn btn-danger btn-delete" onclick="deleteGamer(${item.id})">Delete</button>
                        </td>
                    </tr>`);


                });
            },
            error: function (response) {
                console.log("Lỗi không thể tải được bảng !! Hãy kiểm tra lại API");
            }
        });
    }

    function createData() {
        openModal();
        $("#btn-hide").on("click", hideModal);
        $("#btn-send").on("click", function(event){
            event.preventDefault();
            create();
        })
    }



    function create(){  
        $.ajax({
            type: "POST",
            url: "https://6528c32d931d71583df26e60.mockapi.io/Gamer",
            data: JSON.stringify({ 
                "name": $("#hoTen").val(),
                "phone": $("#soDienThoai").val(),
                "ingame": $("#tenIngame").val()
            }), 
            // Thay đổi dữ liệu theo nhu cầu của bạn
            contentType: "application/json",
            success: function(response) {
                alert("Thêm thành công !!");
                location.reload();
            },
            error: function(error) {
                alert("Thêm thất bại !!");
            }
        });
    }

    function openUpdateModal(id){
        openModal(); //Đây là cửa sổ để User nhập thông tin
        $("#btn-hide").on("click", hideModal);
        $("#btn-send").on("click", function(event){
            event.preventDefault();
            update(id);
        })
    }

    function deleteGamer(id){
        $.ajax({
            type: "DELETE",
            url: `https://6528c32d931d71583df26e60.mockapi.io/Gamer/${id}`,
            success: function (response) {
                alert("Xóa thành công !!");
                location.reload();
            },
            error: function (error) {
                alert("Xóa thất bại !!");
            }
        });
        
    }

    function update(id){
       
        $.ajax({
            type: "PUT",  // Sử dụng phương thức PUT
            url: `https://6528c32d931d71583df26e60.mockapi.io/Gamer/${id}`,  // Thêm id vào URL
            data: JSON.stringify({ 
                "name": $("#hoTen").val(),
                "phone": $("#soDienThoai").val(),
                "ingame": $("#tenIngame").val()
            }), 
            contentType: "application/json",
            success: function(response) {
                alert("Cập nhật thành công !!");
                location.reload();
            },
            error: function(error) {
                alert("Cập nhật thất bại !!");
            }
        });
        
    }

    function create(){  
        $.ajax({
            type: "POST",
            url: "https://6528c32d931d71583df26e60.mockapi.io/Gamer",
            data: JSON.stringify({ 
                "name": $("#hoTen").val(),
                "phone": $("#soDienThoai").val(),
                "ingame": $("#tenIngame").val()
            }), 
            // Thay đổi dữ liệu theo nhu cầu của bạn
            contentType: "application/json",
            success: function(response) {
                alert("Thêm thành công !!");
                location.reload();
            },
            error: function(error) {
                alert("Thêm thất bại !!");
            }
        });
    }


});



