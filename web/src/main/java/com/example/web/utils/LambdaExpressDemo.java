package com.example.web.utils;
// 接口里有且仅有一个方法(函数式接口)
@FunctionalInterface
interface Foo
{
    //public void sayHello();
    public int add(int x,int y);
    // 函数式接口可以有多个default修饰的默认实现
    default int div(int x,int y){
        System.out.println("**********hello");
        return x/y;
    }
    public static int mv(int x ,int y){
        return x*y;
    }
}

/**
 *  2 Lambda Express
 *  2.1 口诀
 *  拷贝小括号 写死右箭头 落地大括号
 *  2.2 @FunctionalInterface 函数式接口注解(接口里有且仅有一个方法)
 *  2.3 default java8之后接口可以有多个default修饰的默认实现
 *
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
      /*  Foo foo = new Foo() {
            @Override
            public void sayHello() {
               System.out.println("**********hello");
            }
        };
        foo.sayHello();*/
        Foo foo = (x ,y) -> {
            System.out.println("**********hello");
            return x+y;
        };

        System.out.println(foo.add(3,5));;
        System.out.println(foo.div(10,5));
        //静态方法属于整个类,调用要用Foo;
        System.out.println(Foo.mv(10,5));

    }
}
