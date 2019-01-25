package com.akuchars.goals.core.infrastructure.query


import com.google.common.collect.ImmutableList
import com.querydsl.core.types.Expression
import com.querydsl.core.types.ExpressionException
import com.querydsl.core.types.ExpressionUtils
import com.querydsl.core.types.FactoryExpressionBase
import com.querydsl.core.types.Ops
import com.querydsl.core.types.Path
import com.querydsl.core.types.Visitor
import javax.annotation.concurrent.Immutable

/**
 * Based on com.querydsl.core.types.ConstructorExpression
 * @param <A>
 * @param <R>
</R></A> */
@Immutable
class VarargsFunctionExpression<A, R> private constructor(type: Class<out R>,
                                                          private val args: ImmutableList<Expression<*>>,
                                                          @field:Transient private val function: (Array<out Any>) -> R) : FactoryExpressionBase<R>(type) {

    constructor(type: Class<out R>,
                         function: (Array<out Any>) -> R,
                         vararg args: Expression<*>) : this(type, ImmutableList.copyOf<Expression<*>>(args), function)

    /**
     * Create an alias for the expression
     *
     * @return alias expression
     */
    fun `as`(alias: Path<R>): Expression<R> {
        return ExpressionUtils.operation(type, Ops.ALIAS, this, alias)
    }

    /**
     * Create an alias for the expression
     *
     * @return alias expression
     */
    fun `as`(alias: String): Expression<R> {
        return `as`(ExpressionUtils.path(type, alias))
    }

    override fun <T, C> accept(v: Visitor<T, C>, context: C?): T? {
        return v.visit(this, context)
    }

    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true
            other is VarargsFunctionExpression<*, *> -> {
                val c = other as VarargsFunctionExpression<*, *>?
                (args == c!!.args && type == c.type && function == c.function)
            }
            else -> false
        }
    }

    override fun getArgs(): List<Expression<*>> {
        return args
    }

    override fun newInstance(vararg args: Any): R? {
        try {
            return function.invoke(args)
        } catch (e: SecurityException) {
            throw ExpressionException(e.message, e)
        }

    }
}
