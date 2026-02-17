package com.mashibing.mult;

public class DynamicDataSourceContextHolder {

    /**
     * translatedTextThreadLocaltranslatedText，ThreadLocaltranslatedText，
     *  translatedText，translatedText。
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * translatedText
     * @param dataSourceType
     */
    public static void setDataSourceType(String dataSourceType){
        System.out.printf("translatedText{%s}translatedText", dataSourceType);
        CONTEXT_HOLDER.set(dataSourceType);
    }

    /**
     * translatedText
     * @return
     */
    public static String getDataSourceType(){
        return CONTEXT_HOLDER.get();
    }

    /**
     * translatedText
     */
    public static void clearDataSourceType(){
        CONTEXT_HOLDER.remove();
    }
}