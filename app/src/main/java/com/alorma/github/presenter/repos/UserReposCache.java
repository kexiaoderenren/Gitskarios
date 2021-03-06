package com.alorma.github.presenter.repos;

import com.alorma.github.presenter.AbstractCacheDataSource;
import core.datasource.SdkItem;
import core.repositories.Repo;
import java.util.List;
import java.util.Locale;

public class UserReposCache extends AbstractCacheDataSource<String,List<Repo>> {

  private String key;

  public UserReposCache(String key) {
    this.key = key + "_%s_page_%d";
  }

  @Override
  protected String getCacheKey(String request, Integer page) {
    String cacheKey =
            String.format(Locale.getDefault(), key, request, page);
    return cacheKey;
  }

  @Override
  protected boolean checkItemIsEmpty(SdkItem<List<Repo>> sdkItem) {
    return sdkItem == null || sdkItem.getK() == null || sdkItem.getK().isEmpty();
  }
}
