package view;

import java.util.Collections;
import java.util.List;

public class CarGroupPositionDto {
	private final List<CarPositionDto> carPositionDto;

	public CarGroupPositionDto(List<CarPositionDto> carPositionDto) {
		this.carPositionDto = Collections.unmodifiableList(carPositionDto);
	}

	public List<CarPositionDto> getCarPosition() {
		return carPositionDto;
	}
}
