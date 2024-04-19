var hour = 0;
var minute = 10;
var second = 60;


var interval;


self.addEventListener('message', function (event){
    setUpTimer(event.data);
})

function setUpTimer(mSecond){

    interval  = setInterval(timer, mSecond);

    function timer(){
        if (second !== 0){
            if (second >= 11){
                if (minute <=1){
                    second -=1;
                    self.postMessage({minute: minute, second: second,color: "red"});
                }
                else{
                    second -=1;
                    self.postMessage({minute: minute, second: second});
                }

            }
            else {
                if (minute <=1){
                    second -=1;
                    self.postMessage({minute: minute, second: "0" + second,color: "red"});
                }
                else{
                    second -=1;
                    self.postMessage({second: "0" + second, minute: minute})

                }

            }

        }


        if (second === 0){
            if(minute === 0){
                clearInterval(interval);
                self.postMessage({minute: minute, second: second, finished: true})
            }
            else{
                minute -= 1;
                second = 60;
            }
        }

    }

}










