// 1. Array of subjects
const subjects = [
    { name: "Mathematics", marks: 0 },
    { name: "Science", marks: 0 },
    { name: "Computer Science", marks: 0 }
];

// 2. Dynamically display subject input fields
let container = document.getElementById("subjectsContainer");
subjects.forEach((subject, index) => {
    container.innerHTML += `
        <div class="mb-3">
            <label class="form-label">${subject.name} Marks</label>
            <input type="number" class="form-control" id="marks-${index}" placeholder="Enter marks (0-100)" min="0" max="100" required>
        </div>
    `;
});

// 3. Handle form submission
document.getElementById("reportForm").addEventListener("submit", function (event) {
    event.preventDefault();

    let totalMarks = 0;
    let maxMarks = subjects.length * 100;

    // Read marks from input fields
    subjects.forEach((subject, index) => {
        let marks = parseInt(document.getElementById(`marks-${index}`).value) || 0;
        subject.marks = marks;
        totalMarks += marks;
    });

    // Calculate percentage
    let percentage = (totalMarks / maxMarks) * 100;

    // Assign grade
    let grade = "";
    if (percentage >= 90) grade = "A+";
    else if (percentage >= 80) grade = "A";
    else if (percentage >= 70) grade = "B";
    else if (percentage >= 60) grade = "C";
    else if (percentage >= 50) grade = "D";
    else grade = "F";

    // Display result in alert
    alert(
        `Total Marks: ${totalMarks}\n` +
        `Percentage: ${percentage.toFixed(2)}%\n` +
        `Grade: ${grade}`
    );
});

// Timer at the top
function updateTimer() {
    const timer = document.getElementById('timer');
    if (timer) {
        const now = new Date();
        timer.textContent = now.toLocaleTimeString();
    }
}
setInterval(updateTimer, 1000);
updateTimer();

// To-Do List using closure
function createTodoList() {
    let tasks = [];
    return {
        add: function(task) {
            tasks.push(task);
        },
        remove: function(index) {
            if (index >= 0 && index < tasks.length) {
                tasks.splice(index, 1);
            }
        },
        getAll: function() {
            return tasks.slice();
        }
    };
}
const todo = createTodoList();

function renderTodoList() {
    const list = document.getElementById('todoList');
    if (!list) return;
    list.innerHTML = '';
    todo.getAll().forEach((task, idx) => {
        const li = document.createElement('li');
        li.className = 'list-group-item';
        li.textContent = `${idx + 1}. ${task}`;
        list.appendChild(li);
    });
}

const addTaskBtn = document.getElementById('addTaskBtn');
if (addTaskBtn) {
    addTaskBtn.onclick = function() {
        const input = document.getElementById('todoInput');
        const task = input.value.trim();
        if (task) {
            todo.add(task);
            input.value = '';
            renderTodoList();
        }
    };
}

const removeTaskBtn = document.getElementById('removeTaskBtn');
if (removeTaskBtn) {
    removeTaskBtn.onclick = function() {
        const idx = parseInt(document.getElementById('removeTaskIndex').value, 10) - 1;
        todo.remove(idx);
        document.getElementById('removeTaskIndex').value = '';
        renderTodoList();
    };
}

const displayTasksBtn = document.getElementById('displayTasksBtn');
if (displayTasksBtn) {
    displayTasksBtn.onclick = function() {
        const tasks = todo.getAll();
        if (tasks.length === 0) {
            alert("No tasks to display.");
        } else {
            alert("Tasks:\n" + tasks.map((t, i) => `${i + 1}. ${t}`).join('\n'));
        }
    };
}

renderTodoList();

// Calculator using arrow functions
const add = (a, b) => a + b;
const sub = (a, b) => a - b;
const mul = (a, b) => a * b;

const calcBtn = document.getElementById('calcBtn');
if (calcBtn) {
    calcBtn.onclick = function() {
        const n1 = parseFloat(document.getElementById('calcNum1').value);
        const n2 = parseFloat(document.getElementById('calcNum2').value);
        const op = document.getElementById('calcOp').value;
        let result = '';
        if (!isNaN(n1) && !isNaN(n2)) {
            if (op === '+') result = add(n1, n2);
            else if (op === '-') result = sub(n1, n2);
            else if (op === '*') result = mul(n1, n2);
            document.getElementById('calcResult').textContent = `Result: ${result}`;
        } else {
            document.getElementById('calcResult').textContent = 'Please enter valid numbers.';
        }
    };
}