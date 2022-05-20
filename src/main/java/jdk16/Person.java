package jdk16;


/**
 * record类
 * 可以自动生成 Get, Set, hashcode, ToString
 * @param name
 * @param age
 */
public record Person(String name, Integer age) {

}
