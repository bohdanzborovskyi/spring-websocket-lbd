var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#machineValues").html("");
}

function connect() {
    var socket = new SockJS('/lbd-test');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        stompClient.subscribe('/msg/info', function (greeting) {
            var machineValues = JSON.parse(greeting.body);
            showMachineValues(machineValues);
            showSumUpValue(machineValues.sum);
            changeColor(machineValues.circleColor);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
}

function showMachineValues(machineModel) {
    $("#machineValues").append("<tr class=\"text-center\">" +
        "<td>" + "Decimal places: " + machineModel.decimalPlaces + "</td>" +
        "<td>" + "Multiplier: " + machineModel.multiplier + "</td>" +
        "<td>" + "Value one: " + machineModel.valueOne + "</td>" +
        "<td>" + "Value two: " + machineModel.valueTwo + "</td>" +
        "</tr>");
    if (document.getElementById("machineValues").rows.length > 10) {
        $("#machineValues tr:first-child").remove();
    }
}

function showSumUpValue(sum) {
    document.getElementById("sumUpMachineValue").textContent = sum;
}

function changeColor(circleColor) {
    document.getElementById("colorIndicator").style.backgroundColor = circleColor;
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
});
