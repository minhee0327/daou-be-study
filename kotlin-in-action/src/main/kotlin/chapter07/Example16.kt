package chapter07

import java.lang.reflect.Type
import kotlin.reflect.KProperty

class Foo{
    var p: Type by Delegate()
}

class Delegate{
    operator fun getValue(foo: Foo, property: KProperty<*>): Type {
        TODO()
    }

    operator fun setValue(foo: Foo, property: KProperty<*>, type: Type) {
        TODO()
    }
}