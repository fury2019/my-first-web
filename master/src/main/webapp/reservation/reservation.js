/**
 * 
 */
 
 function search(){
	let frm = document.searchForm;
	let checkin_date = frm.checkin_date;
	let checkout_date = frm.checkout_date;
	let room = frm.room;
	let adults =  frm.adults;
	let children = frm.children;
	let Cnt = parseInt(adults.value)+parseInt(children.value);
	
	
	if(!checkin_date.value){
		alert("체크인 날짜를 선택하세요");
		checkin_date.focus();
		return false;
	}
	
	if(!checkout_date.value){
		alert("체크아웃 날짜를 입력하세요");
		checkout_date.focus();
		return false;
	}
	
	if(checkout_date.value <= checkin_date.value){
		alert("체크인 날짜 이후로 선택하세요");
		checkout_date.focus();
		return false;
	}
	
	
	if(adults.value == 2 && children.value == 3){
      alert(" 총 인원은 최대 4명까지만 선택 가능합니다.");      
      return false;
   }
   if(adults.value == 3 && children.value == 2){
      alert(" 총 인원은 최대 4명까지만 선택 가능합니다.");      
      return false;
   }
   if(adults.value == 3 && children.value == 3){
      alert(" 총 인원은 최대 4명까지만 선택 가능합니다.");      
      return false;
   }
	
	
//	if(Cnt > 4){
//		alert(" 총 인원은 최대 4명까지만 선택 가능합니다.");
//		children.focus();
//		return false;
//	}
}