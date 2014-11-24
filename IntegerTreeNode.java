public class IntegerTreeNode{
	private int value;
	private IntegerTreeNode left;
	private IntegerTreeNode right;

	public IntegerTreeNode(int value)
	{
		this.value = value;
		this.right = null;
		this.left = null;
	}

	public boolean add(int value)
	{
		if(this.value > value)
		{
			if(this.left != null)
			{
				this.left.add(value);
			}
			else
			{
				this.left = new IntegerTreeNode(value);
			}
		}
		else if(this.value < value)
		{
			if(this.right != null)
			{
				this.right.add(value);
			}
			else
			{
				this.right = new IntegerTreeNode(value);
			}
		}
		else
		{
			return false;
		}
		return true;
	}

	public boolean contains(int value)
	{
		boolean result = false;
		if(this.value == value)
		{
			return true;
		}
		else
		{
			if(this.value < value)
			{
				if(this.right != null)
				{
					result = this.right.contains(value);
				}
				else
				{
					result = false;
				}
			}
			else
			{
				if(this.left != null)
				{
					result = this.left.contains(value);
				}
				else
				{
					result = false;
				}
			}
		}
		return result;
	}

	public int getMax()
	{
		int result = 0;
		if(this.right != null)
		{
			result = this.right.getMax();
		}
		else
		{
			result = this.value;
		}
		return result;
	}

	public int getMin()
	{
		int result = 0;
		if(this.left != null)
		{
			result = this.left.getMin();
		}
		else
		{
			result = this.value;
		}
		return result;
	}

	public static void main(String[] args)
	{
		IntegerTreeNode basenode = new IntegerTreeNode(6);
		basenode.add(10);
		basenode.add(15);
		basenode.add(-1);
		basenode.add(7);
		basenode.add(3);
		basenode.add(2);
		basenode.add(-3);
		basenode.add(4);
		basenode.add(-5);
		basenode.add(-6);
		if(basenode.contains(3))
		{
			System.out.println("This tree contains 3");
		}
		if(basenode.contains(7))
		{
			System.out.println("This tree contains 7");
		}
		if(basenode.contains(17))
		{
			System.out.println("This tree contains 17");
		}
		System.out.println("The mininmum is: " + basenode.getMin());
		System.out.println("The maximum is: " + basenode.getMax());
		System.out.println(basenode.ToString());
		System.out.println("The depth of this tree is: " + basenode.depth());
		basenode = basenode.remove(3);
		System.out.println("Removed 3!");
		System.out.println(basenode.ToString());
	}

	public String ToString()
	{
		String output = "";
		output += this.value;
		if(this.left != null)
		{
			output = output + "[" + this.left.ToString() + "]";
		}

		if(this.right != null)
		{
			output = output + "[" + this.right.ToString() + "]";
		}

		return output;
	}

	public int depth()
	{
		int length = 0;
		int temp = 0;
		if(this.left != null)
		{
			temp = this.left.depth()+1;
			if(temp > length)
			{
				length = temp;
			}
		}
		if(this.right != null)
		{
			temp = this.right.depth()+1;
			if(temp > length)
			{
				length = temp;
			}
		}
		return length;
	}

	public IntegerTreeNode remove(int value)
	{
		IntegerTreeNode = null;
		if(this.value != value)
		{
			if(this.value < value)
			{
				this.right = this.right.remove(value);
			}
			else if(this.value > value)
			{
				this.left = this.left.remove(value);
			}
		}
		else
		{
			if(this.right != null)
			{
				int min = this.right.getMin();
				IntegerTreeNode upmin = this.right.NodeWith(min);
				upmin.left = this.left;
				toreturn = this.right;
			}
			else
			{
				toreturn = this.left;
			}
		}
		return toreturn;
	}

	public IntegerTreeNode NodeWith(int value)
	{
		if(this.value == value)
		{
			return this;
		}
		else if(this.value > value)
		{
			return this.left.NodeWith(value);
		}
		else
		{
			return this.right.NodeWith(value);
		}
	}

}