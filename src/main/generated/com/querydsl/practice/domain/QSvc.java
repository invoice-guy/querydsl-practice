package com.querydsl.practice.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSvc is a Querydsl query type for Svc
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSvc extends EntityPathBase<Svc> {

    private static final long serialVersionUID = 1696798333L;

    public static final QSvc svc = new QSvc("svc");

    public final NumberPath<Integer> custnum = createNumber("custnum", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath svcnum = createString("svcnum");

    public final StringPath svcscrbdt = createString("svcscrbdt");

    public final StringPath svcstcd = createString("svcstcd");

    public final StringPath svctermdt = createString("svctermdt");

    public QSvc(String variable) {
        super(Svc.class, forVariable(variable));
    }

    public QSvc(Path<? extends Svc> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSvc(PathMetadata metadata) {
        super(Svc.class, metadata);
    }

}

