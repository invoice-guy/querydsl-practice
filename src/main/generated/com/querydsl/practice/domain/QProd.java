package com.querydsl.practice.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProd is a Querydsl query type for Prod
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProd extends EntityPathBase<Prod> {

    private static final long serialVersionUID = 1061048026L;

    public static final QProd prod = new QProd("prod");

    public final StringPath effenddtm = createString("effenddtm");

    public final StringPath effstadtm = createString("effstadtm");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath prodid = createString("prodid");

    public final StringPath scrbdt = createString("scrbdt");

    public final NumberPath<Integer> svcmgmtnum = createNumber("svcmgmtnum", Integer.class);

    public final StringPath termdt = createString("termdt");

    public QProd(String variable) {
        super(Prod.class, forVariable(variable));
    }

    public QProd(Path<? extends Prod> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProd(PathMetadata metadata) {
        super(Prod.class, metadata);
    }

}

