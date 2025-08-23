
<html>
<head>
  <title>Contacts</title>
  <script>
    function loadContacts() {
      let contacts = JSON.parse(localStorage.getItem("contacts") || "[]");
      let table = document.getElementById("contactTable");
      table.innerHTML = "";
      contacts.forEach((c, idx) => {
        table.innerHTML += `
          <tr>
            <td>${idx+1}</td>
            <td>${c.name}</td>
            <td>${c.email}</td>
            <td>${c.phone}</td>
            <td>
              <button onclick="editContact(${idx})">Edit</button>
              <button onclick="deleteContact(${idx})">Delete</button>
            </td>
          </tr>`;
      });
    }

    function addContact(event) {
      event.preventDefault();
      let name = document.getElementById("name").value;
      let email = document.getElementById("email").value;
      let phone = document.getElementById("phone").value;
      if (!name || !email) {
        showMessage("Name and Email required!", true);
        return;
      }
      let contacts = JSON.parse(localStorage.getItem("contacts") || "[]");
      contacts.push({name,email,phone});
      localStorage.setItem("contacts", JSON.stringify(contacts));
      showMessage("Contact added successfully!");
      document.getElementById("contactForm").reset();
      loadContacts();
    }

    function editContact(idx) {
      let contacts = JSON.parse(localStorage.getItem("contacts") || "[]");
      let c = contacts[idx];
      document.getElementById("name").value = c.name;
      document.getElementById("email").value = c.email;
      document.getElementById("phone").value = c.phone;
      document.getElementById("editIndex").value = idx;
    }

    function updateContact(event) {
      event.preventDefault();
      let idx = document.getElementById("editIndex").value;
      if (idx === "") return addContact(event);

      let contacts = JSON.parse(localStorage.getItem("contacts") || "[]");
      contacts[idx] = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        phone: document.getElementById("phone").value
      };
      localStorage.setItem("contacts", JSON.stringify(contacts));
      showMessage("Contact updated successfully!");
      document.getElementById("contactForm").reset();
      document.getElementById("editIndex").value = "";
      loadContacts();
    }

    function deleteContact(idx) {
      let contacts = JSON.parse(localStorage.getItem("contacts") || "[]");
      contacts.splice(idx,1);
      localStorage.setItem("contacts", JSON.stringify(contacts));
      showMessage("Contact deleted!");
      loadContacts();
    }

    function showMessage(msg, error=false) {
      let box = document.getElementById("msg");
      box.innerHTML = msg;
      box.style.color = error ? "red" : "green";
      setTimeout(()=>{ box.innerHTML=""; }, 3000);
    }

    window.onload = loadContacts;
  </script>
</head>
<body>
  <h2>Contact Manager</h2>
  <div id="msg"></div>
  <form id="contactForm" onsubmit="updateContact(event)">
    <input type="hidden" id="editIndex"/>
    Name: <input type="text" id="name"/><br/>
    Email: <input type="text" id="email"/><br/>
    Phone: <input type="text" id="phone"/><br/>
    <button type="submit">Save</button>
  </form>

  <h3>All Contacts</h3>
  <table border="1">
    <thead><tr><th>#</th><th>Name</th><th>Email</th><th>Phone</th><th>Actions</th></tr></thead>
    <tbody id="contactTable"></tbody>
  </table>
</body>
</html>
