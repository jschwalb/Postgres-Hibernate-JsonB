package de.johannesschwalb.evaluation.postgresjson.hibernate;

import org.hibernate.dialect.PostgreSQL94Dialect;

import java.sql.Types;

/**
 * Created by LG P310 on 04.07.2017.
 */
public class PostgresJsonDialect extends PostgreSQL94Dialect {

    public PostgresJsonDialect() {
        super();
        registerColumnType(Types.JAVA_OBJECT, JsonB.JSONB_TYPE);
    }

}
