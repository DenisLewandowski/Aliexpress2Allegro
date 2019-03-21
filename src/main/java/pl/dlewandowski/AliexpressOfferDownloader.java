package pl.dlewandowski;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.dlewandowski.model.Offer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class AliexpressOfferDownloader {

    public static Document doc;

    public static Offer getOffer(String url) {
        Offer offer = new Offer();

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        offer.setTitle(getTitle());
        offer.setImageURLs(getImagesFromURL());
        offer.setAliexpressURL(url);
        offer.setQuantity(1);
        offer.setDescription(getDescription());
        offer.setPrice(getPrice());

        return offer;
    }

    public static String getTitle() {
        return doc.getElementsByClass("product-name").text();
    }

    public static Set<String> getImagesFromURL() {
        Set<String> imgUrls = new HashSet<>();
        String imgUrl;

        Elements elements = doc.getElementsByClass("img-thumb-item");
        for (Element e : elements) {
            imgUrl = e.getElementsByTag("img").attr("src");
            imgUrls.add(imgUrl.split(".jpg")[0] + ".jpg");
        }

        return imgUrls;
    }

    public static String getDescription() {
        String description = "";


        return description;
    }

    public static BigDecimal getPrice() {
        BigDecimal price;
        Element priceElement;

        // Discounted price
        priceElement = doc.getElementById("j-sku-discount-price");
        if (priceElement != null) {
            price = new BigDecimal(priceElement.text());
            return price;
        }

        // If it is price range (get higher price)
        priceElement = doc.getElementById("j-sku-price");
        if (priceElement != null) {
            if (priceElement.getElementsByAttribute("highPrice") != null) {
                price = new BigDecimal(priceElement.getElementsByAttributeValue("itemprop", "highPrice").text());
                return price;
            }
        }

        return new BigDecimal(0);
    }

    public static String getCurrency() {
        return doc.getElementsByClass("p-symbol").last().attr("content");
    }

}
