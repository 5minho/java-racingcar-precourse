package view.dto;

public class CarPositionDto {
	private final String name;
	private final int position;

	public CarPositionDto(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
