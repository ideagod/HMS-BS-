package hotelsys;

// ����
public class Room {
	// ����
	private String roomId;
	// �����С
	private double size;
	// ÿ����
	private double price;
	// �Ƿ���������ס: 0, ����; 1, ��������ס
	private int checkIn;
	// ��������: 0,���˷�; 1,˫�˷�; 2, �����󴲷�;
	private int roomType;

	/**
	 * @param roomId
	 * @param size
	 * @param price
	 * @param checkIn
	 * @param roomType
	 */
	public Room(String roomId, double size, double price, int checkIn, int roomType) {
		super();
		this.roomId = roomId;
		this.size = size;
		this.price = price;
		this.checkIn = checkIn;
		this.roomType = roomType;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the checkIn
	 */
	public int getCheckIn() {
		return checkIn;
	}

	/**
	 * @param checkIn
	 *            the checkIn to set
	 */
	public void setCheckIn(int checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * @return the roomType
	 */
	public int getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType
	 *            the roomType to set
	 */
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	/**
	 * @return the roomId
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(double size) {
		this.size = size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", size=" + size + ", price=" + price + ", checkIn=" + checkIn + ", roomType="
				+ roomType + "]";
	}
	
}
