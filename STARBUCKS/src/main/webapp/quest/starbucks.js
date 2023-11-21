/*let amount;

let coffee1_name="나이트로 바닐라 크림";
let coffee2_name="돌체 콜드 브루";
let coffee3_name="제주 비자림 콜드 브루";

let coffee1_price=6100;
let coffee2_price=6000;
let coffee3_price=6800;

function coffee1() {
	document.getElementById('bills_name').innerHTML=coffee1_name+"\n";
	document.getElementById('bills_price').innerText="￦"+coffee1_price+"원";	
}

function coffee2() {
	document.getElementById('bills_name').innerHTML=coffee2_name+"\n";
	document.getElementById('bills_price').innerText="￦"+coffee2_price+"원";	
}

function coffee3() {
	document.getElementById('bills_name').innerText=coffee3_name;
	document.getElementById('bills_price').innerText="￦"+coffee3_price+"원";	
}
*/
let coffeeNames = [];
let coffeePrices = [];
let price = 0;
let amount = 0;
let print="";

function coffee1() {
   coffeeNames.push("나이트로 바닐라 크림 ");
   coffeePrices.push(6100);
   updateBill();
}

function coffee2() {
   coffeeNames.push("돌체 콜드 브루      ");
   coffeePrices.push(6000);
   updateBill();
}

function coffee3() {
   coffeeNames.push("제주 비자림 콜드브루");
   coffeePrices.push(6800);
   updateBill();
}

function updateBill() {
   
   const billsName = document.getElementById('bills');
   const amountPrice = document.getElementById('amount');

   // 기존 내용을 모두 지우고 새로운 내용을 추가
   let combinedData = "";
   for (let i = 0; i < coffeeNames.length; i++) {
      combinedData = coffeeNames[i] + "                                                                                       " + coffeePrices[i] + "\n";
      price = coffeePrices[i];
   }
   amount += price;
   print+=combinedData;
   billsName.innerHTML = print;
   amountPrice.innerHTML = "총액                                                                                " + amount;
}

function resetBill() {

   print="";
   
   amount=0;
   document.getElementById('bills').innerHTML=print;
   document.getElementById('amount').innerHTML="총액                                                                                " + amount;

}

/*function updateBill() {
  const billsName = document.getElementById('bills_name');
  const billsPrice=document.getElementById('bills_price');
  const amoutPrice=document.getElementById('amount');
  amount+=billsPrice;

  // 기존 내용을 모두 지우고 새로운 내용을 추가
  billsName.innerHTML = coffeeNames.join("\n") + "\n";
  billsPrice.innerHTML = coffeePrices.join("\n") + "\n";
  amountPrice.innerHTML = amount.join("\n") + "\n";
  */
	


