import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id =  new_id.toLowerCase(); //1단계
    
        System.out.println("1단계" + new_id);
        for(int i = 0; i < new_id.length(); i++){ //2단계
             char ch  =  new_id.charAt(i);
            if('a' <= ch && ch <= 'z'){
                answer += ch +"";
            }else if('0' <= ch && ch <= '9'){
                answer += ch +"";
            }else if(ch == '-' || ch == '_' || ch == '.' ){
                answer += ch +"";
            }else{     
                continue;
            }
        }
        
        System.out.println("2단계" +answer);
        
        while(answer.indexOf("..") != -1){ //3단계
         answer =  answer.replace("..",".");
        }
        
        System.out.println("3단계" +answer);

        if(!answer.isEmpty() && answer.charAt(0) == '.'){ //4단계
            answer =  answer.substring(1);
        }
       if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.'){
             answer =  answer.substring(0, answer.length()-1);
        }
    
        System.out.println("4단계" +answer);
         System.out.println("4단계" +answer.length());

        if(answer.isEmpty()){ //5단계
            answer += "a";
        }
        
        // answer =  answer.replace(" ",""); //5단계

        System.out.println("5단계" +answer);

        if(answer.length() >= 16){ //6 단계
              answer =  answer.substring(0, 15);
            if(answer.charAt(answer.length()-1) == '.'){ // 6-1단계
              answer =  answer.substring(0, answer.length()-1);
            }
        }
        
        System.out.println("6단계" +answer);
        System.out.println("6단계" +answer.length());

        while (answer.length() < 3){    //7단계
           answer += answer.charAt(answer.length()-1) + ""; 
     }
        
        System.out.println("7단계" +answer);

        return answer;
    }
}   
