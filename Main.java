import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //데이터는 원본 유지 하고 새로운 걸 만들어야함

        list.add(1);
        list.add(2);
        list.add(3);
        // 만약 list*2 한 데이터를 요구

        List<Integer> list2 = new ArrayList<>();

        List<Integer> list3 = list;
        for (int i = 0; i < list.size(); i++) {
            list2.add(list.get(i)*2);
        }
//        System.out.println(list2);
//        System.out.println(list);
//
//        list3.add(3);
//        System.out.println(list);
       //익명함수
        Stream<Integer> stream = list.stream().map(el -> el * 2);
       System.out.println(stream);

        list.stream().map(el -> el * 2);
        List<Integer> collect = list2
                .stream()
                .map(el -> el * 2)
                .collect(Collectors.toList());

        System.out.println(collect);

        List<Integer> collect1 = list
                .stream()
                .filter(el -> el % 2 == 0)
                .map(el -> el * 2)
                .collect(Collectors.toList());
        System.out.println(collect1);
    }

    // stream 1.8 부터 나왔다.
