$(document).ready(function () {
    console.log("Asd");
   // getBbs();
})
// function getBbs(){
//     $(".trSection").empty();
//     $.ajax({
//         type: 'GET',
//         url: '/api/bbs',
//         success: function (response) {
//             for(let i =0;i<response.length;i++){
//                 let bbs =response[i];
//                 let id =bbs.id;
//                 let title = bbs.title;
//                 let writer = bbs.writer;
//                 let createdAt = bbs.createdAt;
//                 let tempHtml = `<tr>
//                                     <th scope="row">${id}</th>
//                                     <td>${title}</td>
//                                     <td>${writer}</td>
//                                     <td>${createdAt}</td>
//                                 </tr>`;
//                 $(".trSection").append(tempHtml);
//
//             }
//
//         }
//     })
// }
