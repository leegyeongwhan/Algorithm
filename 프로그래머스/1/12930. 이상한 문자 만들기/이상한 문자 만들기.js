function solution(str) {
    let answer = "";
    const words = str.split(' ');
      for (let i = 0; i < words.length; i++) {
         for(let j = 0; j < words[i].length; j++){
             if (j % 2 != 0) {
                answer += words[i].charAt(j).toLowerCase();
             } else {
              answer += words[i].charAt(j).toUpperCase();
            }

         }
        if (i < words.length - 1) {
            answer += " ";
        }
    }
  return answer;
}
