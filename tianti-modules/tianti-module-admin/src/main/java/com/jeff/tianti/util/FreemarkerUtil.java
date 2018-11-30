package com.jeff.tianti.util;


import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

public class FreemarkerUtil {

    private static String staticPagePath = "F:/html/staticPages";

    /**
     * @param data             数据模型
     * @param templatePath     模板路径 "WEB-INF/ftl"
     * @param templateFileName 模板文件名 "main.html"
     * @param staticPageName   生成的静态文件的文件名
     */
    public static void createStaticPage(Configuration cfg, HttpServletRequest request, String staticPageName, Map<String, Object> data, String templatePath, String templateFileName) {
        try {
            cfg.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);// 设置标签
            cfg.setServletContextForTemplateLoading(request.getServletContext(), templatePath);// 设置临时加载目录。
            cfg.setDefaultEncoding("UTF-8");
            cfg.setNumberFormat("#");
            Template temp = cfg.getTemplate(templateFileName);// 获取模板对象
            Writer out = new OutputStreamWriter(new FileOutputStream(staticPagePath + File.separator + staticPageName + ".html"), "UTF-8");
            temp.process(data, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createStaticPage(Configuration cfg, String staticPageName, Map<String, Object> data, String templateFileName) {
        try {
            Template temp = cfg.getTemplate(templateFileName);// 获取模板对象
            Writer out = new OutputStreamWriter(new FileOutputStream(staticPagePath + File.separator + staticPageName + ".html"), "UTF-8");
            temp.process(data, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
