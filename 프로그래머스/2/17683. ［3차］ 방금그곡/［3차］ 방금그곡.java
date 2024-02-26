import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int tmp  = -1;
  
        m =  m.replaceAll("C#", "1");
        m =  m.replaceAll("D#", "2");
        m =  m.replaceAll("F#", "3");
        m =  m.replaceAll("G#", "4");
        m =  m.replaceAll("A#", "5");
        m =  m.replaceAll("B#", "6");

        System.out.println("m "+ m); 
        
        
        for(int i = 0; i < musicinfos.length; i++){
            String[] musicInfo = musicinfos[i].split(","); // 시작, 끝, 제목 ,악보
            LocalTime startTime = LocalTime.parse(musicInfo[1], DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime endTime = LocalTime.parse(musicInfo[0], DateTimeFormatter.ofPattern("HH:mm"));

             // 두 시간의 차이 계산
            Duration duration = Duration.between(endTime, startTime);

            // 차이를 초로 변환하여 정수로 얻기
            int time = (int) duration.toMinutes();
            String title = musicInfo[2];
            String sheet  = musicInfo[3];
            String str = "";
            // System.out.println(time / sheet.length());
            // System.out.println(time % sheet.length());

             
            sheet =  sheet.replaceAll("C#", "1");
            sheet =  sheet.replaceAll("D#", "2");
            sheet =  sheet.replaceAll("F#", "3");
            sheet =  sheet.replaceAll("G#", "4");
            sheet =  sheet.replaceAll("A#", "5");
                        sheet =  sheet.replaceAll("B#", "6");

            for (int j = 0; j < time / sheet.length(); j++) {
                str += sheet;
            }

            for (int k = 0; k < time % sheet.length(); k++) {
                str += sheet.charAt(k);
            }  
   

            System.out.println("str의 값 : " + str); //ex) CDEFGABCDEFGAB
            if(str.contains(m) && time > tmp){           
                System.out.println("성공");
                 System.out.println("tmp 값 : " + tmp); //ex) CDEFGABCDEFGAB
                 System.out.println("time 값 : " + time); //ex) CDEFGABCDEFGAB
                  answer = title;
                  tmp = time;
            }                      
        }
        
         return tmp != -1 ? answer : "(None)";
    }
}