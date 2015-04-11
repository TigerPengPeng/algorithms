basic algorithms demos
========================================================
@author:            peng.huang
@email:             huangpengssdut@126.com
@date:              2015-04-11
@更新内容:
更新<算法面试题>工程,添加两种找出第i个顺序统计数的算法
1.使用randomizedPartition方法分割，每次partition算法的key值为A[low], 不对key做处理
2.先将整体按照一定大小分割，找出每个模块的中位数，然后递归继续找出中位数。用该中位数的值作为每次partition算法的key

@author:            peng.huang
@email:             huangpengssdut@126.com
@date:              2015-04-07
@更新内容:
更新<算法面试题>工程， 更新BitMap类，使BitMap类能存储负数
1.若一个负整数想存储到BitMap中，则计算出该数的index=-(abs(value)/32+1),然后在该key为index的map中，存储abs(value)。在取数据的时候，只要稍加判断即可获得该value。
通过该方式，扩展了BitMap的功能，使得BitMap能够存储负整数


@author:            peng.huang
@email:             huangpengssdut@126.com
@date:              2015-04-07
@更新内容:
更新<算法面试题>工程， 更新BitMap类，将BitMap的方法改为非static
1.更新注解，BitMap只能存储正整数和0,具体原因参考int在机器中是以补码的方式存储的


@author:            peng.huang
@email:             huangpengssdut@126.com
@date:              2015-04-07
@更新内容:
更新<算法面试题>工程，添加BitMap类，使用位来存储int类型数据
1. 一个int类型占32位，每一位存储一个int类型数据，那么一个int可以存储32个数据。并支持对数据的排序（类似与计数排序，不过占用的空间更小），时间复杂度为O(n)

@author:            peng.huang
@email:             huangpengssdut@126.com
@date:              2015-04-06
@更新内容:
添加<算法面试题>工程，并向工程内添加获取主串的最大回文串算法.
1. 根据一个字符向两边扩展的求最大回文串算法，若A为回文串字串，则通过O(1)的时间即可判断出aAa是否为回文串，时间复杂度为O(n^2)
2. manacher算法，只需要O(n)的时间复杂度，即可求出最大回文串

This content contains some algorithms demos.
At now, it contains:
<sorts>
<kdtree>
<lru>
<shingling>
<interviews questions>

And then, I will add some other algorithms in next times

Thanks and best wishes
