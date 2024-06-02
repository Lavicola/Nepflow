package com.nepflow.NepenthesManagement;

public class LabelFormats {

    public static String nep1 = "villosa";
    public static String nep2 = "lowii";
    public static String nep3 = "hamata";
    public static String nep4 = "naga";

    public static String hybridFormat1 = String.format("(%s x %s)",nep1,nep2);
    public static String hybridFormat2 = String.format("(%s x %s)",nep2,nep1);
    public static String multiHybridFormat1 = String.format("%s x %s",hybridFormat1,hybridFormat2);
    public static String multiHybridFormat2 = String.format("%s x %s",hybridFormat1,nep2);



}
