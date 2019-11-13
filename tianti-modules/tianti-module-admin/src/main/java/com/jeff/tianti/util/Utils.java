package com.jeff.tianti.util;


import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;

public class Utils {

    public static String extractText(String inputHtml) {
        StringBuffer text = new StringBuffer();
        try {
            Parser parser = Parser.createParser(new String(inputHtml.getBytes(), "GBK"), "GBK");
            // 遍历所有的节点
            NodeList nodes = parser.extractAllNodesThatMatch(new NodeFilter() {
                public boolean accept(Node node) {
                    return true;
                }
            });

            System.out.println(nodes.size()); //打印节点的数量
            for (int i = 0; i < nodes.size(); i++) {
                Node nodet = nodes.elementAt(i);
                //System.out.println(nodet.getText());
                text.append(new String(nodet.toPlainTextString().getBytes("GBK")) + "/r/n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text.toString();

    }

    public static void main(String[] args) {
        String ss = "66);\">错过了国庆没关系，更多精彩将在本周末开园。。。</span><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; color: rgb(217, 33, 66);\">。</span></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><img src=\"http://admin.konglongri.cn/ue/1/../uploads/image/20181009/1539027743705062240.jpg\" style=\"margin: 0px; padding: 0px; height: auto !important; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\"/><img src=\"http://admin.konglongri.cn/ue/1/../uploads/image/20181009/1539027744043068652.jpg\" style=\"margin: 0px; padding: 0px; height: auto !important; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\"/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><br style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\"/></p><section class=\"\" powered-by=\"xiumi.us\" style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; line-height: 25.6px; background-color: rgb(255, 255, 255);\"><section class=\"\" style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><section class=\"\" style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; text-align: center; font-size: 13px; line-height: 2.2;\"><section class=\"\" data-tools=\"135编辑器\" data-id=\"92307\" style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box; overflow-wrap: break-word !important; font-size: 16px; line-height: 25.6px; border: 0px none;\"><section class=\"\" style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box; overflow-wrap: break-word !important; border: 0px none;\"><section style=\"margin: 0px; padding: 10px; max-width: 100%; box-sizing: border-box; overflow-wrap: break-word !important;\"><section data-width=\"100%\" style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; width: 648px;\"><section style=\"margin: 0px; padding: 20px 15px 10px; max-width: 100%; box-sizing: border-box; overflow-wrap: break-word !important; border: 2px solid rgb(66, 66, 66);\"><section style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; text-align: justify;\"><section class=\"\" style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; line-height: 28px;\"><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; letter-spacing: 0.544px; color: rgb(62, 62, 62); text-align: left; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 14px;\"><strong style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\">霸主恐龙，沙漠骆驼，来自<span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; color: rgb(51, 51, 51); font-family: 微软雅黑; letter-spacing: 0.544px; text-align: center;\">澳大利亚小松鼠</span>来啦！你hold住吗？</strong></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; letter-spacing: 0.544px; color: rgb(62, 62, 62); text-align: left; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 14px;\"><strong style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; color: rgb(171, 25, 66);\"><strong style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 16px; text-align: justify; letter-spacing: 0.544px;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 14px; color: rgb(62, 62, 62);\">将在10月13—14日（周六日）南京江宁松鼠咔咔森林乐园盛大举行！周末我们不见不散，约起！</span></strong></span></strong></span><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 14px; color: rgb(255, 41, 65);\"><strong style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\">文末有详细展出地址时间</span></strong></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; letter-spacing: 0.544px; color: rgb(62, 62, 62); text-align: center; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 20px; color: rgb(0, 0, 0); background-color: rgb(255, 251, 0);\"><strong style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; text-align: justify; letter-spacing: 0.544px;\">真实现场以往视频与图</span></strong></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; letter-spacing: 0.544px; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span data-ratio=\"1.7647058823529411\" id=\"js_tx_video_container_0.8070393477100879\" class=\"js_tx_video_container\" style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; display: block; width: 574px !important; height: 323px !important;\"><iframe frameborder=\"0\" width=\"574\" height=\"322.875\" allow=\"autoplay; fullscreen\" allowfullscreen=\"true\" src=\"https://v.qq.com/txp/iframe/player.html?origin=https%3A%2F%2Fmp.weixin.qq.com&vid=b1337sp34ff&autoplay=false&full=true&show1080p=false&isDebugIframe=false\" style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\"></iframe></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; letter-spacing: 0.544px; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><strong style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; color: rgb(217, 33, 66); font-size: 17px; letter-spacing: 0";
        String tt = extractText(ss);
        System.out.println(tt);
    }
}