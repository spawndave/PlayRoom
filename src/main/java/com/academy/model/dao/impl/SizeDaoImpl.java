package com.academy.model.dao.impl;

import com.academy.model.dao.SizeDao;
import com.academy.model.entity.Size;

public class SizeDaoImpl extends DefaultDaoIml<Size> implements SizeDao {

    public SizeDaoImpl() {
        super(Size.class);
    }
}
