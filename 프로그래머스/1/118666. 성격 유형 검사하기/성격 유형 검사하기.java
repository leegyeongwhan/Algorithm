class Solution {
    public String solution(String[] survey, int[] choices) {
      String answer = "";

        int score_RT = 0, score_CF = 0, score_JM = 0, score_AN = 0;

        for (int i = 0; i < survey.length; i++) {
            int score = 0;
            switch (choices[i]) {
                case 1:
                    score -= 3;
                    break;
                case 2:
                    score -= 2;
                    break;
                case 3:
                    score -= 1;
                    break;
                case 4:
                    continue;
                case 5:
                    score += 1;
                    break;
                case 6:
                    score += 2;
                    break;
                case 7:
                    score += 3;
                    break;
            }
            String str = survey[i];
            switch (str) {
                case "RT":
                    score_RT += score;
                    break;
                case "TR":
                    score_RT -= score;
                    break;
                case "CF":
                    score_CF += score;
                    break;
                case "FC":
                    score_CF -= score;
                    break;
                case "JM":
                    score_JM += score;
                    break;
                case "MJ":
                    score_JM -= score;
                    break;
                case "AN":
                    score_AN += score;
                    break;
                case "NA":
                    score_AN -= score;
                    break;
            }
        }

        if (score_RT <= 0) {
            answer += "R";
        }else {
            answer += "T";
        }
        if (score_CF <= 0) {
            answer += "C";
        }else {
            answer += "F";
        }
        if (score_JM <= 0) {
            answer += "J";
        }else {
            answer += "M";
        }
        
        if (score_AN <= 0) {
            answer += "A";
        }else {
            answer += "N";
        }
        return answer;
    }
}