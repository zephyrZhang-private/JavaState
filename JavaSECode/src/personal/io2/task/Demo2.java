package personal.io2.task;

import java.io.*;
import java.util.*;

public class Demo2 {
    public static void main(String[] args) throws IOException {

        File file = new File("src/com/personal/task2/demo2.txt");

        Map<String,Integer> map = new HashMap();

        String mess[] ;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i1 = 1; i1 <= 5; i1++) {
            System.out.println("请输入第"+i1+"个成绩数据（格式:姓名,语文,数学,英语）:");

            String line = bufferedReader.readLine();
            mess = line.split(",");
            String s1=mess[0];
            String count = insert(mess);
            map.put(s1,Integer.parseInt(count));
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (Map.Entry<String,Integer> m :list
             ) {
            bufferedWriter.write(m.getKey()+m.getValue());
            bufferedWriter.newLine();
//            System.out.println(m.getKey()+m.getValue());
        }

        bufferedWriter.close();

    }

//    计算成绩
    static String insert(String[] ints){
        int count=0;
        for (int i=1;i<ints.length;i++) {
            count += Integer.parseInt(ints[i]);
        }
        return count+"";
    }


}