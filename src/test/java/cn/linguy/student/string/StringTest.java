package cn.linguy.student.string;

public class StringTest {
    public static void main(String[] args) {
        String str = "/hsscnfa/gzyypt/fileSync/source/info/WD/20201201";
        int indexOf = str.indexOf("source")-1;
        str = str.substring(indexOf);
        System.out.println(str);

    }
}
