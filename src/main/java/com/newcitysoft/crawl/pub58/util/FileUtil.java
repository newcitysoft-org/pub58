package com.newcitysoft.crawl.pub58.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/10 16:54
 */
public class FileUtil {

    public static String readFileContent(String path) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        return content;
    }

    public static void main(String[] args) throws IOException {
        String path = "D:\\tianlixin\\idea-workspace\\newcitysoft\\work\\pub58\\file\\58\\年检到期.txt";
        show(path).forEach(System.out::println);

    }

    public static List<String> show(String filepath) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(filepath), Charset.defaultCharset());
        return list;
    }

}
