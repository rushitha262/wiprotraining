// Display time zone at the top
function updateTime() {
    const tzDiv = document.getElementById("timezone");
    if (tzDiv) {
        const now = new Date();
        tzDiv.textContent = "Time: " + now.toLocaleTimeString();
    }
}
setInterval(updateTime, 1000);
updateTime();

// To-Do List using closure
function makeTodoList() {
    let tasks = []; // private array (closure)

    return {
        addTask: function(task) {
            tasks.push(task);
        },
        removeTask: function(index) {
            if (index >= 0 && index < tasks.length) {
                tasks.splice(index, 1);
            }
        },
        getTasks: function() {
            return tasks.slice();
        }
    };
}

// Create to-do list instance
const todo = makeTodoList();

// Add Task (does not display immediately)
document.getElementById("addTaskBtn").addEventListener("click", () => {
    const taskInput = document.getElementById("taskInput").value;
    if (taskInput.trim() !== "") {
        todo.addTask(taskInput);
        document.getElementById("taskInput").value = "";
        // Do not display tasks here
    }
});

// Remove Task by index (1-based index for user)
document.getElementById("removeTaskBtn").addEventListener("click", () => {
    const idxStr = document.getElementById("taskInput").value;
    const idx = parseInt(idxStr, 10);
    const tasks = todo.getTasks();
    if (!isNaN(idx) && idx >= 1 && idx <= tasks.length) {
        todo.removeTask(idx - 1);
        document.getElementById("taskInput").value = "";
    } else {
        alert("Please enter a valid task index to remove (as shown in the displayed list).");
    }
});

// Display Tasks when button is clicked
document.getElementById("showTasksBtn").addEventListener("click", () => {
    const taskList = document.getElementById("taskList");
    taskList.innerHTML = "";
    const tasks = todo.getTasks();
    if (tasks.length === 0) {
        taskList.innerHTML = "<li>No tasks available.</li>";
    } else {
        tasks.forEach((t, i) => {
            const li = document.createElement("li");
            li.textContent = `${i + 1}. ${t}`;
            taskList.appendChild(li);
        });
    }
});

// Calculator using arrow functions
const add = (a, b) => a + b;
const subtract = (a, b) => a - b;
const multiply = (a, b) => a * b;

document.getElementById("calcBtn").addEventListener("click", () => {
    const num1 = parseFloat(document.getElementById("num1").value);
    const num2 = parseFloat(document.getElementById("num2").value);
    const operation = document.getElementById("operation").value;
    let result;

    if (isNaN(num1) || isNaN(num2)) {
        result = "Please enter valid numbers";
    } else {
        if (operation === "+") {
            result = add(num1, num2);
        } else if (operation === "-") {
            result = subtract(num1, num2);
        } else if (operation === "*") {
            result = multiply(num1, num2);
        } else {
            result = "Invalid operation";
        }
    }

    document.getElementById("calcResult").textContent = `Result: ${result}`;
});
