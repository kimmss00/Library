/**
 * 
 */
	$(document).ready(function(){
		
		$('#go_view_update').on('click',function(){
			alert($('#book_seq').val());
			$('#frm').attr('action','view_update.do?no='+$('#no').val());
			$('#frm').submit();
		});
		
		$('#go_book_list').on('click',function(){
			alert('go');
			$('#frm').attr('action','list.do');
			$('#frm').attr('method','get');
			$('#frm').submit();
		});
		
		$('#go_book_regist').on('click',function(){
			$('#frm').attr('action','regist.do');
			$('#frm').submit();
		});
		
		
		
		$('#go_book_update').on('click',function(){
			$('#frm').attr('action','update.do?no='+$('#no').val());
			$('#frm').submit();
		});
		
	});
		
