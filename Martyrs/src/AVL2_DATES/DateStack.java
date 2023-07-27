package AVL2_DATES;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStack implements Comparable<DateStack> {

	private Date date;
	private StackList stack;

	public DateStack() {
		super();
	}

	
	public DateStack(Date date) {
		super();
		this.date = date;
	}
	public DateStack(Martyrs martyrs) {
		super();
		this.stack = new StackList();
		stack.push(martyrs);
	}

	public DateStack(Date date , Martyrs martyrs) {
		super();
		this.stack = new StackList();
		stack.push(martyrs);
		this.date = date;
	}


	public DateStack(Date date, StackList stack) {
		super();
		this.date = date;
		this.stack = stack;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StackList getStack() {
		return stack;
	}

	public void setStack(StackList stack) {
		this.stack = stack;
	}
	
	

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("M/dd/yyyy");

		return "DateStack [date=" + format.format(date) + ", stack=" + stack + "]";
	}


	@Override
	public int compareTo(DateStack o) {
		return date.compareTo(o.date);
	}


	@Override
	public boolean equals(Object obj){
		return date.equals(((DateStack)obj).date);
	}
	
	

}
