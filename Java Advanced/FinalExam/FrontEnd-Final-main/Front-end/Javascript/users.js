$(document).ready(function() {
    var selectedUserId = null;
    let username = sessionStorage.getItem("username");
    let password = sessionStorage.getItem("password");

    console.log(username + password);

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
                console.log(data);
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
        </tr>`;
        accTableBody.append(row);
    }
}

// maxPieces
// minPieces
// createDay
// maxCreateDay
// minCreateDay
// maxPrice
// minPrice


// function getInfoSearch(){
//     let type = document.getElementById("productType").value;
//     let maxPieces = document.getElementById("maxPieces").value;
//     let minPieces = document.getElementById("minPieces").value;
//     let createDay = document.getElementById("createDay").value;
//     let maxCreateDay = document.getElementById("maxCreateDay").value;
//     let minCreateDay = document.getElementById("minCreateDay").value;
//     let maxPrice = document.getElementById("maxPrice").value;
//     let minPrice = document.getElementById("minPrice").value;
//     let search = document.getElementById("search").value;


    
//     let infoSearch = {
//         type : type,
//         maxPieces : maxPieces,
//         minPieces : minPieces,
//         createDay : createDay,
//         maxCreateDay : maxCreateDay,
//         minCreateDay : minCreateDay,
//         maxPrice : maxPrice,
//         minPrice : minPrice
//     }

//     console.log(infoSearch);

//     let username = sessionStorage.getItem("username");
//     let password = sessionStorage.getItem("password");

//     if (username && password) {
//         let authHeader = "Basic " + btoa(username+ ':' + password);
        

//         $.ajax({
//             url: `http://localhost:8080/api/v1/lego?search=${search}&form=${infoSearch}`,
//             type: "GET",
//             headers: {
//                 'Authorization': authHeader
//             },
//             crossDomain: true,
//             xhrFields: {
//               withCredentials: true
//             },
//             success: function(response) {
//                 var data = response;
//                 console.log(data);
//                 populateTable(data);
//             },
//             error: function(xhr, status, error) {
//                 console.error(error);
//             }
//         });
//     } else {
//         console.log("Không tìm thấy thông tin xác thực trong sessionStorage.");
//     }
    
// }

function getInfoSearch() {
    let type = document.getElementById("productType").value;
    let maxPieces = document.getElementById("maxPieces").value;
    let minPieces = document.getElementById("minPieces").value;
    let createDay = document.getElementById("createDay").value;
    let maxCreateDay = document.getElementById("maxCreateDay").value;
    let minCreateDay = document.getElementById("minCreateDay").value;
    let maxPrice = document.getElementById("maxPrice").value;
    let minPrice = document.getElementById("minPrice").value;
    let search = document.getElementById("search").value;
  
    let infoSearch = {
      type: type,
      maxPieces: maxPieces,
      minPieces: minPieces,
      createDay: createDay,
      maxCreateDay: maxCreateDay,
      minCreateDay: minCreateDay,
      maxPrice: maxPrice,
      minPrice: minPrice
    };
  
    console.log(infoSearch);
  
    $.ajax({
        url: `http://localhost:8080/api/v1/lego?search=${search}&form=${JSON.stringify(infoSearch)}`,
        type: "GET",
        crossDomain: true, 
        xhrFields: { withCredentials: true }, 
        success: function(response) {
          var data = response;
          console.log(data);
          populateTable(data);
        },
        error: function(xhr, status, error) {
          console.error(error);
        }
      });
  }