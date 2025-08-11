// 1. Store menu items with prices (only 4 items)
const menu = [
  { item: "Burger", price: 120 },
  { item: "Pizza", price: 250 },
  { item: "Pasta", price: 180 },
  { item: "Fries", price: 80 }
];

// Display menu
let menu1 = "";
for (let i = 0; i < menu.length; i++) {
  menu1 += "<li>" + menu[i].item + ": ₹" + menu[i].price + "</li>";
}
document.getElementById("menuList").innerHTML = menu1;

// 2. Take customer's orders
let customerOrders = ["Burger", "Fries", "Pizza", "Pasta"]; // Example orders

// Display orders
let order = "";
for (let i = 0; i < customerOrders.length; i++) {
  order += "<li>" + customerOrders[i] + "</li>";
}
document.getElementById("orderList").innerHTML = order;

// 3. Calculate total price
let total = 0;
let orderDetails = [];

for (let i = 0; i < customerOrders.length; i++) {
  let found = false;
  for (let j = 0; j < menu.length; j++) {
    if (menu[j].item === customerOrders[i]) {
      total += menu[j].price;
      orderDetails.push(menu[j]);
      found = true;
      break;
    }
  }
  if (!found) {
    orderDetails.push({ item: customerOrders[i], price: "Not Found" });
  }
}

// Apply 10% discount if more than 3 items ordered
let discount = 0;
if (customerOrders.length > 3) {
  discount = total * 0.1;
}

let finalAmount = total - discount;

// 4. Display only total, discount, and final amount
document.getElementById("billOutput").textContent =
  "Total Price: " + total + "\n" +
  "Discount Applied: " + discount + "\n" +
  "Final Amount: " + finalAmount;
