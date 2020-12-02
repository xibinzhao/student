package cn.linguy.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTest {
//    public static void main(String[] args) {
//        String bussinessDate = "20201127";
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMdd");
//        Date parse = null;
//        try {
//            parse = simpleDateFormat.parse(bussinessDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(simpleDateFormat.format(date));
//        System.out.println(parse);
//    }
    public static void main(String[] args) throws ParseException {
        List<String> strings = scDateList("2020-01-10", "2020-02-01", 7);
        System.out.println(strings.toString());
//        Date date = addDay(new Date(), 7);
//        SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
//        String format1 = format.format(date);
//        System.out.println(format1);
    }
    public static  List<String> scDateList(String startDate,String endDate,Integer step) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(startDate);
        System.out.println(format.format(date1));
        Date date2 = format.parse(endDate);
        System.out.println(format.format(date2));
        Calendar dateUtil = Calendar.getInstance();
        dateUtil.setTime(date1);
        ArrayList<String> dataList = new ArrayList<>();
        boolean flag = true;
        while (flag){
            Date time = dateUtil.getTime();
            String dateStr = format.format(time);
            if (time.getTime()>date2.getTime()){
                flag = false;
                continue;
            }
            dateUtil.add(Calendar.DAY_OF_MONTH,step-1);
            time = dateUtil.getTime();
            dateStr += ",";
            dateStr += format.format(time);
            dateUtil.add(Calendar.DAY_OF_MONTH,1);
            dataList.add(dateStr);
        }
        return dataList;
    }

    //对日期进行 天数增加
    public static Date addDay(Date date,Integer dayCount){
        Calendar dateUtil = Calendar.getInstance();
        dateUtil.setTime(date);
        dateUtil.add(Calendar.DAY_OF_MONTH,dayCount);
        return dateUtil.getTime();
    }
}
