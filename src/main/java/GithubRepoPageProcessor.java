import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public void process(Page page) {

    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        String url = "https://search.bilibili.com/all?keyword=%E5%9B%BE%E6%8B%89%E5%A4%AB&page=1&order=pubdate";
        Spider.create(new GithubRepoPageProcessor())
                .addUrl(url)
                .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
                .thread(5)
                .run();
    }
}