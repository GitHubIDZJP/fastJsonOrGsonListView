package com.android.thirdlibparsinglistview;

import java.util.List;

//info这一层
public class PageinfoMer {
    private PageTotal pageInfo;
    private List<Contents> merchantKey;

    public List<Contents> getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(List<Contents> merchantKey) {
        this.merchantKey = merchantKey;
    }

    public PageTotal getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageTotal pageInfo) {
        this.pageInfo = pageInfo;
    }
}


