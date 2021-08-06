package com.timesheet.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
//TODO
//FIXME 特別注意，該介面不能被掃描到，否則會出錯
}
