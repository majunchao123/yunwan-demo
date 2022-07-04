package com.mjc.common;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse<T> {

    private PageInfo pageInfo;

    private List<T> pageData;

    @Data
    public static class PageInfo {

        private long pageSize;

        private long currentPage;

        private long totalNumber;

        private long totalPage;
    }

}
