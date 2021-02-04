package cn.linguy.student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JdkNew {

    public static void main(String[] args) {

    }
    public Integer test(){
        Integer sum = Stream.iterate(0, n -> n + 1).limit(100).reduce(Integer::sum).get();
        return sum;
    }
}
