function solution(s){
    var answer = true;
    var countP = 0;
    var countY = 0;
    s = s.toUpperCase(s);

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    for(var i = 0; i < s.length; i++){
        if(s[i] == "P"){
            countP++;
        }else if(s[i] == "Y"){
            countY++;            
        }
    }
    console.log(countP);
    console.log(countY);
 
    
       return countP === countY;
}