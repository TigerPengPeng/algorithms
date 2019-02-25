/**
 * Created by ray on 15-4-7.
 * 使用位存储来存储int类型数据
 * 由int类型的性质，一个int数字经过操作之后可以存储32个数字。但是由于位存储的性质，所以存储后的数据有去重的效果
 * 输入 number（number >= 0， number为负数的情况已经在代码中实现，示例中暂时只考虑number >= 0）
 * index = number / 32
 * mod = number % 32
 * 那么我们可以将该value存储到key为index， value = value | (1 << mod)的TreeMap中（使用TreeMap是为了方便排序）
 * for example
 * number = 55
 * index = number / 32 = 1
 * mod = number % 32 = 23
 * 从TreeMap中取出value = map.get(index), 然后map.put(index, value | (1 << mod))将新值放到map中
 * BitMap还针对存储负数进行了处理，详情请参照代码实现
 */
package com.dlut.interviews.bit;