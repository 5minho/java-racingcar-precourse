package view;

import java.util.List;

public class CarRaceResultDto {
	private final List<CarGroupPositionDto> carGroupPositionDto;

	public CarRaceResultDto(List<CarGroupPositionDto> carGroupPositionDto) {
		this.carGroupPositionDto = carGroupPositionDto;
	}

	public List<CarGroupPositionDto> getCarGroupPosition() {
		return carGroupPositionDto;
	}
}
