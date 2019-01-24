package test;
import java.io.*;
@SuppressWarnings("serial")
public class Book implements Serializable{
	private String BID,BName,BAuthor,BPublisher;
	private int BQty;
	private float BPrice;
	public String getBID() {
		return BID;
	}
	public void setBID(String bID) {
		BID = bID;
	}
	public String getBName() {
		return BName;
	}
	public void setBName(String bName) {
		BName = bName;
	}
	public String getBAuthor() {
		return BAuthor;
	}
	public void setBAuthor(String bAuthor) {
		BAuthor = bAuthor;
	}
	public String getBPublisher() {
		return BPublisher;
	}
	public void setBPublisher(String bPublisher) {
		BPublisher = bPublisher;
	}
	public int getBQty() {
		return BQty;
	}
	public void setBQty(int bQty) {
		BQty = bQty;
	}
	public float getBPrice() {
		return BPrice;
	}
	public void setBPrice(float bPrice) {
		BPrice = bPrice;
	}
}
