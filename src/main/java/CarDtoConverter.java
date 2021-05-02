import java.util.ArrayList;
import java.util.List;

import car.Car;
import car.CarGroup;
import view.CarGroupPositionDto;
import view.CarPositionDto;

public class CarDtoConverter {
	static CarGroupPositionDto toDto(CarGroup carGroup) {
		List<CarPositionDto> carMoveResultsDto = new ArrayList<>();
		for (Car car : carGroup.getCars()) {
			carMoveResultsDto.add(toDto(car));
		}
		return new CarGroupPositionDto(carMoveResultsDto);
	}

	private static CarPositionDto toDto(Car car) {
		return new CarPositionDto(car.getName(), car.getPosition());
	}
}
