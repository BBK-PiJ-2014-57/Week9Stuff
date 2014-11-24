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
}