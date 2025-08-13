// Show section
function showSection(id) {
    document.querySelectorAll("main section").forEach(sec => sec.style.display = "none");
    document.getElementById(id).style.display = "block";
    if (id === "viewItems") loadItems();
}

// Load items into table
function loadItems() {
    const items = JSON.parse(localStorage.getItem('menuItems')) || [];
    const table = document.getElementById('menuTable');
    table.innerHTML = '';
    items.forEach((item, index) => {
        table.innerHTML += `
            <tr>
                <td>${item.name}</td>
                <td>${item.description}</td>
                <td>${item.price}</td>
                <td>${item.category}</td>
                <td>${item.availability}</td>
                <td>
                    <button onclick="editItem(${index})">Edit</button>
                    <button onclick="deleteItem(${index})">Delete</button>
                </td>
            </tr>
        `;
    });
}

// Edit item
function editItem(index) {
    const items = JSON.parse(localStorage.getItem('menuItems')) || [];
    const item = items[index];
    document.getElementById('name').value = item.name;
    document.getElementById('description').value = item.description;
    document.getElementById('price').value = item.price;
    document.getElementById('category').value = item.category;
    document.getElementById('availability').value = item.availability;
    document.getElementById('editIndex').value = index;
    document.getElementById('form-title').innerText = 'Edit Item';
    showSection('addItem');
}

// Delete item
function deleteItem(index) {
    let items = JSON.parse(localStorage.getItem('menuItems')) || [];
    items.splice(index, 1);
    localStorage.setItem('menuItems', JSON.stringify(items));
    loadItems();
}

// Handle form submission
document.getElementById('itemForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const name = document.getElementById('name').value;
    const description = document.getElementById('description').value;
    const price = document.getElementById('price').value;
    const category = document.getElementById('category').value;
    const availability = document.getElementById('availability').value;
    const editIndex = document.getElementById('editIndex').value;

    let items = JSON.parse(localStorage.getItem('menuItems')) || [];

    if (editIndex) {
        items[editIndex] = { name, description, price, category, availability };
        alert('Item updated successfully!');
    } else {
        items.push({ name, description, price, category, availability });
        alert('Item added successfully!');
    }

    localStorage.setItem('menuItems', JSON.stringify(items));

    // Reset form and go to view
    document.getElementById('itemForm').reset();
    document.getElementById('editIndex').value = '';
    document.getElementById('form-title').innerText = 'Add Item';
    showSection('viewItems');
});

// Start at home
showSection('home');
