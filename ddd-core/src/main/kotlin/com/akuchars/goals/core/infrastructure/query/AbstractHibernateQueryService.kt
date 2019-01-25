package com.akuchars.goals.core.infrastructure.query

import com.querydsl.core.types.Expression
import com.querydsl.core.types.Projections
import com.querydsl.jpa.hibernate.HibernateQuery
import com.querydsl.jpa.hibernate.HibernateQueryFactory
import org.hibernate.Session
import org.hibernate.SessionFactory

abstract class AbstractHibernateQueryService(private var sessionFactory: SessionFactory) {

    private fun currentSession(): Session = sessionFactory.currentSession
    private fun hibernateQueryFactory(): HibernateQueryFactory = HibernateQueryFactory(currentSession())

    protected fun <T> selectDto(dtoClass: Class<out T>, vararg constructorArguments: Expression<T>): HibernateQuery<T> =
            hibernateQueryFactory().select(Projections.constructor(dtoClass, *constructorArguments))

    fun <A, R> varargsFunction(returnType: Class<out R>,
                               functionToCall: (Array<out Any>) -> R,
                               vararg argumentExpressions: Expression<*>): VarargsFunctionExpression<A, R> =
            VarargsFunctionExpression(returnType, functionToCall, *argumentExpressions)


    fun <A, R> function1(returnType: Class<out R>,
                         argumentType: Class<out A>,
                         functionToCall: (A) -> R, argumentExpresion: Expression<A>): Function1Expression<A, R> =
            Function1Expression(returnType, argumentType, functionToCall, argumentExpresion)

    fun <R> idFunction(returnType: Class<out R>,
                       functionToCall: (Long) -> R,
                       argumentExpresion: Expression<Long>): Function1Expression<Long, R> =
            Function1Expression(returnType, Long::class.java, functionToCall, argumentExpresion)
}
