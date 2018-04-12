package com.renren.pub58.service;

import com.renren.pub58.model.CarReleaseAutoParmCode;
import com.renren.pub58.util.FileUtil;

import java.io.IOException;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/10 17:06
 */
public class ParaCodeService {

    public static void add(CarReleaseAutoParmCode carReleaseAutoParmCode) {
        carReleaseAutoParmCode.save();
    }

    public static void insert7() {
        String path = "D:\\tianlixin\\idea-workspace\\newcitysoft\\work\\pub58\\file\\58\\首次上牌时间.txt";

        try {
            FileUtil.show(path).stream().skip(1).forEach(line -> {
                System.out.println(line);
                line = line.trim();
                String[] values = line.split(" ");

                CarReleaseAutoParmCode code = new CarReleaseAutoParmCode();

                code.setPlatformCode("58-pub");
                code.setParamName("首次上牌时间");
                code.setParamValue(values[0]);
                code.setParamText(values[1]);

                code.save();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insert6() {
        String path = "D:\\tianlixin\\idea-workspace\\newcitysoft\\work\\pub58\\file\\58\\车辆颜色.txt";

        try {
            FileUtil.show(path).stream().skip(1).forEach(line -> {
                System.out.println(line);
                line = line.trim();
                String[] values = line.split(" ");

                CarReleaseAutoParmCode code = new CarReleaseAutoParmCode();

                code.setPlatformCode("58-pub");
                code.setParamName("车辆颜色");
                code.setParamValue(values[0]);
                code.setParamText(values[1]);

                code.save();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insert5() {
        String path = "D:\\tianlixin\\idea-workspace\\newcitysoft\\work\\pub58\\file\\58\\车辆加装配置.txt";

        try {
            FileUtil.show(path).stream().skip(1).forEach(line -> {
                System.out.println(line);
                line = line.trim();
                String[] values = line.split(" ");

                CarReleaseAutoParmCode code = new CarReleaseAutoParmCode();

                code.setPlatformCode("58-pub");
                code.setParamName("车辆加装配置");
                code.setParamValue(values[0]);
                code.setParamText(values[1]);

                code.save();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void insert4() {
        String path = "D:\\tianlixin\\idea-workspace\\newcitysoft\\work\\pub58\\file\\58\\年检到期.txt";

        try {
            FileUtil.show(path).stream().skip(1).forEach(line -> {
                System.out.println(line);
                line = line.trim();
                String[] values = line.split(" ");

                CarReleaseAutoParmCode code = new CarReleaseAutoParmCode();

                code.setPlatformCode("58-pub");
                code.setParamName("年检到期");
                code.setParamValue(values[0]);
                code.setParamText(values[1]);

                code.save();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insert3() {
        String path = "D:\\tianlixin\\idea-workspace\\newcitysoft\\work\\pub58\\file\\58\\商业险到期.txt";

        try {
            FileUtil.show(path).stream().skip(1).forEach(line -> {
                System.out.println(line);
                line = line.trim();
                String[] values = line.split(" ");

                CarReleaseAutoParmCode code = new CarReleaseAutoParmCode();

                code.setPlatformCode("58-pub");
                code.setParamName("商业险到期");
                code.setParamValue(values[0]);
                code.setParamText(values[1]);

                code.save();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insert2() {
        String path = "D:\\tianlixin\\idea-workspace\\newcitysoft\\work\\pub58\\file\\58\\发布城市.txt";

        try {
            FileUtil.show(path).stream().skip(1).forEach(line -> {
                System.out.println(line);
                line = line.trim();
                String[] values = line.split(" ");

                CarReleaseAutoParmCode code = new CarReleaseAutoParmCode();

                code.setPlatformCode("58-pub");
                code.setParamName("发布城市");
                code.setParamValue(values[2]);
                code.setParamText(values[4]);

                code.save();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insert1() {
        String path = "D:\\tianlixin\\idea-workspace\\newcitysoft\\work\\pub58\\file\\58\\交强险到期.txt";

        try {
            FileUtil.show(path).stream().skip(1).forEach(line -> {
                System.out.println(line);
                line = line.trim();
                String[] values = line.split(" ");

                CarReleaseAutoParmCode code = new CarReleaseAutoParmCode();

                code.setPlatformCode("58-pub");
                code.setParamName("交强险到期");
                code.setParamValue(values[0]);
                code.setParamText(values[1]);

                code.save();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
