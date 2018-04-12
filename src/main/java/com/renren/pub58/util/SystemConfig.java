package com.renren.pub58.util;

public class SystemConfig {
    /**
     * 标记系统的线程是否退出
     * 使用volatile关键字标记
     */
    public static volatile boolean exit = false;
    //最小空闲
    public static double FREE_PER_MIN = 0.2;
    //最大空闲
    public static double FREE_PER_MAX = 0.5;
    //CPU负载
    public static int CPULOAD = 2;
    // 下行带宽 B
    public static long NETWORK_RX_BANDWIDTH = 20 * 1024 * 1024 / 8;
    // 上行带宽 B
    public static long NETWORK_TX_BANDWIDTH = 8 * 1024 * 1024 / 8;

    public static boolean NETWORK_PPPOE_START = true;
    //网卡名称
    public static String NETWORK_CARD_NAME = "eth1";

    public static String NETWORK_PPPOE_COMMAND = "sh /data/pppoe.sh";

    public static String HOST_NAME = null;

    public static Long NETWORK_PPPOE_TIME = 60 * 1000L;
    //简单任务最大并行任务数
    public static int CONCURRENT_SIMPLE_MAX = 1000;
    //简单任务最大并行任务数
    public static int CONCURRENT_SIMPLE_MIN = 300;
    //复杂任务最大并行任务数
    public static int CONCURRENT_COMPLEX_MAX = 100;
    //复杂任务最大并行任务数
    public static int CONCURRENT_COMPLEX_MIN = 1;
    //多线程任务数
    public static int CONCURRENT_SYNC_MIN = 0;
    public static int CONCURRENT_SYNC_MAX = 0;
    //绑定服务器访问的几率
    public static int REQUEST_RANDOM_SERVER_PER = 0;
    //请求最大任务数
    public static int REQUEST_JOB_NUM = 1000;
    //是否需要代理,0不需要，1需要
    public static int REQUEST_USE_PROXY = 0;
    //每次汇报的任务数量，数量越大汇报频率越低,最少20
    public static int REQUEST_REPORT_SIZE = 20;

    public static int REPORT_URL_SIZE = 10;
    public static int REPORT_INSTANCES_SIZE = 10;
    //定时汇报,计每两分钟（汇报数量不为0时）最少汇报一次，最少60000,1分钟
    public static long REQUEST_REPORT_TIME = 60000;

    public static int REQUEST_SOCKET_TIMEOUT = 10000;
    public static int REQUEST_CONNECT_TIMEOUT = 2000;
    public static int REQUEST_CONNECTION_REQUEST_TIMEOUT = 30000;


}
