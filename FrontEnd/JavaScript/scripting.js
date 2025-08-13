function updateClock() {
    let now = new Date();

    // Get hours, minutes, seconds
    let hours = now.getHours();
    let minutes = String(now.getMinutes()).padStart(2, '0');
    let seconds = String(now.getSeconds()).padStart(2, '0');

    // Determine greeting
    let greeting = "";
    if (hours < 12) {
        greeting = "Good Morning";
    } else if (hours < 16) {
        greeting = "Good Afternoon";
    } else {
        greeting = "Good Night";
    }

    // Format time as HH:MM:SS (12-hour format optional)
    let formattedHours = String(hours).padStart(2, '0');
    let timeString = `${formattedHours}:${minutes}:${seconds}`;

    // Display greeting + time
    document.getElementById("clockhours").textContent = `${greeting} - ${timeString}`;
}

// Update every second
setInterval(updateClock, 1000);

// Initial call
updateClock();
