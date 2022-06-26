var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    $("#message").html("");
}

function connect() {
    var socket = new SockJS('/websocket'); // WebSocket通信開始
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        // /receive/messageエンドポイントでメッセージを受信し、表示する
        stompClient.subscribe('/receive/message', function (response) {
            showMessage(JSON.parse(response.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    // /send/messageエンドポイントにメッセージを送信する
    stompClient.send("/send/message", {}, JSON.stringify(
        {'sendingUserName': $("#sendingUserName").val(), 'detail': $("#detail").val()}));
    $("#detail").val('');
}

function showMessage(message) {
    // 受信したメッセージを整形して表示
    $("#message").append(
        "<tr><td>" + message.sendingUserName + ": " + message.detail + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendMessage();
    });
});

setTimeout("connect()", 3000);
