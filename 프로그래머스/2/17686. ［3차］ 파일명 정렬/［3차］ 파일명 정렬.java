import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public String[] solution(String[] files) {
    List<FileSort> list = new ArrayList<>();

        for (String file : files) {
            String head = "";
            String number = "";
            String tail = "";
            int idx = 0;

              for (; idx < file.length(); idx++) {
                char now = file.charAt(idx);
                if (now >= '0' && now <= '9') {
                    break;
                }
                head += now;
            }

            for (; idx < file.length(); idx++) {
                if (number.length() >= 5) {
                    break;
                }
                char now = file.charAt(idx);
                if (now >= '0' && now <= '9') {
                    number += now;
                } else {
                    break;
                }
            }

            for (; idx < file.length(); idx++) {
                char now = file.charAt(idx);
                tail += now;
            }

            list.add(new FileSort(head, number, tail));
        }
        Collections.sort(list);
        return list.stream().map(FileSort::toString).toArray(String[]::new);
    }
}

class FileSort implements Comparable<FileSort> {

    String head;
    String number;
    String tail;

    public FileSort(String head, String number, String tail) {
        this.head = head;
        this.number = number;
        this.tail = tail;
    }

    @Override
    public int compareTo(FileSort fileSort) {
    String first = fileSort.head.toUpperCase();
        String second = this.head.toUpperCase();
        if (first.equals(second)) {
            Integer firstInt = Integer.parseInt(fileSort.number);
            Integer secondInt = Integer.parseInt(this.number);
            if (firstInt.equals(secondInt)) {
                return 0;
            }
            return secondInt.compareTo(firstInt);
        }
        return second.compareTo(first);
    }

    @Override
    public String toString() {
        return head + number + tail;
    }
}