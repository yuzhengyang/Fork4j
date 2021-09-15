package com.yuzhyn.azylee.core.dbs.defines;

import com.yuzhyn.azylee.core.dbs.bases.TableEntity;

public interface ISqlCreator {

    String selectById(TableEntity tableEntity, Object... id);

    String selectAll(TableEntity tableEntity);

}
