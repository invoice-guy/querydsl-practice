package com.querydsl.practice.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProd_ProdKey is a Querydsl query type for ProdKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QProd_ProdKey extends BeanPath<Prod.ProdKey> {

    private static final long serialVersionUID = 949136468L;

    public static final QProd_ProdKey prodKey = new QProd_ProdKey("prodKey");

    public final StringPath effenddtm = createString("effenddtm");

    public final StringPath effstadtm = createString("effstadtm");

    public final StringPath prodid = createString("prodid");

    public final StringPath svcmgmtnum = createString("svcmgmtnum");

    public QProd_ProdKey(String variable) {
        super(Prod.ProdKey.class, forVariable(variable));
    }

    public QProd_ProdKey(Path<? extends Prod.ProdKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProd_ProdKey(PathMetadata metadata) {
        super(Prod.ProdKey.class, metadata);
    }

}

