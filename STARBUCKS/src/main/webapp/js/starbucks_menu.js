let imgs = document.getElementsByTagName('img');
Array.from(imgs).forEach(function(img){
	img.addEventListener('click', function(){
		removeBorderStyle();
		img.style.border = '5px solid red';
		document.getElementById('menu').value = img.dataset.menu;
	});
});
function removeBorderStyle(){
	let imgs = document.getElementsByTagName('img');
	Array.from(imgs).forEach(function(img){
		img.style.removeProperty('border');
	});
}
document.getElementById('btnOrder').addEventListener('click',function(){
	document.getElementById('amount').value = document.getElementById('count').value;
	document.getElementById('orderForm').submit();
});