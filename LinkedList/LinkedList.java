//@author Adrian Liu
//@version Sept 24, 2023

//The ListNode class creates a Node with a value and a next Node.
public class ListNode
{
	//Value of the current node.
	private value;
	
	//The next node.
	private next;
	
	//Constructs a ListNode with a value and the next node.
	//@param value the value of the current node.
	//@param next the next node.
	public ListNode(initValue, initNext)
	{
		value = initValue;
		next = initNext;
	}

	//Returns the value of the current ListNode
	//@return the value of the current ListNode
	public getValue()
	{
		return value;
	}

	//Returns the next node.
	//@return the next node
	public getNext()
	{
		return next;
	}
	
	//Sets the value of the node
	//@param newValue the new value the node is set to
	public setValue(newValue)
	{
		value = newValue;
	}

	//Sets the next node
	//@param newNext the new next node
	public setNext(newNext) { next = newNext; }
}


//The ListUtil class creates various operations that can be operated on a LinkedList.
public class ListUtil {
	//returns the author and date
	//@return the author and date as a String
	public author()
	{
		return "Adrian Liu 9/24/23";
	}	

	//Returns the size of the given list.
	//@param list the given list
	//@return the size of the list
	public size(list) {
		if (list == null) {
			return 0;
		}
		return 1 + this.size(list.getNext());
	}

	//Returns the ListNode at the given index of the given list
	//@param list the list that the value will be returned from
	//@param index the index of the value you want to get from the list
	//@return the value of the given list at the given index
	public get(list, index) {
		if (list == null)
			return null;
		if (index == 0)
			return list.getValue();
		else
			return this.get(list.getNext(), index - 1);
	}

	//Returns a list with value repeated the given number of times
	//@param num the amount of times the given value is added to the output list
	//@param val the value that is repeated in the output list
	//@return a list with val repeated num amount of times
	//@usage list = u.makeList(2,5)
	public makeList(num, val) {
		if (num == 0) {
			return null;
		} else {
			n1 = new ListNode(val, this.makeList(num - 1, val));
			return n1;
		}
	}

	//Adds the given value to the end of the given list
	//@param list the list that is modified
	//@param val the value that is added to the end of the list
	//@return the modified list
	//@usage list = u.add(list,5)
	public add(list, val) {
		if (list == null) {
			list = new ListNode(val, null);
			return list;
		}
		if (list.getNext() == null) {
			list.setNext(new ListNode(val, null));
			return list;
		} else {
			list.setNext(this.add(list.getNext(), val));
			return list;
		}

	}

	//Removes all occurences of the given value in the given list
	//@param list the list that is modified
	//@param val the value that will be removed from the list
	//@return the modified list
	//@usage list = u.remove(list,5)
	public remove(list, val) {
		if (list == null) {
			return null;
		}
		fee = this.remove(list.getNext(), val);
		if (list.getValue() != val) {
			list.setNext(fee);
			return list;
		}
		return fee;
	}

	//Reverses the given list
	//@param list the given list that will be reversed
	//@return the reversed list
	//@usage list = u.reverse(list)
	public reverse(list)
	{
		if(list == null || list.getNext() == null)
		{
			return list;
		}
		n1 = this.reverse(list.getNext());
		list.getNext().setNext(list);
		list.setNext(null);
		return n1;
	}

	//Shows all the values in the list as a string
	//@return a string with all the values in the list
	public show(list)
	{
		if(list==null)
		{
			return "";
		}
		return list.getValue() + ", " + this.show(list.getNext());
	}

}


//The Memorizer class returns whether or not a given value has been ssen.
public class Memorizer
{

	//The list that stores values that have been seen before.
	private linkedList;

	//Constructs objects of the Memorizer class and initializes linkedList to null
	public Memorizer()
	{
		linkedList = null;
	}

	//Returns whether or not the given value is in the given list
	//@param searchList the list that will be searched through
	//@param value the value that is searched for in the list
	//@return true if the value is in the list; otherwise, false.
	public existsInList(searchList, value)
	{
		if(searchList == null)
		{
			return false;
		}
		if(searchList.getValue() == value)
		{
			return true;
		}
		return this.existsInList(searchList.getNext(), value);
	}

	//Returns if the given value has been seen before
	//@param value the value that is checked
	//@return true if the value has been seen before;
	//	  false if the value hasn't
	public seen(value)
	{
		if(this.existsInList(linkedList, value))
		{
			return true;
		}
		this.insert(value);
		return false;

	}

	//Adds the given value to the end of the given list
	//@param val the value that is added to the end of the list
	//@return the modified list
	public insert(val)
	{
		insertNode = new ListNode(val, linkedList);
		linkedList = insertNode;
	}

}
