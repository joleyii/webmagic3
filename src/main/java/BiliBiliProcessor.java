
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author code4crafter@gmail.com <br>
 */
public class BiliBiliProcessor implements PageProcessor {

    private Site site = Site
            .me()
            .setSleepTime(3000)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    public void process(Page page) {
        //div[@class="articleList"]
        page.putField("title", page.getHtml().xpath("//li[@class='video matrix ']"));
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new BiliBiliProcessor())
                .addUrl("https://search.bilibili.com/all?keyword=%E5%9B%BE%E6%8B%89%E5%A4%AB&from_source=banner_search")
                .addPipeline(new JsonFilePipeline("D:\\spider\\webmagic3\\src\\main\\out"))
                .run();
    }
}