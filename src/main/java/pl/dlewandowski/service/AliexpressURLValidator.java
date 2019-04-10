package pl.dlewandowski.service;

public class AliexpressURLValidator {

    public static boolean validate(String url) {
           return url.contains("www.aliexpress.com/item/");
    }
}
