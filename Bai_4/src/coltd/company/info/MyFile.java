package coltd.company.info;

public class MyFile implements Comparable<MyFile> {
	private String name;
	private int kind;
	private String path;

	public MyFile(String name,String path,int kind) {
		this.name = name;
		this.path = path;
		this.kind = kind;
	}

	public MyFile() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	@Override
	public int compareTo(MyFile another) {
		if (this.kind > another.kind) {
			return 1;
		}
		if (this.kind < another.kind) {
			return -1;
		}
		return 0;
	}

}
