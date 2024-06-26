package com.ocrtest;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-05-18 16:49
 */
public class Test {


    public static void main(String[] args) {
            String s = "[[('中国银行保险监督管理委员会监制', 0.9979731), [[37.0, 23.0], [225.0, 23.0], [225.0, 37.0], [37.0, 37.0]]], [('仅限深圳市销售', 0.9951273), [[594.0, 23.0], [682.0, 23.0], [682.0, 37.0], [594.0, 37.0]]], [('阳光保险集团', 0.996725), [[77.0, 67.0], [190.0, 67.0], [190.0, 88.0], [77.0, 88.0]]], [('财产保险', 0.99695665), [[187.0, 69.0], [252.0, 71.0], [252.0, 88.0], [187.0, 86.0]]], [('Sunshine Insurance GroupPsCInsurance', 0.920122), [[77.0, 90.0], [255.0, 90.0], [255.0, 103.0], [77.0, 103.0]]], [('阳光保险服务号', 0.83624107), [[363.0, 108.0], [422.0, 106.0], [422.0, 119.0], [363.0, 121.0]]], [('新能源汽车商业保险电子保单', 0.9983232), [[265.0, 136.0], [453.0, 136.0], [453.0, 153.0], [265.0, 153.0]]], [('收款确认：2023-09-1116：41:26', 0.948245), [[35.0, 169.0], [170.0, 169.0], [170.0, 181.0], [35.0, 181.0]]], [('电子保单流水号：DPB095419052823000541', 0.98936564), [[424.0, 169.0], [593.0, 169.0], [593.0, 181.0], [424.0, 181.0]]], [('生成保单：2023-09-1121：36:21', 0.9487236), [[35.0, 184.0], [169.0, 184.0], [169.0, 197.0], [35.0, 197.0]]], [('保险单号码：1095405282023008916', 0.98164016), [[424.0, 184.0], [567.0, 184.0], [567.0, 197.0], [424.0, 197.0]]], [('电子保单生成时间：2023-09-1121：36:21', 0.9465408), [[35.0, 200.0], [206.0, 200.0], [206.0, 214.0], [35.0, 214.0]]], [('确认码：V0201YGBX440323090394439373677', 0.95476454), [[424.0, 200.0], [598.0, 200.0], [598.0, 214.0], [424.0, 214.0]]], [('POS交易号/支票号：2023-09-11', 0.9366212), [[34.0, 218.0], [161.0, 218.0], [161.0, 231.0], [34.0, 231.0]]], [('鉴于投保人已向保险人提出投保中请，并同意按约定交付保险费，保险人依照承保险种及其对应条款和特别约定承担赔偿责任', 0.94886404), [[35.0, 234.0], [539.0, 234.0], [539.0, 246.0], [35.0, 246.0]]], [('适用条款：', 0.9442989), [[32.0, 248.0], [78.0, 250.0], [78.0, 264.0], [32.0, 262.0]]], [('《新能源汽车商业保险示范条款（试行））', 0.9582986), [[88.0, 250.0], [256.0, 250.0], [256.0, 263.0], [88.0, 263.0]]], [('投保人', 0.9928093), [[34.0, 265.0], [65.0, 265.0], [65.0, 279.0], [34.0, 279.0]]], [('普洛斯科技（重庆）有限公司', 0.93283814), [[97.0, 265.0], [218.0, 265.0], [218.0, 279.0], [97.0, 279.0]]], [('吉首市万锁科技有限公司', 0.94366664), [[159.0, 280.0], [264.0, 281.0], [264.0, 295.0], [159.0, 294.0]]], [('证件号码', 0.9141811), [[425.0, 280.0], [466.0, 282.0], [465.0, 295.0], [424.0, 294.0]]], [('书称', 0.6608881), [[98.0, 282.0], [118.0, 282.0], [118.0, 294.0], [98.0, 294.0]]], [('被保险人', 0.9914348), [[34.0, 288.0], [74.0, 288.0], [74.0, 301.0], [34.0, 301.0]]], [('91433101MA4RB6013T', 0.9236994), [[506.0, 281.0], [591.0, 281.0], [591.0, 294.0], [506.0, 294.0]]], [('地址', 0.99663067), [[98.0, 296.0], [117.0, 296.0], [117.0, 308.0], [98.0, 308.0]]], [('湖南省吉首市乾州街道世纪大道总部经济服务中心19楼1921号', 0.9553443), [[161.0, 296.0], [410.0, 296.0], [410.0, 309.0], [161.0, 309.0]]], [('联系方式', 0.89999974), [[425.0, 296.0], [467.0, 296.0], [467.0, 310.0], [425.0, 310.0]]], [('88****9981', 0.8515293), [[509.0, 297.0], [559.0, 297.0], [559.0, 308.0], [509.0, 308.0]]], [('深圳市赢时通汽车服务有限公司', 0.9413822), [[98.0, 312.0], [227.0, 312.0], [227.0, 325.0], [98.0, 325.0]]], [('行驶证车主', 0.9512273), [[35.0, 313.0], [81.0, 313.0], [81.0, 324.0], [35.0, 324.0]]], [('能源（燃料）种买', 0.8790236), [[427.0, 313.0], [501.0, 313.0], [501.0, 324.0], [427.0, 324.0]]], [('纯电动', 0.7643513), [[504.0, 312.0], [537.0, 312.0], [537.0, 326.0], [504.0, 326.0]]], [('VIN码/车果号', 0.94831496), [[222.0, 326.0], [282.0, 328.0], [282.0, 342.0], [222.0, 340.0]]], [('LNAKA13P565-4295', 0.82859313), [[318.0, 326.0], [401.0, 327.0], [401.0, 341.0], [318.0, 340.0]]], [('号牌号码', 0.99032843), [[34.0, 327.0], [74.0, 327.0], [74.0, 341.0], [34.0, 341.0]]], [('鄂8EQ0120', 0.7558168), [[98.0, 327.0], [141.0, 327.0], [141.0, 341.0], [98.0, 341.0]]], [('发动机号', 0.9995967), [[507.0, 327.0], [545.0, 327.0], [545.0, 341.0], [507.0, 341.0]]], [('A2001P2201B1Q0', 0.9280124), [[587.0, 325.0], [656.0, 327.0], [656.0, 341.0], [587.0, 339.0]]], [('厂牌型号', 0.90882784), [[226.0, 342.0], [264.0, 342.0], [264.0, 355.0], [226.0, 355.0]]], [('埃安GAM7001BEVAON纯电动轿车', 0.8525292), [[320.0, 342.0], [445.0, 342.0], [445.0, 355.0], [320.0, 355.0]]], [('排量/功率', 0.94803345), [[506.0, 342.0], [550.0, 342.0], [550.0, 355.0], [506.0, 355.0]]], [('0.000OL/KW', 0.80246687), [[590.0, 342.0], [637.0, 342.0], [637.0, 355.0], [590.0, 355.0]]], [('叶克', 0.56462), [[319.0, 355.0], [346.0, 357.0], [345.0, 372.0], [318.0, 370.0]]], [('核定载客', 0.77926195), [[34.0, 358.0], [74.0, 358.0], [74.0, 372.0], [34.0, 372.0]]], [('5人', 0.6832931), [[98.0, 358.0], [112.0, 358.0], [112.0, 371.0], [98.0, 371.0]]], [('核定藏质量', 0.8735509), [[224.0, 358.0], [273.0, 358.0], [273.0, 372.0], [224.0, 372.0]]], [('初次登记日期', 0.97669053), [[508.0, 359.0], [564.0, 359.0], [564.0, 370.0], [508.0, 370.0]]], [('2023年07月', 0.98494333), [[590.0, 357.0], [636.0, 357.0], [636.0, 371.0], [590.0, 371.0]]], [('预的出租客增', 0.8203609), [[97.0, 373.0], [154.0, 373.0], [154.0, 387.0], [97.0, 387.0]]], [('行驶区域', 0.9681031), [[224.0, 373.0], [265.0, 373.0], [265.0, 387.0], [224.0, 387.0]]], [('使用性质', 0.9677147), [[35.0, 374.0], [73.0, 374.0], [73.0, 385.0], [35.0, 385.0]]], [('中国境内（不含港、演、台）', 0.94998354), [[318.0, 372.0], [436.0, 373.0], [436.0, 387.0], [318.0, 386.0]]], [('已使用年限', 0.97855866), [[508.0, 374.0], [554.0, 374.0], [554.0, 385.0], [508.0, 385.0]]], [('保险合同争议解决方式', 0.9846047), [[34.0, 389.0], [128.0, 389.0], [128.0, 403.0], [34.0, 403.0]]], [('保险期间：2023年09月12日00:00:00至2024年09月11日24:00:00', 0.9725277), [[34.0, 405.0], [310.0, 405.0], [310.0, 417.0], [34.0, 417.0]]], [('保险金额/责任限额（元）/绝对免赔率/服', 0.9312245), [[296.0, 420.0], [455.0, 420.0], [455.0, 433.0], [296.0, 433.0]]], [('承保险种', 0.8853394), [[145.0, 426.0], [184.0, 426.0], [184.0, 440.0], [145.0, 440.0]]], [('每次事故绝对免赔额', 0.94391143), [[481.0, 426.0], [564.0, 426.0], [564.0, 440.0], [481.0, 440.0]]], [('务次数上限', 0.9937994), [[353.0, 433.0], [399.0, 433.0], [399.0, 444.0], [353.0, 444.0]]], [('保险费(元）', 0.89154893), [[602.0, 424.0], [669.0, 424.0], [669.0, 441.0], [602.0, 441.0]]], [('1385-41.80', 0.857057), [[353.0, 448.0], [399.0, 448.0], [399.0, 462.0], [353.0, 462.0]]], [('2000.00', 0.9480344), [[504.0, 448.0], [541.0, 448.0], [541.0, 462.0], [504.0, 462.0]]], [('新能源汽车损失保险', 0.9553438), [[122.0, 449.0], [207.0, 449.0], [207.0, 462.0], [122.0, 462.0]]], [('2612.31', 0.8487572), [[618.0, 448.0], [655.0, 448.0], [655.0, 462.0], [618.0, 462.0]]], [('新能源汽车第三者责任保险', 0.8696661), [[107.0, 464.0], [220.0, 464.0], [220.0, 476.0], [107.0, 476.0]]], [('保险费合计（人民币大写）：柒仟伍佰玖拾壹元叁角叁分（￥：7591.33元（不含税保费：7.161.63元，增值税：429.70元））', 0.9239478), [[35.0, 478.0], [518.0, 478.0], [518.0, 491.0], [35.0, 491.0]]], [('保险期间内，如发生本保险合同约定的保险事故造成被保险车辆损失或第三者财产损失，保险人可采取实物赔付或现金期付方式进行保险赔付，选拜采取实物', 0.9016502), [[53.0, 493.0], [682.0, 494.0], [682.0, 508.0], [53.0, 507.0]]], [('赔付方式的，由保隐人和被保险人在事故车辆/财产修理前签订《实物赔付确认书》，被保险人与行驶证车主不一致：被保险人为吉首市万硫科技有限公司，', 0.90326256), [[55.0, 507.0], [673.0, 507.0], [673.0, 521.0], [55.0, 521.0]]], [('行驶证车主为深圳市时通汽车服务有限公司，本保单第一受偿人为长涉新智达物流信总有限公司：所有账付都需要得到第一受偿人书面授权，保险合同仅投', 0.90316844), [[54.0, 520.0], [681.0, 519.0], [681.0, 532.0], [54.0, 533.0]]], [('保人普洛斯科技（重庆）有限公司有权发起退保、保单修改、保单挂失、保险合同解除/终止的中请，前述中请无需被保险人、第一受偿人等其他权益人网意。', 0.89487344), [[55.0, 532.0], [671.0, 532.0], [671.0, 545.0], [55.0, 545.0]]], [('本保险合同由保险条款、投保单，保险平，批单和特别的定组成', 0.9138741), [[60.0, 547.0], [321.0, 547.0], [321.0, 561.0], [60.0, 561.0]]], [('2.收到本保验单、承保险种对应的保险条款后，请立即核对，如有不符减就漏，请及时理知保险人并办理变更或补充手候', 0.91022915), [[54.0, 560.0], [539.0, 560.0], [539.0, 573.0], [54.0, 573.0]]], [('3.请详细间读承保险种对应的保险条款，特别是责任免除、投保人被保险人义务、赔偿处理和通用条款等。', 0.9053002), [[55.0, 574.0], [477.0, 574.0], [477.0, 587.0], [55.0, 587.0]]], [('4.被保险新能面汽本被转让、改装、加装求改变使用性质等，导致被保险新能源汽车急险程度是增加，应及时通知保险人。', 0.88510495), [[55.0, 587.0], [550.0, 587.0], [550.0, 599.0], [55.0, 599.0]]], [('被保险人应当在保险事故发生后及时通知保险人', 0.9543837), [[60.0, 599.0], [261.0, 599.0], [261.0, 612.0], [60.0, 612.0]]], [('6投保次日起，您可以通过扫描保单上方阳光财产保险”官方微信，“阳光车生活”AP二维码，验证、', 0.8665258), [[56.0, 611.0], [472.0, 611.0], [472.0, 625.0], [56.0, 625.0]]], [('下我电子保单及获取更多服务，也可以通过本公司', 0.9336924), [[477.0, 610.0], [678.0, 610.0], [678.0, 624.0], [477.0, 624.0]]], [('网页、营业网点核实保单及理始等信息，若对查询结果有异议，请联系本公司，联系方式为网址：ww.sinosig.con，', 0.89319634), [[55.0, 625.0], [519.0, 625.0], [519.0, 639.0], [55.0, 639.0]]], [('电话95510营业网点地址：深圳市罗湖', 0.9524319), [[518.0, 624.0], [681.0, 624.0], [681.0, 638.0], [518.0, 638.0]]], [('区第岗街道笋尚梨路6号物资控般置地大厦5层9-10单元', 0.86851877), [[55.0, 637.0], [285.0, 637.0], [285.0, 649.0], [55.0, 649.0]]], [('公司名称：阳光财产保险股份有限公司深圳市分公司第三支公司', 0.9730651), [[55.0, 652.0], [311.0, 651.0], [311.0, 665.0], [55.0, 666.0]]], [('公司网址t：ww.sinosigcoo', 0.7085442), [[372.0, 651.0], [487.0, 653.0], [487.0, 667.0], [372.0, 665.0]]], [('联系电话：95510', 0.9658659), [[373.0, 666.0], [445.0, 666.0], [445.0, 680.0], [373.0, 680.0]]], [('邮政编码：518026', 0.88192505), [[57.0, 668.0], [128.0, 668.0], [128.0, 679.0], [57.0, 679.0]]], [('S51805', 0.65083194), [[545.0, 667.0], [580.0, 667.0], [580.0, 685.0], [545.0, 685.0]]], [('公司地址：深圳市罗湖区笋岗街道笋岗泰园路6号物资控股置地大厦5层9-10单', 0.92315096), [[55.0, 681.0], [364.0, 681.0], [364.0, 695.0], [55.0, 695.0]]], [('签单日期：2023-09-11', 0.9862563), [[375.0, 688.0], [466.0, 688.0], [466.0, 701.0], [375.0, 701.0]]], [('车编专用章', 0.7771083), [[529.0, 692.0], [592.0, 692.0], [592.0, 709.0], [529.0, 709.0]]], [('核保：自动核保', 0.92366093), [[34.0, 717.0], [100.0, 717.0], [100.0, 731.0], [34.0, 731.0]]], [('制单：谢翠琴', 0.88378054), [[326.0, 717.0], [384.0, 717.0], [384.0, 731.0], [326.0, 731.0]]], [('全国统一客户服务和客户维权电话：95510', 0.97450846), [[34.0, 733.0], [206.0, 733.0], [206.0, 746.0], [34.0, 746.0]]], [('阳光保险电话车险：4000-000-000', 0.9734182), [[328.0, 733.0], [468.0, 733.0], [468.0, 746.0], [328.0, 746.0]]], [('阳光网上车险：', 0.8945194), [[555.0, 734.0], [615.0, 734.0], [615.0, 745.0], [555.0, 745.0]]], [('http://chexian.sinosig.com', 0.9034252), [[32.0, 745.0], [156.0, 746.0], [156.0, 760.0], [32.0, 759.0]]]]";
            LinkedList<Map<String, Object>> maps = dataFormat(s);
            System.out.println(maps);
    }

    public static LinkedList<Map<String, Object>> dataFormat(String paddleResList) {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        String[] split = paddleResList.split("]]],");
        for (int i = 0; i < split.length; i++) {
            String tempS = split[i];
            String[] textSplit = tempS.split("',");
            if (textSplit.length != 2) {
                continue;
            }
            HashMap<String, Object> map = new HashMap<>(4);
            map.put("key", textSplit[0].substring(textSplit[0].indexOf("'") + 1));
            String dealString = textSplit[1].replace(")", "").replace("[", "").replace("]", "").replace(" ", "");
            String[] dealSplit = dealString.split(",");
            map.put("score", dealSplit[0]);
            int[][] location = new int[4][2];
            int tempIdx = 1;
            for (int j = 0; j < location.length; j++) {
                for (int k = 0; k < 2; k++) {
                    location[j][k] = Double.valueOf(dealSplit[tempIdx]).intValue();
                    tempIdx++;
                }
            }
            map.put("x", location[0][0]);
            map.put("y", location[0][1]);
            map.put("location", location);
            // 置信度>0.60的字段才进行返回
            if (Float.valueOf(String.valueOf(map.get("score"))) >= 0.60f) {
                list.add(map);
            }
        }

        return list;
    }

    public static boolean isDateMonth(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            Date parse = format.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static boolean isNumber(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
