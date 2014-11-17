package studentManager;

public class ColsInfo{
	private String colTitle;
	private String colType;
	private boolean autoIncrement;
	private int colSize;
	private int isNullable;
	private int colPosition;
	public String getColTitle() {
		return colTitle;
	}
	public void setColTitle(String colTitle) {
		this.colTitle = colTitle;
	}
	public String getColType() {
		return colType;
	}
	public void setColType(String colType) {
		this.colType = colType;
	}
	public boolean isAutoIncrement() {
		return autoIncrement;
	}
	public void setAutoIncrement(boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
	}
	public int getColSize() {
		return colSize;
	}
	public void setColSize(int colSize) {
		this.colSize = colSize;
	}
	public int getIsNullable() {
		return isNullable;
	}
	public void setIsNullable(int isNullable) {
		this.isNullable = isNullable;
	}
	public int getColPosition() {
		return colPosition;
	}
	public void setColPosition(int colPosition) {
		this.colPosition = colPosition;
	}
} 
