package cn.beida.ssm.controller.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialfontFilter {
       
    /**
     * 过滤特殊字符
     * @param str
     * @return
     *
     * \u00A0 特殊的空格
     */
    public static String stringFilter (String str){
        String regEx="[\\u00A0\\s\"`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

}
