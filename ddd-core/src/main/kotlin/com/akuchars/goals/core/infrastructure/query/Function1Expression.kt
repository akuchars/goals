package com.akuchars.goals.core.infrastructure.query

import com.google.common.collect.ImmutableClassToInstanceMap
import com.google.common.collect.ImmutableList
import com.querydsl.core.types.Expression
import com.querydsl.core.types.ExpressionException
import com.querydsl.core.types.ExpressionUtils
import com.querydsl.core.types.FactoryExpressionBase
import com.querydsl.core.types.Ops
import com.querydsl.core.types.Path
import com.querydsl.core.types.Visitor

import javax.annotation.concurrent.Immutable
import java.util.function.Function

/**
 * Based on com.querydsl.core.types.ConstructorExpression
 * @param <A> - Function agument type
 * @param <R> - Function return type
</R></A> */
@Immutable
class Function1Expression<A, R> internal constructor(retType: Class<out R>,
                                                         private val argType: Class<out A>,
                                                         @field:Transient val function: (A) -> R,
                                                         val arg: Expression<A>) : FactoryExpressionBase<R>(retType) {

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
            other is Function1Expression<*, *> -> {
                val c = other as Function1Expression<*, *>?
                (arg == c!!.arg
                        && argType == c.argType
                        && type == c.type
                        && function == c.function)
            }
            else -> false
        }
    }

    override fun getArgs(): List<Expression<*>> {
        return ImmutableList.of<Expression<*>>(arg)
    }

    override fun newInstance(vararg args: Any?): R? {
        try {
            var arg = args[0]
            if (argType.isPrimitive && args[0] == null) {
                arg = defaultPrimitives.getInstance<A>(argType as Class<A>)
            }
            return function.invoke(arg as A)
        } catch (e: SecurityException) {
            throw ExpressionException(e.message, e)
        }

    }

    companion object {

        private const val serialVersionUID = 2421558537928098268L

        private val defaultPrimitives = ImmutableClassToInstanceMap.builder<Any>()
                .put(java.lang.Boolean.TYPE, false)
                .put(java.lang.Byte.TYPE, 0.toByte())
                .put(Character.TYPE, 0.toChar())
                .put(java.lang.Short.TYPE, 0.toShort())
                .put(Integer.TYPE, 0)
                .put(java.lang.Long.TYPE, 0L)
                .put(java.lang.Float.TYPE, 0.0f)
                .put(java.lang.Double.TYPE, 0.0)
                .build()
    }
}
