package com.querydsl.practice.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCust is a Querydsl query type for Cust
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCust extends EntityPathBase<Cust> {

    private static final long serialVersionUID = 1060663766L;

    public static final QCust cust = new QCust("cust");

    public final StringPath custnm = createString("custnm");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public QCust(String variable) {
        super(Cust.class, forVariable(variable));
    }

    public QCust(Path<? extends Cust> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCust(PathMetadata metadata) {
        super(Cust.class, metadata);
    }

}

