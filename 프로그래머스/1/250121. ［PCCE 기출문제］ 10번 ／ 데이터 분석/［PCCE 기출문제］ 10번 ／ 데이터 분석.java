import java.util.*;


class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};            // "date"	20300501	"remain"
        int extNum = 0;
        int sortByNum = 0;

            switch (ext){
                case "code":
                    extNum = 0;
                    break;
                case "date":
                    extNum = 1;  
                    break;
                case "maximum":
                     extNum = 2; 
                     break;
                case "remain":
                     extNum = 3;
                     break;
            }
        
            switch (sort_by){
            case "code":
                sortByNum = 0;
                break;
            case "date":
                sortByNum = 1;
                break;
            case "maximum":
                sortByNum = 2;
                break;
            case "remain":
                sortByNum = 3;
                break;
        }
        
        List<int[]> list = new ArrayList();
        System.out.println("val_ext " + val_ext);
        System.out.println("extNum " + extNum);
        for (int i = 0; i < data.length; i++) {
            if(data[i][extNum] < val_ext){
            System.out.println("data[i][extNum] " + data[i][extNum]);
                list.add(data[i]);
            }       
        }
        //정렬 기준 생성
       int finalSortByNum = sortByNum;
        Comparator<int[]> comparator = Comparator.comparingInt(arr -> arr[finalSortByNum]);

        // List를 정의한 Comparator를 사용하여 정렬
        Collections.sort(list, comparator);
        
         return list.toArray(new int[0][]);
    }
}