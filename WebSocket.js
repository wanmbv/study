var webSocket =  new WebSocket('wss://172.18.72.83:8443/tjrh/websocket'); 
        
webSocket.onopen = function(event) {      
    onOpen(event)      
};      
//
webSocket.onmessage = function(event) {      
    onMessage(event)      
}; 
// 
webSocket.onclose = function(event) {      
  onClose(event)      
};  
// 
webSocket.onerror = function(event) {      
    onError(event)      
};   
