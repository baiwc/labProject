package com.wc.util;

/**
 * 纯粹的数组队列，实行增删改查等功能，一个第三方的类
 * 
 * @author lzj
 * 
 */
public class MyArrayList<E> {
	private Object[] array;// 声明对象数组
	private int size = 0;// 声明size属性，设置初值为0

	/**
	 * 构造方法
	 */
	public MyArrayList() {
		array = new Object[0];// 初始化
	}

	public MyArrayList(int size) {
		array = new Object[size];// 初始化
	}

	/**
	 * 向数组队列中添加元素的方法
	 * 
	 * @param elements要添加的元素
	 */
	public void add(E element) {
		// 创建一个新的数组，长度为size+1
		Object[] newArray = new Object[size + 1];
		for (int i = 0; i < size; i++) {
			newArray[i] = array[i];// 赋值
		}
		newArray[size] = element;// 添加元素至数组最后的位置
		size++;// size加1
		array = newArray;// 把newArray的地址给array
	}

	/**
	 * 根据索引删除对应的元素（删除区别于移除，删除需要释放空间）
	 * 
	 * @param index要删除的元素的索引
	 * @return
	 */
	public E delete(int index) {
		if (index < 0 || index >= size)// 防止所给下标为负值或超出size
			return null;
		Object temp;// Object类型变量
		temp = array[index];// 将被删除的元素赋予临时变量temp
		Object[] newArray = new Object[size - 1];// 创建Object类数组，数组长度减1
		// 小于索引时，照搬过去
		for (int i = 0; i < index; i++) {
			newArray[i] = array[i];// 把值移到新数组中
		}
		// 大于索引时
		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];// 移位填补空位
			newArray[i] = array[i];// 把值移到新数组中
		}
		array = newArray;// 把newArray的地址给array
		size--;
		return (E) temp;// 返回被删除的元素
	}

	/**
	 * 根据索引插入对应的元素
	 * 
	 * @param index要插入的位置的索引
	 * @return
	 */
	public E ins(int index, E element) {
		Object[] newArray = new Object[size + 1];// 创建Object类数组，数组长度减1
		// 小于索引时，照搬过去
		for (int i = 0; i < index; i++) {
			newArray[i] = array[i];// 把值移到新数组中
		}
		newArray[index] = element;
		// 大于索引时
		for (int i = index; i < size; i++) {
			newArray[i + 1] = array[i];// 把值移到新数组中
		}
		array = newArray;// 把newArray的地址给array
		size++;
		return element;// 返回被插入的元素
	}

	// 得到数组队列的长度的方法
	public int size() {
		return size;
	}

	// 根据索引和传人的元素设定相应的元素
	public void set(int index, E obj) {
		array[index] = obj;
	}

	// 根据索引得到相应的元素
	public E get(int index) {
		if (index < 0 || index >= size)// 防止所给下标为负值或超出size
			return null;
		return (E) array[index];
	}

	public E find(E obj) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(obj))
				return (E) array[i];
		}
		return null;
	}

	// 修改元素，根据元素和下标
	public void modify(E element, int index) {
		array[index] = element;
	}

}
