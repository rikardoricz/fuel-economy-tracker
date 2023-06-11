function addFuelEntry() {
  var distance = document.getElementById("distance").value;
  var liters = document.getElementById("liters").value;
  var date = document.getElementById("date").value;

  var entry = {
    distance: distance,
    liters: liters,
    date: date,
  };

  var xhr = new XMLHttpRequest();
  const url = "http://localhost:8080/fuel-entries";
  xhr.open("POST", url);
  xhr.setRequestHeader("Content-Type", "application/json");
  xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
  xhr.setRequestHeader("Access-Control-Allow-Credentials", "true");
  xhr.onload = function () {
    if (xhr.status === 200) {
      var response = JSON.parse(xhr.responseText);
      displayFuelEntry(response);
      calculateAverageFuelConsumption();
      resetForm();
    } else {
      console.error(xhr.statusText);
    }
  };
  xhr.send(JSON.stringify(entry));
}

function displayFuelEntry(entry) {
  var table = document.getElementById("fuelEntriesTable");
  var row = table.insertRow(-1);
  var dateCell = row.insertCell(0);
  var distanceCell = row.insertCell(1);
  var litersCell = row.insertCell(2);

  dateCell.textContent = entry.date;
  distanceCell.textContent = entry.distance;
  litersCell.textContent = entry.liters;
}

function calculateAverageFuelConsumption() {
  var xhr = new XMLHttpRequest();
  const url = "http://localhost:8080/fuel-entries/average-fuel-consumption";
  xhr.open("GET", url);
  xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
  xhr.setRequestHeader("Access-Control-Allow-Credentials", "true");
  xhr.onload = function () {
    if (xhr.status === 200) {
      var averageFuelConsumption = parseFloat(xhr.responseText).toFixed(2);
      document.getElementById("averageFuelConsumption").textContent =
        averageFuelConsumption;
    } else {
      console.error(xhr.statusText);
    }
  };
  xhr.send();
}
function resetForm() {
  document.getElementById("distance").value = "";
  document.getElementById("liters").value = "";
  document.getElementById("date").value = "";
}

function fetchFuelEntries() {
  var xhr = new XMLHttpRequest();
  const url = "http://localhost:8080/fuel-entries";
  xhr.open("GET", url);
  xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
  xhr.setRequestHeader("Access-Control-Allow-Credentials", "true");
  xhr.onload = function () {
    if (xhr.status === 200) {
      var fuelEntries = JSON.parse(xhr.responseText);
      fuelEntries.forEach(function (entry) {
        displayFuelEntry(entry);
      });
    } else {
      console.error(xhr.statusText);
    }
  };
  xhr.send();
}

fetchFuelEntries();
calculateAverageFuelConsumption();
