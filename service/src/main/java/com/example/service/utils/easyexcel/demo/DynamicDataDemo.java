package com.example.service.utils.easyexcel.demo;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @Auther: YUANEL
 * @Date: 2019/10/12 16:02
 * @Description:
 */
public class DynamicDataDemo implements Serializable {

    /*****************如果增加这个类的属性的时候请保证该值与当前类属性个数一致***************/
    public static final int ATTRIBUTE_NUM = 230;
    /*********************************属性前缀************************************************/
    private static final String ATTRIBUTE_PREFIX = "attribute";
    private static final Field[] fs;

    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;
    private String attribute8;
    private String attribute9;
    private String attribute10;
    private String attribute11;
    private String attribute12;
    private String attribute13;
    private String attribute14;
    private String attribute15;
    private String attribute16;
    private String attribute17;
    private String attribute18;
    private String attribute19;
    private String attribute20;
    private String attribute21;
    private String attribute22;
    private String attribute23;
    private String attribute24;
    private String attribute25;
    private String attribute26;
    private String attribute27;
    private String attribute28;
    private String attribute29;
    private String attribute30;
    private String attribute31;
    private String attribute32;
    private String attribute33;
    private String attribute34;
    private String attribute35;
    private String attribute36;
    private String attribute37;
    private String attribute38;
    private String attribute39;
    private String attribute40;
    private String attribute41;
    private String attribute42;
    private String attribute43;
    private String attribute44;
    private String attribute45;
    private String attribute46;
    private String attribute47;
    private String attribute48;
    private String attribute49;
    private String attribute50;
    private String attribute51;
    private String attribute52;
    private String attribute53;
    private String attribute54;
    private String attribute55;
    private String attribute56;
    private String attribute57;
    private String attribute58;
    private String attribute59;
    private String attribute60;
    private String attribute61;
    private String attribute62;
    private String attribute63;
    private String attribute64;
    private String attribute65;
    private String attribute66;
    private String attribute67;
    private String attribute68;
    private String attribute69;
    private String attribute70;
    private String attribute71;
    private String attribute72;
    private String attribute73;
    private String attribute74;
    private String attribute75;
    private String attribute76;
    private String attribute77;
    private String attribute78;
    private String attribute79;
    private String attribute80;
    private String attribute81;
    private String attribute82;
    private String attribute83;
    private String attribute84;
    private String attribute85;
    private String attribute86;
    private String attribute87;
    private String attribute88;
    private String attribute89;
    private String attribute90;
    private String attribute91;
    private String attribute92;
    private String attribute93;
    private String attribute94;
    private String attribute95;
    private String attribute96;
    private String attribute97;
    private String attribute98;
    private String attribute99;
    private String attribute100;
    private String attribute101;
    private String attribute102;
    private String attribute103;
    private String attribute104;
    private String attribute105;
    private String attribute106;
    private String attribute107;
    private String attribute108;
    private String attribute109;
    private String attribute110;
    private String attribute111;
    private String attribute112;
    private String attribute113;
    private String attribute114;
    private String attribute115;
    private String attribute116;
    private String attribute117;
    private String attribute118;
    private String attribute119;
    private String attribute120;
    private String attribute121;
    private String attribute122;
    private String attribute123;
    private String attribute124;
    private String attribute125;
    private String attribute126;
    private String attribute127;
    private String attribute128;
    private String attribute129;
    private String attribute130;
    private String attribute131;
    private String attribute132;
    private String attribute133;
    private String attribute134;
    private String attribute135;
    private String attribute136;
    private String attribute137;
    private String attribute138;
    private String attribute139;
    private String attribute140;
    private String attribute141;
    private String attribute142;
    private String attribute143;
    private String attribute144;
    private String attribute145;
    private String attribute146;
    private String attribute147;
    private String attribute148;
    private String attribute149;
    private String attribute150;
    private String attribute151;
    private String attribute152;
    private String attribute153;
    private String attribute154;
    private String attribute155;
    private String attribute156;
    private String attribute157;
    private String attribute158;
    private String attribute159;
    private String attribute160;
    private String attribute161;
    private String attribute162;
    private String attribute163;
    private String attribute164;
    private String attribute165;
    private String attribute166;
    private String attribute167;
    private String attribute168;
    private String attribute169;
    private String attribute170;
    private String attribute171;
    private String attribute172;
    private String attribute173;
    private String attribute174;
    private String attribute175;
    private String attribute176;
    private String attribute177;
    private String attribute178;
    private String attribute179;
    private String attribute180;
    private String attribute181;
    private String attribute182;
    private String attribute183;
    private String attribute184;
    private String attribute185;
    private String attribute186;
    private String attribute187;
    private String attribute188;
    private String attribute189;
    private String attribute190;
    private String attribute191;
    private String attribute192;
    private String attribute193;
    private String attribute194;
    private String attribute195;
    private String attribute196;
    private String attribute197;
    private String attribute198;
    private String attribute199;
    private String attribute200;
    private String attribute201;
    private String attribute202;
    private String attribute203;
    private String attribute204;
    private String attribute205;
    private String attribute206;
    private String attribute207;
    private String attribute208;
    private String attribute209;
    private String attribute210;
    private String attribute211;
    private String attribute212;
    private String attribute213;
    private String attribute214;
    private String attribute215;
    private String attribute216;
    private String attribute217;
    private String attribute218;
    private String attribute219;
    private String attribute220;
    private String attribute221;
    private String attribute222;
    private String attribute223;
    private String attribute224;
    private String attribute225;
    private String attribute226;
    private String attribute227;
    private String attribute228;
    private String attribute229;
    private String attribute230;


    /***************************反射设置当前对象的属性******************************************/
    public void setDynamicAttribute(int attribute, String attributeStr) throws IllegalAccessException {
        String attributeEnd = String.valueOf(attribute + 1);
        for (Field f : fs) {
            if ((ATTRIBUTE_PREFIX + attributeEnd).equals(f.getName())) {
                f.set(this, attributeStr);
                break;
            }
        }
    }

    static {
        fs = DynamicDataDemo.class.getDeclaredFields();
    }

    public String getAttribute14() {
        return attribute14;
    }

    public void setAttribute14(String attribute14) {
        this.attribute14 = attribute14;
    }

    public String getAttribute15() {
        return attribute15;
    }

    public void setAttribute15(String attribute15) {
        this.attribute15 = attribute15;
    }

    public String getAttribute16() {
        return attribute16;
    }

    public void setAttribute16(String attribute16) {
        this.attribute16 = attribute16;
    }

    public String getAttribute17() {
        return attribute17;
    }

    public void setAttribute17(String attribute17) {
        this.attribute17 = attribute17;
    }

    public String getAttribute18() {
        return attribute18;
    }

    public void setAttribute18(String attribute18) {
        this.attribute18 = attribute18;
    }

    public String getAttribute19() {
        return attribute19;
    }

    public void setAttribute19(String attribute19) {
        this.attribute19 = attribute19;
    }

    public String getAttribute20() {
        return attribute20;
    }

    public void setAttribute20(String attribute20) {
        this.attribute20 = attribute20;
    }

    public String getAttribute21() {
        return attribute21;
    }

    public void setAttribute21(String attribute21) {
        this.attribute21 = attribute21;
    }

    public String getAttribute22() {
        return attribute22;
    }

    public void setAttribute22(String attribute22) {
        this.attribute22 = attribute22;
    }

    public String getAttribute23() {
        return attribute23;
    }

    public void setAttribute23(String attribute23) {
        this.attribute23 = attribute23;
    }

    public String getAttribute24() {
        return attribute24;
    }

    public void setAttribute24(String attribute24) {
        this.attribute24 = attribute24;
    }

    public String getAttribute25() {
        return attribute25;
    }

    public void setAttribute25(String attribute25) {
        this.attribute25 = attribute25;
    }

    public String getAttribute26() {
        return attribute26;
    }

    public void setAttribute26(String attribute26) {
        this.attribute26 = attribute26;
    }

    public String getAttribute27() {
        return attribute27;
    }

    public void setAttribute27(String attribute27) {
        this.attribute27 = attribute27;
    }

    public String getAttribute28() {
        return attribute28;
    }

    public void setAttribute28(String attribute28) {
        this.attribute28 = attribute28;
    }

    public String getAttribute29() {
        return attribute29;
    }

    public void setAttribute29(String attribute29) {
        this.attribute29 = attribute29;
    }

    public String getAttribute30() {
        return attribute30;
    }

    public void setAttribute30(String attribute30) {
        this.attribute30 = attribute30;
    }

    public String getAttribute31() {
        return attribute31;
    }

    public void setAttribute31(String attribute31) {
        this.attribute31 = attribute31;
    }

    public String getAttribute32() {
        return attribute32;
    }

    public void setAttribute32(String attribute32) {
        this.attribute32 = attribute32;
    }

    public String getAttribute33() {
        return attribute33;
    }

    public void setAttribute33(String attribute33) {
        this.attribute33 = attribute33;
    }

    public String getAttribute34() {
        return attribute34;
    }

    public void setAttribute34(String attribute34) {
        this.attribute34 = attribute34;
    }

    public String getAttribute35() {
        return attribute35;
    }

    public void setAttribute35(String attribute35) {
        this.attribute35 = attribute35;
    }

    public String getAttribute36() {
        return attribute36;
    }

    public void setAttribute36(String attribute36) {
        this.attribute36 = attribute36;
    }

    public String getAttribute37() {
        return attribute37;
    }

    public void setAttribute37(String attribute37) {
        this.attribute37 = attribute37;
    }

    public String getAttribute38() {
        return attribute38;
    }

    public void setAttribute38(String attribute38) {
        this.attribute38 = attribute38;
    }

    public String getAttribute39() {
        return attribute39;
    }

    public void setAttribute39(String attribute39) {
        this.attribute39 = attribute39;
    }

    public String getAttribute40() {
        return attribute40;
    }

    public void setAttribute40(String attribute40) {
        this.attribute40 = attribute40;
    }

    public String getAttribute41() {
        return attribute41;
    }

    public void setAttribute41(String attribute41) {
        this.attribute41 = attribute41;
    }

    public String getAttribute42() {
        return attribute42;
    }

    public void setAttribute42(String attribute42) {
        this.attribute42 = attribute42;
    }

    public String getAttribute43() {
        return attribute43;
    }

    public void setAttribute43(String attribute43) {
        this.attribute43 = attribute43;
    }

    public String getAttribute44() {
        return attribute44;
    }

    public void setAttribute44(String attribute44) {
        this.attribute44 = attribute44;
    }

    public String getAttribute45() {
        return attribute45;
    }

    public void setAttribute45(String attribute45) {
        this.attribute45 = attribute45;
    }

    public String getAttribute46() {
        return attribute46;
    }

    public void setAttribute46(String attribute46) {
        this.attribute46 = attribute46;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public String getAttribute11() {
        return attribute11;
    }

    public void setAttribute11(String attribute11) {
        this.attribute11 = attribute11;
    }

    public String getAttribute12() {
        return attribute12;
    }

    public void setAttribute12(String attribute12) {
        this.attribute12 = attribute12;
    }

    public String getAttribute13() {
        return attribute13;
    }

    public void setAttribute13(String attribute13) {
        this.attribute13 = attribute13;
    }

    public String getAttribute47() {
        return attribute47;
    }

    public void setAttribute47(String attribute47) {
        this.attribute47 = attribute47;
    }

    public String getAttribute48() {
        return attribute48;
    }

    public void setAttribute48(String attribute48) {
        this.attribute48 = attribute48;
    }

    public String getAttribute49() {
        return attribute49;
    }

    public void setAttribute49(String attribute49) {
        this.attribute49 = attribute49;
    }

    public String getAttribute50() {
        return attribute50;
    }

    public void setAttribute50(String attribute50) {
        this.attribute50 = attribute50;
    }

    public String getAttribute51() {
        return attribute51;
    }

    public void setAttribute51(String attribute51) {
        this.attribute51 = attribute51;
    }

    public String getAttribute52() {
        return attribute52;
    }

    public void setAttribute52(String attribute52) {
        this.attribute52 = attribute52;
    }

    public String getAttribute53() {
        return attribute53;
    }

    public void setAttribute53(String attribute53) {
        this.attribute53 = attribute53;
    }

    public String getAttribute54() {
        return attribute54;
    }

    public void setAttribute54(String attribute54) {
        this.attribute54 = attribute54;
    }

    public String getAttribute55() {
        return attribute55;
    }

    public void setAttribute55(String attribute55) {
        this.attribute55 = attribute55;
    }

    public String getAttribute56() {
        return attribute56;
    }

    public void setAttribute56(String attribute56) {
        this.attribute56 = attribute56;
    }

    public String getAttribute57() {
        return attribute57;
    }

    public void setAttribute57(String attribute57) {
        this.attribute57 = attribute57;
    }

    public String getAttribute58() {
        return attribute58;
    }

    public void setAttribute58(String attribute58) {
        this.attribute58 = attribute58;
    }

    public String getAttribute59() {
        return attribute59;
    }

    public void setAttribute59(String attribute59) {
        this.attribute59 = attribute59;
    }

    public String getAttribute60() {
        return attribute60;
    }

    public void setAttribute60(String attribute60) {
        this.attribute60 = attribute60;
    }

    public String getAttribute61() {
        return attribute61;
    }

    public void setAttribute61(String attribute61) {
        this.attribute61 = attribute61;
    }

    public String getAttribute62() {
        return attribute62;
    }

    public void setAttribute62(String attribute62) {
        this.attribute62 = attribute62;
    }

    public String getAttribute63() {
        return attribute63;
    }

    public void setAttribute63(String attribute63) {
        this.attribute63 = attribute63;
    }

    public String getAttribute64() {
        return attribute64;
    }

    public void setAttribute64(String attribute64) {
        this.attribute64 = attribute64;
    }

    public String getAttribute65() {
        return attribute65;
    }

    public void setAttribute65(String attribute65) {
        this.attribute65 = attribute65;
    }

    public String getAttribute66() {
        return attribute66;
    }

    public void setAttribute66(String attribute66) {
        this.attribute66 = attribute66;
    }

    public String getAttribute67() {
        return attribute67;
    }

    public void setAttribute67(String attribute67) {
        this.attribute67 = attribute67;
    }

    public String getAttribute68() {
        return attribute68;
    }

    public void setAttribute68(String attribute68) {
        this.attribute68 = attribute68;
    }

    public String getAttribute69() {
        return attribute69;
    }

    public void setAttribute69(String attribute69) {
        this.attribute69 = attribute69;
    }

    public String getAttribute70() {
        return attribute70;
    }

    public void setAttribute70(String attribute70) {
        this.attribute70 = attribute70;
    }

    public String getAttribute71() {
        return attribute71;
    }

    public void setAttribute71(String attribute71) {
        this.attribute71 = attribute71;
    }

    public String getAttribute72() {
        return attribute72;
    }

    public void setAttribute72(String attribute72) {
        this.attribute72 = attribute72;
    }

    public String getAttribute73() {
        return attribute73;
    }

    public void setAttribute73(String attribute73) {
        this.attribute73 = attribute73;
    }

    public String getAttribute74() {
        return attribute74;
    }

    public void setAttribute74(String attribute74) {
        this.attribute74 = attribute74;
    }

    public String getAttribute75() {
        return attribute75;
    }

    public void setAttribute75(String attribute75) {
        this.attribute75 = attribute75;
    }

    public String getAttribute76() {
        return attribute76;
    }

    public void setAttribute76(String attribute76) {
        this.attribute76 = attribute76;
    }

    public String getAttribute77() {
        return attribute77;
    }

    public void setAttribute77(String attribute77) {
        this.attribute77 = attribute77;
    }

    public String getAttribute78() {
        return attribute78;
    }

    public void setAttribute78(String attribute78) {
        this.attribute78 = attribute78;
    }

    public String getAttribute79() {
        return attribute79;
    }

    public void setAttribute79(String attribute79) {
        this.attribute79 = attribute79;
    }

    public String getAttribute80() {
        return attribute80;
    }

    public void setAttribute80(String attribute80) {
        this.attribute80 = attribute80;
    }

    public String getAttribute81() {
        return attribute81;
    }

    public void setAttribute81(String attribute81) {
        this.attribute81 = attribute81;
    }

    public String getAttribute82() {
        return attribute82;
    }

    public void setAttribute82(String attribute82) {
        this.attribute82 = attribute82;
    }

    public String getAttribute83() {
        return attribute83;
    }

    public void setAttribute83(String attribute83) {
        this.attribute83 = attribute83;
    }

    public String getAttribute84() {
        return attribute84;
    }

    public void setAttribute84(String attribute84) {
        this.attribute84 = attribute84;
    }

    public String getAttribute85() {
        return attribute85;
    }

    public void setAttribute85(String attribute85) {
        this.attribute85 = attribute85;
    }

    public String getAttribute86() {
        return attribute86;
    }

    public void setAttribute86(String attribute86) {
        this.attribute86 = attribute86;
    }

    public String getAttribute87() {
        return attribute87;
    }

    public void setAttribute87(String attribute87) {
        this.attribute87 = attribute87;
    }

    public String getAttribute88() {
        return attribute88;
    }

    public void setAttribute88(String attribute88) {
        this.attribute88 = attribute88;
    }

    public String getAttribute89() {
        return attribute89;
    }

    public void setAttribute89(String attribute89) {
        this.attribute89 = attribute89;
    }

    public String getAttribute90() {
        return attribute90;
    }

    public void setAttribute90(String attribute90) {
        this.attribute90 = attribute90;
    }

    public String getAttribute91() {
        return attribute91;
    }

    public void setAttribute91(String attribute91) {
        this.attribute91 = attribute91;
    }

    public String getAttribute92() {
        return attribute92;
    }

    public void setAttribute92(String attribute92) {
        this.attribute92 = attribute92;
    }

    public String getAttribute93() {
        return attribute93;
    }

    public void setAttribute93(String attribute93) {
        this.attribute93 = attribute93;
    }

    public String getAttribute94() {
        return attribute94;
    }

    public void setAttribute94(String attribute94) {
        this.attribute94 = attribute94;
    }

    public String getAttribute95() {
        return attribute95;
    }

    public void setAttribute95(String attribute95) {
        this.attribute95 = attribute95;
    }

    public String getAttribute96() {
        return attribute96;
    }

    public void setAttribute96(String attribute96) {
        this.attribute96 = attribute96;
    }

    public String getAttribute97() {
        return attribute97;
    }

    public void setAttribute97(String attribute97) {
        this.attribute97 = attribute97;
    }

    public String getAttribute98() {
        return attribute98;
    }

    public void setAttribute98(String attribute98) {
        this.attribute98 = attribute98;
    }

    public String getAttribute99() {
        return attribute99;
    }

    public void setAttribute99(String attribute99) {
        this.attribute99 = attribute99;
    }

    public String getAttribute100() {
        return attribute100;
    }

    public void setAttribute100(String attribute100) {
        this.attribute100 = attribute100;
    }

    public String getAttribute101() {
        return attribute101;
    }

    public void setAttribute101(String attribute101) {
        this.attribute101 = attribute101;
    }

    public String getAttribute102() {
        return attribute102;
    }

    public void setAttribute102(String attribute102) {
        this.attribute102 = attribute102;
    }

    public String getAttribute103() {
        return attribute103;
    }

    public void setAttribute103(String attribute103) {
        this.attribute103 = attribute103;
    }

    public String getAttribute104() {
        return attribute104;
    }

    public void setAttribute104(String attribute104) {
        this.attribute104 = attribute104;
    }

    public String getAttribute105() {
        return attribute105;
    }

    public void setAttribute105(String attribute105) {
        this.attribute105 = attribute105;
    }

    public String getAttribute106() {
        return attribute106;
    }

    public void setAttribute106(String attribute106) {
        this.attribute106 = attribute106;
    }

    public String getAttribute107() {
        return attribute107;
    }

    public void setAttribute107(String attribute107) {
        this.attribute107 = attribute107;
    }

    public String getAttribute108() {
        return attribute108;
    }

    public void setAttribute108(String attribute108) {
        this.attribute108 = attribute108;
    }

    public String getAttribute109() {
        return attribute109;
    }

    public void setAttribute109(String attribute109) {
        this.attribute109 = attribute109;
    }

    public String getAttribute110() {
        return attribute110;
    }

    public void setAttribute110(String attribute110) {
        this.attribute110 = attribute110;
    }

    public String getAttribute111() {
        return attribute111;
    }

    public void setAttribute111(String attribute111) {
        this.attribute111 = attribute111;
    }

    public String getAttribute112() {
        return attribute112;
    }

    public void setAttribute112(String attribute112) {
        this.attribute112 = attribute112;
    }

    public String getAttribute113() {
        return attribute113;
    }

    public void setAttribute113(String attribute113) {
        this.attribute113 = attribute113;
    }

    public String getAttribute114() {
        return attribute114;
    }

    public void setAttribute114(String attribute114) {
        this.attribute114 = attribute114;
    }

    public String getAttribute115() {
        return attribute115;
    }

    public void setAttribute115(String attribute115) {
        this.attribute115 = attribute115;
    }

    public String getAttribute116() {
        return attribute116;
    }

    public void setAttribute116(String attribute116) {
        this.attribute116 = attribute116;
    }

    public String getAttribute117() {
        return attribute117;
    }

    public void setAttribute117(String attribute117) {
        this.attribute117 = attribute117;
    }

    public String getAttribute118() {
        return attribute118;
    }

    public void setAttribute118(String attribute118) {
        this.attribute118 = attribute118;
    }

    public String getAttribute119() {
        return attribute119;
    }

    public void setAttribute119(String attribute119) {
        this.attribute119 = attribute119;
    }

    public String getAttribute120() {
        return attribute120;
    }

    public void setAttribute120(String attribute120) {
        this.attribute120 = attribute120;
    }

    public String getAttribute121() {
        return attribute121;
    }

    public void setAttribute121(String attribute121) {
        this.attribute121 = attribute121;
    }

    public String getAttribute122() {
        return attribute122;
    }

    public void setAttribute122(String attribute122) {
        this.attribute122 = attribute122;
    }

    public String getAttribute123() {
        return attribute123;
    }

    public void setAttribute123(String attribute123) {
        this.attribute123 = attribute123;
    }

    public String getAttribute124() {
        return attribute124;
    }

    public void setAttribute124(String attribute124) {
        this.attribute124 = attribute124;
    }

    public String getAttribute125() {
        return attribute125;
    }

    public void setAttribute125(String attribute125) {
        this.attribute125 = attribute125;
    }

    public String getAttribute126() {
        return attribute126;
    }

    public void setAttribute126(String attribute126) {
        this.attribute126 = attribute126;
    }

    public String getAttribute127() {
        return attribute127;
    }

    public void setAttribute127(String attribute127) {
        this.attribute127 = attribute127;
    }

    public String getAttribute128() {
        return attribute128;
    }

    public void setAttribute128(String attribute128) {
        this.attribute128 = attribute128;
    }

    public String getAttribute129() {
        return attribute129;
    }

    public void setAttribute129(String attribute129) {
        this.attribute129 = attribute129;
    }

    public String getAttribute130() {
        return attribute130;
    }

    public void setAttribute130(String attribute130) {
        this.attribute130 = attribute130;
    }

    public String getAttribute131() {
        return attribute131;
    }

    public void setAttribute131(String attribute131) {
        this.attribute131 = attribute131;
    }

    public String getAttribute132() {
        return attribute132;
    }

    public void setAttribute132(String attribute132) {
        this.attribute132 = attribute132;
    }

    public String getAttribute133() {
        return attribute133;
    }

    public void setAttribute133(String attribute133) {
        this.attribute133 = attribute133;
    }

    public String getAttribute134() {
        return attribute134;
    }

    public void setAttribute134(String attribute134) {
        this.attribute134 = attribute134;
    }

    public String getAttribute135() {
        return attribute135;
    }

    public void setAttribute135(String attribute135) {
        this.attribute135 = attribute135;
    }

    public String getAttribute136() {
        return attribute136;
    }

    public void setAttribute136(String attribute136) {
        this.attribute136 = attribute136;
    }

    public String getAttribute137() {
        return attribute137;
    }

    public void setAttribute137(String attribute137) {
        this.attribute137 = attribute137;
    }

    public String getAttribute138() {
        return attribute138;
    }

    public void setAttribute138(String attribute138) {
        this.attribute138 = attribute138;
    }

    public String getAttribute139() {
        return attribute139;
    }

    public void setAttribute139(String attribute139) {
        this.attribute139 = attribute139;
    }

    public String getAttribute140() {
        return attribute140;
    }

    public void setAttribute140(String attribute140) {
        this.attribute140 = attribute140;
    }

    public String getAttribute141() {
        return attribute141;
    }

    public void setAttribute141(String attribute141) {
        this.attribute141 = attribute141;
    }

    public String getAttribute142() {
        return attribute142;
    }

    public void setAttribute142(String attribute142) {
        this.attribute142 = attribute142;
    }

    public String getAttribute143() {
        return attribute143;
    }

    public void setAttribute143(String attribute143) {
        this.attribute143 = attribute143;
    }

    public String getAttribute144() {
        return attribute144;
    }

    public void setAttribute144(String attribute144) {
        this.attribute144 = attribute144;
    }

    public String getAttribute145() {
        return attribute145;
    }

    public void setAttribute145(String attribute145) {
        this.attribute145 = attribute145;
    }

    public String getAttribute146() {
        return attribute146;
    }

    public void setAttribute146(String attribute146) {
        this.attribute146 = attribute146;
    }

    public String getAttribute147() {
        return attribute147;
    }

    public void setAttribute147(String attribute147) {
        this.attribute147 = attribute147;
    }

    public String getAttribute148() {
        return attribute148;
    }

    public void setAttribute148(String attribute148) {
        this.attribute148 = attribute148;
    }

    public String getAttribute149() {
        return attribute149;
    }

    public void setAttribute149(String attribute149) {
        this.attribute149 = attribute149;
    }

    public String getAttribute150() {
        return attribute150;
    }

    public void setAttribute150(String attribute150) {
        this.attribute150 = attribute150;
    }

    public String getAttribute151() {
        return attribute151;
    }

    public void setAttribute151(String attribute151) {
        this.attribute151 = attribute151;
    }

    public String getAttribute152() {
        return attribute152;
    }

    public void setAttribute152(String attribute152) {
        this.attribute152 = attribute152;
    }

    public String getAttribute153() {
        return attribute153;
    }

    public void setAttribute153(String attribute153) {
        this.attribute153 = attribute153;
    }

    public String getAttribute154() {
        return attribute154;
    }

    public void setAttribute154(String attribute154) {
        this.attribute154 = attribute154;
    }

    public String getAttribute155() {
        return attribute155;
    }

    public void setAttribute155(String attribute155) {
        this.attribute155 = attribute155;
    }

    public String getAttribute156() {
        return attribute156;
    }

    public void setAttribute156(String attribute156) {
        this.attribute156 = attribute156;
    }

    public String getAttribute157() {
        return attribute157;
    }

    public void setAttribute157(String attribute157) {
        this.attribute157 = attribute157;
    }

    public String getAttribute158() {
        return attribute158;
    }

    public void setAttribute158(String attribute158) {
        this.attribute158 = attribute158;
    }

    public String getAttribute159() {
        return attribute159;
    }

    public void setAttribute159(String attribute159) {
        this.attribute159 = attribute159;
    }

    public String getAttribute160() {
        return attribute160;
    }

    public void setAttribute160(String attribute160) {
        this.attribute160 = attribute160;
    }

    public String getAttribute161() {
        return attribute161;
    }

    public void setAttribute161(String attribute161) {
        this.attribute161 = attribute161;
    }

    public String getAttribute162() {
        return attribute162;
    }

    public void setAttribute162(String attribute162) {
        this.attribute162 = attribute162;
    }

    public String getAttribute163() {
        return attribute163;
    }

    public void setAttribute163(String attribute163) {
        this.attribute163 = attribute163;
    }

    public String getAttribute164() {
        return attribute164;
    }

    public void setAttribute164(String attribute164) {
        this.attribute164 = attribute164;
    }

    public String getAttribute165() {
        return attribute165;
    }

    public void setAttribute165(String attribute165) {
        this.attribute165 = attribute165;
    }

    public String getAttribute166() {
        return attribute166;
    }

    public void setAttribute166(String attribute166) {
        this.attribute166 = attribute166;
    }

    public String getAttribute167() {
        return attribute167;
    }

    public void setAttribute167(String attribute167) {
        this.attribute167 = attribute167;
    }

    public String getAttribute168() {
        return attribute168;
    }

    public void setAttribute168(String attribute168) {
        this.attribute168 = attribute168;
    }

    public String getAttribute169() {
        return attribute169;
    }

    public void setAttribute169(String attribute169) {
        this.attribute169 = attribute169;
    }

    public String getAttribute170() {
        return attribute170;
    }

    public void setAttribute170(String attribute170) {
        this.attribute170 = attribute170;
    }

    public String getAttribute171() {
        return attribute171;
    }

    public void setAttribute171(String attribute171) {
        this.attribute171 = attribute171;
    }

    public String getAttribute172() {
        return attribute172;
    }

    public void setAttribute172(String attribute172) {
        this.attribute172 = attribute172;
    }

    public String getAttribute173() {
        return attribute173;
    }

    public void setAttribute173(String attribute173) {
        this.attribute173 = attribute173;
    }

    public String getAttribute174() {
        return attribute174;
    }

    public void setAttribute174(String attribute174) {
        this.attribute174 = attribute174;
    }

    public String getAttribute175() {
        return attribute175;
    }

    public void setAttribute175(String attribute175) {
        this.attribute175 = attribute175;
    }

    public String getAttribute176() {
        return attribute176;
    }

    public void setAttribute176(String attribute176) {
        this.attribute176 = attribute176;
    }

    public String getAttribute177() {
        return attribute177;
    }

    public void setAttribute177(String attribute177) {
        this.attribute177 = attribute177;
    }

    public String getAttribute178() {
        return attribute178;
    }

    public void setAttribute178(String attribute178) {
        this.attribute178 = attribute178;
    }

    public String getAttribute179() {
        return attribute179;
    }

    public void setAttribute179(String attribute179) {
        this.attribute179 = attribute179;
    }

    public String getAttribute180() {
        return attribute180;
    }

    public void setAttribute180(String attribute180) {
        this.attribute180 = attribute180;
    }

    public String getAttribute181() {
        return attribute181;
    }

    public void setAttribute181(String attribute181) {
        this.attribute181 = attribute181;
    }

    public String getAttribute182() {
        return attribute182;
    }

    public void setAttribute182(String attribute182) {
        this.attribute182 = attribute182;
    }

    public String getAttribute183() {
        return attribute183;
    }

    public void setAttribute183(String attribute183) {
        this.attribute183 = attribute183;
    }

    public String getAttribute184() {
        return attribute184;
    }

    public void setAttribute184(String attribute184) {
        this.attribute184 = attribute184;
    }

    public String getAttribute185() {
        return attribute185;
    }

    public void setAttribute185(String attribute185) {
        this.attribute185 = attribute185;
    }

    public String getAttribute186() {
        return attribute186;
    }

    public void setAttribute186(String attribute186) {
        this.attribute186 = attribute186;
    }

    public String getAttribute187() {
        return attribute187;
    }

    public void setAttribute187(String attribute187) {
        this.attribute187 = attribute187;
    }

    public String getAttribute188() {
        return attribute188;
    }

    public void setAttribute188(String attribute188) {
        this.attribute188 = attribute188;
    }

    public String getAttribute189() {
        return attribute189;
    }

    public void setAttribute189(String attribute189) {
        this.attribute189 = attribute189;
    }

    public String getAttribute190() {
        return attribute190;
    }

    public void setAttribute190(String attribute190) {
        this.attribute190 = attribute190;
    }

    public String getAttribute191() {
        return attribute191;
    }

    public void setAttribute191(String attribute191) {
        this.attribute191 = attribute191;
    }

    public String getAttribute192() {
        return attribute192;
    }

    public void setAttribute192(String attribute192) {
        this.attribute192 = attribute192;
    }

    public String getAttribute193() {
        return attribute193;
    }

    public void setAttribute193(String attribute193) {
        this.attribute193 = attribute193;
    }

    public String getAttribute194() {
        return attribute194;
    }

    public void setAttribute194(String attribute194) {
        this.attribute194 = attribute194;
    }

    public String getAttribute195() {
        return attribute195;
    }

    public void setAttribute195(String attribute195) {
        this.attribute195 = attribute195;
    }

    public String getAttribute196() {
        return attribute196;
    }

    public void setAttribute196(String attribute196) {
        this.attribute196 = attribute196;
    }

    public String getAttribute197() {
        return attribute197;
    }

    public void setAttribute197(String attribute197) {
        this.attribute197 = attribute197;
    }

    public String getAttribute198() {
        return attribute198;
    }

    public void setAttribute198(String attribute198) {
        this.attribute198 = attribute198;
    }

    public String getAttribute199() {
        return attribute199;
    }

    public void setAttribute199(String attribute199) {
        this.attribute199 = attribute199;
    }

    public String getAttribute200() {
        return attribute200;
    }

    public void setAttribute200(String attribute200) {
        this.attribute200 = attribute200;
    }

    public String getAttribute201() {
        return attribute201;
    }

    public void setAttribute201(String attribute201) {
        this.attribute201 = attribute201;
    }

    public String getAttribute202() {
        return attribute202;
    }

    public void setAttribute202(String attribute202) {
        this.attribute202 = attribute202;
    }

    public String getAttribute203() {
        return attribute203;
    }

    public void setAttribute203(String attribute203) {
        this.attribute203 = attribute203;
    }

    public String getAttribute204() {
        return attribute204;
    }

    public void setAttribute204(String attribute204) {
        this.attribute204 = attribute204;
    }

    public String getAttribute205() {
        return attribute205;
    }

    public void setAttribute205(String attribute205) {
        this.attribute205 = attribute205;
    }

    public String getAttribute206() {
        return attribute206;
    }

    public void setAttribute206(String attribute206) {
        this.attribute206 = attribute206;
    }

    public String getAttribute207() {
        return attribute207;
    }

    public void setAttribute207(String attribute207) {
        this.attribute207 = attribute207;
    }

    public String getAttribute208() {
        return attribute208;
    }

    public void setAttribute208(String attribute208) {
        this.attribute208 = attribute208;
    }

    public String getAttribute209() {
        return attribute209;
    }

    public void setAttribute209(String attribute209) {
        this.attribute209 = attribute209;
    }

    public String getAttribute210() {
        return attribute210;
    }

    public void setAttribute210(String attribute210) {
        this.attribute210 = attribute210;
    }

    public String getAttribute211() {
        return attribute211;
    }

    public void setAttribute211(String attribute211) {
        this.attribute211 = attribute211;
    }

    public String getAttribute212() {
        return attribute212;
    }

    public void setAttribute212(String attribute212) {
        this.attribute212 = attribute212;
    }

    public String getAttribute213() {
        return attribute213;
    }

    public void setAttribute213(String attribute213) {
        this.attribute213 = attribute213;
    }

    public String getAttribute214() {
        return attribute214;
    }

    public void setAttribute214(String attribute214) {
        this.attribute214 = attribute214;
    }

    public String getAttribute215() {
        return attribute215;
    }

    public void setAttribute215(String attribute215) {
        this.attribute215 = attribute215;
    }

    public String getAttribute216() {
        return attribute216;
    }

    public void setAttribute216(String attribute216) {
        this.attribute216 = attribute216;
    }

    public String getAttribute217() {
        return attribute217;
    }

    public void setAttribute217(String attribute217) {
        this.attribute217 = attribute217;
    }

    public String getAttribute218() {
        return attribute218;
    }

    public void setAttribute218(String attribute218) {
        this.attribute218 = attribute218;
    }

    public String getAttribute219() {
        return attribute219;
    }

    public void setAttribute219(String attribute219) {
        this.attribute219 = attribute219;
    }

    public String getAttribute220() {
        return attribute220;
    }

    public void setAttribute220(String attribute220) {
        this.attribute220 = attribute220;
    }

    public String getAttribute221() {
        return attribute221;
    }

    public void setAttribute221(String attribute221) {
        this.attribute221 = attribute221;
    }

    public String getAttribute222() {
        return attribute222;
    }

    public void setAttribute222(String attribute222) {
        this.attribute222 = attribute222;
    }

    public String getAttribute223() {
        return attribute223;
    }

    public void setAttribute223(String attribute223) {
        this.attribute223 = attribute223;
    }

    public String getAttribute224() {
        return attribute224;
    }

    public void setAttribute224(String attribute224) {
        this.attribute224 = attribute224;
    }

    public String getAttribute225() {
        return attribute225;
    }

    public void setAttribute225(String attribute225) {
        this.attribute225 = attribute225;
    }

    public String getAttribute226() {
        return attribute226;
    }

    public void setAttribute226(String attribute226) {
        this.attribute226 = attribute226;
    }

    public String getAttribute227() {
        return attribute227;
    }

    public void setAttribute227(String attribute227) {
        this.attribute227 = attribute227;
    }

    public String getAttribute228() {
        return attribute228;
    }

    public void setAttribute228(String attribute228) {
        this.attribute228 = attribute228;
    }

    public String getAttribute229() {
        return attribute229;
    }

    public void setAttribute229(String attribute229) {
        this.attribute229 = attribute229;
    }

    public String getAttribute230() {
        return attribute230;
    }

    public void setAttribute230(String attribute230) {
        this.attribute230 = attribute230;
    }
}
