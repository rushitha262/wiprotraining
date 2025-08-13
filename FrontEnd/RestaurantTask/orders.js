function loadItems() {
    const tbody = document.querySelector('#menuTable tbody');
    tbody.innerHTML = '';
    let items = JSON.parse(localStorage.getItem('menuItems') || '[]');
    items.forEach((item, idx) => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${item.name}</td>
            <td>${item.desc}</td>
            <td>${item.category || ''}</td>
            <td>${item.price}</td>
            <td>${item.availability}</td>
            <td>
                <button onclick="editItem(${idx})">Edit</button>
                <button onclick="deleteItem(${idx})">Delete</button>
            </td>
        `;
        tbody.appendChild(tr);
    });
}

function deleteItem(idx) {
    let items = JSON.parse(localStorage.getItem('menuItems') || '[]');
    items.splice(idx, 1);
    localStorage.setItem('menuItems', JSON.stringify(items));
    loadItems();
}

function editItem(idx) {
    // Redirect to Task.html with edit index (implement edit logic in Task.js)
    location.href = `Task.html?edit=${idx}`;
}

window.onload = loadItems;