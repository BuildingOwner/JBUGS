let currentYear;
let currentMonth;
let eventTitleInput;
let selectedDate = null; // Move selectedDate here to ensure it's accessible to the saveEvent function

document.addEventListener("DOMContentLoaded", function () {
  const currentDate = new Date();
  currentYear = currentDate.getFullYear();
  currentMonth = currentDate.getMonth();

  createCalendar(currentYear, currentMonth);
  setupEventHandlers();
});

function gotoPreviousMonth() {
  currentMonth--;
  if (currentMonth < 0) {
    currentYear--;
    currentMonth = 11;
  }
  createCalendar(currentYear, currentMonth);
  setupEventHandlers(); // Call setupEventHandlers after creating the calendar
}

function gotoNextMonth() {
  currentMonth++;
  if (currentMonth > 11) {
    currentYear++;
    currentMonth = 0;
  }
  createCalendar(currentYear, currentMonth);
  setupEventHandlers(); // Call setupEventHandlers after creating the calendar
}

function createCalendar(year, month) {
  const calendarEl = document.getElementById("calendar");
  calendarEl.innerHTML = ""; // Clear the calendar content

  const firstDay = new Date(year, month, 1);
  const lastDay = new Date(year, month + 1, 0);
  const daysInMonth = lastDay.getDate();
  const prevMonthDays = firstDay.getDay();
  const nextMonthDays = 6 - lastDay.getDay();

  const monthNames = [
    "1월",
    "2월",
    "3월",
    "4월",
    "5월",
    "6월",
    "7월",
    "8월",
    "9월",
    "10월",
    "11월",
    "12월",
  ];
  const dayNames = ["일", "월", "화", "수", "목", "금", "토"];

  const header = document.createElement("div");
  header.textContent = `${monthNames[month]} ${year}`;
  header.style.textAlign = "center";
  header.style.marginBottom = "10px";
  calendarEl.appendChild(header);

  const days = document.createElement("div");
  days.className = "calendar";
  for (let i = prevMonthDays; i > 0; i--) {
    const day = document.createElement("div");
    day.className = "day";
    day.textContent = new Date(year, month, -i + 1).getDate();
    day.classList.add("prev-month");
    days.appendChild(day);
  }
  for (let i = 1; i <= daysInMonth; i++) {
    const day = document.createElement("div");
    day.className = "day";
    day.textContent = i;
    days.appendChild(day);
  }
  for (let i = 1; i <= nextMonthDays; i++) {
    const day = document.createElement("div");
    day.className = "day";
    day.textContent = i;
    day.classList.add("next-month");
    days.appendChild(day);
  }
  calendarEl.appendChild(days);
  setupEventHandlers(); // Call setupEventHandlers after creating the calendar
}

function clearCalendar() {
  const calendarEl = document.getElementById("calendar");
  calendarEl.innerHTML = "";
}

function setupEventHandlers() {
  const calendarEl = document.getElementById("calendar");
  eventTitleInput = document.getElementById("eventTitle"); // Move this line here
  const saveEventBtn = document.getElementById("saveEventBtn"); // Move this line here

  calendarEl.addEventListener("click", function (event) {
    if (event.target.classList.contains("day")) {
      const selectedDay = event.target.textContent;
      const selectedMonth = calendarEl
        .querySelector("div:first-child")
        .textContent.split(" ")[0];
      const selectedYear = calendarEl
        .querySelector("div:first-child")
        .textContent.split(" ")[1];

      const currentDate = new Date();
      const currentDay = currentDate.getDate();
      const currentMonth = currentDate.toLocaleString("default", {
        month: "long",
      });
      const currentYear = currentDate.getFullYear();

      if (
        selectedYear == currentYear &&
        selectedMonth == currentMonth &&
        selectedDay == currentDay
      ) {
        event.target.classList.add("today");
      } else {
        const today = calendarEl.querySelector(".today");
        if (today) {
          today.classList.remove("today");
        }
      }

      // Show add event form
      addEventForm.style.display = "block";
      eventTitleInput.focus();

      // Store the selected date
      selectedDate = `${selectedYear}-${selectedMonth}-${selectedDay}`;
    }
  });

  saveEventBtn.addEventListener("click", function () {
    saveEvent();
  });
}

function init() {
  const currentDate = new Date();
  const currentYear = currentDate.getFullYear();
  const currentMonth = currentDate.getMonth();

  createCalendar(currentYear, currentMonth);
  setupEventHandlers();
}

init();

function saveEvent() {
  const eventTitle = eventTitleInput.value;
  if (eventTitle.trim() !== "" && selectedDate) {
    const eventDiv = document.createElement("div");
    eventDiv.textContent = eventTitle;
    eventDiv.className = "event";

    const days = document.querySelectorAll(".day");
    for (const day of days) {
      if (
        !day.classList.contains("prev-month") &&
        !day.classList.contains("next-month")
      ) {
        if (day.textContent === selectedDate.split("-")[2]) {
          day.appendChild(eventDiv);
          break;
        }
      }
    }

    // Clear the input and hide the form
    eventTitleInput.value = "";
    addEventForm.style.display = "none";
    selectedDate = null; // Reset the selected date
  }
}
