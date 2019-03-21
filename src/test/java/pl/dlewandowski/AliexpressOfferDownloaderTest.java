package pl.dlewandowski;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AliexpressOfferDownloaderTest {

    private Document doc;

    @Before
    public void setUp() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("test_aliexpress.html").toURI());
        doc = Jsoup.parse(file, "UTF-8");
        AliexpressOfferDownloader.doc = doc;
    }

    @Test
    public void getTitle() {
        assertEquals("Xiaomi Mi 9 Mi9 6GB 128GB Global Version 48MP Triple Camera " +
                "Snapdragon 855 Smart Phone Fingerprint NFC AMOLED Display", AliexpressOfferDownloader.getTitle());
    }

    @Test
    public void getImagesFromURL() {
        String firstImgUrl = "https://ae01.alicdn.com/kf/HTB1KIpdKMHqK1RjSZFgq6y7JXXaj/Xiaomi-Mi-9-Mi9-6GB-128GB-Global-Version-48MP-Triple-Camera-Snapdragon-855-Smart-Phone-Fingerprint.jpg";
        assertEquals(firstImgUrl, AliexpressOfferDownloader.getImagesFromURL().toArray()[0]);
    }

    @Test
    public void getDescription() {

    }

    @Test
    public void getPrice() {
        BigDecimal expectedPrice = new BigDecimal("596.38");
        assertEquals(expectedPrice, AliexpressOfferDownloader.getPrice());
    }

    @Test
    public void getCurrency() {
        assertEquals("USD", AliexpressOfferDownloader.getCurrency());
    }
}