package ru.toster.artem.ui;


import ru.toster.artem.Presenter;
import ru.toster.artem.utility.HttpCleint;

public class PostPresenter implements Presenter {
    private PostAppCompat fragment;
    private String url;

    public PostPresenter(PostAppCompat fragment, String url) {
        this.fragment = fragment;
        this.url = url;
    }

    @Override
    public void getHttp() {
        HttpCleint cleint = new HttpCleint(fragment.getApplication(), this);
        cleint.execute(url);
    }

    @Override
    public void viewsPresent(final String html) {
        fragment.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fragment.views(ParsingPage.getQuestPage(html));
            }
        });
    }
}
