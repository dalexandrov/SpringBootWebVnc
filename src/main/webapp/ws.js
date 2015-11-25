/**
 * Created by mitia on 25.11.15.
 */

var canvas;
var ctx;
var socket = new WebSocket("ws://localhost:8080/screen");//to be fixed to relative!!


socket.onopen = function () {
    console.log("Connection establisched");
    //for now just an empty message to get started
    socket.send("");
};

socket.onclose = function (event) {
    console.log("Connection closed/lost");
};

socket.onmessage = function (event) {
    console.log("Data received ");
    var imgObj = new Image();
    imgObj.src = event.data;
    ctx.drawImage(imgObj, 0, 0);
};

socket.onerror = function (error) {
    console.log("Error: " + error.message);
};

function init() {
    canvas = document.getElementById("screenCanvas");
    ctx = canvas.getContext("2d");
}

document.addEventListener("DOMContentLoaded", init, false);
