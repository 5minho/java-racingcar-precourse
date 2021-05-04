package view.dto;

import java.util.List;

public class CarRaceResultDto {
	private final List<CarGroupPositionDto> carGroupPositionDto;
	private final List<String> winnerNames;

	public CarRaceResultDto(List<CarGroupPositionDto> carGroupPositionDto, List<String> winnerNames) {
		this.carGroupPositionDto = carGroupPositionDto;
		this.winnerNames = winnerNames;
	}

	public List<CarGroupPositionDto> getCarGroupPosition() {
		return carGroupPositionDto;
	}

	public List<String> getWinnerNames() {
		return winnerNames;
	}
}
