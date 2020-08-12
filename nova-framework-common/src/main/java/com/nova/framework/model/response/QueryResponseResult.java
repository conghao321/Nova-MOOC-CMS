package com.nova.framework.model.response;

import lombok.Data;
import lombok.ToString;

/*
  response object
* Created by HaoCong
* */
@Data
@ToString
public class QueryResponseResult<T> extends ResponseResult {

    QueryResult<T> queryResult;

    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
