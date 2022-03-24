function deleteBbs(id){

    $.ajax({
        type : 'DELETE',
        url  : `/api/bbs/${id}`,
        success:function (){
            alert('삭제가 완료되었습니다.')
            window.location.href='/';
        }
    })
}

function updateBbs(id){

    $.ajax({
        type : 'POST',
        url  : `/api/bbs/${id}`,
        success:function (){
            alert('삭제가 완료되었습니다.')
            window.location.href='/';
        }
    })
}