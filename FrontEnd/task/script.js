
    function loadItems() {
        const items = JSON.parse(localStorage.getItem('menuItems')) || [];
        const table = document.getElementById('menuTable');
        table.innerHTML = '';
        items.forEach((item, index) => {
            table.innerHTML += `
                <tr>
                    <td>${item.name}</td>
                    <td>${item.Discription}</td>
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

    function editItem(index) {
        localStorage.setItem('editIndex', index);
        window.location.href = 'add.html';
    }

    function deleteItem(index) {
        let items = JSON.parse(localStorage.getItem('menuItems')) || [];
        items.splice(index, 1);
        localStorage.setItem('menuItems', JSON.stringify(items));
        loadItems();
    }

    loadItems();
