package com.run.test;

import com.alibaba.fastjson.JSON;
import com.run.dao.TestMapper;
import com.run.entity.TestExample;
import com.run.service.TestService;
import com.run.service.UserService;
import com.run.utils.DatetimeUtil;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.CannotLoadBeanClassException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;
import sun.java2d.pipe.SpanShapeRenderer;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * test 方法
 * @author hewei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/applicationContext.xml"})
public class MainTest {

    @Autowired
    private TestService testService;
    @Autowired
    private TestMapper testMapper;

    @Test
    public void testSelectAll() {
        try {
            List<com.run.entity.Test> testList = testService.selectAll();
            for(com.run.entity.Test test: testList) {
                System.out.println(test.getId());
            }
            System.out.println(testList.size());
            //System.out.println(testService.selectAll());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertItem() {
        try {
            com.run.entity.Test test = new com.run.entity.Test();
            test.setId("24");
            test.setName("贺炜");
            testService.insertItem(test);
            System.out.println("insert 哈哈1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        UserService userService = (UserService) ac.getBean("userService");
        Long beginTime = System.currentTimeMillis();
        //完成注册请求
        userService.doLogin("wei.he@bkjk.com","12345678911");
        System.out.println("处理注册相关业务耗时" + (System.currentTimeMillis() - beginTime )+ "ms");
        System.out.println("处理其他业务逻辑");
        //模拟处理其他业务请求耗时
        Thread.sleep(500);
        System.out.println("处理所有业务耗时" + (System.currentTimeMillis() - beginTime )+ "ms");
        System.out.println("向客户端发送注册成功响应");
    }

    @Test
    public void testRowbounds() {
        int offset = 1;
        int limit = 1;
        RowBounds rowBounds = new RowBounds(offset,limit);
        TestExample example = new TestExample();
        TestExample.Criteria criteria = example.createCriteria();
        List<com.run.entity.Test> testList = testMapper.selectByExampleWithRowbounds(example,rowBounds);
       //  List<com.run.entity.Test> testList = testMapper.selectByExample(example);
        for (com.run.entity.Test test : testList) {
            System.out.println(test.getId());
        }
    }

    @Test
    public void testExample() {
        TestExample example = new TestExample();
        example.setLimit(1);
        example.setOffset(1);
        List<com.run.entity.Test> testList = testMapper.selectByExample(example);
        for (com.run.entity.Test test : testList) {
            System.out.println(test.getId());
        }
    }

    @Test
    public void testDecimal() {
        BigDecimal bd = new BigDecimal("2.0");
        System.out.println(bd);
    }

    @Test
    public void insertTest() {
        com.run.entity.Test test = new com.run.entity.Test();
        test.setId("12");
        test.setName("1111111111");
  }

    @Test
    public void listTest() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.get(0));
    }

//    @Test
//    public void selectListStringTest() {
//        System.out.println(testMapper.selectListStringTest());
//        List<String> testList = testMapper.selectListStringTest();
//        System.out.println(null == testList);
//    }

    @Test
    public void testString() {
        String str1 = null;
        System.out.println(str1 == "1");
        System.out.println();
    }

    @Test
    public void testRandom() {
        for(int i = 0; i < 1000; i++) {
//            System.out.println(new Random().nextInt(9000)+1000);
            System.out.println("ZL" + (System.currentTimeMillis()/1000) + "01" + ((new Random().nextInt(9000))+1000));
        }
        //System.out.println(System.currentTimeMillis()/1000);
    }

    @Test
    public void testDate() {
        Date testDate = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(testDate);
        calendar.add(calendar.YEAR,1);
        Date testDate2 = calendar.getTime();
        System.out.println(testDate2.toString());

    }

    @Test
    public void testList() {
        List<Integer> list = new ArrayList<>();
        System.out.println(list);
    }

    @Test
    public void testListNum() {
        TestExample example = new TestExample();
        TestExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo("100000");
        List<com.run.entity.Test> testList = testMapper.selectByExample(example);
        System.out.println(testList);
    }

    @Test
    public void testName() {
        TestExample example = new TestExample();
        TestExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo("1");
        List<com.run.entity.Test> testList = testMapper.selectByExample(example);
        com.run.entity.Test test = testList.get(0);
        Calendar c = Calendar.getInstance();
        c.setTime(test.getDueTime());
        int month = c.get(Calendar.MONTH);
        System.out.println(month+1);
    }

    @Test
    public void testDateThirty() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
        Calendar calendarOne = Calendar.getInstance();
        Date now = sdf.parse("2017-11-20");
        Date now2 = sdf.parse("2017-11-20 00:00:00");
        System.out.println(now);
        System.out.println(now2);

//        calendarOne.setTime(now);
//
//        calendarOne.add(Calendar.DATE, 30);
//        Date nowAddThirtyDay = calendarOne.getTime();
//        System.out.println(sdf.format(nowAddThirtyDay));
//            System.out.println(DatetimeUtil.getDistinceDay(now,nowAddThirtyDay));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOutputMap() {
        System.out.println(testMapper.selectUserMap("24"));
    }

    @Test
    public void testPrintMap() {
        Map<String, String> map = new HashMap<>();
        map.put("1","2");
        System.out.println(map);
    }

    @Test
    public void testMap() {
        Map<String,Object> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        map1.put("S","S");
//        map2 = map1;
    }

    @Test
    public void getListIndex() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        System.out.println(list.get(1));
        System.out.println(list.size());
    }

    @Test
    public void testNull() {
        List<Integer> list = new ArrayList<>();
        list = null;
        System.out.println(list == null);
    }

    @Test
    public void printCalendor(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(calendar.getTime()));
    }

    @Test
    public void saveCodoe() {
//        // TODO 申请时效校验 在lease_contract查询合同签约日期，看是否在三十天内
//        Date signedDate = leaseContract.getSignedDate();
//        Date nowDate = new Date();
//        long dayCountSignedDate = DatetimeUtil.getDistinceDay(signedDate, nowDate);
//        if (dayCountSignedDate >= 30) {
//            // 更新订单状态
//            LoanOrderExample loanOrderExample = new LoanOrderExample();
//            LoanOrderExample.Criteria criteria = loanOrderExample.createCriteria();
//            criteria.andCodeEqualTo(signContractSummitInDto.getLoanOrderCode());
//            LoanOrder record = new LoanOrder();
//            record.setStatus(LoanOrderStatusEnum.TIMEOUT.getCode()); // 申请过期(无效)
//            loanOrderMapper.updateByExampleSelective(record, loanOrderExample);
//
//            // 记录返回结果
//            signContractSummitOutDto.setSignContractResult("0");
//            signContractSummitOutDto.setFailureReason("申请过期");
//            responseVo.setData(signContractSummitOutDto);
//            responseVo.setCode(402);
//            responseVo.setMsg("签约失败");
//            return responseVo;
//        }
    }

    @Test
    public void testCount() {
        TestExample testExample = new TestExample();
        TestExample.Criteria criteria = testExample.createCriteria();
        criteria.andIdEqualTo("244");
        Long count = testMapper.countByExample(testExample);
        System.out.println(count);
    }

    @Test
    public void testBigDecimal() {
        BigDecimal bd1 = new BigDecimal(0);
        System.out.println(bd1.equals(new BigDecimal(0)));
    }

    @Test
    public void testDate2() throws Exception {
        try {
            Date nowDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(nowDate);
            // 将时分秒,毫秒域清零
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            nowDate = cal.getTime();

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(nowDate);
            cal2.set(Calendar.MONTH,9);
            cal2.set(Calendar.HOUR_OF_DAY, 0);
            cal2.set(Calendar.MINUTE, 0);
            cal2.set(Calendar.SECOND, 0);
            cal2.set(Calendar.MILLISECOND, 0);
            Date instalmentEnd = cal2.getTime();
            long dayCountLeaseDate = DatetimeUtil.getDistinceDay(instalmentEnd, nowDate);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
            System.out.println("instalmentEnd:" + sdf.format(instalmentEnd));
            System.out.println("nowDate:" + sdf.format(nowDate));
            System.out.println(dayCountLeaseDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testBetweentInteger() {
        TestExample testExample = new TestExample();
        TestExample.Criteria criteria = testExample.createCriteria();
        criteria.andInstalmentBetween(1,1);
        testExample.setOrderByClause("instalment asc");
        List<com.run.entity.Test> testList = testMapper.selectByExample(testExample);
        for (com.run.entity.Test test : testList) {
            System.out.println(test);
        }

    }

    @Test
    public void testIntegerEqu(){
        Integer one = 1;
        System.out.println(one.equals(1));
    }

    @Test
    public void compareString() {
        String nullStr = null;
        String oneStr = "1";
        List<String> strList = new ArrayList<>();
        strList.add(nullStr);
        strList.add(oneStr);
        for (String str : strList) {
            System.out.println(str);
        }
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (null == o1 && null == o2) {
                    return 0;
                }
                if (null == o1) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println("------------------------------------");
        for (String str : strList) {
            System.out.println(str);
        }
    }

    @Test
    public void testSort() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(5);
        list.add(5);
        Collections.sort(list);
        System.out.println(list);
    }

    @Test
    public void printTest() {
        com.run.entity.Test test = new com.run.entity.Test();
        test.setId(null);
        System.out.println(test);
    }

    @Test
    public void testRadom(){
        for (int i = 0; i < 100 ; i++) {
            String code = "ZL" + "A01" + ((new Random().nextInt(9000000)) + 1000000);
            System.out.println(code);
        }
    }

    @Test
    public void compareDate() {
        try {
            Date nowDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(nowDate);
            // 将时分秒,毫秒域清零
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            cal.add(Calendar.DAY_OF_MONTH, -1);
            nowDate = cal.getTime();
            long dayCountLeaseDate = DatetimeUtil.getDistinceDay(new Date(), nowDate);
            System.out.println(dayCountLeaseDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void betweenDate () {
        try{

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date date1 = sdf.parse("20171128");
            Date date2 = sdf.parse("20171228");
            System.out.println(DatetimeUtil.getDistinceDay(date1,date2));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testM(){
        for (int i = 0; i < 12 ; i++) {
            System.out.println();
        }
    }

    @Test
    public void testDay() {
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            // 计算各分期时间
            Calendar calendar = Calendar.getInstance();
            Date instalmentOneStart = simpleDateFormat.parse("20191129");
            calendar.setTime(instalmentOneStart);
            calendar.add(Calendar.MONTH, 3);
            calendar.add(Calendar.DATE, -1);
            Date instalmentOneEnd = calendar.getTime();

            calendar.add(Calendar.DATE, 1);
            Date instalmentTwoStart = calendar.getTime();
            calendar.add(Calendar.MONTH, 3);
            calendar.add(Calendar.DATE, -1);
            Date instalmentTwoEnd = calendar.getTime();

            calendar.add(Calendar.DATE, 1);
            Date instalmentThreeStart = calendar.getTime();
            calendar.add(Calendar.MONTH, 3);
            calendar.add(Calendar.DATE, -1);
            Date instalmentThreeEnd = calendar.getTime();

            calendar.add(Calendar.DATE, 1);
            Date instalmentFourStart = calendar.getTime();
            calendar.add(Calendar.MONTH, 3);
            Date instalmentFourEnd = calendar.getTime();

            System.out.println(simpleDateFormat.format(instalmentOneStart) + "-" + simpleDateFormat.format(instalmentOneEnd) +":"+DatetimeUtil.getDistinceDay(instalmentOneStart,instalmentOneEnd));
            System.out.println(simpleDateFormat.format(instalmentTwoStart) + "-" + simpleDateFormat.format(instalmentTwoEnd) +":"+DatetimeUtil.getDistinceDay(instalmentTwoStart,instalmentTwoEnd));
            System.out.println(simpleDateFormat.format(instalmentThreeStart) + "-" + simpleDateFormat.format(instalmentThreeEnd) +":"+DatetimeUtil.getDistinceDay(instalmentThreeStart,instalmentThreeEnd));
            System.out.println(simpleDateFormat.format(instalmentFourStart) + "-" + simpleDateFormat.format(instalmentFourEnd) +":"+DatetimeUtil.getDistinceDay(instalmentFourStart,instalmentFourEnd));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test30 (){
        try{

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Calendar calendarOne = Calendar.getInstance();
            Date now = new Date();
            calendarOne.setTime(now);
            calendarOne.set(Calendar.HOUR_OF_DAY, 0);
            calendarOne.set(Calendar.MINUTE, 0);
            calendarOne.set(Calendar.SECOND, 0);
            calendarOne.set(Calendar.MILLISECOND, 0);
            calendarOne.add(Calendar.DATE, 29);
            Date nowAddThirtyDay = calendarOne.getTime();
            System.out.println(nowAddThirtyDay);
            System.out.println(DatetimeUtil.getDistinceDay(sdf.parse("20171228"), nowAddThirtyDay));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testBigdecimal() {
        BigDecimal bigDecimal = new BigDecimal(10250);
        BigDecimal result = bigDecimal.divide(new BigDecimal(3),2,BigDecimal.ROUND_HALF_UP);
        System.out.println(result);
    }

    @Test
    public void testBigDecimal1() {
        BigDecimal bigDecimal = new BigDecimal("01.2350000000000");
        BigDecimal bigDecimal2 = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal2.toString());
    }

    @Test
    public void testDateLong() {
        long longTime = Long.parseLong("1513872000000");
        Date date = new Date(longTime);
        System.out.println(date);
    }

    @Test
    public void testString2() {
        String s = "1";
        s = "2";
        System.out.println(s);
    }

    @Test
    public void testUpdate() {
        TestExample example = new TestExample();
        TestExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo("1");
        com.run.entity.Test test = new com.run.entity.Test();
        test.setName("haha");
        test.setDueTime(new Date());
        test.setInstalment(1);
        System.out.println(testMapper.updateByExampleSelective(test,example));
    }

    @Test
    public void testBigDecimal2() {
        BigDecimal bg = new BigDecimal(1);
        BigDecimal bg2 = bg.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(bg);
        System.out.println(bg2);
    }

    @Test
    public void testPrint () {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        System.out.println(JSON.toJSONString(list));
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","1");
        map.put("3","1");
        System.out.println(JSON.toJSONString(map));

        com.run.entity.Test test = new com.run.entity.Test();
        test.setName("a");
        System.out.println(test);
        System.out.println(test.getId());
    }

    @Test
    public void testString3() {
        String reason1 = ":";
        //reason1 = "E1010:银行卡错误";
        String reason2 = "E1212:其他";
        String reason3 = "";
//        if (null != reason1) {
//            System.out.println(JSON.toJSONString(reason1.split(":")));
//        } else {
//            System.out.println("null");
//        }
        System.out.println(reason1.contains(":"));
    }



}
